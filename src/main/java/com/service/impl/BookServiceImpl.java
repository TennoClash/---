package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.BookDAO;
import com.entity.Book;
import com.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {
	@Autowired
	@Resource
	private BookDAO bookDAO;

	@Override
	public int insertBook(Book book) {
		return this.bookDAO.insertBook(book);
	}

	@Override 
	public int updateBook(Book book) {
		return this.bookDAO.updateBook(book);
	}

	@Override 
	public int deleteBook(String bookid) {
		return this.bookDAO.deleteBook(bookid);
	}

	@Override
	public List<Book> getAllBook() {
		return this.bookDAO.getAllBook();
	}

	@Override
	public List<Book> getBookByCond(Book book) {
		return this.bookDAO.getBookByCond(book);
	}

	@Override
	public List<Book> getBookByLike(Book book) {
		return this.bookDAO.getBookByLike(book);
	}

	@Override
	public Book getBookById(String bookid) {
		return this.bookDAO.getBookById(bookid);
	}

}
