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

import javafx.stage.StageStyle;
import javafx.util.Duration;
import static  grainde.Main.primaryStage;

public class EmployeeLoad extends AnchorPane{

	private AnchorPane view;
	public EmployeeLoad() {}
   /* public EmployeeLoad(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
	
	public AnchorPane getEmp()
	{
		// fxmlLoader = new FXMLLoader(getClass().getResource("Employee.fxml"));
		try {
		URL fileurl= Main.class.getResource("./Employee.fxml");
		if(fileurl==null)
		{
			throw new java.io.FileNotFoundException("XML FILE NOT FOUND");
		}
		
		view=FXMLLoader.load(fileurl);
		//return view;
		}catch(Exception e) {e.printStackTrace();}
		return view;
    }
	
	public AnchorPane getMenu()
	{
		// fxmlLoader = new FXMLLoader(getClass().getResource("Employee.fxml"));
		try {
		URL fileurl= Main.class.getResource("./Menue.fxml");
		if(fileurl==null)
		{
			throw new java.io.FileNotFoundException("XML FILE NOT FOUND");
		}
		
		view=FXMLLoader.load(fileurl);
		//return view;
		}catch(Exception e) {e.printStackTrace();}
		return view;
    }
	
	public AnchorPane getOrder()
	{
		// fxmlLoader = new FXMLLoader(getClass().getResource("Employee.fxml"));
		try {
		URL fileurl= Main.class.getResource("./Order.fxml");
		if(fileurl==null)
		{
			throw new java.io.FileNotFoundException("XML FILE NOT FOUND");
		}
		
		view=FXMLLoader.load(fileurl);
		//return view;
		}catch(Exception e) {e.printStackTrace();}
		return view;
    }
	
	public AnchorPane getSetting()
	{
		// fxmlLoader = new FXMLLoader(getClass().getResource("Employee.fxml"));
		try {
		URL fileurl= Main.class.getResource("./setting.fxml");
		if(fileurl==null)
		{
			throw new java.io.FileNotFoundException("XML FILE NOT FOUND");
		}
		
		view=FXMLLoader.load(fileurl);
		//return view;
		}catch(Exception e) {e.printStackTrace();}
		return view;
    }

}