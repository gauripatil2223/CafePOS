package grainde;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
import java.util.List;
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
public class OrderController {

	@FXML 
	private TextField tord_id;
	@FXML 
	private TextField tcid;
	@FXML 
	private TextField tcnm;
	@FXML
	private TextField tcno;
	@FXML 
	private  TextField tsplreq;
	@FXML 
	private TextField tcomm;
	@FXML
	private TextField tdiscnt;
	
	@FXML 
	private ChoiceBox sel_category;
	@FXML 
	private ChoiceBox additembox;
	
	@FXML
	private ChoiceBox remitembox;
	
	@FXML
	private Button  Additem;
	
	@FXML 
	private Button RemItem;
	@FXML
	private Button AddOrder;
	@FXML 
	private Button cancelOrder;
	@FXML
	private Button genBill;
	
	@FXML
	private TableView<NewItem> ordtab;
	@FXML
	private TableColumn<NewItem,String> FOOD_ITEM;
	@FXML
	private TableColumn<NewItem,Integer> QUANTITY;
	@FXML
	private TableColumn<NewItem,Integer>RATE;
	@FXML 
	private TableColumn<NewItem,String> SPECIAL_REQUEST;
	@FXML 
	private TableColumn<NewItem,String> COMMENTS;
	@FXML
	private TableColumn<NewItem,Integer> COST;
	
	@FXML 
	private Spinner<Integer> AddQuant;
	
	@FXML
	private Spinner<Integer> RemQuant;
	 ObservableList<NewItem> itemdata= FXCollections.observableArrayList();	
	@FXML
	private Label billamt;
	 
	@FXML
	private void initialize()
	{
		ObservableList<String> catlist = FXCollections.observableArrayList();
		
		
		try {
		DBConnect dbobj= new DBConnect();
		Connection con=dbobj.getDBConnect();
		String query1="SELECT Menu_Cat FROM MENU ";
		java.sql.Statement stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery(query1);
		 while(rs.next()) {
			if(catlist.contains(rs.getString(1))==true) {
			//catlist.add(rs.getString(1));
			}else {
				catlist.add(rs.getString(1));
					
			}
		 
		 }
		 for(int i=0;i<catlist.size();i++) {
			 System.out.println(catlist.get(i));
		 }
		 con.close();
		 sel_category.setItems(catlist);
		 
		}catch(Exception e) {e.printStackTrace();}
		
		
		initSpinner();
		FOOD_ITEM.setCellValueFactory(new PropertyValueFactory<NewItem, String>("inameProperty"));
		QUANTITY.setCellValueFactory(new PropertyValueFactory<NewItem, Integer>("quantProperty"));
		RATE.setCellValueFactory(new PropertyValueFactory<NewItem, Integer>("itm_rateProperty"));
		SPECIAL_REQUEST.setCellValueFactory(new PropertyValueFactory<NewItem, String>("spl_reqProperty"));
		COMMENTS.setCellValueFactory(new PropertyValueFactory<NewItem, String>("cmtProperty"));
		COST.setCellValueFactory(new PropertyValueFactory<NewItem, Integer>("corrItmRate"));
		
	}
	
	@FXML
	 private void initSpinner() {
		AddQuant.setValueFactory(
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100)
        );
		
