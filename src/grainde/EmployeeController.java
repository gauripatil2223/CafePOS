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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
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
import javafx.collections.FXCollections;
import com.mysql.jdbc.Statement;

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
import javafx.scene.layout.Pane;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import static  grainde.Main.primaryStage;

public class EmployeeController {
	
 
	@FXML
	private TextField tid ;
	
	@FXML
	private TextField tfnm ;
	
	@FXML
	private TextField tsnm;
	
	@FXML
	private TextField tunm;
	
	@FXML
	private TextField trole;
	
	@FXML
	private TextField  tpass;
	
	@FXML 
	private  TableView<Employee> EmpInfo;
	
	@FXML
	private   TableColumn<Employee ,Integer> empID;
	
	@FXML
	private  TableColumn<Employee ,String> empFnm;
	
	@FXML
	private TableColumn<Employee ,String>empSnm;
	
	@FXML
	private TableColumn<Employee ,String> empUnm;
	@FXML
	private TableColumn<Employee ,String> empRole;
	
	@FXML
	private TableColumn<Employee ,String> empLog;
	
	//ObservableList<Employee> ob=new FXCollections.observableArrayList();
	private ObservableList<ObservableList> data;
	  
	@FXML 
	private Button addEmpbtn;
	
	@FXML
	private Button remEmpbtn;
	
	@FXML
	private Button ediEmpbtn;
	
	@FXML
	private Button searchEmpbtn;
	
	
	
	
	@FXML
	private void AddEmployeeRecord()
	{
		//data = FXCollections.observableArrayList();
		try {
			initialize();
			System.out.println("Initilize called");
		String eid=tid.getText();
		String fnm=tfnm.getText();
		String snm=tsnm.getText();
		String unm=tunm.getText();
		String role=trole.getText();
		String pass=tpass.getText();
		String lastlog=null;
		System.out.println("You are in ");
		
		Employee emobj=new Employee();
		DBConnect dbobj= new DBConnect();
		Connection con=dbobj.getDBConnect();
		
		  PreparedStatement p=con.prepareStatement("insert into employee values('"+eid+"','"+fnm+"','"+snm+"','"+unm+"','"+role+"','"+pass+"','"+lastlog+"')");
          int i=p.executeUpdate();
          Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Add Record");
	 
	        // Header Text: null
	        alert.setHeaderText(null);
	        alert.setContentText("Record Added  successfully!");
	 
	        alert.showAndWait();
		
		}catch(Exception e) {e.printStackTrace();}
		
	}
	
	

	
	
	@FXML 
	private  void initialize() {
		try {
		 empID.setCellValueFactory(cellData ->cellData.getValue().getEmID().asObject());
		 empFnm.setCellValueFactory(cellData ->cellData.getValue().getEmFnm());
		 empSnm.setCellValueFactory(cellData ->cellData.getValue().getEmSnm());
		 empUnm.setCellValueFactory(cellData ->cellData.getValue().getEmUnm());
		 empRole.setCellValueFactory(cellData ->cellData.getValue().getEmRole());
		 empLog.setCellValueFactory(cellData ->cellData.getValue().getEmLog());
		 ObservableList<Employee> eml=EmployeeDAO.getAllRecords();
		 populateTable(eml);
		 System.out.println("populated");
		 
		 //Editing 
		/* EmpInfo.setEditable(true);

		 empFnm.setCellFactory(TextFieldTableCell.forTableColumn());
		  String t1= empFnm.getText();
		 empSnm.setCellFactory(TextFieldTableCell.forTableColumn());
		  String t2=empSnm.getText();
		 empUnm.setCellFactory(TextFieldTableCell.forTableColumn());
		 String t3=empUnm.getText();
		 empRole.setCellFactory(TextFieldTableCell.forTableColumn());
		 String t4=empRole.getText();*/
		 
		 
		 
		}catch(Exception e) { System.out.println("Exception in initilize");
		e.printStackTrace();
		}
	}
	
