package bit.basic.obj4;

public class Parent {

	public int sum(int ...values) {
		int sum = 0;

		for (int i : values) {
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		Parent p = new Parent();
		int e = p.sum(1, 2, 3, 4, 5);
		System.out.println(e);
	}
}
