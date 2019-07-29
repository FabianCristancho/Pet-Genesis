package unitTests;

import com.cmv.petGenesis.model.TypePerson;
import com.cmv.petGenesis.model.TypeUser;
import com.cmv.petGenesis.model.User;
import com.cmv.petGenesis.view.JFrameMainWindow;

public class TestJFrameMainWindow {
	public static void main(String[] args) {
		User user = new User();
		user.setNameUser("fabian.c");
		user.setTypeUser(TypeUser.MANAGER);
		new JFrameMainWindow(user);
	}

}
