package grainde;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee {
	int id=0;
	String firstname=null;
	String surname=null;
	String username=null;
	String Role=null;
	String Pass=null;
	String LastLogin=null;
	
	private IntegerProperty idProperty;
	private StringProperty  fnmProperty;
	private StringProperty  snmProperty;
	private StringProperty  unmProperty;
	private StringProperty  roleProperty;
	private StringProperty  passProperty;
	private StringProperty  lastlogProperty;
	
	
	public Employee() {
		this.idProperty= new SimpleIntegerProperty();
		this.fnmProperty= new SimpleStringProperty();
		this.snmProperty= new SimpleStringProperty();
		this.unmProperty= new SimpleStringProperty();
		this.roleProperty= new SimpleStringProperty();
		this.passProperty= new SimpleStringProperty();
		this.lastlogProperty= new SimpleStringProperty();
		
	}
	public Employee(int i,String fn, String sn , String un, String r,String pas)
	{this.idProperty= new SimpleIntegerProperty(i);
	this.fnmProperty= new SimpleStringProperty(fn);
	this.snmProperty= new SimpleStringProperty(sn);
	this.unmProperty= new SimpleStringProperty(un);
	this.roleProperty= new SimpleStringProperty(r);
	this.passProperty= new SimpleStringProperty(pas);
	this.lastlogProperty= new SimpleStringProperty("null");
	
		
		
	}
	
	//FOR ID
	public int getEmployeeID()
	{
			return this.idProperty.get();
	}
	public void setEmployeeID(int i)
	{
		this.idProperty.set(i);
	}
	public IntegerProperty getEmID()
	{
		return idProperty;
	}
	public int getEmpID()
	{
		return this.id;
		
	}
	public void setEmpID(int ii)
	{
		this.id=ii;
	}

	//FOR FNM
	public String getEmployeeFnm()
	{
		return this.fnmProperty.get();
	}
	public void setEmployeeFnm(String f)
	{
		this.fnmProperty.set(f);
	}
	
	public StringProperty getEmFnm()
	{
		return fnmProperty;
	}
	public String getEmpFnm()
	{
		return this.firstname;
		
	}
	public void setEmpFnm(String fn)
	{
		this.firstname=fn;
	}
	
	//FOR SNM
	public String getEmployeeSnm()
	{
		return this.snmProperty.get();
	}
	public void setEmployeeSnm(String s)
	{
		this.snmProperty.set(s);
	}
	
	public StringProperty getEmSnm()
	{
		return snmProperty;
	}
	public String getEmpSnm()
	{
		return this.surname ;
		
	}
	public void setEmpSnm(String sn) {
		this.surname=sn;
	}
	
	
	//FOR UNM
	
	public String getEmployeeUnm()
	{
		return this.unmProperty.get();
	}
	public void setEmployeeUnm(String u)
	{
		this.unmProperty.set(u);
	}
	
	public StringProperty getEmUnm()
	{
		return unmProperty;
	}
	public String getEmpUnm()
	{
		return this.username;
	}
	public void setEmpUnm(String un)
	{
		this.username=un;
		
	}
	
	//FOR ROLE
	public String getEmployeeRole()
	{
		return this.roleProperty.get();
	}
	public void setEmployeeRole(String r)
	{
		this.roleProperty.set(r);
	}
	public StringProperty getEmRole()
	{
		return roleProperty;
	}
	
	public String getEmpRole()
	{
		return this.Role;
	}
	public void setEmpRole(String r)
	{
		this.Role=r;
	}
	
	//FOR PASS
	public String getEmployeePass()
	{
		return this.passProperty.get();
	}
	public void setEmployeePass(String p)
	{
		this.passProperty.set(p);
	}
	public StringProperty getEmPass()
	{
		return passProperty;
	}
	public String getEmpPass()
	{
		return this.Pass;
	}
	public void setEmpPass(String pas)
	{
		this.Pass=pas;
	}
	
	//LAST LOGIN
	
	public String getEmployeeLog()
	{
		return this.lastlogProperty.get();
	}
	public void setEmployeeLog(String l)
	{
		this.lastlogProperty.set(l);
	}
	public StringProperty getEmLog()
	{
		return lastlogProperty;
	}
	public String getEmpLog()
	{
		return this.LastLogin;
	}
	public void setLastLogin(String l)
	{
		this.LastLogin=l;
	}
}
