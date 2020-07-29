package com.ahad.hashtable;

public class SimpleHashtable {
	
	private StoredEmployee[] hashtable;
	
	public SimpleHashtable() {
		hashtable = new StoredEmployee[10];
	}
	
	public void put(String key, Employee employee) {
		int hashedKey = hashKey(key);
		
		if (occupied(hashedKey)) {
			int stopIndex = hashedKey;
			if (hashedKey == hashtable.length - 1) {
				hashedKey = 0;
			}
			else {
				hashedKey++;
			}
			while (occupied(hashedKey) && hashedKey != stopIndex) {
				hashedKey = (hashedKey + 1) % hashtable.length;
			}
		}
		
		if (occupied(hashedKey)) {
			System.out.println("Sorry, there's already an employee at position " + hashedKey);
		}
		else {
			hashtable[hashedKey] = new StoredEmployee(key, employee);
		}
	}
	
	public Employee get(String key) {
		int hashedKey = findKey(key);
		if (hashedKey == -1) {
			return null;
		}
		else {
			Employee employee = hashtable[hashedKey].employee;
			return employee;
		}
	}
	
	public Employee remove(String key) {
		int hashedkey = findKey(key);
		if (hashedkey == -1) {
			return null;
		}
		else {
			Employee employee = hashtable[hashedkey].employee;
			hashtable[hashedkey] = null;
			
			StoredEmployee[] oldhashtable = hashtable;
			hashtable = new StoredEmployee[oldhashtable.length];
			for (int i = 0; i < oldhashtable.length; i++) {
				if (oldhashtable[i] != null) {
					hashtable[i] = new StoredEmployee(oldhashtable[i].key, oldhashtable[i].employee);
				}
			}
			
			return employee;
		}
	}
	
	public int findKey(String key) {
		int hashedKey = hashKey(key);
		if (hashtable[hashedKey] != null && hashtable[hashedKey].equals(key)) {
			return hashedKey;
		}
		
		int stopIndex = hashedKey;
		if (hashedKey == hashtable.length - 1) {
			hashedKey = 0;
		}
		else {
			hashedKey++;
		}
		while (hashedKey != stopIndex && hashtable[hashedKey] != null && !hashtable[hashedKey].key.equals(key)) {
			hashedKey = (hashedKey + 1) % hashtable.length;
		}
		
		if(hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
			return hashedKey;
		}
		else {
			return -1;
		}
		
		
	}
	
	private int hashKey(String key) {
		return key.length() % hashtable.length;
	}
	
	public boolean occupied(int index) {
		return hashtable[index] != null;
	}
	
	public void printHashtable() {
		for (int i = 0; i < hashtable.length; i++) {
			
			if(hashtable[i] == null) {
				System.out.println("empty");
			}
			else {
			System.out.println("Position " + i + ":" +hashtable[i].employee);}
		}
	}

}
