package com.controller;

import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Book;
import com.service.BookService;
import com.service.CateService;
import com.util.Excel;
import com.util.VeDate;

@Controller
@RequestMapping("/chartLine")
public class ChartLineController extends BaseController {
	@Autowired
	@Resource
	private CateService cateService;
	@Autowired
	@Resource
	private BookService bookService;

	@RequestMapping("chartLine.action")
	public void chartLine(HttpServletResponse response) throws IOException {
		CategoryDataset dataset = getDataSet();
		JFreeChart chart = ChartFactory.createLineChart("收支统计图表", // 图表标题
				"收支日期", // 目录轴的显示标签
				"金额(元)", // 数值轴的显示标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
		);
		// 从这里开始
		CategoryPlot plot = chart.getCategoryPlot();// 获取图表区域对象
		CategoryAxis domainAxis = plot.getDomainAxis(); // 水平底部列表
		domainAxis.setLabelFont(new Font("黑体", Font.BOLD, 14)); // 水平底部标题
		domainAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 12)); // 垂直标题
		ValueAxis rangeAxis = plot.getRangeAxis();// 获取柱状
		rangeAxis.setLabelFont(new Font("黑体", Font.BOLD, 15));
		chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 20));// 设置标题字体

		response.setContentType("image/png");
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 1200, 850);
	}

	private CategoryDataset getDataSet() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		String start = this.getRequest().getParameter("start");
		String end = this.getRequest().getParameter("end");
		List<Book> bookList = new ArrayList<Book>();
		long days = VeDate.getDays(end, start) + 1;
		double inTotal = 0;
		double outTotal = 0;
		for (int i = 0; i < days; i++) {
			String nxtDay = VeDate.getNextDay(start, "" + i);
			Book book = new Book();
			book.setAddtime(nxtDay);
			book.setWay("收入");
			List<Book> inList = this.bookService.getBookByCond(book);
			Book book1 = new Book();
			book1.setAddtime(nxtDay);
			book1.setWay("支出");
			List<Book> outList = this.bookService.getBookByCond(book1);
			double inSum = 0;
			double outSum = 0;
			for (Book b1 : inList) {
				bookList.add(b1);
				inTotal += Double.parseDouble(b1.getMoney());
				inSum += Double.parseDouble(b1.getMoney());
				dataset.addValue(inSum, "收入", nxtDay);
			}
			for (Book b2 : outList) {
				bookList.add(b2);
				outTotal += Double.parseDouble(b2.getMoney());
				outSum += Double.parseDouble(b2.getMoney());
				dataset.addValue(outSum, "支出", nxtDay);
			}
		}
		this.getSession().setAttribute("inTotal", inTotal);
		this.getSession().setAttribute("outTotal", outTotal);
		Excel excel = new Excel();
		String banner = "财务收支信息统计报表";
		String s1 = "收支单号,收支项目,日期,金额,经手人,备注";
		String[] strTitle = s1.split(",");
		List<String[]> strList = new ArrayList<String[]>();
		for (Book kits : bookList) {
			String strTemp = kits.getBookno() + "," + kits.getCatename() + "," + kits.getAddtime() + "," + kits.getMoney() + ","
					+ kits.getMemo();
			String[] str = strTemp.split(",");
			strList.add(str);
		}
		String paths = getRequest().getSession().getServletContext().getRealPath("/");
		String url = excel.getExcel(strList, strTitle, banner, paths);
		this.getSession().setAttribute("url", url);
		return dataset;
	}
}
