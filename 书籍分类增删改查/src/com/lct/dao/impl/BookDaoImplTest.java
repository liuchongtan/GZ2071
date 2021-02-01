package com.lct.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.lct.dao.IBookDao;
import com.lct.domain.Book;

class BookDaoImplTest {
    IBookDao b=new BookDaoImpl();
	@Test
	void testSave() {
		Book book=new Book("1246551","java疯狂讲义","汪洋","java出版社","科学");
		b.save(book);
	}

	@Test
	void testDeleteByIsbn() {
		b.deleteByIsbn("1246559");
	}

	@Test
	void testUpdate() {
		Book book=b.getByIsbn("1246551");
		book.setAuthor("王阳");
		b.update(book);
	}

	@Test
	void testGetByIsbn() {
		Book book=b.getByIsbn("1246551");
		System.out.println(book);
	}

	@Test
	void testFindAllBooks() {
		List<Book> books=b.findAllBooks();
		books.forEach(book->System.out.println(book));
	}

}
