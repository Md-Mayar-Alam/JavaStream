package com;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MapperExample {

	public static void main(String[] args) {
		
		List<String> namesList= Arrays.asList("Hemant", "Alam", "Nitika");
		
		namesList.stream()
					.filter(new Predicate<String>() {
						@Override
						public boolean test(String name) {
							return !name.equals("Nitika");
						}
					})
					.map(new Function<String, User>() {
						@Override
						public User apply(String name) {
							return new User(name);
						}
					})
					.forEach(new Consumer<User>() {
						@Override
						public void accept(User user) {
							System.out.println(user);
						}
					});
		
		System.out.println("========================================================");
		
		namesList.stream()
					.filter(name -> !name.equals("Nitika"))
					.map(name -> {
						return new User(name);
					})
					.forEach(user -> System.out.println(user));
		
		System.out.println("========================================================");
		
		namesList.stream()
					.filter(MapperExample::isNotNitika)
					.map(User::new)
					.forEach(System.out::println);
		
		System.out.println("========================================================");
		
		List<User> userList= namesList.stream()
					.filter(MapperExample::isNotNitika)
					.map(User::new)
					.collect(Collectors.toList());
		
		userList.stream()
					.forEach(System.out::println);
	}

	static class User{
		private String name;
		private int age= 30;
		
		public User(String name) {
			this.name= name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
		
		@Override
		public String toString() {
			return "Name "+ name + " Age "+ age;
		}
	}
	
	private static boolean isNotNitika(String name) {
		return !name.equals("Nitika");
	}
}
