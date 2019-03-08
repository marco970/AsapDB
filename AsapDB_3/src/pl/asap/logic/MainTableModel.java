package pl.asap.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import pl.asap.entity.Lista;
import pl.asap.transactions.ReadTrans;
import pl.asap.transactions.SaveTrans;

public class MainTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private static String[] nazwyKolumn = {"ZZ", "PZ", "WP", "DK", "Status", 
			"Przemiot Zakupu", "Dostawca", "Nazwa", "Tryb postępowania", "Spółka", 
			"dsZZ", "dsPZ", "dsWP", "dsDK" };


	private String current = "Current4.txt";
	
	private Object[][] dane = null;
	private Object[][] adane = null;
	private Object[] ids;
	private Lista lista; //to jest klasa bean, jakbym zapomniał
	
			//tu powinien być odczyt z bazy

	/*
	 * Walidacja
	 */
	//private boolean[] notNull = 
	//private String[] ZZ = {"notNull"};

	//private String current = "F:/aSapData/Current3.txt";
	//private String current = "C:/Users/Lappo/git/AsapJava/aSapData/Current3.txt";
	//private String current = "Current4.txt";
	//private String current = "C:/Users/marcin.kuciak/Documents/workIT_projects/doAsap/aSapData/Current3.txt";
	
	//private Object[][] dane = null;
	
	public MainTableModel() 	{
		
		//do wywalenia ale najpierw przepisać jednorazowo plik do BD - moze oddzielna klasa?
		try {
			this.adane=readFile(current);
		} catch (IOException e) {
			e.printStackTrace();
		}

		lista = new Lista();
		ReadTrans readDB = new ReadTrans(lista);
		//this.dane=adane;
		this.dane=readDB.getMatrix();
		this.ids = readDB.getIDs();
		
		/*
		System.out.println("wiersze n: "+dane.length);
		System.out.println("kolumny m: "+dane[0].length);
		System.out.println("kolumny m': "+nazwyKolumn.length);
		
		int i = dane.length;
		int j = dane[0].length;
		
		for(int m = 0; m<=i-1; m++)	{
					
			for (int n =0; n<=j-1; n++)	{
				if (n==0)	{							
					//System.out.print("ids-"+ids[m]+"("+m+"|"+n+")  ");
				}
					System.out.print(dane[m][n]+"-("+m+"|"+n+") ");
			}
			System.out.println();
		}	
		*/
	
				
	}
	//----------metody--

	public String getPath()	{
		return current;
	}
	public Object[][] getMatrix()	{
		return dane;
	}
	public Object[] getRowData(int i)	{
		return dane[i];		
	}
	public String[] getColumns()	{
		return nazwyKolumn ;
	}
	public String[] getColumnsNoDs()	{
		String[] colNoDs = new String[nazwyKolumn.length-getNumberDs()];
		for (int i=0; i<=nazwyKolumn.length-getNumberDs()-1; i++)	{
			colNoDs[i] = nazwyKolumn[i];
		}
		return nazwyKolumn ;
	}
	public String getColumnName(int i)	{
		return nazwyKolumn[i];	
	}
	public boolean doesElExists(int i, int j)	{
		boolean a = true;
		if (i <= getRowCount())	{
			if ((null==getValueAt(i,j))||"".equals(getValueAt(i,j))) a = false;
			else a = true;
		}
		else a = false;
		return a;
	}
	public int getColumnPosition(String ColName)	{
		int j=100;
		for (int i=0; i<=nazwyKolumn.length-1; i++)	{
			if(nazwyKolumn[i].equals(ColName))	{
				j=i;
			}
		}
		return j;	
	}
	@Override
	public int getColumnCount() {
		return dane[0].length;
	}

	@Override
	public int getRowCount() {
		return dane.length;
	}

	@Override	
	public Object getValueAt(int row, int col) {

		if (row<=getRowCount() && col<=getColumnCount()) return dane[row][col];
		else return "";
	}
	//----------------------------------------------------------
	public Object[][] readFile(String filePath) throws IOException {
		  FileReader fileReader = new FileReader(filePath);
		  BufferedReader bufferedReader = new BufferedReader(fileReader);
		  
		  String textLine = bufferedReader.readLine();
		  ArrayList<String> linia = new ArrayList<String>();	  
		  do {
		    linia.add(textLine);
		    textLine = bufferedReader.readLine();	    
		  } while(textLine != null);

		  bufferedReader.close();
		  int i =0;
		  Object[][] sdane = new String[linia.size()][nazwyKolumn.length];
		  for (String el: linia)	{
			  	String[] row=el.split(";");
			  	for (int j=0; j<=row.length-1; j++)	{	  		
			  		sdane[i][j]=row[j];
			  		if (sdane[i][j]==null) sdane[i][j]="";
			  	}
			  i++;
		  }
		  int n=1;
		  List<Object[]> wiersz = new ArrayList<Object[]>();
		  wiersz.add(sdane[n]);
		  return sdane;
		}
	public int getNumberDs() {
		int a = 0;
		for (Object el: nazwyKolumn)	{
			if ("ds".equals(((String) el).substring(0, 2))) {
				a++; 
			}
		}
		return a;
	}
	public void recordAdd(Object[] savedRow) {	//--zapis do DB
		int n = getRowCount()+1;
		//System.out.println("recordAdd, n: "+n + " ilość wierszy :"+getRowCount());
		Object[][] daneUpd = new Object[n][nazwyKolumn.length];
		for (int i = 0; i<= n-1; i++)	{
			if (i<=n-2) daneUpd[i]=dane[i];
			else 		daneUpd[i]=savedRow;
		}
		dane=daneUpd;
		SaveTrans st = new SaveTrans(lista);
		st.saveRow(savedRow);
		fireTableRowsInserted(n-1, n-1);
		fireTableDataChanged();

	}
	public void recordUpdate(Object[] savedRow, int rowNr) { //--zapis do DB
		ArrayList<Object[]> rowList = new ArrayList<Object[]>();
		for (int i = 0; i<=getRowCount()-1; i++)	{
			rowList.add(dane[i]);
		}
		//System.out.println("recordUpdated rowNr: "+rowNr + " ilość wierszy :"+getRowCount());
		rowList.set(rowNr, savedRow);
		Object[][] daneUpd = new Object[rowList.size()][nazwyKolumn.length];
		int j = 0;
		for (Object[] el: rowList)	{
			daneUpd[j]=el;
			j++;
		}
		dane=daneUpd;
		fireTableRowsUpdated(rowNr, rowNr);
		fireTableDataChanged();	

	}
	public void cellUpdate(Object value, int rowNr, int kolNr)	{ //--zapis do DB
		dane[rowNr][kolNr] = value;
		fireTableCellUpdated(rowNr, kolNr);
	}
}
