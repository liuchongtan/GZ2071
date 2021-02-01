package com.lct.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.lct.domain.Clock;
import com.lct.domain.ViewClock;
import com.lct.service.IClockService;
import com.lct.service.IViewclockService;
import com.lct.service.impl.ClockServiceImpl;
import com.lct.service.impl.ViewclockServiceImpl;

public class ClockOp {
    IViewclockService ivcs=new ViewclockServiceImpl();
	IClockService ics=new ClockServiceImpl();
    public void findAllClock() {
    	List<ViewClock> clocks=ivcs.findAllClock();
    	System.out.println("-----------☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆-------------");
    	System.out.println("日期:"+"\t"+"\t"+"员工编号"+"\t"+"上班打卡时间"+"\t"+"下班打卡时间"+"\t"+"是否迟到"+"\t"+"是否早退");
    	for(int i=0;i<clocks.size();i++) {
    		if(clocks.get(i).getEmpnumber()!=null) {
    			if(i!=11) {
    		System.out.println(clocks.get(i).getWorkdate()+"\t"+clocks.get(i).getEmpnumber()+"\t"+clocks.get(i).getDatein()+"\t"+clocks.get(i).getDateoff()+"\t"+clocks.get(i).getChidao()+"\t"+clocks.get(i).getZaotui());}
    			else {
    				System.out.println(clocks.get(i).getWorkdate()+"\t"+clocks.get(i).getEmpnumber()+"\t"+clocks.get(i).getDatein()+"\t"+"\t"+clocks.get(i).getDateoff()+"\t"+clocks.get(i).getChidao()+"\t"+clocks.get(i).getZaotui());
    			}	
    		}
    	}
//    	clocks.forEach(clock->System.out.println(clock));
    }
    public void saveClock(Clock clock) {
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
    	Date date=new Date();
    	java.sql.Date date2=new java.sql.Date(date.getTime());
    	Clock clock2 = ics.getByempnum(clock.getEmpnum(), date2);
    	if(clock2.getEmpnum()==null) {
    	ics.save(clock);
    	System.out.println("上班打卡成功!");
    	System.out.println("您的上班打卡时间为："+sdf.format(clock.getDatein()));}
    	else {
    		System.out.println("请勿重复打卡!");
    	}
    }
    public void findtodayClock(java.sql.Date date) {
    	List<ViewClock> clocks = ivcs.getByDate(date);
    	System.out.println("-----------☆☆☆☆☆-------------");
    	System.out.println("日期:"+"\t"+"\t"+"员工编号"+"\t"+"上班打卡时间"+"\t"+"下班打卡时间"+"\t"+"是否迟到"+"\t"+"是否早退");
    	for(int i=0;i<clocks.size();i++) {
    		if(clocks.get(i).getEmpnumber()!=null) {

    		System.out.println(clocks.get(i).getWorkdate()+"\t"+clocks.get(i).getEmpnumber()+"\t"+clocks.get(i).getDatein()+"\t"+clocks.get(i).getDateoff()+"\t"+clocks.get(i).getChidao()+"\t"+clocks.get(i).getZaotui());}

    		}
    	}
//    	clocks.forEach(clock->System.out.println(clock));

    public void updateClock(Clock clock) {
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
    	System.out.println("您的下班打卡时间为："+sdf.format(clock.getDatein()));
    	ics.update(clock);
    }
    public Clock getbyempnum(String empnum) {
    	Date date1=new Date();
    	java.sql.Date date2=new java.sql.Date(date1.getTime());
    	Clock clock = ics.getByempnum(empnum, date2);
    	return clock;
    }
}
