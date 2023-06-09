package bit.basic.obj1;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ObjectEx3 {
	private String name;
	private int age;
	private boolean birth;
	private String gender;
	private String loca;
	private String ddi;
	
	//   나이평균, 나이별정렬, 성씨별 인원수
	public ObjectEx3(String info) {		
		setName(info);
		setAge(info);
		isBirth(info);
		setGender(info);
		setLoca(info);
		setDdi(info);
	}
	final static String[] strDDi = {"닭", "개", "돼지","쥐","소","호랑이","토끼","용","뱀","말","양","원숭이"};	
	
	public String getDdi(int year) {
		int index = year%12; // 
		return strDDi[index!=0 ? (index-1) : strDDi.length-1];
	}
	// 띠
	public void setDdi(String info) {
		int year = 2023  - this.age + 1;
		this.ddi = getDdi(year);
	}
	// 지역
	public void setLoca(String info) {
		String jibun = info.split("#")[2].split("\\)")[0];
		if(jibun.equals("051")) {
			this.loca = "부산";
		}else if(jibun.equals("02")) {
			this.loca = "서울";
		}else{
			this.loca = "대한민국 어딘가";
		}
	}
	// 성별
	public void setGender(String info) {
			String gender = info.split("#")[1].split("-")[1].substring(0,1);
			this.gender = (gender.equals("2") || gender.equals("4"))? "f" : "m";
	}
	// 오늘생일여부
	public void isBirth(String info) {
		LocalDate now = LocalDate.now();
		String[] today = now.toString().split("-");
		
		String jumin = info.split("#")[1];
		if(jumin.substring(2, 6).equals(today[1]+today[2])) {
			this.birth = true;
		}else {
			this.birth = false;
		}			
	}
	// 나이
	public void setAge(String info) {
		String jumin = info.split("#")[1];
		int front = Integer.parseInt(jumin.substring(0, 2));
		int back = Integer.parseInt(jumin.split("-")[1].substring(0, 1));
		if(back==1 || back==2) {
			this.age = 123-front + 1;
		}else {
			this.age = 23-front + 1;
		}
	}
	// 이름
	public void setName(String info) {
			this.name = info.split("#")[0];
	}
	
	@Override
	public String toString() {
		return "ObjectEx3 [name=" + name + ", age=" + age + ", birth=" + birth + ", gender=" + gender + ", loca=" + loca
				+ ", ddi=" + ddi + "]";
	}
	// 나이평균
	public static double getAgeAvg(ObjectEx3 ...m) {
		int sum = 0;
		for(ObjectEx3 p : m) {
			sum += p.getAge();
		}
		return sum/m.length;
	}
	public static void swap(ObjectEx3[] arr, int i, int j) {
		ObjectEx3 temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	// 나이별 정렬
	public static void sortByAge(ObjectEx3 ...m) {
		for(int i=0; i<m.length-1; i++) {
			int minIdx = i;
			for(int j= i+1; j<m.length; j++) {
				if(m[j].getAge() < m[minIdx].getAge()) {
					minIdx = j;
				}
			}
			swap(m, i, minIdx);
		}
	}
	// 성씨별 인원수
	public static Map<String, Integer> getFst(ObjectEx3[] mArr){
		Map<String, Integer> ans = new HashMap<String, Integer>();
		for(ObjectEx3 m : mArr) {
			String fname = m.getName().substring(0, 1);
			if(ans.containsKey(fname)) {
				ans.put(fname, ans.get(fname)+1);
			}else {
				ans.put(fname, 1);
			}
		}
		return ans;
	}
	
	public int getAge() {
		return age;
	}
	public boolean isBirth() {
		return birth;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public String getLoca() {
		return loca;
	}
	public String getDdi() {
		return ddi;
	}
	
	public static void main(String[] args) {
		String[] member = {
				"장영주#940207-2111111#051)518-1043",
				"장영#920323-2000000#051)518-3333",
				"장주#900207-2122222#051)518-2222",
				"영주#911212-2133311#031)518-1111",
				"구영주#021212-3133311#021)518-1111",
				"김영주#101212-4133311#02)518-1111",
				"이영주#881212-2133311#02)518-1111",
				"박영주#201212-4133311#051)518-1111",
				"박장영주주#050321-4222211#02)518-1000"	};
		
		ObjectEx3[] mArr = new ObjectEx3[member.length];
		// 배열에 객체 생성
		for(int i=0; i<member.length; i++) {
			mArr[i] = new ObjectEx3(member[i]);
		}
		for(ObjectEx3 m : mArr) {
			System.out.println(m.toString());
		}
		// 나이평균
		System.out.println("나이평균 : " + getAgeAvg(mArr));
		// 나이순 정렬
		sortByAge(mArr);
		for(ObjectEx3 m : mArr) {
			System.out.println(m.toString());
		}
		// 성씨별 인원수
		System.out.println(getFst(mArr).toString());
	}
}
