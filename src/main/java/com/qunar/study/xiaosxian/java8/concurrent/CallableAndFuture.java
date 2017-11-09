package com.qunar.study.xiaosxian.java8.concurrent;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class CallableAndFuture {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService es = Executors.newFixedThreadPool(1);
		Future<Integer> f;
		f = es.submit(new SumInteger(10));
		try {
			System.out.println(f.get());
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		es.shutdown();
		System.out.println("Done");
	}
}
class SumInteger implements Callable<Integer>{
	int stop;
	public SumInteger(int v) {
		// TODO Auto-generated constructor stub
		stop = v;
	}
	public Integer call() {
		int sum = 0;
		for (int i = 0; i <= stop; i++) {
			sum += i;
		}
		return sum;
	}
}