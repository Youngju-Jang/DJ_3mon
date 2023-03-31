package bit.basic.array;

import java.util.Iterator;

public class ArrayEx5 {

	// 정렬 > 
	private int[] m = new int[20];
	public ArrayEx5() {
		for(int i=0; i<m.length; i++) {
			m[i] = (int)(Math.random()*100);
		}
	}
	public void print() {
		for(int i=0; i<m.length; i++) {
			System.out.printf("%5d", m[i]);
		}
		System.out.println();
		System.out.println("최댓값: " + maxValue(1));
		System.out.println("최솟값: " + minValue(1));
		System.out.println("40의 근사값: " + getGsa(40));
		System.out.println("평균값 : " + getAvg());
		System.out.printf("값 %3d의 편차: %.2f",m[0], getDev(m[0]));
		System.out.println();
		System.out.println("최빈값 : " + getMost() );
		System.out.println("합계 : " + getSum() );
		System.out.println("평균이상갯수 : " + getBiggerThanAvg() );
		System.out.println("평균이하갯수 : " + getLowerThanAvg() );
		System.out.println("개수 : " + getTotalCnt() );
	}
	// 갯수
	public int getTotalCnt() {
		return m.length;
	}
	// 평균이하갯수
	public int getLowerThanAvg() {
		int cnt = 0;
		double avg = getAvg();
		for(int i:m) {
			if((double)i<avg) {
				cnt++;
			}
		}
		return cnt;
	}
	// 평균이상갯수
	public int getBiggerThanAvg() {
		int cnt = 0;
		double avg = getAvg();
		for(int i:m) {
			if((double)i>avg) {
				cnt++;
			}
		}
		return cnt;
	}
	// 합계
	public int getSum() {
		int sum = 0;
		for(int i: m) {
			sum += i;
		}
		return sum;
	}
	// 최빈값(최다빈도수)
	public String getMost() {
		int[] cnt = new int[100];
		int maxCnt = 0;
		String ans = "";
		// 카운트용
		for(int i: m) {
			cnt[i]++;
		}
		// 최대갯수 확인용
		for(int i:cnt) {
			if(i>maxCnt) {
				maxCnt = i;
			}
		}
		
		for(int i=0; i<cnt.length; i++) {
			if(cnt[i]==maxCnt) {
				ans += i + " ";
			}
		}		
		return ans;
	}
	//최댓값 (두번째, 세번째도)
	public int maxValue(int order) {
		sort(0);
		return m[order-1];
	}
	//최솟값 (두번째, 세번째도)
	public int minValue(int order) {
		sort(1);
		return m[order-1];
	}
	// 근사값
	public int getGsa(int val) {
		int diff = Math.abs(m[0] - val);
		int ans = m[0];
		for(int i : m) {
			if(Math.abs(val-i) < diff) {
				diff = Math.abs(val-i);
				ans = i;
			}
		}
		
		return ans;
	}
	//평균
	public double getAvg() {
		int sum = 0;
		for(int i:m) {
			sum += i;
		}
		return (double)sum/m.length;			
	}
	//편차
	public double getDev(int val) {
		return val-getAvg();
	}
	
	
	
	public void swap(int i, int j) {
		int imsi = 0;
		imsi = m[i];
		m[i] = m[j];
		m[j] = imsi;
	}
	//최솟값, 근사값, 편차, 최빈값(최다빈도수), 합계, 평균, 개수, 평균이상갯수, 평균이하갯수
	// 67 94 89 40 39
	public void sort(int order) { // selection sort
		for (int i = 0; i < m.length-1; i++) {
			for (int j = i+1; j < m.length; j++) {
				if(order == 0) { // 내림차순
					if(m[i] < m[j]) {
						swap(i, j);
					}
				}else{ // 내림차순
					if(m[i] > m[j]) { 
						swap(i, j);
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		ArrayEx5 a = new ArrayEx5();
		a.print();
	}

}
