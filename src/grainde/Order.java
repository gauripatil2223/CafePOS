package grainde;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Order {
	String order_id=null;
	String customer_id=null;
	String customer_Name=null;
	String Contact_No=null;
	String ord_item_list=null;
	String spl_req=null;
	String comment=null;
	String Bill=null;
	
	private StringProperty oidProperty;
	private StringProperty  cidProperty;
	private StringProperty  cnmProperty;
	private StringProperty  conProperty;
    private StringProperty ordListProperty;
    private StringProperty splReqProperty;
    private StringProperty commentProperty;
    private StringProperty BillProperty;
    
	
	public Order() {
		
		this.oidProperty= new SimpleStringProperty();
		this.cidProperty= new SimpleStringProperty();
		this.cnmProperty= new SimpleStringProperty();
		this.conProperty= new SimpleStringProperty();
		this.ordListProperty= new SimpleStringProperty();
		this.splReqProperty= new SimpleStringProperty();
		this.commentProperty= new SimpleStringProperty();
		this.BillProperty= new SimpleStringProperty();
		
	}
	public Order(String oid, String cid, String cnm, String con, String ordList, String spl,String Comm, String Bil) 
	{
		this.oidProperty= new SimpleStringProperty(oid);
		this.cidProperty= new SimpleStringProperty(cid);
		this.cnmProperty= new SimpleStringProperty(cnm);
		this.conProperty= new SimpleStringProperty(con);
		this.ordListProperty= new SimpleStringProperty(ordList);
		this.splReqProperty= new SimpleStringProperty(spl);
		this.commentProperty= new SimpleStringProperty(Comm);
		this.BillProperty= new SimpleStringProperty(Bil);
		
		
	}
	

	//For Order ID
	public String getOrderID()
	{
			return this.oidProperty.get();
	}
	public void setOrderID(String i)
	{
		this.oidProperty.set(i);
	}
	public StringProperty getOID()
	{
		return oidProperty;
	}
	public String getOrdID()
	{
		return this. order_id;
		
	}
	public void setOrdD(String ii)
	{
		this.order_id=ii;
	}
	

	//For Customer id
	public String getCustomerID()
	{
			return this.cidProperty.get();
	}
	public void setCustomerID(String i)
	{
		this.cidProperty.set(i);
	}
	public StringProperty getCID()
	{
		return cidProperty;
	}
	public String getCusID()
	{
		return this. customer_id;
		
	}
	public void setCusID(String ii)
	{
		this.customer_id=ii;
	}
	
	//For Customer Name
		public String getCustomerName()
		{
				return this.cnmProperty.get();
		}
		public void setCustomerName(String i)
		{
			this.cnmProperty.set(i);
		}
		public StringProperty getCNM()
		{
			return cnmProperty;
		}
		public String getCusName()
		{
			return this. customer_Name;
			
		}
		public void setCusName(String ii)
		{
			this.customer_Name=ii;
		}
		
		//For Customer contact
		public String getCustomerCNO()
		{
				return this.conProperty.get();
		}
		public void setCustomerCNO(String i)
		{
			this.conProperty.set(i);
		}
		public StringProperty getCCNO()
		{
			return conProperty;
		}
		public String getCusCNO()
		{
			return this.Contact_No;
			
		}
		public void setCusCNO(String ii)
		{
			this.Contact_No=ii;
		}
		//for Order item List
		public String getOrderList()
		{
				return this.ordListProperty.get();
		}
		public void setOrderList(String i)
		{
			this.ordListProperty.set(i);
		}
		public StringProperty getOL()
		{
			return ordListProperty;
		}
		public String getOrdList()
		{
			return this. ord_item_list;
			
		}
		public void setOrdList(String ii)
		{
			this.ord_item_list=ii;
		}
		
		//for spl req
		public String getSpecialRequest()
		{
				return this.splReqProperty.get();
		}
		public void setSpecialRequest(String i)
		{
			this.splReqProperty.set(i);
		}
		public StringProperty getSR()
		{
			return splReqProperty;
		}
		public String getSplReq()
		{
			return this. spl_req;
			
		}
		public void setSplReqt(String ii)
		{
			this.spl_req=ii;
		}
		
		//For Comments
		public String getComment()
		{
				return this.commentProperty.get();
		}
		public void setComment(String i)
		{
			this.commentProperty.set(i);
		}
		public StringProperty getCOMM()
		{
			return commentProperty;
		}
		public String getCom()
		{
			return this. comment;
			
		}
		public void setCom(String ii)
		{
			this.comment=ii;
		}
	
}

class TempListOrder extends Order{
	

}
