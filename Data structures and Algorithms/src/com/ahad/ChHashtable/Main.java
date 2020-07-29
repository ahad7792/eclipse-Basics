package com.ahad.ChHashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
		
		Employee kazimZim = new Employee("Kazim", "Zim", 48);
		Employee anamTorun = new Employee("Anam", "Torun", 12);
		Employee hossainNoyon = new Employee("Hossain", "Noyon", 01);
		Employee pollob = new Employee("Nazmul", "Haque", 42);
		
		LinkedList<Employee> employees = new LinkedList<>();
		
		employees.add(pollob);
		employees.add(hossainNoyon);
		employees.add(anamTorun);
		employees.add(pollob);
		employees.add(kazimZim);
		
		employees.forEach(e -> System.out.println(e));
		
		HashMap<Integer, Employee> employeeTable = new HashMap<>();
		ListIterator<Employee> iterator = employees.listIterator();
		List<Employee> remove = new ArrayList<>();
		
		while (iterator.hasNext()) {
			Employee employee = iterator.next();
			if (employeeTable.containsKey(employee.getId())) {
				remove.add(employee);
			}
			else {
				employeeTable.put(employee.getId(), employee);
			}
		}
		for (Employee employee: remove) {
			employees.remove(employee);
		}
		
		System.out.println("------------------------------");
		employees.forEach(e -> System.out.println(e));

	}

}














