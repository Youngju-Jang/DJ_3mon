package bit.basic.obj1;
// 오버로딩
public class ObjectEx2 {

	public void add(int x) {
		System.out.println(" void add(int x)");
	}
//	public int add(int x) {
//		return 0;
//	}
	public void add(short x) {
		System.out.println(" void add(short x)");
	}
	public void add(int x, int y) {
		System.out.println(" void add(int x, int y)");
	}
	public void add(int x, long y) {
		System.out.println(" void add(int x, long y)");
		System.out.println(y);
	}
	public void add(long x, int y) {
		System.out.println(" void add(long x, int y)");
	}
	public static void main(String[] args) {
		ObjectEx2 o = new ObjectEx2();
		o.add(10,10);
	}
}
