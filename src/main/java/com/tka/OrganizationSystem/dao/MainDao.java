package com.tka.OrganizationSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee27;

@Repository
public class MainDao {

	@Autowired
	SessionFactory factory;
	
	public String addCountry(Country c) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
		
		session = factory.openSession();
		tx= session.beginTransaction();
		
		session.persist(c);
		tx.commit();
		msg="Country is Added....";
		}catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}

	public String updateCountry(int id, Country c) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			session= factory.openSession();
			tx=session.beginTransaction();
			
			Country country= session.get(Country.class, id);
			country.setCname(c.getCname());
			session.merge(country);
			tx.commit();
			
			msg="Country is Updated...";
			
		}catch (Exception e) {
			
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}

	public String addEmployee27(Employee27 emp) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			session.persist(emp);
			tx.commit();
			
			msg="Employee Added Successfully...";
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}

	public String updateEmployee27(Employee27 emp) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			Employee27 employee= session.get(Employee27.class, emp.getId());
			
			employee.setName(emp.getName());
			employee.setCountry(emp.getCountry());
			employee.setCreateby(emp.getCreateby());
			employee.setCreateddtm(emp.getCreateddtm());
			employee.setUpdatedby(emp.getUpdatedby());
			employee.setDepartment(emp.getDepartment());
			employee.setStatus(emp.getStatus());
			employee.setPhoneno(emp.getPhoneno());
			employee.setEmailid(emp.getEmailid());
			employee.setSalary(emp.getSalary());
			
			session.merge(employee);
			tx.commit();
			msg="Employee Updated Successfully...";
			
			
			
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}

	public String deleteEmployee27(int id) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Employee27 emp= session.get(Employee27.class, id);
			session.remove(emp);
			tx.commit();
			msg="Employee is Deleted successfully...";
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}

	public List<Employee27> getAllEmployee27() {
		
		Session session=null;
		Transaction tx=null;
		List<Employee27> list=null;
		String hqlQuery="from Employee27";
		
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			Query<Employee27> query= session.createQuery(hqlQuery,Employee27.class);
			
			list=query.list();
			tx.commit();
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			
			if(session!=null) {
				session.close();
			}
		}

		return list;
	}

	public Employee27 getParticularById(int id) {
		
		Session session=null;
		Transaction tx=null;
		Employee27 emp=null;
		
try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			
			emp= session.get(Employee27.class, id);
			tx.commit();
			
	}catch (Exception e) {
	if(tx!=null) {
		tx.rollback();
	}
	e.printStackTrace();
	}finally {
	
	if(session!=null) {
		session.close();
	}
}
	
		return emp;
	}

	public List<Employee27> getEmployee27ByStatus(String status) {
		
		Session session=null;
		Transaction tx=null;
		List<Employee27> list=null;
		String hqlQuery="from Employee27 where status=:mystatus";
		
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			Query<Employee27> query= session.createQuery(hqlQuery,Employee27.class);
			
			query.setParameter("mystatus", status);
			
			
			list=query.list();
			tx.commit();
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			
			if(session!=null) {
				session.close();
			}
		}
		return list;
	}

	public Employee27 loginCheck(Employee27 emp) {
		Session session=null;
		Transaction tx=null;
		Employee27 employee=null;
		
		String hqlQuery="from Employee27 where emailid=:myemailid and phoneno=:myphone";
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Query<Employee27> query= session.createQuery(hqlQuery, Employee27.class);
			query.setParameter("myemailid", emp.getEmailid());
			query.setParameter("myphone", emp.getPhoneno());
			
			employee= query.uniqueResult();
			tx.commit();
			
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return employee;
	}

	public List<Country> getAllCountry() {
		
		Session session=null;
		Transaction tx=null;
		List<Country> list=null;
		String hqlQuery="from Country";
		
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			Query<Country> query= session.createQuery(hqlQuery,Country.class);
			
			list=query.list();
			tx.commit();
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			
			if(session!=null) {
				session.close();
			}
		}

		return list;
	}


		
	}
	
	


