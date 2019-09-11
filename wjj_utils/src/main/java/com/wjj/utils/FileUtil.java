package com.wjj.utils;

import java.io.File;
import java.math.BigDecimal;

public class FileUtil {
 private FileUtil() {}
 //获取文件拓展名
 public static String getExtensions(String fileName) {
	 int lastIndexof=fileName.lastIndexOf(".");
	 String substring=fileName.substring(lastIndexof);
	 return substring;
 }
 //删除文件如果目录。则下面的文件和所有子目录的文件都要删除
 public static void deleteFile(File f) {
	 if(f.isFile()) {
		 f.delete();
	 }else {
		 //获取包含file对象对应的子目录或者文件
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
 //获取操作系统用户目录
 public static File getUserHome() {
	 String property=System.getProperty("user.home");
	 File file=new File(property);
	 return file;
 }
 //返回文件大小的（目录不适用）
 public static String getFormSize(File file) {
	 if(file.isFile()) {
		 System.out.println(file.length());
		 double kiloByte=file.length()/1024;
		 if(kiloByte<1) {
			 return file.length()+"Byte(s)";
		 }
		 double megaByte=kiloByte/1024;
		 if(megaByte<1) {
			 //获取高精度 的浮点型数据
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
	 return file+"为目录";
	
 }
}
