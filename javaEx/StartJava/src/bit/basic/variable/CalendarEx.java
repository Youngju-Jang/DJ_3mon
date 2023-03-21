package bit.basic.variable;

import java.util.Scanner;

// byte short int long / 
public class CalendarEx {
	static String[] yoil = new String[]{"일","월", "화", "수", "목", "금", "토"};
	static int[] months = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public boolean yun(int year) {
		if(year%4==0) {
			if(year%100==0 && year%400!=0) {
				return false;
			}else {
				return true;
			}
		}
		return false;
	}
	
	public int getCount(int year, int month, int day) {
		int count = day;
		
		for(int i=1; i<month; i++) {
			count += months[i];
		}
		
		count += (year-1)*365 + (year-1)/4 - (year-1)/100 + (year-1)/400;
		return count;
	}
	private String[] getDate() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return input.split(" ");
	}
	public static void main(String[] args) {
		CalendarEx c = new CalendarEx();
		String[] inArr = c.getDate();
		int year = Integer.parseInt(inArr[0].substring(0, inArr[0].length()-1));
		int month = Integer.parseInt(inArr[1].substring(0, inArr[1].length()-1));
		int day = Integer.parseInt(inArr[2].substring(0, inArr[2].length()-1));
		months[2] = c.yun(year)? 29 : 28;		
		
		int count = c.getCount(year, month, day);
		System.out.println(yoil[count%7]);		
	}
	
}
