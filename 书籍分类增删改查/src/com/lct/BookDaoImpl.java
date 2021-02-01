package com.lct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lct.dao.IBookDao;
import com.lct.domain.Book;

public class BookDaoImpl implements IBookDao{

	@Override
	public void save(Book book) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//建立数据库连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "124683");
			//写好sql语句
			String sql="insert into tb_book values(?,?,?,?,?)";
			//通过conn获得preparedStatement
			ps = conn.prepareStatement(sql);
			ps.setString(1, book.getIsbn());
			ps.setString(2, book.getName());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getPublish());
			ps.setString(5, book.getCategory());
			//执行executeQuery()，注意 preparedstatement里面形参是空的
			ps.executeUpdate();
			//把数据库数据放入books集合
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
						try {if(ps!=null) {
							ps.close();}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}finally {
								try {if(conn!=null) {
									conn.close();}
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();}}}}
	@Override
	public void deleteByIsbn(String isbn) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//建立数据库连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "124683");
			//写好sql语句
			String sql="delete from tb_book where isbn=?";
			//通过conn获得preparedStatement
			ps = conn.prepareStatement(sql);
			ps.setString(1, isbn);
			//执行executeQuery()，注意 preparedstatement里面形参是空的
			ps.executeUpdate();
			//把数据库数据放入books集合
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
						try {if(ps!=null) {
							ps.close();}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}finally {
								try {if(conn!=null) {
									conn.close();}
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();}}}}

	@Override
	public void update(Book book) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//建立数据库连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "124683");
			//写好sql语句
			String sql="update tb_book set name=?,author=?,publish=?,book_category=? where isbn=?";
			//通过conn获得preparedStatement
			ps = conn.prepareStatement(sql);
			ps.setString(1, book.getName());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getPublish());
			ps.setString(4, book.getCategory());
			ps.setString(5, book.getIsbn());
			//执行executeQuery()，注意 preparedstatement里面形参是空的
			ps.executeUpdate();
			//把数据库数据放入books集合
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
						try {if(ps!=null) {
							ps.close();}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}finally {
								try {if(conn!=null) {
									conn.close();}
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();}}}
		
	}

	@Override
	public Book getByIsbn(String isbn) {
		Book book=new Book();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//建立数据库连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "124683");
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
				try {if(rs!=null) {
					rs.close();}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
						try {if(ps!=null) {
							ps.close();}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}finally {
								try {if(conn!=null) {
									conn.close();}
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();}}}}
		return book;
	}

	@Override
	public List<Book> findAllBooks() {
		List<Book> books=new ArrayList<>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//建立数据库连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "124683");
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
		}finally {
				try {if(rs!=null) {
					rs.close();}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
						try {if(ps!=null) {
							ps.close();}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}finally {
								try {if(conn!=null) {
									conn.close();}
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();}}}}
		return books;
		}

}
