package pl.test;

import pl.asap.DB.DBConnect;
import pl.asap.entity.Lista;
import pl.asap.logic.DataModel;
import pl.asap.logic.EkranGlowny;
import pl.asap.logic.MainTableModel;
import pl.asap.transactions.ReadTrans;
import pl.asap.transactions.SaveTrans;

public class Main {

	public static void main(String[] args) {
		
		String[] values = {"ZZ/CPO0002239"," "," "," ","aktywne","","","","","23.12.2018","","","",""};
		//System.out.println(values.length);
		
		DBConnect dbConnect = new DBConnect();
		//Lista lista = new Lista();
		//Object[] pola = lista.getArray();
		//for (Object el: pola)	{
			//System.out.println(" main el "+el);
		//}
		
		//SaveTrans st = new SaveTrans(lista);
		//st.saveRow(values);
		//st.saveField("ZZ", "ZZ/CPO0002244");
		
		
		
		//ReadTrans readTrans = new ReadTrans(lista);
		MainTableModel mtm = new MainTableModel();
		//DataModel dataModel = new DataModel(readTrans);
		EkranGlowny eg = new EkranGlowny(mtm, dbConnect);
		//EkranGlowny eg = new EkranGlowny(dataModel);
		
		
	}

}
