package org.velocity.template.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IOTemplate {

	private static final Logger logger = LoggerFactory.getLogger(IOTemplate.class);
	
	public static <T> T apply(String path,IOStreamProcessor processor) {
		
		IOException ex = null;
		InputStream input = null;
		T t = null;
		
		try {
			input = new FileInputStream(path);
			t = processor.process(input);
		}catch(IOException e) {
			ex = e;	
		}finally {
			if (input !=null) {
				try {
					input.close();
				} catch (IOException e) {
					if(ex!=null) {
						logger.error("根据路径获取文件流失败，路径：{}，失败原因：{}",path,ex.getMessage());
					} else {
						logger.error("关闭输入流失败，路径：{}，失败原因：{}",path,e.getMessage());
					}
				}
			}
			
			if(ex!=null) {
				logger.error("根据路径获取文件流失败，路径：{}，失败原因：{}",path,ex.getMessage());
			}
		}
		
		return t;
	}
}
