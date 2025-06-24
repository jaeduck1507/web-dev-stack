package com.kh.polymorphism.controller;


import com.kh.polymorphism.model.*;
public class EmployeeController {
	
	public Employee findEmployee(Employee[] emp , String name) {
		Employee findE = null;
		for(Employee employee : emp) {
			if(employee.getName().equals(name)) findE = employee;
		}
		
		
		
		return findE;
	}
	
	public int getAnnualSalary(Employee findE) {
		if (findE == null) return -1;
		if(findE instanceof Engineer) {
			Engineer engineer = (Engineer) findE;
			return (engineer.getSalary() * 12 + engineer.getBonus());
		} else return findE.getSalary() * 12;
	}
	
	public int totalSalary(Employee[] emp) {
		int sum = 0;
		for(Employee employee : emp) {
			sum += employee.getSalary();
		}
		return sum;
	}
}
