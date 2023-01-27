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


public class DBConnect {
	DBConnect(){
		
	}
	Connection conn;
	public Connection getDBConnect()
	{
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 String url = ("jdbc:mysql://localhost/grainde");
	         String username = ("root"); 
	         String password = ("");
	         conn = DriverManager.getConnection(url, username, password);
	         System.out.println("COnnected");
			}catch(Exception e) { e.printStackTrace();}
		return conn;
	}

}
