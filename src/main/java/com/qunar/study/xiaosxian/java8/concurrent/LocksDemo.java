package com.qunar.study.xiaosxian.java8.concurrent;
import java.util.concurrent.locks.ReentrantLock;
public class LocksDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReentrantLock rl = new ReentrantLock();
		new LockThread(rl, "A");
		new LockThread(rl, "B");
	}
}
class Sharedl {
	static int count = 0;
}
class LockThread implements Runnable {
	String name;
	ReentrantLock lock;
	public LockThread(ReentrantLock rl, String n) {
		// TODO Auto-generated constructor stub
		lock = rl;
		name = n;
		new Thread(this).start();
	}
	public void run() {
		System.out.println("Starting " + name);
		try {
			System.out.println(name + " is waiting to lock count.");
			lock.lock();
			System.out.println(name + " is locking count.");
			Sharedl.count++;
			System.out.println(name + ": " + Sharedl.count);
			System.out.println(name + " is sleepling");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			System.out.println(name + " is unlocking count.");
			lock.unlock();
		}
	}
}