/**
 * @Title: App.java
 * @Package com.ccx
 * @Description: 
 * @author ljf
 * @date 2021年11月7日
 * @version V1.0
 */
package com.ccx;

import java.util.Arrays;
import java.util.List;

import com.ccx.center.Center;
import com.ccx.right.Right;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @ClassName: App
 * @Description:
 * @author LJF
 * @date 2021年11月7日
 *
 */
public class App extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane root = new BorderPane();
		VBox box =new VBox();
		Scene scene = new Scene(root, 600, 400);
		stage.setScene(scene);
		stage.setTitle("hello");

		AnchorPane top = new AnchorPane();
		top.setPrefHeight(100);
		BorderPane bottom = new BorderPane();
		
		root.setTop(box);
		
		root.setBottom(bottom);
		// root.

		MenuBar menuBar = new MenuBar();

		// --- Menu File
		Menu menuFile = new Menu("File");
		//menuFile.setStyle("-fx-font-size:20");
		// --- Menu Edit
		Menu menuEdit = new Menu("Edit");

		// --- Menu View
		Menu menuView = new Menu("View");

		menuBar.getMenus().addAll(menuFile, menuEdit, menuView);
		box.getChildren().add(menuBar);
		left(root);
		Right.get().initPanel(root);
		Right.get().initData();
		Center c =new Center();
		c.center(root);
		
		
		stage.show();
	}
	
	private void left(BorderPane root) {
		List<String> snackList = Arrays.asList("A", "B", "C",
	            "D", "E", "F", "G");
		VBox leftbox =new VBox();
		 // 把清单对象转换为JavaFX控件能够识别的数据对象
	    ObservableList<String> obList = FXCollections.observableArrayList(snackList);
	    ListView<String> listView = new ListView<>(obList); // 依据指定数据创建列表视图
		leftbox.getChildren().addAll(listView);
		
		AnchorPane left = new AnchorPane();
		left.getChildren().add(leftbox);
		root.setLeft(left);
	}
	

}
