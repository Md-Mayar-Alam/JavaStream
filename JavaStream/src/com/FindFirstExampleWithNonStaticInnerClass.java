package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * findFirst() returns an Optional for the first entry in the stream; 
 * the Optional can, of course, be empty
 * @author Mayar
 */
public class FindFirstExampleWithNonStaticInnerClass {

	public static void main(String[] args) {
		
		FindFirstExampleWithNonStaticInnerClass ff = new FindFirstExampleWithNonStaticInnerClass();
		
		List<Employee> empList = new ArrayList<Employee>();
		
		empList.add(ff.new Employee("Mohammad", 5000.0f));
		empList.add(ff.new Employee("Mayar", 10000.0f));
		empList.add(ff.new Employee("Alam", 12000.0f));
		
		Optional<Employee> employee = empList.stream()
					.filter(emp -> emp.getSalary() >= 10000)
					.findFirst();
		
		if(employee.isPresent()) {
			System.out.println("First Employee with salary >= 10000= "+ employee.get().getName());
		}
	}
	
	class Employee{

		private String name;
		private float salary;
		
		public Employee(String name, float salary) {
			this.name = name;
			this.salary = salary;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public float getSalary() {
			return salary;
		}
		public void setSalary(float salary) {
			this.salary = salary;
		}
	}
}
