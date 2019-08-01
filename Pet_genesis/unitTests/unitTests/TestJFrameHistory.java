package unitTests;

import com.cmv.petGenesis.model.User;
import com.cmv.petGenesis.view.historyManagement.JFrameHistory;

public class TestJFrameHistory {

	public static void main(String[] args) {
		User user = new User("fabia.c", "fdfd", "dffd");
		new JFrameHistory(user);
	}
}
