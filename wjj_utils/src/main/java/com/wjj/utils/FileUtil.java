package com.wjj.utils;

import java.io.File;
import java.math.BigDecimal;

public class FileUtil {
 private FileUtil() {}
 //��ȡ�ļ���չ��
 public static String getExtensions(String fileName) {
	 int lastIndexof=fileName.lastIndexOf(".");
	 String substring=fileName.substring(lastIndexof);
	 return substring;
 }
 //ɾ���ļ����Ŀ¼����������ļ���������Ŀ¼���ļ���Ҫɾ��
 public static void deleteFile(File f) {
	 if(f.isFile()) {
		 f.delete();
	 }else {
		 //��ȡ����file�����Ӧ����Ŀ¼�����ļ�
		 File[] listFiles = f.listFiles();
		 for (int i = 0; i < listFiles.length; i++) {
			if(listFiles[i].isFile()) {
				listFiles[i].delete();
			}else {
				deleteFile(listFiles[i]);
			}
		}
		 f.delete();
	 }
 }
 //��ȡ����ϵͳ�û�Ŀ¼
 public static File getUserHome() {
	 String property=System.getProperty("user.home");
	 File file=new File(property);
	 return file;
 }
 //�����ļ���С�ģ�Ŀ¼�����ã�
 public static String getFormSize(File file) {
	 if(file.isFile()) {
		 System.out.println(file.length());
		 double kiloByte=file.length()/1024;
		 if(kiloByte<1) {
			 return file.length()+"Byte(s)";
		 }
		 double megaByte=kiloByte/1024;
		 if(megaByte<1) {
			 //��ȡ�߾��� �ĸ���������
			 BigDecimal result1=new BigDecimal(Double.toString(kiloByte));
			 return result1.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString()+"KB";
		 }
		 double gigaByte=megaByte/1024;
		 if(gigaByte<1) {
			 BigDecimal result2=new BigDecimal(Double.toString(megaByte));
		 }
		 double teraBytes=gigaByte/1024;
		 if(teraBytes<1) {
			 BigDecimal result3=new BigDecimal(Double.toString(gigaByte));
		  return result3.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "GB";
		 }
		 BigDecimal result4 = new BigDecimal(teraBytes);
			return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "TB";
	 }
	 return file+"ΪĿ¼";
	
 }
}
