/**
 * @Title: FileUtil.java
 * @Package com.ccx.file
 * @Description: 
 * @author ljf
 * @date 2021年11月9日
 * @version V1.0
 */
package com.ccx.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @ClassName: FileUtil
 * @Description: 
 * @author LJF
 * @date 2021年11月9日
 *
 */
public class FileUtil {
	
	
	public static <T> List<T> readFileIO( String fileName,Class<T> c) throws Exception {
	    File file = new File(fileName);
	    List<T> list = new ArrayList<>();
	    InputStreamReader reader = new InputStreamReader(new FileInputStream(file)); // 建立一个输入流对象reader
	    BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
	    String line = ""; // 每一行的内容
	    while ((line = br.readLine()) != null) {
	    	T obj = toObj(line.trim(),c);
	    	list.add(obj);
	    }
	    reader.close();
	    br.close();
	    return list;
	}
	
	public static String toString(Object value) {
		try {
		return	objectMapper.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static <T> T toObj(String str,Class<T> t) {
		try {
			return objectMapper.readValue(str, t);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static final ObjectMapper objectMapper = new ObjectMapper();
	static {
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
		objectMapper.configure(SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN, true);
		objectMapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY,true);
	}
	
	public static ObjectMapper getObjectMapper() {
		return objectMapper;
	}
}
