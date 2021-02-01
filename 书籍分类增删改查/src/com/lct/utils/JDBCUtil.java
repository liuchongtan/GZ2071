package com.lct.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.ParsingContextSnapshot;

public class JDBCUtil {
public static Properties p=new Properties();

static {
	InputStream is=JDBCUtil.class.getResourceAsStream("/jdbc.properties");
	try {
		p.load(is);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		Class.forName(p.getProperty("driver"));
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void executeUpdate(String sql,Object...objects) {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	try {
		conn=JDBCUtil.getConn();
		ps=conn.prepareStatement(sql);
		for(int i=0;i<objects.length;i++) {
			ps.setObject((i+1), objects[i]);
		}
		ps.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.closeAllResource(conn, ps, rs);
	}
}

 public static Connection getConn() {
	 Connection conn=null;
	 try {
		conn=DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"),p.getProperty("password"));
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 return conn;
 }
 
 public static void closeAllResource(Connection conn,Statement statement,ResultSet rs) {
	 try {if(rs!=null) {
			rs.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {if(statement!=null) {
					statement.close();}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
						try {if(conn!=null) {
							conn.close();}
						} catch (SQLException e) {
							e.printStackTrace();}}}
	 
 }
}
