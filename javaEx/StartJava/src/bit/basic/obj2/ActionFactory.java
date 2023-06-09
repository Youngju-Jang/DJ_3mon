package bit.basic.obj2;

// 커맨드요청에따라 액션을 생성, 요청없으면 가비지콜렉션 ㄱㄱ하는 역할
// action을 생성하는 공장
public class ActionFactory { // 싱글톤으로 생성하기
	private static ActionFactory actionFactory;
	public static ActionFactory getInstance() {
		if(actionFactory==null) {
			actionFactory = new ActionFactory();
		}
		return actionFactory;
	}
	
	public Action getAction(String command) {
		if(command.equals("login")) {
			return new LoginAction("loginView", true); // Action action = new LoginAction("loginView", true);
		}
		if(command.equals("list")) {
			return new ListAction("listView", false); // Action action = new ListAction("listView", false);
		}
		return null;
	}
}
