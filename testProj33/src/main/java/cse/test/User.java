package cse.test;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	String id;
	String pw;
	
	public User()
	{
		
	}
	public User(String id,String pw)
	{
		this.id=id;
		this.pw=pw;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

	
}
