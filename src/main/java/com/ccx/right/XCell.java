/**
 * @Title: XCell.java
 * @Package com.ccx.right
 * @Description: 
 * @author ljf
 * @date 2021年11月10日
 * @version V1.0
 */
package com.ccx.right;

import java.util.Objects;

import com.ccx.data.Book;
import com.ccx.data.LableMark;
import com.ccx.manager.BookManager;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

/**
 * @ClassName: XCell
 * @Description:
 * @author LJF
 * @date 2021年11月10日
 *
 */
public class XCell extends ListCell<LableMark> {
	HBox hbox = new HBox();
	Label label = new Label("");
	Pane pane = new Pane();
	Button button = new Button("X");
	
	private boolean status =false;

	private void active() {
		status = true;
		this.setStyle("-fx-background-color: #7381ca73");
	}
	
	private void disActive() {
		status =false;
		this.setStyle(defaultStyle);
	}
	
	private String defaultStyle ;
	public XCell() {
		super();
		System.out.println("new---------->");
		defaultStyle =this.getStyle();
		hbox.getChildren().addAll(label, pane, button);
		HBox.setHgrow(pane, Priority.ALWAYS);
		button.setOnAction(event -> {
			disActive();
			getListView().getItems().remove(getItem());
			});
		
		this.setOnMouseClicked(event -> {
			if (event.getClickCount() == 2 && event.getButton().name().equals("PRIMARY")) {
				if(BookManager.isActice()) {
					Book book = BookManager.getEditBook().getBook();
					LableMark iteMark= this.itemProperty().get();
					ListView<LableMark> listView = getListView() ;
					listView.getItems().size();
					System.err.println("ListView---size-->"+ listView.getItems().size());
					System.err.println("ListView---Text-->"+ this.label.getText());
					this.label.getText();
					//if(true) return ;
					if(Objects.isNull(iteMark)) {
						getListView().getItems().remove(getItem());
						return ;
					}
					if(book.hasLableMark(iteMark.getId())) {
						//移除
						disActive();
						book.removeLableMark(iteMark.getId());
					}else {
						//添加
						active();
						book.addLableMark(iteMark);
					}
				}
			}
		});
	}

	@Override
	protected void updateItem(LableMark item, boolean empty) {
		super.updateItem(item, empty);
		int size = getListView().getItems().size();
		setText(null);
		setGraphic(null);
		if (item != null && !empty) {
			label.setText(item.getName());
			System.out.println("additme-->"+label.getText()+"size:"+size);
			setGraphic(hbox);
			if(BookManager.isActice() && BookManager.getEditBook().getBook().hasLableMark(this.getItem().getId())) {
				active();
			}else {
				disActive();
			}
		}
	}
}
