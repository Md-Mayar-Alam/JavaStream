package com;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * In this example we will see how to filter even and odd number from
 * list of numbers
 * @author Mayar
 */
		
public class FilterEvenOddExample {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		
		//Using Lambda Expression
		List<Integer> evenResult = list.stream()
										.filter(i -> i%2 == 0)
										.collect(Collectors.toList());
		System.out.println("Even List= "+ evenResult);
		
		//Using Functional Interface
		List<Integer> evenResultFun = list.stream()	
										.filter(new Predicate<Integer>() {
											@Override
											public boolean test(Integer i) {
												return i%2 == 0;
											}
										})
										.collect(Collectors.toList());
		System.out.println("Even List using Functional Interface= "+ evenResultFun);
		
		List<Integer> oddResult = list.stream()
										.filter(i -> i%2 != 0)
										.collect(Collectors.toList());
		System.out.println("Odd List= "+ oddResult);
	}
}