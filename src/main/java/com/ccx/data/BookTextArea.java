/**
 * @Title: BookTextArea.java
 * @Package com.ccx.data
 * @Description: 
 * @author ljf
 * @date 2021年11月10日
 * @version V1.0
 */
package com.ccx.data;

import java.util.List;


import com.ccx.manager.BookManager;
import com.ccx.right.Right;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;

/**
 * @ClassName: BookTextArea
 * @Description:
 * @author LJF
 * @date 2021年11月10日
 *
 */
public class BookTextArea extends TextArea {

	private Book book = new Book();

	public BookTextArea() {
		book.setId(BookManager.getNextId());
		book.setStatus(true);
		BookManager.setEditBook(this);
		this.setPrefHeight(20);
		this.textProperty()
				.addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
					this.setPrefHeight(this.getLayoutBounds().getHeight());
					book.setContent(this.getText());
					BookManager.store(book);
				});
		this.setOnMouseClicked(event->{
			if (event.getClickCount() == 2 && event.getButton().name().equals("PRIMARY")) {
				BookManager.actice(this);
			}
			if (event.getClickCount() == 1 && event.getButton().name().equals("PRIMARY")) {
				BookManager.actice(this);
				List<LableMark> lables = book.getLables();
				Right.get().reLoadData(lables);
			}
		});
	}

	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}

}
