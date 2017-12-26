package com.qunar.study.xiaosxian.java8.stream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.lang.model.element.Element;
public class StreamReduce {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> al = new ArrayList<>();
		al.add(7);
		al.add(18);
		al.add(19);
		al.add(24);
		al.add(17);
		al.add(5);
		Optional<Integer> productObj = al.stream().reduce((a,b) -> a*b);
		//productObj = al.parallelStream().reduce((a,b) -> a*b);
		//中间结果合并
		//double productOfSqrRoots = al.parallelStream().reduce(1.0,(a,b) -> a* Math.sqrt(b),(a,b) -> a*b);
		if (productObj.isPresent())
			System.out.println("Product as Optional: " + productObj.get());
		int product = al.stream().reduce(1, (a,b) -> a*b);
		System.out.println("Product as int : " + product);
		int eventProduct = al.stream().reduce(1, (a,b) -> {
			if (b%2 == 0) return a*b; else return a;
		});
		//每个元素被单独处理-无状态、不会改变数据源-不干预、操作先后无关-关联性
		//map + reduce demo
		Stream<Double> sqrtRootStrm = al.stream().map((a) -> Math.sqrt(a));
		double productOfSqrtRoots = sqrtRootStrm.reduce(1.0, (a,b) -> a*b);
		//stream to collector
		List<Integer> alList = al.stream().collect(Collectors.toList());
		LinkedList<Integer> llt = al.stream().collect(() -> new LinkedList<>(),(list,element) -> list.add(element),(listA,listB) -> listA.addAll(listB) );
		HashSet<Integer> ihSet = al.stream().collect(HashSet::new,HashSet::add,HashSet::addAll);
		//spliterator 遍历
		Spliterator<Integer> spliterator = al.stream().spliterator();
		while (spliterator.tryAdvance((n) -> System.out.println(n)));
	}
}
