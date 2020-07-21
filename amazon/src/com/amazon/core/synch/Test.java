package com.amazon.core.synch;

public class Test {
	public static void main(String[] args) {
		SynchExtended synchExtended = new SynchExtended();
		Thread t1 = new Thread(synchExtended);
		Thread t2 = new Thread(synchExtended);
		t1.setName("Thread A");
		t2.setName("Thread B");
		
		t1.start();
		t2.start();
	}
}
