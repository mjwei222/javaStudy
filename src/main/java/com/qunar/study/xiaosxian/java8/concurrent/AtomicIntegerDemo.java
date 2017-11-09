package com.qunar.study.xiaosxian.java8.concurrent;
import java.util.concurrent.atomic.AtomicInteger;
public class AtomicIntegerDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AtomThread("A");
		new AtomThread("B");
		new AtomThread("C");
	}
}
class shareda {
	static AtomicInteger ai = new AtomicInteger(0);
}
class AtomThread implements Runnable {
	String name;
	public AtomThread(String n) {
		// TODO Auto-generated constructor stub
		name = n;
		new Thread(this).start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Starting " + name);
		for (int i = 0; i < 3; i++) {
			System.out.println(name + " got " + shareda.ai.getAndSet(i));
		}
	}
}