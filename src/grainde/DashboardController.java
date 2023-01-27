package grainde;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import javafx.application.Application;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import java.io.File;
import java.io.*;
import javafx.scene.layout.Pane;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import static  grainde.Main.primaryStage;

public class DashboardController {
	static Stage secStage;
	@FXML
	private Button btnmenu;
	@FXML
	private Button btnlgout;
	@FXML
	private Button btnempmg;
	
	@FXML
	private Button btnord;
	
	@FXML
	private Button btnbook;
	
	@FXML 
	private Button btnsale;
	
	@FXML
	private Button btnset;
	
	@FXML 
	private Button btnpay;
	@FXML
	private BorderPane mainPane;
	private AnchorPane newPane;
	
	@FXML
	public void GoOrder(ActionEvent ae) {
		try {
			System.out.println("you clicked Order");
			 EmployeeLoad obj = new EmployeeLoad();
			 newPane =obj.getOrder();
			 mainPane.setCenter(newPane);
		
		}catch(Exception e) {
			e.printStackTrace();}
		}
	@FXML
	public void GoEmployee(ActionEvent ae1) {
			try {
				System.out.println("you clicked employee");
				 EmployeeLoad obj = new EmployeeLoad();
				 newPane =obj.getEmp();
				 mainPane.setCenter(newPane);
				// EmployeeController.initilize();
			}catch(Exception e) {
				System.out.println("Printing");
				e.printStackTrace();}
	}
	
	@FXML
	public void GoMenu(ActionEvent ae1) {
		try {
			System.out.println("you clicked Menu");
			 EmployeeLoad obj = new EmployeeLoad();
			 newPane =obj.getMenu();
			 mainPane.setCenter(newPane);
			// EmployeeController.initilize();
		}catch(Exception e) {
			System.out.println("Printing");
			e.printStackTrace();}
	}
	
	@FXML
	public void GoSetting() {
		try {
			System.out.println("you clicked Setting");
			 EmployeeLoad obj = new EmployeeLoad();
			 newPane =obj.getSetting();
			 mainPane.setCenter(newPane);
			// EmployeeController.initilize();
		}catch(Exception e) {
			System.out.println("Printing");
			e.printStackTrace();}
	}
	
	
	
}
