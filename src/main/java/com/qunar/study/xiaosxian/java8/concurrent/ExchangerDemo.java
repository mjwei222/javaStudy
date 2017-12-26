package com.qunar.study.xiaosxian.java8.concurrent;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<>();
		new UseString(exchanger);
		new MakeString(exchanger);
	}
}
class MakeString implements Runnable {
	Exchanger<String> exchanger;
	String string;
	MakeString(Exchanger<String> c) {
		exchanger = c;
		string = new String();
		new Thread(this).start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		char ch = 'A';
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				string += ch++;
			}
			try {
				string = exchanger.exchange(string);
			} catch (InterruptedException e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
	}
}
class UseString implements Runnable {
	Exchanger<String> ex;
	String str;
	public UseString(Exchanger<String> c) {
		// TODO Auto-generated constructor stub
		ex = c;
		new Thread(this).start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			try {
				str = ex.exchange(new String());
				System.out.println("Got:" + str);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
}