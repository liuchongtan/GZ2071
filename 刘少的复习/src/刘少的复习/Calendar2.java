package 刘少的复习;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Calendar2 {

	public static void main(String[] args) {
		//现在Date不够国际化 已经被淘汰了 现在一般用Calendar
		//下面是用calendar做一个今天与月底还差多少天的测试
		Calendar calendar=Calendar.getInstance();
		System.out.println("这是calendar的getTime方法得到一个Date时间对象:"+calendar.getTime());
        //下面是设置时间
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		long start=calendar.getTimeInMillis();
		
		//下面设置月底的时间
		calendar.set(Calendar.DAY_OF_MONTH,31);
		long end=calendar.getTimeInMillis();
		System.out.println("--------------------------------------");
		System.out.println("今天距离月底还有："+((end-start)/1000/60/60/24)+"天");
	}

}
