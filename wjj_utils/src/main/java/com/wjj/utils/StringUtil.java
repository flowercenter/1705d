package com.wjj.utils;

public class StringUtil {
private StringUtil() {}
//�ж��ַ����Ƿ�Ϊ��
public static boolean isNotEmpty(String str) {
	return !(str.equals(null)&&str.length()>0);
}
//ȥ�ո��ж��ַ����Ƿ�Ϊ��
public static boolean isNotEmpotyand(String str) {
	return str.trim().length()>0;
}
//������֤�ֻ���
public static boolean isTellPhone(String num) {
	String reg="^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$";
	boolean matches = num.matches(reg);
	return matches;
}
//������������ַ�
public static String radomChinese(int n) {
	StringBuffer buffer=new StringBuffer();
	Integer start = Integer.valueOf("4e00", 16);
	Integer end = Integer.valueOf("9fa5", 16);
	//������������ַ��㷨����
	for (int i = 0; i <n; i++) {
	char radomChar=(char)((Math.random()*(end-start+1))+start);
	buffer.append(radomChar);
	}
	return buffer.toString();
}
//��������ַ�
public static String  randomString(int n) {
	StringBuffer buffer=new StringBuffer();
	for (int i = 0; i <n; i++) {
		char randomChar=(char)((Math.random()*58)+65);
		//�����㷨��֤����ַ���a-zA-Z���
		
		randomChar=randomChar>90&&randomChar<97?(char)(randomChar+8):randomChar;
		buffer.append(randomChar);
	}
	return buffer.toString();
}
//����1��String changeText(String str)  windowsϵͳ��  ����ǣ� \r\n �滻�� <p></p> ��ǩ  �����\r �滻��<br>
public static String changeText(String str) {
	String reg_text1="\\\\r\\\\n";
	
	String replaceAll = str.replaceAll(reg_text1, "<p></p>");
	String reg_text2="\\\\r";
	String replaceAll2 = replaceAll.replaceAll(reg_text2, "<br>");
	return replaceAll2;
}
//�������֤
public static boolean IsEmail(String email) {
	String reg="^([a-zA-Z]|[0-9])(\\w|\\-)+@[a-zA-Z0-9]+\\.([a-zA-Z]{2,4})$";
	return email.matches(reg);
}
}


