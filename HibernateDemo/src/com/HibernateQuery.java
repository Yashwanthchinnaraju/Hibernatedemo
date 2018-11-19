package com;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.Product;

public class HibernateQuery 
{
	public static void main(String arg[])
	{
		try
		{
			Configuration config=new Configuration();
			
			config.configure("hibernate.cfg.xml");
			
			SessionFactory sessionFactory=config.buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Query query = session.createQuery("from Product");
			
			List<Product> listProducts=query.list();
			
			for(Product product:listProducts)
			{
				System.out.print(product.getProductId()+":::");
				System.out.print(product.getProductName()+":::");
				System.out.println(product.getPrice());
			}
			
			session.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:");
		}
		
	}
}