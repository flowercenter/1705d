package com.wjj.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
 //��������������
	private DateUtil() {}
	public static int getAge(Calendar target) {
		int age=0;
		Calendar instance = Calendar.getInstance();
		//���Ҵ�������� �ǵ�ǰ����֮�������
		if(instance.before(target)) {
			throw new IllegalArgumentException("��������ȷ");
		}
		//��ȡ��ǰʱ���������
		int day_year=instance.get(Calendar.YEAR);
		int day_month=instance.get(Calendar.MONTH);
		int day_day=instance.get(Calendar.DAY_OF_MONTH);
		//��ȡtarget���ڵ�������
		int target_year=target.get(Calendar.YEAR);
	
		int target_month=target.get(Calendar.MONTH);		
		int target_day=target.get(Calendar.DAY_OF_MONTH);
		//��������
		System.out.println(" ���� a ");
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
	//��δ����������컹ʣ������
	public static int getFutureDays(Calendar target) {
		int day=0;
		long time=Calendar.getInstance().getTime().getTime();
		long time2=target.getTime().getTime();
		if(time2-time<0) {
			throw new IllegalArgumentException("�������Ϸ��쳣 a");
		}else {
			day=(int)((time2-time)/1000/60/60/24);
		}
		
		
		return day;
	}
	//���ȥ��������컹ʣ������
	public static int getPastDays(Calendar target) {
		int day=0;
	long time=Calendar.getInstance().getTime().getTime();
	long time2=target.getTime().getTime();
	if(time2-time<0) {
		throw new IllegalArgumentException("�������Ϸ��쳣 a");
	}else {
		day=(int)((time-time2)/1000/60/60/24);
	}
	return day;
		
	}
	//�жϸ����������Ƿ�Ϊ����
	public static boolean isTorday(Calendar target) {
		boolean result=false;
		if(target ==null) {
			return false;
		}
		Calendar toDay=Calendar.getInstance();
		//�ȶԱ����
		if(toDay.get(Calendar.YEAR)==target.get(Calendar.YEAR)) {
		//�ȶ��·�
			if(toDay.get(Calendar.MONTH)==target.get(Calendar.MONTH)) {
				//�ȶ���
				if(toDay.get(Calendar.DAY_OF_MONTH)==target.get(Calendar.DAY_OF_MONTH)) {
					return true;
				}
			}
			
		}
		return result;
	}
	//�ж�ѡ��������Ƿ�Ϊ����
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
	//�жϸ����������Ƿ��ڱ���֮��
	
	  public static boolean IsInThisWeek(Calendar target) {
		  boolean result=false;
	  if(target ==null) { return false; } 
	  Calendar toDay=Calendar.getInstance(); 
	  if(toDay.get(Calendar.WEEK_OF_YEAR)==target.get(Calendar.WEEK_OF_YEAR)) {
		  return true;
	  }
	  return result;
	  }
	 
	//����ʱ������ʼ���³���1��1��0ʱ0��0��
	public static void initDateTime(Calendar target) {
		//��target�������ʱ���� ���� ����
		target.set(Calendar.DAY_OF_MONTH, 1);
		target.set(Calendar.HOUR, 0);
		target.set(Calendar.MINUTE, 0);
		target.set(Calendar.SECOND, 0);
		target.set(Calendar.MILLISECOND, 0);
	}
	//����ʱ����� �趨�������һ���23ʱ59��59��
	public static void setToLastDateOfMonth(Calendar target) {
		int targetMonth=target.get(Calendar.MONTH);
		if(targetMonth ==2) {
			//�ж��Ƿ�������
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
	//�ж��Ƿ�Ϊ����
	private static boolean isLeapYear(int year) {
		// TODO Auto-generated method stub
		return (year %4==0&& year %100!=0)|| year%400==0;
	}
	//ʱ��Ƚ�
	public static int compareDate(Date date1,Date date2) {
		return date1.compareTo(date2);
	}
}
