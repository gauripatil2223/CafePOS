package grainde;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MenuDOA {
	
	public static ObservableList<Menu> getAllRecords() throws ClassNotFoundException,SQLException{
		String sqlquery="SELECT * FROM MENU";
		 ObservableList<Menu> MenuList=null;
		 ObservableList<Menu> Menlist= FXCollections.observableArrayList();
		 Menu Menuob=null;
		try {
			DBConnect dbo=new DBConnect();
			Connection con1=dbo.getDBConnect();
			 java.sql.Statement stmt = con1.createStatement();
			 ResultSet rs = stmt.executeQuery(sqlquery);
			 System.out.println(rs.next()+"This is rs.next in menu");
			 //System.out.println("got rs");
		//	 EmployeeList=getEmployeeObjects(rs);
			//System.out.println(rs.getCursorName());
			 
			 while(rs.next()) {
				   System.out.println("you are in resultset");
				   Menuob=new Menu(rs.getString("menu_ID"),rs.getString("Menu_Nm"),rs.getString("Menu_Cat"),rs.getString("Rate"));
				  //  System.out.println(rs.getInt("ID"));
				 //   System.out.println(rs.getString("FNM")+"This is FNM");

					Menuob.setMenID(rs.getString(1));
					//System.out.println(empob.getEmpID()+" This is getter method");
					/*empob.setEmpFnm(rs.getString(2));
					empob.setEmpSnm(rs.getString(3));
					empob.setEmpUnm(rs.getString(4));
					empob.setEmpRole(rs.getString(5));
					empob.setEmpPass(rs.getString(6));*/
					Menlist.add(Menuob);
					System.out.println(Menlist.size()+"  is size of menu list");
					System.out.println(Menlist.isEmpty()+"   After Adding Obj");
				}
				
			// System.out.println("EMmployeeList"+EmployeeList.isEmpty());
			 System.out.println("Menu list filler");
			 
		}catch(Exception e) {e.printStackTrace();}
		System.out.println(Menlist.isEmpty()+"  Is menu list empty b r");
		return Menlist;
	}
	

}
