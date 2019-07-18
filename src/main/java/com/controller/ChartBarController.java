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

import com.entity.Orders;
import com.service.ItemsService;
import com.service.OrdersService;
import com.util.Excel;
import com.util.VeDate;

@Controller
@RequestMapping("/chartBar")
public class ChartBarController extends BaseController {
	@Autowired
	@Resource
	private OrdersService ordersService;
	@Autowired
	@Resource
	private ItemsService itemsService;

	@RequestMapping("chartBar.action")
	public void chartBar(HttpServletResponse response) throws IOException {
		CategoryDataset dataset = getDataSet();
		JFreeChart chart = ChartFactory.createBarChart3D("租赁统计图表", // 图表标题
				"订单状态", // 目录轴的显示标签
				"订单数量", // 数值轴的显示标签
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
		long days = VeDate.getDays(end, start) + 1;
		List<Orders> ordersList = new ArrayList<Orders>();
		int overSum = 0;
		int sum = 0;
		for (int i = 0; i < days; i++) {
			String nxtDay = VeDate.getNextDay(start, "" + i);
			Orders orders = new Orders();
			orders.setAddtime(nxtDay);
			List<Orders> list = this.ordersService.getOrdersByCond(orders);
			double sum1 = 0;
			double sum2 = 0;
			for (Orders op : list) {
				ordersList.add(op);
				if ("未完成".equals(op.getStatus())) {
					overSum++;
					sum1++;
				} else {
					sum++;
					sum2++;
				}
			}
			dataset.addValue(sum1, "未完成", nxtDay);
			dataset.addValue(sum2, "已完成", nxtDay);
		}
		this.getSession().setAttribute("overSum", overSum);
		this.getSession().setAttribute("sum", sum);
		Excel excel = new Excel();
		String banner = "租赁统计报表";
		String s1 = "用户,订单号,下单日期,结算方式,状态";
		String[] strTitle = s1.split(",");
		List<String[]> strList = new ArrayList<String[]>();
		for (Orders kits : ordersList) {
			String strTemp = kits.getUsername() + "," + kits.getOrdercode() + "," + kits.getAddtime() + "," + kits.getWay() + ","
					+ kits.getStatus();
			String[] str = strTemp.split(",");
			strList.add(str);
		}
		String paths = getRequest().getSession().getServletContext().getRealPath("/");
		String url = excel.getExcel(strList, strTitle, banner, paths);
		this.getSession().setAttribute("url", url);
		return dataset;
	}
}
