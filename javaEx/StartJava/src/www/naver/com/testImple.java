package www.naver.com;


interface Fightable{
	int fire();
}

interface Transformable{
	void changeShape(boolean isHeroMode);
}

// interface의 경우 다중상속 가능
interface Heroable extends Fightable, Transformable{
	void upgrade();
}

class Fighter implements Fightable{

	@Override
	public int fire() {
		return 0;
	}
}

class Hero implements Heroable{

	@Override
	public int fire() {
		return 0;
	}

	@Override
	public void changeShape(boolean isHeroMode) {
	}

	@Override
	public void upgrade() {
	}
	
}

class Cat implements Fightable{
	@Override
	public int fire() {
		return 0;
	}
}
class Dog implements Fightable{
	@Override
	public int fire() {
		return 0;
	}
}
public class testImple {
	public static void main(String[] args) {
		// 조상인터페이스인 Fightable으로 자식객체 참조 가능 
		// 인터페이스의 다형성
		Fightable f1 = new Hero(); 
		Fightable f2 = new Fighter();
		
		// 서로 상속의 관계가 없는 클래스들에게인터페이스를 통한 관계 부여로 다형성 확장
		Fightable f3 = new Cat();
		Fightable f4 = new Dog();
	}
}