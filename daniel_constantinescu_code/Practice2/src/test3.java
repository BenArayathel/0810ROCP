
public  class test3 {
public static void main(String[] args) {

}
}

  interface i1{
	public  void m1();
	public void m2();
	public default void m3() {
}

public class c1 implements i1{
  public static final double pi=3.14;
	@Override
	public void m1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		math.sum(3, 4);
	}
}
}
public class math{
	public static int sum(int x, int y) {
		return x+y;
	}
	public static int dif(int x,int y) {
		return x-y;
	}
	public static int mult(int... i) {
		
	}
	public static int div(int[] args) {
		
	}
}




