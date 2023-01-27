package grainde;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Menu {
	
	String menu_iid=null;
	String menu_name=null;
	String Category=null;
	String rate =null;
	
	
	private StringProperty midProperty;
	private StringProperty  mnmProperty;
	private StringProperty  catnmProperty;
	private StringProperty  rateProperty;
	
	public Menu()
	{
		this.midProperty= new SimpleStringProperty();
		this.mnmProperty= new SimpleStringProperty();
		this.catnmProperty= new SimpleStringProperty();
		this.rateProperty= new SimpleStringProperty();
		
	}
	public Menu(String i, String n , String cat, String rate)
	{
	this.midProperty= new SimpleStringProperty(i);
	this.mnmProperty= new SimpleStringProperty(n);
	this.catnmProperty= new SimpleStringProperty(cat);
	this. rateProperty= new SimpleStringProperty(rate);
	
	
		
		
	}
	
	//For Menu ID
	public String getMenuID()
	{
			return this.midProperty.get();
	}
	public void setMenuID(String i)
	{
		this.midProperty.set(i);
	}
	public StringProperty getMID()
	{
		return midProperty;
	}
	public String getMenID()
	{
		return this. menu_iid;
		
	}
	public void setMenID(String ii)
	{
		this. menu_iid=ii;
	}
	
	// For Menu Name
	public String getMenuMnm()
	{
		return this.mnmProperty.get();
	}
	public void setMenuMnm(String f)
	{
		this.mnmProperty.set(f);
	}
	
	public StringProperty getMnm()
	{
		return mnmProperty;
	}
	public String getMenMnm()
	{
		return this.menu_name;
		
	}
	public void setMenMnm(String fn)
	{
		this.menu_name=fn;
	}
	
	//For Menu Category
	public String getMenuCat()
	{
		return this. catnmProperty.get();
	}
	public void setMenuCat(String f)
	{
		this. catnmProperty.set(f);
	}
	
	public StringProperty getCat()
	{
		return  catnmProperty;
	}
	public String getMenCat()
	{
		return this.Category;
		
	}
	public void setMenCat(String fn)
	{
		this.Category=fn;
	}
	
	//For Rate
	public String getMenuRate()
	{
		return this. rateProperty.get();
	}
	public void setMenuRate(String f)
	{
		this. rateProperty.set(f);
	}
	
	public StringProperty getRate()
	{
		return  rateProperty;
	}
	public String getMenRate()
	{
		return this.rate;
		
	}
	public void setMenRate(String fn)
	{
		this.rate=fn;
	}
	
}
