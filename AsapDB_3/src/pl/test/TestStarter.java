package pl.test;

import pl.asap.entity.Lista;
import pl.asap.transactions.SaveTrans;

public class TestStarter {

	public static void main(String[] args) {
		
		Lista lista = new Lista();
		
		new SaveTrans("hibernate.cfg.xml", lista, "ZZ", "ZZ/PLI0006565");

	}

}
