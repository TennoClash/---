package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Book;

@Repository("bookDAO")
public interface BookDAO {

	public int insertBook(Book book);

	public int updateBook(Book book);

	public int deleteBook(String bookid);

	public List<Book> getAllBook();

	public List<Book> getBookByCond(Book book);

	public List<Book> getBookByLike(Book book);

	public Book getBookById(String bookid);

}
