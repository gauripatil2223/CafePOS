package grainde;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.collections.FXCollections;
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

public class EmployeeDAO {
	public static ObservableList<Employee> getAllRecords() throws ClassNotFoundException,SQLException{
		String sqlquery="SELECT * FROM EMPLOYEE";
		 ObservableList<Employee> EmployeeList=null;
		 ObservableList<Employee> emplist= FXCollections.observableArrayList();
		 Employee empob=null;
		try {
			DBConnect dbo=new DBConnect();
			Connection con1=dbo.getDBConnect();
			 java.sql.Statement stmt = con1.createStatement();
			 ResultSet rs = stmt.executeQuery(sqlquery);
			 System.out.println(rs.next()+"This is rs.next");
			 System.out.println("got rs");
		//	 EmployeeList=getEmployeeObjects(rs);
			//System.out.println(rs.getCursorName());
			 
			 while(rs.next()) {
				   System.out.println("you are in resultset");
				   empob=new Employee(rs.getInt("ID"),rs.getString("FNM"),rs.getString("SNM"),rs.getString("UNM"),rs.getString("ROLE"),rs.getString("LASTLOG"));
				  //  System.out.println(rs.getInt("ID"));
				 //   System.out.println(rs.getString("FNM")+"This is FNM");

					empob.setEmpID(rs.getInt(1));
					//System.out.println(empob.getEmpID()+" This is getter method");
					/*empob.setEmpFnm(rs.getString(2));
					empob.setEmpSnm(rs.getString(3));
					empob.setEmpUnm(rs.getString(4));
					empob.setEmpRole(rs.getString(5));
					empob.setEmpPass(rs.getString(6));*/
					emplist.add(empob);
					System.out.println(emplist.size());
					System.out.println(emplist.isEmpty()+"After Adding Obj");
				}
				
			// System.out.println("EMmployeeList"+EmployeeList.isEmpty());
			 System.out.println("Emp list filler");
			 
		}catch(Exception e) {e.printStackTrace();}
		System.out.println(emplist.isEmpty());
		return emplist;
	}
	
	/*private static ObservableList<Employee> getEmployeeObjects(ResultSet rs) throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
		ObservableList<Employee> emplist= FXCollections.observableArrayList();
		try {
		System.out.println("You are in obl");
		while(rs.next()) {
			Employee empob=new Employee();
			empob.setEmployeeID(rs.getInt("ID"));
			empob.setEmployeeFnm(rs.getString("FNM"));
			empob.setEmployeeSnm(rs.getString("SNM"));
			empob.setEmployeeUnm(rs.getString("UNM"));
			empob.setEmployeeRole(rs.getString("ROLE"));
			empob.setEmployeePass(rs.getString("PASS"));
			emplist.add(empob);
			System.out.println(emplist.isEmpty()+"After Adding Obj");
		}
		
		}catch(Exception e) {}
		System.out.println(emplist.isEmpty());
		return emplist;	
		
	}
*/
}
