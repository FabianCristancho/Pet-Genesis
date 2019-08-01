package testLogin;

import java.io.Serializable;
import java.util.ArrayList;

public class Rancher implements Serializable{
	
	private String name;
	private String lastName;
	private String address;
	private long phoneNumber;
	private String username;
	private ArrayList<Integer> herds;
	
	public Rancher(String name, String lastName, String address, long phoneNumber, String username) {
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.herds = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void addHerd(int i) {
		this.herds.add(i);
	}
	
	public ArrayList<Integer> getHerds(){
		return herds;
	}
}
