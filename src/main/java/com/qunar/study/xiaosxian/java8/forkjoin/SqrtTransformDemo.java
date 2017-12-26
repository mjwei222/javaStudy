package com.qunar.study.xiaosxian.java8.forkjoin;

import java.util.concurrent.RecursiveAction;

public class SqrtTransformDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] nums = new double[10000];
		for (int i = 0; i< nums.length; i++) {
			nums[i] = i;
		}
		System.out.println("A portion of the original sequence:");
		for (int i = 0; i < 10; i++) {
			System.out.print(nums[i] + " ");
			System.out.print("\n");
		}
		SqrtTransform task = new SqrtTransform(nums, 0, nums.length);
		task.invoke();
		System.out.println("A portion of the transformed sequence" + " (to four decimal places):");
		for (int i =0; i < 10; i++) {
			System.out.format("%.4f",nums[i]);
			System.out.println();
		}
	}
}
class SqrtTransform extends RecursiveAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int seqThreshold = 1000;
	double[] data;
	int start,end;
	public SqrtTransform(double[] vals,int s,int e) {
		// TODO Auto-generated constructor stub
		data = vals;
		start = s;
		end = e;
	}
	protected void compute() {
		if ((end - start ) < seqThreshold) {
			for (int i = start; i < end; i++) {
				data[i] = Math.sqrt(data[i]);
			}
		} else {
			int middle = (start + end) / 2;
			invokeAll(new SqrtTransform(data, start, middle),new SqrtTransform(data, middle, end));
		}
	}
}