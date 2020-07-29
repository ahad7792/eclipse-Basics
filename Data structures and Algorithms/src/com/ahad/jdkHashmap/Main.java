package com.ahad.jdkHashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		Employee kazimZim = new Employee("Kazim", "Zim", 48);
		Employee anamTorun = new Employee("Anam", "Torun", 12);
		Employee hossainNoyon = new Employee("Hossain", "Noyon", 01);
		Employee pollob = new Employee("Nazmul", "Haque", 42);
		
		Map<String, Employee> hashmap = new HashMap<String, Employee>();
		
		hashmap.put("Zim", kazimZim);
		hashmap.put("Torun", anamTorun);
		hashmap.put("Pollob", pollob);
		
		Iterator<Employee> iterator = hashmap.values().iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		
	}

}
