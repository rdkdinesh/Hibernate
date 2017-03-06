package com.dinesh.mapping;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();
		Transaction tx = ses.beginTransaction();
		
		Employee emp = new Employee();
		emp.setEmp_name("vijay");
		emp.setSalary(6000);
		emp.setAge(24);
		
		Address addr = new Address();		
		addr.setAddress("abc street");
		addr.setCity("Cheennai");
		addr.setEmployee(emp);
		
		emp.setAddress(addr);
		int last_insert_id = (Integer) ses.save(emp);
		
		System.out.println("Employee => "+last_insert_id);
		
		Employee e1 = (Employee) ses.get(Employee.class, last_insert_id);
		System.out.println("Employee => "+e1);
		tx.commit();
		sf.close();		

	}

}
