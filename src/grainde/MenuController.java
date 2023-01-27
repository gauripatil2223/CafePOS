package grainde;
import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
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
import javafx.scene.control.MenuItem;

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


public class MenuController {
	@FXML
	private TextField 	menu_id;
	@FXML
	private TextField  menu_nm;
	
	
	@FXML
	private MenuItem menu_sel_i;
	
	@FXML
	private Button addbtn;
	
	@FXML 
	private Button rembtn;
	
	@FXML
	private Button EditBtn;
	
	@FXML
	private Button searchBtn;
	
    @FXML 
    private TextField  menu_rate;
    
    @FXML
    private TableView<Menu> mentab;
    
    @FXML
    private TableColumn<Menu ,String> ITEM_ID;
    
    @FXML
    private TableColumn<Menu ,String>  ITEM_NAME;
    
    @FXML
    private TableColumn<Menu ,String>  CATEGORY;
    
    @FXML
    private TableColumn<Menu ,String>  RATE;
    
    @FXML 
    private MenuItem category1;
    
    @FXML
    private MenuItem category2;
    
    @FXML 
    private MenuItem category3;
    
    @FXML
    private ChoiceBox   menu_category;
    
    
    ObservableList<String> menuitems=null;
    
    
    //Adding new menu 
    @FXML 
    private void AddMenu()
    {
    	String idpat="[0-9]";
    	
    	try {
			initialize();
			System.out.println("Initilize called");
			menu_id.setEditable(true);
		String mid=menu_id.getText();
		 if(mid.matches(idpat)) {
			 
		 }
		
		String mnm=menu_nm.getText();
		String Catnm= (String)menu_category.getValue();
		String rate=menu_rate.getText();
		
		//System.out.println("You are in ");
		
		//Employee emobj=new Employee();
		DBConnect dbobj= new DBConnect();
		Connection con=dbobj.getDBConnect();
		
		  PreparedStatement p=con.prepareStatement("insert into menu values('"+mid+"','"+mnm+"','"+Catnm+"','"+rate+"')");
		  int i=p.executeUpdate();
		  Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Add Menu");
	 
	        // Header Text: null
	        alert.setHeaderText(null);
	        alert.setContentText("Menu Item  Added  successfully!");
	 
	        alert.showAndWait();
	        initialize();
		
		}catch(Exception e) {e.printStackTrace();
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Add Menu");
 
        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("  Unsuccessfully!");
 
        alert.showAndWait();
        
		
		}
		
    	
    }
    
    @FXML
    private void RemoveMenu()
    {
    	String sqldel="DELETE FROM MENU WHERE ID="+menu_id.getText();
		try {
			 initialize();
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
		        alert.setContentText("Menu  Deleted  successfully!");
		 
		        alert.showAndWait();
		        initialize();
		        }
		catch(Exception e) {e.printStackTrace();}
			
    }
    
    
    @FXML
    private void EditMenu()
    {
    	 try {
			 initialize();
 			String iid=menu_id.getText();
 		String mfnm= menu_nm.getText();
 		String mencat=(String)menu_category.getValue();
 		String rate= menu_rate.getText();
 		
 		String afterQuery="UPDATE menu SET Menu_Nm='"+mfnm+"', Menu_Cat='"+mencat+"',Rate='"+rate+"' WHERE menu_ID='"+iid+"'";
 		DBConnect dbo=new DBConnect();
 		Connection con1=dbo.getDBConnect();
 		 java.sql.Statement stmt = con1.createStatement();
 		 stmt.executeUpdate(afterQuery);
 		 Alert alert = new Alert(AlertType.INFORMATION);
 	        alert.setTitle("MENU EDITTED");
 	 
 	        // Header Text: null
 	        alert.setHeaderText(null);
 	        alert.setContentText(" Menu Record Edited  successfully!");
 	        
 	        alert.showAndWait();
 		
 	       initialize();
 		 
 		}catch(Exception e) {e.printStackTrace();
 		
		 Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("MENU EDITTED");
	 
	        // Header Text: null
	        alert.setHeaderText(null);
	        alert.setContentText(" Menu Edit  unsuccessfull!");
	        initialize();
	        alert.showAndWait();
 		}
    	
    }
    @FXML 
    private void initcat()
    {
    	menuitems=FXCollections.observableArrayList("SELECT CATEGORY" ,"category 1","category 2","category 3");
    	menu_category.setItems(menuitems);
    }
    
    @FXML
    private void SearchMenu()
    {
    	initialize();
    	String iid=menu_id.getText();
		menu_id.setEditable(false);
		
		String Sbrfore = "SELECT *   FROM MENU WHERE menu_ID='"+iid+"'";
		try {
		DBConnect dbo=new DBConnect();
		Connection con1=dbo.getDBConnect();
		 java.sql.Statement stmt = con1.createStatement();
		 ResultSet rs = stmt.executeQuery(Sbrfore);
		 while(rs.next()) {
		menu_nm.setText(rs.getString("Menu_Nm"));
		menu_category.setValue(rs.getString("Menu_Cat"));
		 menu_rate.setText(rs.getString("Rate"));
		
		 
		 
		 }
		 con1.close();
		 initialize();
		 
		}catch(Exception e) {e.printStackTrace();}
    	
    }
    
    @FXML
    private void  initialize()
    {
    	try {
    		//ITEM_ID.setCellValueFactory(cellData ->cellData.getValue().getEmID().asObject());
    		ITEM_ID.setCellValueFactory(cellData ->cellData.getValue().getMID());
    		ITEM_NAME.setCellValueFactory(cellData ->cellData.getValue().getMnm());
    		CATEGORY.setCellValueFactory(cellData ->cellData.getValue().getCat());
    		RATE.setCellValueFactory(cellData ->cellData.getValue().getRate());
   		
   		 ObservableList<Menu> eml=MenuDOA.getAllRecords();
   		 populateTable(eml);
   		 System.out.println("populated");
    	}catch(Exception e) { e.printStackTrace();}
    }
    
    private void populateTable(ObservableList<Menu> menlist)
	{
		
		mentab.setItems(menlist);
		System.out.println("Items set");
	}
    
   
       public void handleMB() {
        category1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               // System.out.println("Option 3 selected");
            	//menu_category.setText(category1);
            }
        });
        }

}
