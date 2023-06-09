package bit.basic.array;

import java.util.Arrays;

public class ArrayEx7 {
	// 밑으로(행추가) 늘어나는 버전
	// 배열이 꽉찼을 경우 increment하기
	// 10 -> 20 -> 30 순으로 배열늘리기
	final static int colNum = 3;
	int cnt = 0;
	int[][] m = new int[3][colNum];
	
	public int[] getLastIdx() {
		return new int[] {(cnt-1)/colNum, (cnt-1)%colNum};
	}
	public boolean isFull() {		
		// full -> increment		
		return cnt == m.length*colNum;
	}
	public boolean isEmpty() {
		return cnt == 0;
	}
	public void increment() {
		int[][] temp = new int[m.length][colNum];
		for(int i=0; i<m.length; i++) {
			System.arraycopy(m[i], 0, temp[i], 0, m[i].length);
		}
		m = new int[m.length+1][colNum];
		
		for(int i=0; i<temp.length; i++) {
			for(int j=0; j<temp[i].length; j++) {
				m[i][j] = temp[i][j];
			}
		}
	}
	public int[] search(int num) {
		// fromIndex 넣을수있음
		//순환탐색
		// 비었는가
		if(isEmpty()) return null;		
		// 못찾으면 null
		int tempCnt = 0;
		for(int i=0; i<m.length; i++) {
			for(int j=0; j<colNum; j++) {
				if(m[i][j]==num) return new int[]{i,j};
				tempCnt++;
				if(tempCnt >= cnt) return null;
			}
		}
		return null;
	}
	public void modify(int oldNum, int newNum) {
		modify(oldNum, newNum, "one");
	}
	// 값 변경
	public void modify(int oldNum, int newNum, String isAll) {
		// 있는지먼저 확인
		int[] index = search(oldNum);
		// 없으면 나감
		if(index ==null) return;
		
		m[index[0]][index[1]] = newNum;
		
		if(isAll.equals("All")) {
			modify(oldNum, newNum, "All");
		}
	}
	// 값 삭제
	public void delete(int num) {
		delete( num, "one");
	}
	public void delete(int num, String all) {
		// char 추가로 받아서 allDelete도 되도록 수정가능
		// 숫자존재유무 검색
		int[] index = search(num);
		// 없으면 끝
		if(index==null) return;
		// 마지막 값 위치
		int[] lastIdx = getLastIdx();
		// 해당숫자 뒤에수들 땡기기
		Loop1:
		for(int i=index[0]; i<=lastIdx[0]; i++) {
			for(int j=0; j<colNum; j++) {
				// 바꿀거 이전것들은 패스
				if(i==index[0]&&j<index[1]) continue;
				// 마지막 열이고 마지막행이 아닐경우경우 밑에꺼 땡겨오기
				if(j==colNum-1 && i!=lastIdx[0]) {
					m[i][j] = m[i+1][0];
				}else if(j==colNum-1 && i==lastIdx[0]){
				// 제일 마지막열이고 마지막 놈일경우
					break Loop1;
				}else {
					m[i][j] = m[i][j+1];
				}
				// 들어있는 값만큼만 땡기도록
				if((i*colNum)+j+1 > cnt) {
					break Loop1;
				}
			}
		}
		m[lastIdx[0]][lastIdx[1]] = 0;
		cnt--;
		if(all.equals("all")||all.equals("All")) {
			delete(num, "all");
		}
	}
	public void add(int data) {		
		// 꽉찼는가 > 찼으면 늘리기
		if(isFull()) {
			increment();
		}
		m[cnt/colNum][cnt%colNum] = data;
		cnt++;
	} 
	public void add(int ...data) {
		for(int i: data) {
			add(i);
		}
	}

	public static void main(String[] args) {
		ArrayEx7 a = new ArrayEx7();
		a.add(20, 30, 5, 39);
		a.add(10, 20, 30,30, 20, 20,10);
		System.out.println(Arrays.deepToString(a.m));
		a.delete(20);
		System.out.println("20 하나 삭제후>");
		System.out.println(Arrays.deepToString(a.m));
		a.delete(20, "all");
		a.delete(30);
		System.out.println("20 all delete, 30 2개 delete> " );
		System.out.println(Arrays.deepToString(a.m));
		a.modify(30, 3);
		a.modify(10, 40, "All");
		System.out.println("30>3 한개만, 10>40 전부");
		printAll(a);
		a.add(0, 30, 20, 30, 20, 20, 20, 20, 20, 20,20 );
		System.out.println("많이 추가함 > ");
		printAll(a);
	}
	private static void printAll(ArrayEx7 a) {
		System.out.println(Arrays.deepToString(a.m));
		System.out.println();
	}
}
