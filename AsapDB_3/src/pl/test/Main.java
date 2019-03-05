package pl.test;

import pl.asap.DB.DBConnect;
import pl.asap.entity.Lista;
import pl.asap.logic.DataModel;
import pl.asap.logic.EkranGlowny;
import pl.asap.logic.MainTableModel;
import pl.asap.transactions.ReadTrans;

public class Main {

	public static void main(String[] args) {
		
		DBConnect dbConnect = new DBConnect();
		Lista lista = new Lista();
		ReadTrans readTrans = new ReadTrans(lista);
		MainTableModel mtm = new MainTableModel();
		DataModel dataModel = new DataModel(readTrans);
		EkranGlowny eg = new EkranGlowny(mtm, dbConnect);
		//EkranGlowny eg = new EkranGlowny(dataModel);
		
		
	}

}
