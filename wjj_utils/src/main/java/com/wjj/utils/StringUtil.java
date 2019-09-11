package com.wjj.utils;

public class StringUtil {
private StringUtil() {}
//判断字符串是否为空
public static boolean isNotEmpty(String str) {
	return !(str.equals(null)&&str.length()>0);
}
//去空格判断字符串是否为空
public static boolean isNotEmpotyand(String str) {
	return str.trim().length()>0;
}
//正则验证手机号
public static boolean isTellPhone(String num) {
	String reg="^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$";
	boolean matches = num.matches(reg);
	return matches;
}
//随机生成中文字符
public static String radomChinese(int n) {
	StringBuffer buffer=new StringBuffer();
	Integer start = Integer.valueOf("4e00", 16);
	Integer end = Integer.valueOf("9fa5", 16);
	//随机生成中文字符算法如下
	for (int i = 0; i <n; i++) {
	char radomChar=(char)((Math.random()*(end-start+1))+start);
	buffer.append(radomChar);
	}
	return buffer.toString();
}
//生成随机字符
public static String  randomString(int n) {
	StringBuffer buffer=new StringBuffer();
	for (int i = 0; i <n; i++) {
		char randomChar=(char)((Math.random()*58)+65);
		//巩固算法保证随机字符有a-zA-Z组成
		
		randomChar=randomChar>90&&randomChar<97?(char)(randomChar+8):randomChar;
		buffer.append(randomChar);
	}
	return buffer.toString();
}
//方法1：String changeText(String str)  windows系统中  如果是： \r\n 替换成 <p></p> 标签  如果是\r 替换成<br>
public static String changeText(String str) {
	String reg_text1="\\\\r\\\\n";
	
	String replaceAll = str.replaceAll(reg_text1, "<p></p>");
	String reg_text2="\\\\r";
	String replaceAll2 = replaceAll.replaceAll(reg_text2, "<br>");
	return replaceAll2;
}
//邮箱号验证
public static boolean IsEmail(String email) {
	String reg="^([a-zA-Z]|[0-9])(\\w|\\-)+@[a-zA-Z0-9]+\\.([a-zA-Z]{2,4})$";
	return email.matches(reg);
}
}


