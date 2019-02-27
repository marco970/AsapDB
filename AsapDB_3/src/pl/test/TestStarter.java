package pl.test;

import pl.asap.entity.Lista;
import pl.asap.transactions.SaveTrans;
import pl.asap.transactions.UpdateTrans;

public class TestStarter {

	public static void main(String[] args) {
		
		Lista lista = new Lista();
		
            //new SaveTrans("hibernate.cfg.xml", lista, "ZZ", "ZZ/PLI0006565");
            UpdateTrans updateTrans = new UpdateTrans(lista, "WP", "WP/PLK0004328", 8);

	}

}
