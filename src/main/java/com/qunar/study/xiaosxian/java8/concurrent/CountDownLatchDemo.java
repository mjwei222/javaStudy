package com.qunar.study.xiaosxian.java8.concurrent;
import java.util.concurrent.CountDownLatch;
public class CountDownLatchDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatch cD = new CountDownLatch(5);
		System.out.println("Starting");
		new MyThread(cD);
		try {
			cD.await();
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		System.out.println("Done");
	}
}
class MyThread implements Runnable {
	CountDownLatch latch;
	public MyThread(CountDownLatch c) {
		// TODO Auto-generated constructor stub
		latch = c;
		new Thread(this).start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			latch.countDown();
		}
	}
}