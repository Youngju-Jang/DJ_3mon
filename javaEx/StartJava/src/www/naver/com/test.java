package www.naver.com;

public class test {
	static int answer = 0;
	public static int solution(String s) {
        int[] alArr = new int[26];
        char[] chaArr = s.toCharArray();
        for(int i=0; i<s.length(); i++) {
        	alArr[chaArr[i]-65]++;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(solution("banana"));
		System.out.println(("A").toCharArray()[0]-65);
	}
}
