package pl.asap.transactions;

import java.util.List;

import org.hibernate.query.Query;

import pl.asap.entity.Lista;

public class ReadTrans extends TransBlank{
	
	public Object[][] dane;
	public int rowNr;

	public ReadTrans(Object bean) {
		super(bean);
		
		session.beginTransaction();
		
		String select = "from Lista";
				
		Query query = session.createQuery(select);
		List<Lista> result = query.getResultList();
		
		session.getTransaction().commit();
		factory.close();
		
		int i = result.get(0).getLength();	//kolumny
		int j = result.size();	//wiersze
		//System.out.println("kolumny i: "+i);
		//System.out.println("wiersze j: "+j);
		
		dane = new Object[i-1][j-1];
		int k;
		int l = 0;
		for(Lista values: result) {
			k = 0;
			Object[] obj = values.getArray();
			for (Object el: obj)	{
				if (!(k==0 || l==0))	{
				dane[k-1][l-1] = el;
				//System.out.print(el+"-("+k+"|"+l+") ");
				}
				k++;
			}
			l++;
			//System.out.println();
		}
		//System.out.println("kolumny m: "+dane.length);
		//System.out.println("wiersze n: "+dane[0].length);
		/*
		for(int n = 0; n<=j-2; n++)	{
			for (int m =0; m<=i-2; m++)	{
				System.out.print(dane[m][n]+"-("+m+"|"+n+") ");
			}
			System.out.println();
		}	*/
	}
	public Object[][] getMatrix()	{
		return dane;
	}
	public int rowNr()	{
		return dane[0].length;
	}
	
	/*public int getID(int rowNr)	{
		int id = 0;
		return id;
	}
	public int getID(String r)	{
		int id = 0;
		return id;
	} */
	

}
