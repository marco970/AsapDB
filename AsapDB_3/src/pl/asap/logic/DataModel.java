package pl.asap.logic;

import javax.swing.table.AbstractTableModel;

import pl.asap.entity.Lista;
import pl.asap.transactions.ReadTrans;

public class DataModel extends AbstractTableModel {

	
	public DataModel(ReadTrans readDB)	{
		readDB
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
