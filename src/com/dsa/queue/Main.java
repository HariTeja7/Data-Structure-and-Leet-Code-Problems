package com.dsa.queue;


public class Main {
	
	public static void main(String[] args) {
		Queue q = new Queue(2);
		q.add(0);
		q.add(1);
		q.printQueue();
		System.out.println();
		System.out.println(q.peek());
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}

}
