package com.lct.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lct.dao.IBookDao;
import com.lct.domain.Book;
import com.lct.utils.JDBCUtil;

public class BookDaoImpl implements IBookDao{

	@Override
	public void save(Book book) {
		String sql="insert into tb_book values(?,?,?,?,?)";
		Object[] objects= {book.getIsbn(),book.getName(),book.getAuthor(),book.getPublish(),book.getCategory()};
	    JDBCUtil.executeUpdate(sql, objects);	
	}
	@Override
	public void deleteByIsbn(String isbn) {
		String sql="delete from tb_book where isbn=?";
		Object[] objects= {isbn};
	    JDBCUtil.executeUpdate(sql, objects);	
	}
	@Override
	public void update(Book book) {
		String sql="update tb_book set name=?,author=?,publish=?,book_category=? where isbn=?";
        Object[] objects= {book.getName(),book.getAuthor(),book.getPublish(),book.getCategory(),book.getIsbn()};
        JDBCUtil.executeUpdate(sql, objects);
	}

	@Override
	public Book getByIsbn(String isbn) {
		Book book=new Book();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtil.getConn();
			//写好sql语句
			String sql="select * from tb_book where isbn=?";
			//通过conn获得preparedStatement
			ps = conn.prepareStatement(sql);
			ps.setString(1, isbn);
			//执行executeQuery()，注意 preparedstatement里面形参是空的
			rs = ps.executeQuery();
			//把数据库数据放入books集合
			while(rs.next()) {
				book.setIsbn(rs.getString("isbn"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPublish(rs.getString("publish"));
				book.setCategory(rs.getString("book_category"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAllResource(conn, ps, rs);}
		return book;
	}

	@Override
	public List<Book> findAllBooks() {
		List<Book> books=new ArrayList<>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtil.getConn();
			//写好sql语句
			String sql="select * from tb_book";
			//通过conn获得preparedStatement
			ps = conn.prepareStatement(sql);
			//执行executeQuery()，注意 preparedstatement里面形参是空的
			rs = ps.executeQuery();
			//把数据库数据放入books集合
			while(rs.next()) {
				Book book=new Book();
				book.setIsbn(rs.getString("isbn"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPublish(rs.getString("publish"));
				book.setCategory(rs.getString("book_category"));
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {JDBCUtil.closeAllResource(conn, ps, rs);
		}
		return books;
		}
}
