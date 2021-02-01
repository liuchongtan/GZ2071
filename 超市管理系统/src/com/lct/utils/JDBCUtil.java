package com.lct.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {

	public static Properties p=new Properties();
	static {
		try(InputStream is=JDBCUtil.class.getResourceAsStream("/jdbc.properties")){
			p.load(is);
			Class.forName(p.getProperty("driver"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static int executeupdate(String sql,Object...objects) {
		int row=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=getconn();
			ps=conn.prepareStatement(sql);
		    for(int i=0;i<objects.length;i++) {
		    ps.setObject((i+1), objects[i]); 
		    }
		    row=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		closeAllresource(conn, ps, rs);
		}
		return row;
	}
	
	public static Connection getconn() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(p.getProperty("url"),p.getProperty("user"),p.getProperty("password"));
		} catch (Exception e) {
		     e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeAllresource(Connection conn,Statement statement,ResultSet rs) {
		try {
			if(rs!=null) {rs.close();}
			if(statement!=null) {statement.close();}
			if(conn!=null) {conn.close();}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
