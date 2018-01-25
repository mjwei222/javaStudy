package com.qunar.study.xiaosxian.java8.lambda;
interface MyFunc<T> {
	boolean func(T v1,T v2);
}
class HighTemp {
	private int hTemp;
	HighTemp (int ht) { hTemp = ht;}
	boolean sameTemp(HighTemp h2) {
		return hTemp == h2.hTemp;
	}
	boolean lessThanTemp(HighTemp h2) {
		return hTemp < h2.hTemp;
	}
	
}
public class MultiParamLambda {
	static <T> int counter(T[] vals,MyFunc<T> f,T v) {
		int count = 0;
		for (int i = 0; i < vals.length; i++) {
			if (f.func(vals[i], v)) count++;
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count;
		HighTemp[] weekDayHighs = {new HighTemp(89),new HighTemp(82),new HighTemp(90),new HighTemp(89),
				new HighTemp(89),new HighTemp(91),new HighTemp(84),new HighTemp(83)};
		count = counter(weekDayHighs,HighTemp::sameTemp,new HighTemp(89));
		System.out.println(count + " days had a high of 89");
		count = counter(weekDayHighs,HighTemp::lessThanTemp,new HighTemp(89));
		System.out.println(count + " days had a high less than 89");
	}

}
