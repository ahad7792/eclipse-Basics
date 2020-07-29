package com.ahad.hashtableChaining;

public class Main {

	public static void main(String[] args) {
		
		Employee kazimZim = new Employee("Kazim", "Zim", 48);
		Employee anamTorun = new Employee("Anam", "Torun", 12);
		Employee hossainNoyon = new Employee("Hossain", "Noyon", 01);
		Employee pollob = new Employee("Nazmul", "Haque", 42);
		
		ChainedHashtable ht = new ChainedHashtable();
		ht.put("Zim", kazimZim);
		ht.put("Torun", anamTorun);
		ht.put("Noyon", hossainNoyon);
		ht.put("Haque", pollob);
		
		ht.printHashtable();
		
		System.out.println("Retrive the key of Noyon :" + ht.get("Noyon") );
		
		ht.remove("Noyon");
		ht.printHashtable();

	}

}
