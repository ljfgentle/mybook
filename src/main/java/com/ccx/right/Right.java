/**
 * @Title: Right.java
 * @Package com.ccx.right
 * @Description: 
 * @author ljf
 * @date 2021年11月11日
 * @version V1.0
 */
package com.ccx.right;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import com.ccx.data.LableMark;
import com.ccx.manager.LableManager;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * @ClassName: Right
 * @Description:
 * @author LJF
 * @date 2021年11月11日
 *
 */
public class Right {

	private static class Get {
		private static Right instnce = new Right();
	}

	public static Right get() {
		return Get.instnce;
	}
	VBox labMarkBox = new VBox();

	public void initPanel(BorderPane root) {
		VBox rightbox = new VBox();// lab列表
		AnchorPane right = new AnchorPane();
		right.getChildren().add(rightbox);
		root.setRight(right);
		HBox firstHBox = new HBox();
		TextField textField = new TextField("此处创建标签");
		Button all = new Button("A");
		all.setOnMouseClicked(event -> {
			clearData();
			initData();
		});

		Button button = new Button("N");
		button.setOnMouseClicked(event -> {
			String text = textField.getText();
			if (StringUtils.isBlank(text)) {
				return;
			}
			if (LableManager.exist(text)) {
				return;
			}
			LableMark lableMark = new LableMark();
			lableMark.setName(text);
			lableMark.setId(LableManager.getNextId());
			lableMark.setCreateDate(new Date());
			add(lableMark);
			textField.clear();
			LableManager.addLableMark(lableMark);
		});
		firstHBox.getChildren().add(textField);
		firstHBox.getChildren().add(button);
		firstHBox.getChildren().add(all);
		rightbox.getChildren().add(0, firstHBox);
		rightbox.getChildren().add(labMarkBox);
	}
	
	public void append(LableMark lableMark) {
		labMarkBox.getChildren().add(new HboxCell(labMarkBox, lableMark));
	}
	
	public void add(LableMark lableMark) {
		labMarkBox.getChildren().add(0, new HboxCell(labMarkBox, lableMark));
	} 
	
	public void initData() {
		List<LableMark> list = LableManager.getAll();
		if (CollectionUtils.isEmpty(list))
			return;
		addAll(list);
	}

	public void reLoadData(List<LableMark> list) {
		clearData();
		addAll(list);
	}

	public void addAll(List<LableMark> list) {
		list.forEach(this::add);
	}

	public void clearData() {
		 labMarkBox.getChildren().clear();
	}

	public static void right(BorderPane root) {
		AnchorPane right = new AnchorPane();
		VBox rightbox = new VBox();
		// 把清单对象转换为JavaFX控件能够识别的数据对象
		// ObservableList<String> obList = FXCollections.observableArrayList(snackList);
		// ListView<String> listView = new ListView<>(obList); // 依据指定数据创建列表视图
		ListView<LableMark> listView = new ListView<>(); // 依据指定数据创建列表视图
		listView.setCellFactory(param -> new XCell());
		// rightbox.getChildren().addAll(listView);
		right.getChildren().add(rightbox);
		right.getChildren().add(listView);
		root.setRight(right);
		HBox firstHBox = new HBox();
		TextField textField = new TextField("此处创建标签");
		Button button = new Button();
		button.setOnMouseClicked(event -> {
			String text = textField.getText();
			if (StringUtils.isBlank(text)) {
				return;
			}
			if (LableManager.exist(text)) {
				return;
			}
			LableMark lableMark = new LableMark();
			listView.getItems().add(0, lableMark);
			lableMark.setName(text);
			lableMark.setId(LableManager.getNextId());
			lableMark.setCreateDate(new Date());
			textField.clear();
			LableManager.addLableMark(lableMark);
		});
		firstHBox.getChildren().add(textField);
		firstHBox.getChildren().add(button);
		rightbox.getChildren().add(0, firstHBox);
	}

}
