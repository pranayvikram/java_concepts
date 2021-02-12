package com.concept.allClasses;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Map;


public class CollectionTest {

	public static void main(String args[]) {

		CollectionTest collection = new CollectionTest();

		collection.hashMapTest();
		//collection.hashTableTest();
		//collection.hashSetTest();
		//collection.userHashSetTest();
	}

	/**
	 * bucketHashMap
	 */
	private void hashMapTest() {

		HashMap<String, Double> bucketHashMap = new HashMap<String, Double>();

		bucketHashMap.put(null, new Double(4.09));
		bucketHashMap.put("Zara", null);
		bucketHashMap.put("Zara", new Double(3434.35));
		bucketHashMap.put("Zara", new Double(3434.35));
		bucketHashMap.put("Zara", new Double(3434.35));
		bucketHashMap.put("Mahnaz", new Double(123.22));
		bucketHashMap.put("Ayan", new Double(1378.00));
		bucketHashMap.put("Daisy", new Double(99.22));
		bucketHashMap.put("Qadir", new Double(-19.08));

		System.out.println("Complete Hash Map: " + bucketHashMap);
		System.out.println("NULL of Hash Map: " + bucketHashMap.get(null));
		
		
		System.out.println(bucketHashMap.containsKey("Zara"));
		System.out.println(bucketHashMap.containsValue(Double.valueOf("3434.35")));
		System.out.println(bucketHashMap.entrySet());
		//bucketHashMap.forEach("Zara",Double.valueOf("3434.35"));
	}

	/**
	 * bucketHashTable
	 */
	private void hashTableTest() {

		Hashtable<String, Double> bucketHashTable = new Hashtable<String, Double>();

		bucketHashTable.put(null, new Double(4.09));
		bucketHashTable.put("Zara", null);
		bucketHashTable.put("Zara", new Double(3434.35));
		bucketHashTable.put("Mahnaz", new Double(123.22));
		bucketHashTable.put("Ayan", new Double(1378.00));
		bucketHashTable.put("Daisy", new Double(99.22));
		bucketHashTable.put("Qadir", new Double(-19.08));

		System.out.println("Complete Hash Table:" + bucketHashTable);
		
		String str = null;
		Enumeration<String> enumKeys = bucketHashTable.keys();

		while(enumKeys.hasMoreElements()) {
			str = enumKeys.nextElement();
			System.out.println(str + ": " + bucketHashTable.get(str));
		}        

		double bal = bucketHashTable.get("Zara").doubleValue();
		System.out.println("Zara's old balance: " + bal);
		
		// Deposit 1,000 into Zara's account
		bucketHashTable.put("Zara", new Double(bal + 1000));
		System.out.println("Zara's new balance: " + bucketHashTable.get("Zara"));
	}

	/**
	 * bucketSet
	 */
	private void hashSetTest() {

		HashSet<Comparable> bucketSet = new HashSet<Comparable>();
		//HashSet<Double> bucketSet = new HashSet<Double>();
		//HashSet<Object> bucketSet = new HashSet<Object>();
		
		bucketSet.add(null);
		bucketSet.add(new Double(3434.35));
		bucketSet.add(new Double(123.22));
		bucketSet.add(new Double(123.22));
		bucketSet.add("Ayan");
		System.out.println("Complete HashSet: " + bucketSet);
	}
	
	private void userHashSetTest() {
		
		LinkedHashSet<User> userSet = new LinkedHashSet<User>();
		
		userSet.add(null);
		userSet.add(null);
		userSet.add(new User());
		userSet.add(new User());
		userSet.add(new User(101));
		userSet.add(new User(101));
		userSet.add(new User(101, "first", "Samy"));
		userSet.add(new User(101, "first", "Samy"));
		userSet.add(new User(102, "first", "Samy"));
		userSet.add(new User(102, "second", "Samy"));
		userSet.add(new User(102, "second", "Samy2"));
		// If hashCode and equal method is commented, it will store all the User objects.
		
		for(User user : userSet) {
			if (user == null)
				System.out.println("Null User");
			else {
				System.out.print("User's Id: " + (user.id == null ? 0 : user.id));
				
				System.out.print("  User's userId: " + (user.userId == null ? "Null" : user.userId));
				
				System.out.print("  User's Name: " + (user.name == null ? "Null" : user.name));
				
				System.out.println(user.hashCode());
			}
		}
		System.out.println("HashSet elements: " + userSet);
		
	}
	
	class User {
		
		private Integer id;
		private String userId;
		private String name;
		
		User() {}
		
		User(int id) {
			this.id = id;
		}
		
		User(int id, String userId, String name) {
			this.id = id;
			this.userId = userId;
			this.name = name;
		}
		
		public int getId() {
			return id;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		/*@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((userId == null) ? 0 : userId.hashCode());
			
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			
			if (obj == null)
				return false;
			
			if (!(obj instanceof User))
				return false;
			
			User other = (User) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} 
			else if (!id.equals(other.id))
				return false;
			
			if (userId == null) {
				if (other.userId != null)
					return false;
			} 
			else if (!userId.equals(other.userId))
				return false;
			
			return true;
		}*/
	}
}