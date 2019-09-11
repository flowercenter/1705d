package com.wjj.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

import com.wjj.utils.DateUtil;

public class DateUtilTest {
//编写对应的Junit测试类进行测试。10分。 (每个方法完整测试通过给2分
	
	@Test
	public void test1() throws ParseException {
	//	DateUtil.getAge();
		//Calendar target=new 
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date parse = sdf.parse("2015-10-25 08:19:00");
	//int year = parse.getYear();
	//Ca
	//	DateUtil.getAge();
		//Locale.
	//	Calendar target=Calendar.getInstance(parse.toLocaleString())
	//	DateUtil.getAge(target)
	}
	/*
	 * @Test public void test2() {
	 * 
	 * }
	 */
}
