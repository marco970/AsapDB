/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.asap.transactions;

import org.hibernate.query.Query;

import pl.asap.entity.Lista;

/**
 *
 * @author marcin.kuciak
 */
public class UpdateTrans extends TransBlank {
    
    public UpdateTrans(Object bean) {
        super(bean);      
    }
    
    public void upadateCell(Object field, Object newValue, int id)	{
    	
    	session.beginTransaction();
    	
    	
    	String str = bean.toString();
        int i = str.indexOf("@");
    	String update = "update "+str.substring(0, i)+" set "+ field+"=:"+field+ " where id_postepowanie=:id";
    	
        
        Query<?> query = session.createQuery(update);
        query.setParameter("id", id);
        query.setParameter((String) field, newValue.toString());
        query.executeUpdate();
        session.getTransaction().commit();
        factory.close();
    }
    
    public void updateRow(Object[] savedRow, int id)	{
    	Object[] a = ((Lista) bean).getArray();
    	for (int i = 0; i<=a.length-1; i++)	{
    		if (savedRow[i]==null) savedRow[i] = "a";
    		System.out.println(i+" * "+a[i]+" * "+savedRow[i]);
    		//upadateCell(a[i], savedRow[i], id);
    	}
    }
}
