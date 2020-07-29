package com.ahad.arraylist;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {


		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("Abdul", "Ahad", 49));
		employeeList.add(new Employee("Anam", "Torun", 01));
		employeeList.add(new Employee("Kazim", "Zim", 48));
		
		employeeList.forEach(employee -> System.out.println(employee));
		
		System.out.println(employeeList.get(1));
		
		System.out.println(employeeList.isEmpty());
		
		employeeList.set(1, new Employee("Hossain", "Noyon", 01));
		System.out.println(employeeList.get(1));
		
		System.out.println(employeeList.size()); 
		
		employeeList.add(2, new Employee("Hasib", "Shanto", 45));
		
		employeeList.forEach(employee -> System.out.println(employee));
		
		Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
		for (Employee employee: employeeArray) {
			System.out.println(employee);
		}
		
		System.out.println(employeeList.contains(new Employee("Abdul", "Ahad", 49)));
		
		System.out.println(employeeList.indexOf(new Employee("Hasib", "Shanto", 45 )));

	}

}
