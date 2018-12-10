package org.velocity.template.utils;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.velocity.template.sql.SqlResources;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 单例模式的方法来使用模板
 * 
 * @author Huaiku
 * @date Dec 10, 2018
 */
public class SqlUtils {

	private static final Logger logger = LoggerFactory.getLogger(SqlUtils.class);
	private static final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	private static DocumentBuilder xmlBuilder = null;

	static {
		try {
			xmlBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			logger.error("创建DocumentBuilder对象失败.......");
			e.printStackTrace();
		}
	}

	private static class InstanceHolder {
		private static final SqlUtils INSTANCE = new SqlUtils();
	}

	private SqlUtils() {
	}

	public static SqlUtils INSTANCE() {
		return InstanceHolder.INSTANCE;
	}

	private static Document getDocument(String path) {
		Document doc = null;
		URL paths = SqlResources.class.getClassLoader().getResource("");
		path = paths.toString()+"/"+path;
		try {
			doc = xmlBuilder.parse(paths.toString());
		} catch (SAXException | IOException e) {
			logger.error("从XML中获取Document对象失败，路径：{}，错误信息：{}",path,e.getMessage());
		}
		return doc;
	}

	public static void main(String args[]) {
		String path = SqlResources.class.getName();
		path = path.replaceAll("\\.", "/");
		Document doc = getDocument(path+".xml");
		
		NodeList nodes = doc.getDocumentElement().getElementsByTagName("select");
		
		if(nodes!=null) {
			logger.info("nodes....");
		}
	}

}
