package grainde;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class NewItem {
	String iname=null;
	int quant=0;
	int itm_rate=0;
	String spl_req=null;
	String commentss=null;
	int coRR=0;
	
	private StringProperty inameProperty;
	private IntegerProperty  quantProperty;
	private IntegerProperty  itm_rateProperty;
	private StringProperty  spl_reqProperty;
	private StringProperty  cmtProperty;
	private IntegerProperty corrItmRate;
	
	public NewItem() {
		this.inameProperty= new SimpleStringProperty();
		this.quantProperty= new SimpleIntegerProperty();
		this.itm_rateProperty= new SimpleIntegerProperty();
		this.spl_reqProperty= new SimpleStringProperty();
		this.cmtProperty= new SimpleStringProperty();
		this.corrItmRate= new SimpleIntegerProperty();
		
	}
	
	public NewItem(String inm,int qun, int irate, String splcm,String comm, Integer corR ) 
	{
		this.inameProperty= new SimpleStringProperty(inm);
		this.quantProperty= new SimpleIntegerProperty(qun);
		this.itm_rateProperty= new SimpleIntegerProperty(irate);
		this.spl_reqProperty= new SimpleStringProperty(splcm);
		this.cmtProperty= new SimpleStringProperty(comm);
		this.corrItmRate= new SimpleIntegerProperty(corR);
		
	}
	

	//For ITEM NAME
	public String getItemName()
	{
			return this.inameProperty.get();
	}
	public void setItemName(String i)
	{
		this.inameProperty.set(i);
	}
	public StringProperty getINM()
	{
		return inameProperty;
	}
	public String getItemNM()
	{
		return this. iname;
		
	}
	public void setOrdD(String ii)
	{
		this.iname=ii;
	}
	
	// FOR ITEM QUANT
	public int getItem_Quantity()
	{
			return this. quantProperty.get();
	}
	public void setItemQuantity(int i)
	{
		this. quantProperty.set(i);
	}
	public IntegerProperty getItm_Qnt()
	{
		return  quantProperty;
	}
	public int getItm_QT()
	{
		return this.quant;
		
	}
	public void setItem_QT(int ii)
	{
		this.quant=ii;
	}
	
	// FOR ITEM RATE
		public int getItem_rate()
		{
				return this. itm_rateProperty.get();
		}
		public void setItem_rate(int i)
		{
			this.itm_rateProperty.set(i);
		}
		public IntegerProperty getItm_Rate()
		{
			return  itm_rateProperty;
		}
		public int getItm_RT()
		{
			return this.itm_rate;
			
		}
		public void setItm_RT(int ii)
		{
			this.itm_rate=ii;
		}
	
		
	//FOR ITEM SPL_REQ
		public String getItem_Spl_req()
		{
				return this.spl_reqProperty.get();
		}
		public void setItem_Spl_req(String i)
		{
			this.spl_reqProperty.set(i);
		}
		public StringProperty getItm_SplR()
		{
			return  spl_reqProperty;
		}
		public String getItm_SPL()
		{
			return this.spl_req;
			
		}
		public void setItm_SPL(String ii)
		{
			this.spl_req=ii;
		}
		
		//FOR ITEM COMENT
		
		public String getItem_Comment()
		{
				return this.cmtProperty.get();
		}
		public void setItem_Comment(String i)
		{
			this.cmtProperty.set(i);
		}
		public StringProperty getItm_Cmt()
		{
			return  cmtProperty;
		}
		public String getItm_CT()
		{
			return this.commentss;
			
		}
		public void setItm_CT(String ii)
		{
			this.commentss=ii;
		}
		
		
		//For Corresponding item rate 
		public int getItem_corRate()
		{
				return this. corrItmRate.get();
		}
		public void setItemcorRate(int i)
		{
			this. corrItmRate.set(i);
		}
		public IntegerProperty getItm_COR()
		{
			return  corrItmRate;
		}
		public int getItm_CR()
		{
			return this.coRR;
			
		}
		public void setItem_CR(int ii)
		{
			this.coRR=ii;
		}
}
