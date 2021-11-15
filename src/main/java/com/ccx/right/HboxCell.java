/**
 * @Title: HboxCell.java
 * @Package com.ccx.right
 * @Description: 
 * @author ljf
 * @date 2021年11月15日
 * @version V1.0
 */
package com.ccx.right;

import java.util.List;

import com.ccx.data.Book;
import com.ccx.data.LableMark;
import com.ccx.manager.BookManager;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * @ClassName: HboxCell
 * @Description:
 * @author LJF
 * @date 2021年11月15日
 *
 */
public class HboxCell extends HBox {

	Label label = new Label("");
	Pane pane = new Pane();
	Button button = new Button("X");
	LableMark iteMark;
	VBox rightbox;

	private String defaultStyle;
	private boolean status = false;

	private void active() {
		status = true;
		this.setStyle("-fx-background-color: #7381ca73");
	}

	private void disActive() {
		status = false;
		this.setStyle(defaultStyle);
	}

	public HboxCell(VBox rightbox, LableMark iteMark) {
		this.iteMark = iteMark;
		this.rightbox = rightbox;
		this.defaultStyle = this.getStyle();
		this.label.setText(iteMark.getName());
		this.getChildren().addAll(label, pane, button);
		if (BookManager.isActice() && BookManager.getEditBook().getBook().hasLableMark(iteMark.getId())) {
			active();
		} else {
			disActive();
		}
		HBox.setHgrow(pane, Priority.ALWAYS);
		button.setOnAction(event -> {
			disActive();
			rightbox.getChildren().remove(this);
		});

		this.setOnMouseClicked(event -> {
			if (event.getClickCount() == 2 && event.getButton().name().equals("PRIMARY")) {
				if (BookManager.isActice()) {
					Book book = BookManager.getEditBook().getBook();
					if (book.hasLableMark(iteMark.getId())) {
						// 移除
						disActive();
						book.removeLableMark(iteMark.getId());
					} else {
						// 添加
						active();
						book.addLableMark(iteMark);
					}
				}
			}
		});
	}

}