		RemQuant.setValueFactory(
	            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100)
	        );
    }

	@FXML
	private void init2()
	{
		
		ObservableList<String> menli =FXCollections.observableArrayList();
		String cat =(String)sel_category.getValue();
		System.out.println(cat);
		String Querymenu="SELECT Menu_Nm FROM MENU WHERE Menu_Cat='"+cat+"'";
		try {
			DBConnect dbobj= new DBConnect();
			Connection con=dbobj.getDBConnect();
			java.sql.Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(Querymenu);
			 while(rs.next()) {
					if(menli.contains(rs.getString(1))==true) {
					//catlist.add(rs.getString(1));
					}else {
						menli.add(rs.getString(1));
							
					}
					
					 
			 }
			 for(int i=0;i<menli.size();i++) {
				 System.out.println(menli.get(i));
			 }
			//con.close();
			//additembox.getItems().addAll(menli);
			additembox.setItems(menli);
			additembox.show();
		}catch(Exception e) {e.printStackTrace();}
		
	}
	
	@FXML
	private void AddOrdItem()
	{
		System.out.println("Additem called");
		int irate=0;
		String orditm= (String) additembox.getValue();
		int qunt=AddQuant.getValue();
		//String irate=
		String req=tsplreq.getText();
		String comt=tcomm.getText();
		String sqlquery="SELECT Rate FROM MENU WHERE Menu_Nm='"+orditm+"'";
		int corRate=0;
		try {
			DBConnect dbo=new DBConnect();
			Connection con1=dbo.getDBConnect();
			 java.sql.Statement stmt = con1.createStatement();
			 ResultSet rs = stmt.executeQuery(sqlquery);
			 while(rs.next()) {
				irate =Integer.parseInt(rs.getString(1));
			 }
			 System.out.println(irate+"  got rate");
			 corRate=qunt*irate;
			 
		}catch(Exception e) {e.printStackTrace();}
		
		NewItem nitm= new NewItem(orditm,qunt,irate,req,comt,corRate);
		
		//ordtab.getItem().add(nitm);
		itemdata.add(nitm);
		System.out.println(itemdata.size()+"  This is the size of item data  list");
		FOOD_ITEM.setCellValueFactory(cellData ->cellData.getValue().getINM());
		QUANTITY.setCellValueFactory(cellData ->cellData.getValue(). getItm_Qnt().asObject());
		RATE.setCellValueFactory(cellData ->cellData.getValue(). getItm_Rate().asObject());
		SPECIAL_REQUEST.setCellValueFactory(cellData ->cellData.getValue().getItm_SplR());
		COMMENTS.setCellValueFactory(cellData ->cellData.getValue().getItm_Cmt());
		COST.setCellValueFactory(cellData ->cellData.getValue(). getItm_COR().asObject());
		ordtab.setItems(itemdata);
		
		//additembox.setValue("null");
		
		
	}
	
	@FXML
	private void initRemList()
	{

		ObservableList<String> relist = FXCollections.observableArrayList();

		for(int i=0;i<itemdata.size();i++)
		{
			NewItem selecteditems=itemdata.get(i);
			String itemsel=selecteditems. getItemName();
			relist.add(itemsel);
		}
		remitembox.setItems(relist);
	}
	
	@FXML 
	private void RemoveOrdItem()
	{
		
		String rem=(String)remitembox.getValue();
		for(int j=0;j<itemdata.size();j++)
		{
		    if(itemdata.get(j).getItemName().contentEquals(rem))
		    {
		    	if(itemdata.get(j).getItem_Quantity()==1 || itemdata.get(j).getItem_Quantity()<0 || itemdata.get(j).getItem_Quantity()==RemQuant.getValue())
		    	{
		    	itemdata.remove(itemdata.get(j));
		    	ordtab.setItems(itemdata);
		    	}else {
		    		int cn=itemdata.get(j).getItem_Quantity();
		    		cn=cn-RemQuant.getValue();
		    		itemdata.get(j).setItemQuantity(cn);
		    		ordtab.setItems(itemdata);
		    		
		    	}
		    }
		}
		
		
		
	}
	
	@FXML
	private void AddOrder()
	{
		
		List<String> newjoin=new ArrayList<String>();
		List<String > req=new ArrayList<String>();
		List<String > cmt=new ArrayList<String>();
		double grandtotal=0.0;
		System.out.println("Add order");
		for(int k=0;k<itemdata.size();k++)
		{
			
			String itm=itemdata.get(k).getItemName();
			System.out.println(itm);
			String re=itemdata.get(k).getItem_Spl_req();
			String comt=itemdata.get(k).getItem_Comment();
			int q=itemdata.get(k).getItem_Quantity();
			int r=itemdata.get(k).getItem_rate();
			grandtotal=grandtotal+(q*r);
			newjoin.add(itm);
			System.out .println( " item list prepared");
			req.add(re);
			cmt.add(comt);
			
		}
		/*if(tdiscnt.getText()!=null)
		{
			int discount=Integer.parseInt(tdiscnt.getText());
		grandtotal=grandtotal-discount;
		}*/
		String joinedItem = String.join(":", newjoin);
		String joinedreq= String.join(":", req);
		String joinedCmt= String.join(":", cmt);
		String bill=Double.toString(grandtotal);
		String oid=tord_id.getText();
		String cid=tcid.getText();
		String cnm=tcnm.getText();
		String cno=tcno.getText();
		try {
			DBConnect dbobj= new DBConnect();
			Connection con=dbobj.getDBConnect();
			String sqlquery="INSERT INTO order1 VALUES('"+oid+"','"+cid+"','"+cnm+"','"+cno+"','"+joinedItem+"','"+joinedreq+"','"+joinedCmt+"','"+bill+"','1')";
			String demo ="INSERT INTO ORDER1 VALUES (121, 1222, askda, 0987654412, jsad:ada:asd:asda, Asdas:asas:asas:sas, ad:ada:asdas:asdas, 7782)"
;			PreparedStatement p=con.prepareStatement(sqlquery);
	          int i=p.executeUpdate();
	          Alert alert = new Alert(AlertType.INFORMATION);
		        alert.setTitle("Add Order");
		 
		        // Header Text: null
		        alert.setHeaderText(null);
		        alert.setContentText("Order Added  successfully!");
		 
		        alert.showAndWait();
		}catch(Exception e) {e.printStackTrace();
		
		Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Add Order");
 
        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Cannot Add Order !!");
 
			
		}
		
	
		
		
		
	}
	
	@FXML 
	private void CancelOrder()
	{
		
	}
	
	@FXML
	private void GenerateBill()
	{
		String bi=null;
		String orderid=tord_id.getText();
		String query="SELECT bill from order1 WHERE order_id='"+orderid+"'";
		try {
			
				DBConnect dbobj= new DBConnect();
				Connection con=dbobj.getDBConnect();
				java.sql.Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery(query);
				 while(rs.next()) {
					 bi=rs.getString(1);
				 }
				 billamt.setText(bi+"  RS");
			
		}catch(Exception e) {e.printStackTrace();}
	}
	
	
	
}
