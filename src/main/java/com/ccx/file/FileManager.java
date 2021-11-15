/**
 * @Title: FileManager.java
 * @Package com.ccx.file
 * @Description: 
 * @author ljf
 * @date 2021年11月15日
 * @version V1.0
 */
package com.ccx.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.ccx.data.Book;

import javafx.scene.shape.Line;

/**
 * @ClassName: FileManager
 * @Description:
 * @author LJF
 * @date 2021年11月15日
 *
 */
public class FileManager {

	public File getFileName(String faileName) {
		String duefalutFileName = "ljf.lab";
		if (StringUtils.isBlank(faileName)) {
			faileName = duefalutFileName;
		}
		File file = new File(duefalutFileName);
		try {
			file.createNewFile();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	public List<Book> loadBooks() {

		try {
			RandomAccessFile rFile = new RandomAccessFile(getFileName(null), "rw");
			String line = rFile.readLine();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void append(List<Book> books) {
		try (RandomAccessFile rFile = new RandomAccessFile(getFileName(null), "rw")) {
			for(Book book:books) {
				String bookStr = FileUtil.toString(book);
				rFile.write(bookStr.getBytes());
				rFile.write("/r/n".getBytes());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void save(Book book) {
		try (RandomAccessFile rFile = new RandomAccessFile(getFileName(null), "rw")) {
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void del() {
		
	}

}
