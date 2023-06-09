package bit.basic.variable;

// 변수 
//	local - 메소드사용될때 사용됨. 스택메모리,
//	static : 클래스 영역. 
//	instance (HEAP)
//7. 클래스 (설계도(속성 + 기능)) → 객체 Object 
//8. 객체 : 기능을 갖고있는 데이터다
// 기본형(primitive) | 참조형(Reference)
public class VariableEx1 {
	int y; // 멤버변수 > 생성시 인스턴스변수. heap에 생성됨
	static int z; // static 변수.static영역
	public void variableMethod1() {
		int x; // 지역변수. 스택영역. 메소드 콜시점에 생성.
//		x++; 초기화안한거라 에러남
		y++;
		z++;
	}
	
	public void variableMethod2(int x) {
		// private int value; 지역변수는 은닉화할 일 없음
		// static int view;
	}
	
	// 클래스영역
	public static void main(String[] args) {
		// 메소드영역 > 로컬변수임 > 스택메모리에 저장됨
		VariableEx1 v1 = new VariableEx1(); // y
		v1.variableMethod2(2);
		VariableEx1 v2 = new VariableEx1(); // y
		VariableEx1 v3 = new VariableEx1(); // y
		
	}

}
