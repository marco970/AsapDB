package pl.test;

import pl.asap.entity.Lista;
import pl.asap.logic.EkranGlowny;

public class Main {

	public static void main(String[] args) {
		
		Lista lista = new Lista();
		new EkranGlowny(lista);
	}

}
