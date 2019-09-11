package com.wjj.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

public class IOUtil {
	// ����
		public static void closeStream(Closeable... closeAble) {
			for (Closeable closeable2 : closeAble) {
				try {
					closeable2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//������
		public static void copyTo(InputStream input, 
				OutputStream output, 
				boolean needCloseInput, boolean needCloseOutput) throws IOException {
			
			if (input == null || output == null) return;
			// ������������
			BufferedInputStream bis = new BufferedInputStream(input);
			// �����������
			BufferedOutputStream bos = new BufferedOutputStream(output);
			
			byte[] buffer = new byte[1024];
			
			// ����������ȡ  ֱ����󷵻�-1ʱ������ȡ
			while (bis.read(buffer) != -1) {
				// ����ȡ��������  д�� �������
				bos.write(buffer);
			}
			
			// ����ʹ���˻�������������û�йرո� ���������flush������ر�����������ڹر�ʱ���Զ�flush
			bos.flush();
			
			if (needCloseInput) {
				closeStream(input);
			}
			
			if (needCloseOutput) {
				closeStream(output);
			}
		}
		
		// ��ȡ�ı��ļ�
		public static String readTextFile(File file) throws Exception {
			if (file == null) return null;
			StringBuffer sb = new StringBuffer();
			
			FileReader fileReader = new FileReader(file);
			BufferedReader br=new BufferedReader(fileReader);
			String readLine = br.readLine();
			while(readLine!=null) {
				sb.append(readLine);
				readLine = br.readLine();
			}
			return sb.toString();
		}
		
		// ���ж�ȡ�ı��ļ�
		public static List<String> readTextFileByLine(File file) throws Exception {
			if (file == null) return null;
			List<String> list=new ArrayList<String>();
			FileReader fileReader = new FileReader(file);
			BufferedReader br=new BufferedReader(fileReader);
			String readLine = br.readLine();
			while(readLine!=null) {
				list.add(readLine);
				readLine = br.readLine();
			}
			return list;
		}
		
		//д���ı��ļ�
		public static void  inFileWrite(String content,File file) throws IOException {
			OutputStream os=new FileOutputStream(file);
			byte[] bytes = content.getBytes();
			os.write(bytes, 0, bytes.length);
		}
		
		//�����ļ�����
		public static void downloadFile(InputStream is,HttpServletResponse response,boolean closeInputStream,
				boolean closeResponse) throws IOException {
			OutputStream os = response.getOutputStream();
			//������������
			BufferedInputStream bis = new BufferedInputStream(is);
			// ����� ������
			BufferedOutputStream bos = new BufferedOutputStream(os);
	        byte[] buffer = new byte[1024];
	        int bytesRead = bis.read(buffer);
	        while (bytesRead != -1){ //�ص�
	           bos.write(buffer, 0, bytesRead);// ���ļ����͵��ͻ���
	           bytesRead=bis.read(buffer);
	        }
	        if(closeInputStream) {
	        	closeStream(bis,is);
	        }
	        if(closeResponse) {
	        	closeStream(bos,os);
	        }
		}
		
}
