package bit.basic.obj1;

public class SuperMain {

	public static void main(String[] args) {
//		SuperClass sp=new SuperClass();
//		SubClass1 sc1=new SubClass1();//SubClass1( Object( )  )
		
//		SubClass2 sc2=new SubClass2();  //SubClass2(  SuperClass( Object( )  )  )
//      SubClass3 sc3=new SubClass3();
//		SubClass2 sc2=(SubClass2)new SuperClass(); // SuperClass( Object( )  ) 
//		sc2.actionProces();
		
		SubClass1 s1 = new SubClass1(10,20);
		
		String str1 = "abc";
		String str2 = "abc";
		System.out.println(str1 == str2); // true
		
		String str3 = new String("abc");
		String str4 = new String("abc");
		System.out.println(str3 == str4); // false, 주소값을 비교 
		System.out.println(str3.hashCode() == str4.hashCode()); // true	
		// string의 경우 값이 같으면 hashCode() 같음. 재정의해서그럼
		System.out.println(str3.equals(str4)); // true, equals : 값을 비교
	}
}
