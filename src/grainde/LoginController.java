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

public class LoginController {

	
	
	
	@FXML
	private TextField uname;
	
	@FXML
	private PasswordField pass;
	@FXML
	private Button logbtn;
	
	Stage wind=null;
	public void Login(ActionEvent ae) {
		if(uname.getText().equals("OWNER123") && pass.getText().equals("owner"))
		{
			System.out.println("Successful");
			
		/*	Calendar c1 = Calendar.getInstance();
			 Date dateOne = c1.getTime();
			 long d1=dateOne.getTime();
			 String d2=d1+"";
			// l1.setText("SUCCESSFUL"+d2);
			// wind=(Stage)(()*/
			 try {
			
				AnchorPane loadwe = (AnchorPane)FXMLLoader.load(getClass().getResource("Dashboard3.fxml"));
				Scene scene = new Scene(loadwe);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			 }catch(Exception e) {
				 System.out.println("Printing");
				 e.printStackTrace();
			 }
			/* try {            
		            // Load the database driver for MySQL.            
		            //Class.forName("com.mysql.jdbc.Driver");
		 
		            // Set database connection parameters. 
		            String url = ("jdbc:mysql://localhost/login");
		            String username = ("root"); 
		            String password = ("");            
		            
		            // Create the database connection.            
		          Connection  connection = DriverManager.getConnection(url, username, password);
		          System.out.println("COnnected");
		          PreparedStatement p=connection.prepareStatement("insert into time values('"+d2+"')");
		          int i=p.executeUpdate();
		         System.out.println("Inserted");
		        } 
		        catch ( SQLException ex) {             
		            ex.printStackTrace();          
		        }
		      */
			
		}else {
			System.out.println("UnSucccessful");
			
		}
	}
}
