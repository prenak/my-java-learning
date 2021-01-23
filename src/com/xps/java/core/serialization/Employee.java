package com.xps.java.core.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable{

	private static final long serialVersionUID = -1412063780110959261L;
	
	private Person 	person;
	private transient Address 	address;
	
	
	public void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		oos.writeObject(address.getHouseNumber());
	}
	
	public void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		ois.defaultReadObject();
		Integer houseNumber = (Integer) ois.readObject();
		Address ad = new Address();
		ad.setHouseNumber(houseNumber);
		this.setAddress(ad);
	}
	
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [person=" + person + ", address=" + address + "]";
	}
}
