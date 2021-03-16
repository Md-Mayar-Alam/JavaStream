package com;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterExample {

	public static void main(String[] args) {
		List<String> namesList= Arrays.asList("Hemant", "Alam", "Nikita", "Subharna");

		//traditional approach
		for (String name : namesList) {
			if(! name.equals("Nikita")) {
				System.out.println(name);
			}
		}
		
		System.out.println("========================================");
		
		//functional approach 1st method using Functional Interfaces
		namesList.stream()
					.filter(new Predicate<String>() {
						@Override
						public boolean test(String name) {
							return !name.equals("Nikita");
						}
					})
					.forEach(new Consumer<String>() {
						@Override
						public void accept(String name) {
							System.out.println(name);
						}
					});
		
		
		System.out.println("========================================");
		
		//functional approach 2nd method replacing Consumer by Lambda Expression 

		namesList.stream()
					.filter(new Predicate<String>() {
						@Override
						public boolean test(String name) {
							return !name.equals("Nikita");
						}
					})
					.forEach(name -> System.out.println(name));
		
		//functional approach 3rd method replacing Predicate and Consumer both by Lambda Expression
		
		System.out.println("========================================");
		
		namesList.stream()
					.filter(name -> !name.equals("Nikita"))
					.forEach(name -> System.out.println(name));
		
		//functional approach 4th method replacing Consumer by Method reference 
		
		System.out.println("========================================");
		
		namesList.stream()
					.filter(name -> !name.equals("Nikita"))
					.forEach(System.out::println);
		
		//functional approach 5th method replacing Predicate check by method
		
		System.out.println("========================================");
		
		namesList.stream()
					.filter(name -> isNotNikita(name))
					.forEach(System.out::println);
		
		//functional approach 6th method replacing Predicate by method reference 
		
		System.out.println("========================================");
		
		namesList.stream()
					.filter(FilterExample::isNotNikita)
					.forEach(System.out::println);
	}

	private static boolean isNotNikita(String name) {
		return!name.equals("Nikita");
	}

}
