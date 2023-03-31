package bit.pk.app1;

public class Sub extends Super{
	// 같은패키지. 후손o
	public Sub() { // 후손생성자
		this.publicData = 10;
		this.protectedData = 10;
		this.defaultData = 10;
//		this.privateDate = 10;
	}
}
