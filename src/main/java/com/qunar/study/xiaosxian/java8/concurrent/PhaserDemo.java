package com.qunar.study.xiaosxian.java8.concurrent;
import java.util.concurrent.Phaser;
public class PhaserDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Phaser phsr = new MyPhaser(1, 4);
		System.out.println("Starting ");
		new MyThreadp(phsr, "A");
		new MyThreadp(phsr, "B");
		new MyThreadp(phsr, "C");
		while (!phsr.isTerminated()) {
			phsr.arriveAndAwaitAdvance();
		}
		System.out.println("The Phaser is terminated");
	}
}
class MyPhaser extends Phaser {
	int numPhases;
	public MyPhaser(int parties,int phaseCount) {
		// TODO Auto-generated constructor stub
		super(parties);
		numPhases = phaseCount;
	}
	protected boolean onAdvance(int p,int regParties) {
		System.out.println("Phase " + p + " completed .");
		if (p == numPhases || regParties == 0) {
			return true;
		}
		return false;
	}
}
class MyThreadp implements Runnable {
	Phaser phsr;
	String name;
	public MyThreadp(Phaser p,String n) {
		// TODO Auto-generated constructor stub
		phsr = p;
		name = n;
		phsr.register();
		new Thread(this).start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!phsr.isTerminated()) {
			System.out.println("Thread " + name + " Beginnig Phase " + phsr.getPhase());
			phsr.arriveAndAwaitAdvance();
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}