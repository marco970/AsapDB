package pl.asap.transactions;

import java.util.List;

import org.hibernate.query.Query;

import pl.asap.entity.Lista;

public class ReadTrans extends TransBlank{

	public ReadTrans(Object bean) {
		super(bean);
		
		session.beginTransaction();
		
		String select = "from Lista";
		
		Query query = session.createQuery(select);
		List<Lista> result = query.getResultList();
		
		session.getTransaction().commit();
		factory.close();
		
		for(Lista values: result) {
			Object[] obj = values.getArray();
			for (Object el: obj)	{
				System.out.print(el+" ");
			}
			
			//for (Lista el: values)	{
			//	System.out.print(el+" ");
			//}
			System.out.println();
			//System.out.println(values[0] +" "+ values[1]);

			
		}
		
	}

}
