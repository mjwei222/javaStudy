package com.qunar.study.xiaosxian.java8.stream;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> myList = new ArrayList<>();
		myList.add(7);
		myList.add(18);
		myList.add(10);
		myList.add(24);
		myList.add(17);
		myList.add(5);
		System.out.println("Original lis :" +  myList);
		Stream<Integer> myStream = myList.stream();
		Optional<Integer> minVal = myStream.min(Integer::compare);
		if (minVal.isPresent()) System.out.println("Mininum value: " + minVal.get());
		myStream = myList.stream();
		Optional<Integer> maxVal = myStream.max(Integer::compare);
		if (maxVal.isPresent()) System.out.println("Maxinum value: " + maxVal.get());
		Stream<Integer> sortedStream = myList.stream().sorted();
		System.out.println("Sorted stream :" );
		sortedStream.forEach((n) -> System.out.println(n + " "));
		Stream<Integer> oddVals = myList.stream().sorted().filter((n) -> (n % 2) ==1 );
		System.out.println("Odd vals : ");
		oddVals.forEach((n) -> System.out.println(n + " "));
		oddVals = myList.stream().sorted().filter((n) -> (n > 5));
		oddVals.forEach((n) -> System.out.println(n + " "));
	}

}
