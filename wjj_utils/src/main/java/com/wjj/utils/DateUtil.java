package com.wjj.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
 //根据日期算年龄
	private DateUtil() {}
	public static int getAge(Calendar target) {
		int age=0;
		Calendar instance = Calendar.getInstance();
		//当我传入的日期 是当前日期之后的日期
		if(instance.before(target)) {
			throw new IllegalArgumentException("参数不正确");
		}
		//获取当前时间的年月日
		int day_year=instance.get(Calendar.YEAR);
		int day_month=instance.get(Calendar.MONTH);
		int day_day=instance.get(Calendar.DAY_OF_MONTH);
		//获取target日期的年月日
		int target_year=target.get(Calendar.YEAR);
	
		int target_month=target.get(Calendar.MONTH);		
		int target_day=target.get(Calendar.DAY_OF_MONTH);
		//计算年龄
		System.out.println(" 计算 a ");
		age=day_year-target_year;
		if(day_month<=target_month) {
			if(day_month==target_month) {
				if(target_day>day_day) {
					age--;
				}
			}
			age--;
		}
		
		return age+1;
	}
	//求未来日期离今天还剩的天数
	public static int getFutureDays(Calendar target) {
		int day=0;
		long time=Calendar.getInstance().getTime().getTime();
		long time2=target.getTime().getTime();
		if(time2-time<0) {
			throw new IllegalArgumentException("参数不合法异常 a");
		}else {
			day=(int)((time2-time)/1000/60/60/24);
		}
		
		
		return day;
	}
	//求过去日期离今天还剩的天数
	public static int getPastDays(Calendar target) {
		int day=0;
	long time=Calendar.getInstance().getTime().getTime();
	long time2=target.getTime().getTime();
	if(time2-time<0) {
		throw new IllegalArgumentException("参数不合法异常 a");
	}else {
		day=(int)((time-time2)/1000/60/60/24);
	}
	return day;
		
	}
	//判断给定的日期是否为今天
	public static boolean isTorday(Calendar target) {
		boolean result=false;
		if(target ==null) {
			return false;
		}
		Calendar toDay=Calendar.getInstance();
		//先对比年份
		if(toDay.get(Calendar.YEAR)==target.get(Calendar.YEAR)) {
		//比对月份
			if(toDay.get(Calendar.MONTH)==target.get(Calendar.MONTH)) {
				//比对日
				if(toDay.get(Calendar.DAY_OF_MONTH)==target.get(Calendar.DAY_OF_MONTH)) {
					return true;
				}
			}
			
		}
		return result;
	}
	//判断选择的日期是否为本月
	public static boolean isInThisMonth(Calendar target) {
		boolean result=false;
		if(target==null) {
			return false;
		}
		Calendar toDay=Calendar.getInstance();
		if(toDay.get(Calendar.YEAR)==target.get(Calendar.YEAR)) {
			if(toDay.get(Calendar.YEAR)==target.get(Calendar.YEAR)) {
				if(toDay.get(Calendar.MONTH)==target.get(Calendar.MONTH)) {
					return true;
				}
			}
			
		}
		return result;
		
	}
	//判断给定的日期是否在本周之内
	
	  public static boolean IsInThisWeek(Calendar target) {
		  boolean result=false;
	  if(target ==null) { return false; } 
	  Calendar toDay=Calendar.getInstance(); 
	  if(toDay.get(Calendar.WEEK_OF_YEAR)==target.get(Calendar.WEEK_OF_YEAR)) {
		  return true;
	  }
	  return result;
	  }
	 
	//给定时间对象初始化月初的1月1日0时0分0秒
	public static void initDateTime(Calendar target) {
		//把target对象的日时分秒 毫秒 重置
		target.set(Calendar.DAY_OF_MONTH, 1);
		target.set(Calendar.HOUR, 0);
		target.set(Calendar.MINUTE, 0);
		target.set(Calendar.SECOND, 0);
		target.set(Calendar.MILLISECOND, 0);
	}
	//给定时间对象 设定该月最后一天的23时59分59秒
	public static void setToLastDateOfMonth(Calendar target) {
		int targetMonth=target.get(Calendar.MONTH);
		if(targetMonth ==2) {
			//判断是否是闰年
			if(isLeapYear(target.get(Calendar.YEAR))) {
				target.set(Calendar.DATE, 29);
			}else {
				target.set(Calendar.DATE, 28);
			}
		}else {
			switch(targetMonth) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
			target.set(Calendar.DATE, 31);
			break;
			default:target.set(Calendar.DATE, 30);
			break;
				
			}
		}
		target.set(Calendar.HOUR, 23);
		target.set(Calendar.MINUTE, 59);
		target.set(Calendar.SECOND, 59);
		target.set(Calendar.MILLISECOND, 999);
	}
	//判断是否为闰年
	private static boolean isLeapYear(int year) {
		// TODO Auto-generated method stub
		return (year %4==0&& year %100!=0)|| year%400==0;
	}
	//时间比较
	public static int compareDate(Date date1,Date date2) {
		return date1.compareTo(date2);
	}
}
