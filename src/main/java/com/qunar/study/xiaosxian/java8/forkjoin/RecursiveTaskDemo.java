package com.qunar.study.xiaosxian.java8.forkjoin;
import java.util.concurrent.RecursiveTask;
public class RecursiveTaskDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] nums = new double[5000];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (double) (((i%2) == 0) ? i : -1);
		}
		Sum task = new Sum(nums,0,nums.length);
		double res = task.invoke();
		System.out.println("res is :" + res);
	}
}
class Sum extends RecursiveTask<Double> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int seqThresHold = 500;
	double[] data;
	int start,end;
	Sum(double[] vals,int s,int e){
		data = vals;
		start = s;
		end = e;
	}
	protected Double compute() {
		double sum = 0;
		if ((end - start) < seqThresHold) {
			for (int i = start; i < end; i++) {
				sum += data[i];
			}
		}else {
			int middle = (start + end) / 2;
			Sum subTaskA = new Sum(data,start,middle);
			Sum subTaskB = new Sum(data,middle,end);
			subTaskA.fork();
			subTaskB.fork();
			//sum = subTaskB.invoke() + subTaskA.join();
			//sum = subTaskA.compute() + subTaskB.join();
			sum = subTaskA.join() + subTaskB.join();
		}
		return sum;
	}
}