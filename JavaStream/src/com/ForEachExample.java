package com;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * forEach() acts as terminal operation and takes Consumer as an 
 * input argument. 
 * @author Mayar
 */
public class ForEachExample {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<>();
		
		list.add("Mohammad");
		list.add("Mayar");
		list.add("Alam");

		list.stream()	
				.forEach(new Consumer<String>() {
					
					@Override
					public void accept(String name) {
						System.out.print(name + " ");
					}
				});
		System.out.println();
		
		list.stream()
				.forEach(name -> System.out.print(name + " "));
		System.out.println();
		
		list.stream()
			.map(name -> name+" ")
				.forEach(System.out::print);
		
	}
}