	private void populateTable(ObservableList<Employee> emlist)
	{
		
		EmpInfo.setItems(emlist);
		System.out.println("Items set");
	}
	
	@FXML
	private void DeletEmployee()
	{
		String sqldel="DELETE FROM EMPLOYEE WHERE ID="+tid.getText();
		try {
			 
			//Employee emdelet=new Employee();
			DBConnect dbobj= new DBConnect();
			Connection con2=dbobj.getDBConnect();
			java.sql.Statement stmt = con2.createStatement();
			 stmt.executeUpdate(sqldel);
			 System.out.println("Record deleted");
			 initialize();
			 Alert alert = new Alert(AlertType.INFORMATION);
		        alert.setTitle("Delete Record");
		 
		        // Header Text: null
		        alert.setHeaderText(null);
		        alert.setContentText("Record Deleted  successfully!");
		 
		        alert.showAndWait();
			
		}catch(Exception e) { e.printStackTrace();}
		
	}
	
	@FXML
	private  void EditEmployee()
	{
		
		 
		 //EDiting
		 try {
			 
			String iid=tid.getText();
		String nfnm= tfnm.getText();
		String nsnm=tsnm.getText();
		String unmu= tunm.getText();
		String nrole=trole.getText();
		String afterQuery="UPDATE EMPLOYEE SET FNM="+nfnm+", SNM="+nsnm+",UNM="+unmu+"ROLE="+nrole+"WHERE ID='"+iid+"'";
		DBConnect dbo=new DBConnect();
		Connection con1=dbo.getDBConnect();
		 java.sql.Statement stmt = con1.createStatement();
		 stmt.executeUpdate(afterQuery);
		 Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("RECORD EDITTED");
	 
	        // Header Text: null
	        alert.setHeaderText(null);
	        alert.setContentText("Record Edited  successfully!");
	        initialize();
	        alert.showAndWait();
		
		
		 
		}catch(Exception e) {e.printStackTrace();}
		
		
	}
	
	@FXML
	private void SearchEmp()
	{
		String iid=tid.getText();
		tid.setEditable(false);
		
		String Sbrfore = "SELECT FNM , SNM, UNM , ROLE FROM EMPLOYEE WHERE ID="+iid;
		try {
		DBConnect dbo=new DBConnect();
		Connection con1=dbo.getDBConnect();
		 java.sql.Statement stmt = con1.createStatement();
		 ResultSet rs = stmt.executeQuery(Sbrfore);
		 while(rs.next()) {
		 tfnm.setText(rs.getString("FNM"));
		 tsnm.setText(rs.getString("SNM"));
		 tunm.setText(rs.getString("UNM"));
		 trole.setText(rs.getString("ROLE"));
		 
		 
		 }
		 con1.close();
		 initialize();
		 
		}catch(Exception e) {e.printStackTrace();}
		
	}
/*	public void changeFnm(CellEditEvent editedcell)
	{
		Employee newobj=EmpInfo.getSelectionModel().getSelectedItem();
		newobj.setEmployeeFnm(editedcell.getNewValue().toString());
	}
	
	public void changeSnm(CellEditEvent editedcell)
	{
		Employee newobj=EmpInfo.getSelectionModel().getSelectedItem();
		newobj.setEmployeeSnm(editedcell.getNewValue().toString());
	}
	
	public void changeUnm(CellEditEvent editedcell)
	{
		Employee newobj=EmpInfo.getSelectionModel().getSelectedItem();
		newobj.setEmployeeUnm(editedcell.getNewValue().toString());
	}
	
	public void changePass(CellEditEvent editedcell)
	{
		Employee newobj=EmpInfo.getSelectionModel().getSelectedItem();
		newobj.setEmployeePass(editedcell.getNewValue().toString());
	}
	public void changeRole(CellEditEvent editedcell)
	{
		Employee newobj=EmpInfo.getSelectionModel().getSelectedItem();
		newobj.setEmployeeRole(editedcell.getNewValue().toString());
	}*/
}
