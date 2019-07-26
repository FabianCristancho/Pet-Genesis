package unitTests;

import com.cmv.petGenesis.connection.SQLPeople;

public class TestCreateIndex {
	public static void main(String[] args) {
		SQLPeople sqlPeople = new SQLPeople();
		System.out.println(sqlPeople.getLastIdPerson());
	}

}
