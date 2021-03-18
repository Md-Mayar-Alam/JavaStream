package com;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * In this example we will see how to set multiple conditions in filter
 * @author Mayar
 *
 */
public class FilterWithMultipleConditions {

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
		
		//The problem statement is to filter even numbers from list except
		//the number 4
		List<Integer> result = list.stream()
			.filter(i -> i%2 == 0 && i != 4)
			.collect(Collectors.toList());
		
		System.out.println("Even List Except 4= "+ result);
	}
}
