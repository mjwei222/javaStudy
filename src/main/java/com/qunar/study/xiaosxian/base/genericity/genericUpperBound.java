package com.qunar.study.xiaosxian.base.genericity;
class TwoD {
	int x,y;
	TwoD(int a,int b){
		x = a;
		y = b;
	}
}
class ThreeD extends TwoD {
	int z;
	ThreeD(int a, int b, int c) {
		super(a, b);
		// TODO Auto-generated constructor stub
		z = c;
	}
	
}
class FourD extends ThreeD {
	int t;
	FourD(int a, int b, int c, int d) {
		super(a, b, c);
		// TODO Auto-generated constructor stub
		t = d;
	}
}
class Coords<T extends TwoD> {
	T[] coords;
	Coords(T[] o){
		coords = o;
	}
}
public class genericUpperBound{
	static class BoundedWildcard {
		static void showXY(Coords<?> c) {
			System.out.println("X Y Coordinates:");
			for (int i = 0; i < c.coords.length; i++) {
				System.out.println(c.coords[i].x + " " + c.coords[i].y);
			}
			System.out.println();
		}
		static void showXYZ(Coords<? extends ThreeD> c) {
			System.out.println("X Y Z Coordinates:");
			for (int i = 0; i < c.coords.length; i++) {
				System.out.println(c.coords[i].x + " " + c.coords[i].y + " " + c.coords[i].z);
			}
			System.out.println();
		}
		static void showALL(Coords<? extends FourD> c) {
			System.out.println("X Y Z T Coordinates:");
			for (int i = 0; i < c.coords.length; i++) {
				System.out.println(c.coords[i].x + " " + c.coords[i].y + " " + c.coords[i].z +
						" " + c.coords[i].t);
			}
			System.out.println();
		}
	}
	public static void main(String args[]) {
		TwoD td[] = {
				new TwoD(0, 0),
				new TwoD(7, 9),
				new TwoD(18, 4),
				new TwoD(-1, -23)
		};
		Coords<TwoD> tdlocs = new Coords<TwoD>(td);
		System.out.println("Contents of tdlocs.");
		BoundedWildcard.showXY(tdlocs);
		FourD fd[] = {
				new FourD(1,2,3,4),
				new FourD(6,8,14,8),
				new FourD(22,9,4,9),
				new FourD(3,-2,-23,17)
		};
		Coords<FourD> fdlocs = new Coords<FourD>(fd);
		System.out.println("Contents of fdlocs:");
		BoundedWildcard.showXY(fdlocs);
		BoundedWildcard.showXYZ(fdlocs);
		BoundedWildcard.showALL(fdlocs);
	}
}