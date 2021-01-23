package com.xps.java.core.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {

	public static void main(String[] args) {
		
		normalSerialize();
		
		customSerialize(); // doesn't work. check more
		
	}

	private static void normalSerialize() {
		Person person = new Person();
		person.setAge(30);
		person.setName("Preetesh");
		person.setHeight(170);
		System.out.println(">> " + person);
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/var/tmp/serialized/person.txt"))){
			
			oos.writeObject(person);
			oos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Person p2 = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/var/tmp/serialized/person.txt"))){
			
			p2 = (Person) ois.readObject();
			System.out.println("<< " + p2);
			
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private static void customSerialize() {
		Person person = new Person();
		person.setAge(26);
		person.setName("Bhakti");
		person.setHeight(160);
		
		Address ad = new Address();
		ad.setHouseNumber(204);
		ad.setRoadNumber(22);
		ad.setCity("Bengaluru");
		ad.setPincode(560102);
		
		Employee em = new Employee();
		em.setPerson(person);
		em.setAddress(ad); // is transient 
		System.out.println("Employee >> " + em);
		
		// Address is transient but we want to serialize the address.house number
		// For this we override 2 methods in employee class
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/var/tmp/serialized/employee.txt"))){
			
			em.writeObject(oos);
			oos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Employee em2 = new  Employee();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/var/tmp/serialized/employee.txt"))){
			
			em2.readObject(ois);
			System.out.println("<< " + em2);
			
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}
