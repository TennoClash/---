package com.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Book;
import com.service.BookService;
import com.entity.Cate;
import com.entity.Admin;
import com.service.CateService;
import com.service.AdminService;
import com.util.PageHelper;
import com.util.VeDate;

@Controller
@RequestMapping("/book")
public class BookController extends BaseController {
	@Autowired
	@Resource
	private BookService bookService;
	@Autowired
	@Resource
	private CateService cateService;
	@Autowired
	@Resource
	private AdminService adminService;

	@RequestMapping("createBook.action")
	public String createBook() {
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		String bno = "B" + VeDate.getStringDatex();
		this.getRequest().setAttribute("bno", bno);
		return "admin/addbook";
	}

	@RequestMapping("addBook.action")
	public String addBook(Book book) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		book.setAdminid(adminid);
		book.setAddtime(VeDate.getStringDateShort());
		this.bookService.insertBook(book);
		return "redirect:/book/createBook.action";
	}

	@RequestMapping("deleteBook.action")
	public String deleteBook(String id) {
		this.bookService.deleteBook(id);
		return "redirect:/book/getAllBook.action";
	}

	@RequestMapping("deleteBookByIds.action")
	public String deleteBookByIds() {
		String[] ids = this.getRequest().getParameterValues("bookid");
		for (String bookid : ids) {
			this.bookService.deleteBook(bookid);
		}
		return "redirect:/book/getAllBook.action";
	}

	@RequestMapping("updateBook.action")
	public String updateBook(Book book) {
		this.bookService.updateBook(book);
		return "redirect:/book/getAllBook.action";
	}

	@RequestMapping("getAllBook.action")
	public String getAllBook(String number) {
		List<Book> bookList = this.bookService.getAllBook();
		PageHelper.getPage(bookList, "book", null, null, 10, number, this.getRequest(), null);
		return "admin/listbook";
	}

	@RequestMapping("queryBookByCond.action")
	public String queryBookByCond(String cond, String name, String number) {
		Book book = new Book();
		if (cond != null) {
			if ("bookno".equals(cond)) {
				book.setBookno(name);
			}
			if ("cateid".equals(cond)) {
				book.setCateid(name);
			}
			if ("addtime".equals(cond)) {
				book.setAddtime(name);
			}
			if ("money".equals(cond)) {
				book.setMoney(name);
			}
			if ("adminid".equals(cond)) {
				book.setAdminid(name);
			}
			if ("memo".equals(cond)) {
				book.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.bookService.getBookByLike(book), "book", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querybook";
	}

	@RequestMapping("getBookById.action")
	public String getBookById(String id) {
		Book book = this.bookService.getBookById(id);
		this.getRequest().setAttribute("book", book);
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		List<Admin> adminList = this.adminService.getAllAdmin();
		this.getRequest().setAttribute("adminList", adminList);
		return "admin/editbook";
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

}
