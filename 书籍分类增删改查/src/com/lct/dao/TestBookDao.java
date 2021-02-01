package com.lct.dao;

import java.util.List;

import com.lct.dao.impl.BookDaoImpl;
import com.lct.domain.Book;

public class TestBookDao {

	public static void main(String[] args) {
		IBookDao b=new BookDaoImpl();
		//查看数据库所有数据
//		List<Book> books = b.findAllBooks();
//		books.forEach(book->System.out.println(book));
		
		//测试通过isbn号码获得书籍信息
//        System.out.println(b.getByIsbn("1246555"));
		
        //测试增加书籍方法
//		Book book=new Book("1246558","水浒传","施耐庵","中国出版社","历史");
//		b.save(book);
//		
		//测试根据isbn号删除信息方法
		
//		b.deleteByIsbn("1246558");
		
		//测试修改方法
//		Book book=b.getByIsbn("1246555");
//		book.setPublish("中国西游记出版社222");
//		b.update(book);
	}

}
