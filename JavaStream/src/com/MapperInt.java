package com;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class MapperInt {

	public static void main(String[] args) {
		List<String> namesList= Arrays.asList("Hemant", "Subharna", "Mayar", "Nitika");
		
		List<User> userList= namesList.stream()
										.filter(MapperInt::isNotNitika)
										.map(User::new)
										.collect(Collectors.toList());
		
		
		int fnSum= userList.stream()
								.mapToInt(new ToIntFunction<User>() {
									@Override
									public int applyAsInt(User user) {
										return user.getAge();
									}
								})
								.sum();
		
		System.out.println("FnSum is "+ fnSum);
		
		int sum= userList.stream()
					.mapToInt(user -> {
						return user.getAge();
					})
					.sum();
		System.out.println("Sum is "+ sum);
		
		//to count
		
		long count= userList.stream()
								.mapToInt(user -> {
									return user.getAge();
								})
							.count();
		System.out.println("Count is "+count);
	}

	static class User{
		private String name;
		private int age= 30;
		
		public User(String name) {
			this.age= age;
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
	}
	
	private static boolean isNotNitika(String name) {
		return !name.equals("Nitika");
	}
}
