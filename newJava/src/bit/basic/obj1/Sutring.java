package bit.basic.obj1;

public class Sutring {
	private char[]value;
	public Sutring(char [] value) {		
		this.value=value;
	}
	public char charAt(int index) {
		if(index<0||index>value.length-1) {
			throw new StringIndexOutOfBoundsException();
		}
		return this.value[index];			
	}
	public boolean equals(Object obj) {
		//System.out.println("this="+this);
		if(this==obj)return true;
		if(obj instanceof String) {
			char []imsi=((String)obj).toCharArray();
			if(imsi.length!=this.value.length)return false;
			for (int i = 0; i < imsi.length; i++) {
				if(value[i]!=imsi[i])return false;
			}
			return true;			
		}
		return false;
		
	}
	public static void main(String[] args) {
		Sutring s1=new Sutring("abc".toCharArray());//value [a][b][c]
		Sutring s2=new Sutring("def".toCharArray());//value [d][e][f]
//		System.out.println("s1="+s1);
//		System.out.println("s2="+s2);
		System.out.println(s2.equals("deF"));
		//System.out.println(s2.charAt(0));
		
	}

}








