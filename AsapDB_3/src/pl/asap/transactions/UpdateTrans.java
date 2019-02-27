/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.asap.transactions;

import org.hibernate.query.Query;

/**
 *
 * @author marcin.kuciak
 */
public class UpdateTrans extends TransBlank {
    
    private final String newValue;
    private String fieldName;

    public UpdateTrans(Object bean, String fieldName, String newValue, int id) {
        super(bean);
        this.newValue = newValue;
        //String val = fieldName;
        //String PZ = newValue;
        //String ZZ = "ZZ/PLI0003457";
        //int id = 9;
        String str = bean.toString();
        int i = str.indexOf("@");
        System.out.println("***"+str.substring(0, i));
        
        String update = "update "+str.substring(0, i)+" set "+ fieldName+"=:"+fieldName+ " where id_postepowanie=:id";
        System.out.println("**"+update);

        //String update = "update Lista set PZ=:PZ where ZZ=:ZZ";
        
        session.beginTransaction();
        Query<?> query = session.createQuery(update);
        query.setParameter("id", id);
        query.setParameter(fieldName, newValue);
        query.executeUpdate();
        session.getTransaction().commit();
        factory.close();
        
    }
    

    
    
}
