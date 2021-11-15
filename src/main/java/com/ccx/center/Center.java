/**
 * @Title: Center.java
 * @Package com.ccx.center
 * @Description: 
 * @author ljf
 * @date 2021年11月10日
 * @version V1.0
 */
package com.ccx.center;

import org.apache.commons.lang3.StringUtils;

import com.ccx.data.BookTextArea;
import com.ccx.manager.BookManager;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * @ClassName: Center
 * @Description: 
 * @author LJF
 * @date 2021年11月10日
 *
 */
public class Center {
	
	public void center(BorderPane root) {
		VBox center = new VBox();
		HBox buttonBox = new HBox();
		Button save =new Button("√");
		//save.setOnAction(event->BookManager.disActive());
		save.setOnAction(event->{
			BookManager.store(BookManager.getEditBook().getBook());
		});
		
		Button newbutton =new Button("+");
		newbutton.setOnAction(event->{
			ObservableList<Node> ch = center.getChildren();
			if(ch.size()>1) {
				Node node = center.getChildren().get(1);
				if(node instanceof TextArea) {
					BookTextArea textArea = (BookTextArea)node;
					String text = textArea.getText();
					if(StringUtils.isBlank(text)) {
						BookManager.actice(textArea);
						return ;
					}else {
						//textArea.setDisable(true);
						addBookTextArea(center);
						return ;
					}
				}
			}
			addBookTextArea(center);
		});
		center.getChildren().add(buttonBox);
		buttonBox.getChildren().addAll(newbutton,save);
		root.setCenter(center);
	}
	
	private void addBookTextArea(VBox center) {
		BookTextArea textArea = new BookTextArea();
		BookManager.actice(textArea);
		center.getChildren().add(1,textArea);
	}

}
