package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Product;

public class HibernateUtilDelete 
{
	public static void main(String arg[])
	{
		try
		{
			Configuration config=new Configuration();
			
			config.configure("hibernate.cfg.xml");
			
			SessionFactory sessionFactory=config.buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			Product product=(Product) session.get(Product.class,"P1001");
			
			product.setPrice(7500);
			
			session.delete(product);
			
			transaction.commit();
			
			session.close();
			
			System.out.println("Object is Deleted");
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
	}
}