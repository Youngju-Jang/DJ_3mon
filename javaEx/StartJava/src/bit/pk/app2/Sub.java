package bit.pk.app2;

import bit.pk.app1.Super;

public class Sub extends Super{
	// 다른패키지. 후손o
		public Sub() { // 후손생성자
			this.publicData = 10;
			this.protectedData = 10;
//			this.defaultData = 10;
//			this.privateDate = 10;
		}
}
