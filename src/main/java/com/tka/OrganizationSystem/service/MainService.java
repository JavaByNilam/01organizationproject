package com.tka.OrganizationSystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.OrganizationSystem.dao.MainDao;
import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee27;

@Service
public class MainService {
	
	@Autowired
	MainDao dao;
	
	
	public String addCountry(Country c) {
		String msg= dao.addCountry(c);
		
		if(Objects.isNull(msg)) {
			msg="Country is not Added.....";
		}
		return msg;
	}


	public String updateCountry(int id, Country c) {
		 String msg= dao.updateCountry(id,c);
		 if(Objects.isNull(msg)) {
			 msg="Country is not Updated...";
		 }
		return msg;
	}


	public String addEmployee27(Employee27 emp) {
		String msg=dao.addEmployee27(emp);
		if(Objects.isNull(msg)) {
			msg="Record is not addedd...";
		}
		return msg;
		
	}


	public String updateEmployee27(Employee27 emp) {
		String msg=dao.updateEmployee27(emp);
		if(Objects.isNull(msg)) {
			msg="Record is not Updated ...";
		}
		
		return msg;
	}


	public String deleteEmployee27(int id) {
		String msg=dao.deleteEmployee27(id);
		if(Objects.isNull(msg)) {
			msg="Record is not Deleted..";
		}
		return msg;
	}


	public List<Employee27> getAllEmployee27() {
		List<Employee27> list= dao.getAllEmployee27();
		if(Objects.isNull(list)) {
			list=null;
		}
		return list;
	}


	public Employee27 getParticularById(int id) {
		Employee27 emp= dao.getParticularById(id);
		if(Objects.isNull(emp)) {
			emp=null;
		}
		return emp;
	}


	public List<Employee27> getEmployee27ByStatus(String status) {
		List<Employee27> list= dao.getEmployee27ByStatus(status);
		
		if(Objects.isNull(list)) {
			list=null;
		}
		return list;
	}


	public HashMap loginCheck(Employee27 emp) {
		Employee27 e= dao.loginCheck(emp);
		
		HashMap map=new HashMap();
		if(Objects.isNull(e)) {
			map.put("msg", "Invalid User");
			map.put("user", e);
			
		}else {
			map.put("msg", "Valid User");
			map.put("user", e);
			
		}
		return map;
	}


	public List<Country> getAllCountry() {
		List<Country> list=dao.getAllCountry();
		if(Objects.isNull(list)) {
			list=null;
		}
		return list;
	}

}
