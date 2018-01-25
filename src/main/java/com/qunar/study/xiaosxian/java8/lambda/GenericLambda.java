package com.qunar.study.xiaosxian.java8.lambda;
interface SomeFunc<T> {
	T func(T t);
}
public class GenericLambda {
	public static void main (String args[]) {
		SomeFunc<String> reverse  = (str) -> {
			String result = "";
			int i ;
			for (i = str.length() - 1; i >= 0; i--) {
				result += str.charAt(i);
			}
			return result;
		};
		System.out.println("lambda reversed is " + reverse.func("lambda"));
		SomeFunc<Integer> factorial = (n) -> {
			int result = 1;
			for (int i = 1; i <= n; i++) {
				result = i * result;
			}
			return result;
		};
		System.out.println("The factoral of 3 is " + factorial.func(3));
		System.out.println("The factoral of 3 is " + factorial.func(5));
	}
}
