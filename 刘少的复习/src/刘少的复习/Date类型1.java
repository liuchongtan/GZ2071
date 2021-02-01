package 刘少的复习;

import java.text.SimpleDateFormat;

public class Date类型1 {

	public static void main(String[] args) {
		//util的Date可以直接创建 sql的Date不能直接创建 需要给个参数 System.currentTimeMillis()
		//util的Date如果写入数据库可以精确到秒  sql的Date写入数据库只可以精确到日期
		//SimpleDateFormat  yyyy-MM-dd HH:mm:ss
		java.util.Date date=new java.util.Date();
		java.sql.Date date1=new java.sql.Date(System.currentTimeMillis());
        System.out.println("这是原本的util时间:"+date);
        System.out.println("这是原本的sql时间："+date1);
        System.out.println();
        System.out.println("-----------------------------------");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = sdf.format(date);
        System.out.println("这是格式化后的util的时间:"+dateString);
        System.out.println("这是sql的时间:"+date1);
	}

}
