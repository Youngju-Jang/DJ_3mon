package bit.basic.obj2;

public class ObjectEx2Main {

	public static void main(String[] args) {
		ObjectEx2.getInstance().setMessage("Java");
		System.out.println(ObjectEx2.getInstance().getMessage());
	}

}
