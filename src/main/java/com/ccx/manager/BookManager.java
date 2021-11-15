/**
 * @Title: BookManager.java
 * @Package com.ccx.manager
 * @Description: 
 * @author ljf
 * @date 2021年11月10日
 * @version V1.0
 */
package com.ccx.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.ccx.data.Book;
import com.ccx.data.BookTextArea;

/**
 * @ClassName: BookManager
 * @Description: 
 * @author LJF
 * @date 2021年11月10日
 *
 */
public class BookManager {
	
	private static Map<Integer, Book> bookMap= new HashMap<>();
	
	private static int currentBookId = 0;
	
	private static BookTextArea editBook;
	
	//private static BookTextArea focusBook;
	
	public static void disActive() {
		if(isActice()) {
			//editBook.setDisable(true);
			editBook.setStyle("-fx-background-color: #ffffffd9");
			//editBook =null;
		}
	}
	
	public static void actice(BookTextArea bookTextArea) {
		//editBook.setDisable(false);
		disActive();
		editBook = bookTextArea;
		editBook.setStyle("-fx-background-color: #fc5531");
	}
	
	public static boolean isActice() {
		return Objects.nonNull(editBook);
	}
	
	public static int getNextId() {
		return currentBookId++;
	}
	
	public static void store(Book book) {
		bookMap.put(book.getId(), book);
	}

	/**
	 * @return the editBook
	 */
	public static BookTextArea getEditBook() {
		return editBook;
	}

	/**
	 * @param editBook the editBook to set
	 */
	public static void setEditBook(BookTextArea editBook) {
		disActive();
		BookManager.editBook = editBook;
	}

	

}
