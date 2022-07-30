package com.ahad.leetcode;

import java.util.HashMap;

class LRUCache {
	
	Node headNode = new Node(0, 0);
	Node taiNode = new Node(0, 0);
	HashMap<Integer, Node> map = new HashMap<>();
	int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        headNode.next = taiNode;
        taiNode.prev = headNode;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
        	Node dataNode = map.get(key);
        	
        	//used the node this time, so it is recently used
        	//to get it on first remove it and insert it
        	
        	remove(dataNode);
        	insert(dataNode);
        	
        	return dataNode.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
    	
    	//if we try to put a value that already exists in the structure
    	//then we need to move it on top by removing and inserting it
    	
    	if(map.containsKey(key)) {
    		remove(map.get(key));
    	}
    	
    	//the cache might be full
    	if(capacity == map.size()) {
    		remove(taiNode.prev);
    		//this is the least recently used node
    	}
    	
    	insert(new Node(key, value));
        
    }
    
    
    
    private void insert(Node node) {
    	
    	map.put(node.key, node);
    	
    	Node headNext = headNode.next;
    	headNode.next = node;
    	node.prev = headNode;
    	node.next = headNext;
    	headNext.prev = node;
		
	}

	private void remove(Node node) {
		//we are using two data structures here
    	//first we need to remove it from HashMap
    	//then we need to rearrange the link between HashMap node
    	map.remove(node.key);
    	node.prev.next = node.next;
    	node.next.prev = node.prev;
	}



	class Node {
    	Node prev, next;
    	int key, value;
    	
    	Node(int key, int value){
    		this.key = key;
    		this.value = value;
    	}
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */