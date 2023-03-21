package bit.basic.variable;

public class VariableEx2 {
	// 인스턴스 변수
	int value = 500;
	// value = 50;
	{
		value = 90;
	}
	static { // static block : static 초기화블럭
		
	}
	VariableEx2() {
		value = 90;
	}
	
}
