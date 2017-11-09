package com.qunar.study.xiaosxian.java8.concurrent;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ExecutorDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatch cd1 = new CountDownLatch(5);
		CountDownLatch cd2 = new CountDownLatch(5);
		CountDownLatch cd3 = new CountDownLatch(5);
		CountDownLatch cd4 = new CountDownLatch(5);
		ExecutorService es = Executors.newFixedThreadPool(2);
		System.out.println("Starting");
		es.execute(new MyThreade(cd1, "A"));
		es.execute(new MyThreade(cd2, "B"));
		es.execute(new MyThreade(cd3, "C"));
		es.execute(new MyThreade(cd4, "D"));
		try {
			cd1.await();
			cd2.await();
			cd3.await();
			cd4.await();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		es.shutdown();
		System.out.println("Done");
	}
}
class MyThreade implements Runnable {
	String name;
	CountDownLatch latch;
	public MyThreade(CountDownLatch c,String n) {
		// TODO Auto-generated constructor stub
		latch = c;
		name = n;
		new Thread(this).start();
	}
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			System.out.println(name + ": " + i);
			latch.countDown();
		}
	}
}