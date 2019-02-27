package pl.asap.transactions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.asap.entity.Config;

public abstract class TransBlank {
	
		final SessionFactory factory;
		final Session session;
		private final Object bean;
		//String hibernateConf;
		
	
	public TransBlank(Object bean)		{
		Config config = new Config();
		String hibernateConf = config.getHibernateXML();

		Configuration conf = new Configuration();
		conf.configure(hibernateConf);
		this.bean = bean;
		Class<? extends Object> beanClass = bean.getClass();
		
		conf.addAnnotatedClass(beanClass);
		factory = conf.buildSessionFactory();
		session = factory.getCurrentSession();

	}
	public void exeTransaction()	{
		session.beginTransaction();
		session.save(bean);
		session.getTransaction().commit();
		factory.close();
		
	}

}
