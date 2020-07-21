package com.amazon.core.synch;

public class SynchExtended extends Thread {
	Synch synch = new Synch();
	public void run() {
		synch.sum(10);
	}
}
