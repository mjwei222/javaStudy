package com.qunar.study.xiaosxian.java8.concurrent;
import java.util.concurrent.Semaphore;
public class SemaphoreDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Semaphore sem = new Semaphore(1);
		new IncThread(sem,"A");
		new DecThread(sem,"B");
	}
}
class Shared{
	static int count = 0;
}
class IncThread implements Runnable {
	String name;
	Semaphore sem;
	IncThread(Semaphore s ,String n){
		sem = s;
		name = n;
		new Thread(this).start();
	}
	public void run() {
		System.out.println("Starting " + name);
		try {
			System.out.println(name + " is waiting for a permit.");
			sem.acquire();
			System.out.println(name + " get a permit.");
			for (int i = 0; i < 5; i++) {
				Shared.count++;
				System.out.println(name + " : " + Shared.count);
				Thread.sleep(10);
			}
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}
		System.out.println(name + " releases the permit.");
		sem.release();
	}
}
class DecThread implements Runnable {
	String name;
	Semaphore sem;
	public DecThread(Semaphore s,String n) {
		// TODO Auto-generated constructor stub
		sem = s;
		name = n;
		new Thread(this).start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(name);
		try {
			System.out.println(name + " is waiting for a permit.");
			sem.acquire();
			System.out.println(name + " get a permit.");
			for (int i = 0; i < 5; i++) {
				Shared.count--;
				System.out.println(name + " : " + Shared.count);
				Thread.sleep(10);
			}
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}
		System.out.println(name + " releases the permit.");
		sem.release();
	}
	
}