package bit.basic.array;

import java.util.Arrays;

public class ArrayEx2 {
	public void methodArray1(int[] x) {
//		x[1]++;
		int[] imsi = {55, 66, 77, 88};
		
//		x = imsi; > 이렇게 하면 main의 x가 바뀌지않음
		for(int i=0; i<imsi.length; i++) {
			x[i] = imsi[i];
		}
		// 배열카피
		System.arraycopy(imsi, 0, x, 0, imsi.length);
	
	}
	public static void main(String[] args) {
		ArrayEx2 a = new ArrayEx2();
		int[] x= {10, 20, 30, 40};
		a.methodArray1(x);
		System.out.println(Arrays.toString(x));
	}

}
