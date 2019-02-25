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

    public UpdateTrans(String hibernateConf, Object bean, String fieldName, String newValue) {
        super(hibernateConf, bean, fieldName);
        this.newValue = newValue;
        String PZ = "PZ/0000005311";
        String ZZ = "ZZ/PLI0006565";
        int id = 9;
        String update = "update Lista el set el.PZ=:PZ where el.ZZ=:ZZ";
        
        session.beginTransaction();
        Query query = session.createQuery(update);
        query.setParameter("ZZ", ZZ);
        query.setParameter("PZ", PZ);
        query.executeUpdate();
        session.getTransaction().commit();
        factory.close();
        
    }
    

    
    
}
