package com.lct.dao;

import java.util.List;

import com.lct.domain.Book;

public interface IBookDao {

	//此接口实现对数据库增删改查抽象方法的定义
	//增加书籍信息方法
	public void save(Book book);
	//删除书籍信息方法
	public void deleteByIsbn(String isbn);
	//修改书籍信息方法
	public void update(Book book);
	//根据isbn查看书籍信息
	public Book getByIsbn(String isbn);
	//查看全部书籍信息
	public List<Book> findAllBooks();
}
