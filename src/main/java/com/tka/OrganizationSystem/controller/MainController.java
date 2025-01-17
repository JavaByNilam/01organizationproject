package com.tka.OrganizationSystem.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee27;
import com.tka.OrganizationSystem.service.MainService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class MainController {

	@Autowired
	MainService service;
	@PostMapping("addcountry")
	public String addCountry(@RequestBody Country c) {
//		System.out.println(c);
		
		 String msg=service.addCountry(c);
		 return msg;
		 
		
	}
	
	@GetMapping("getAllCountry")
	public List<Country> getAllCountry(){
		List<Country> list=service.getAllCountry();
		return list;
		
	}
	
	@PutMapping("updatecountry/{id}")
	public String updateCountry(@PathVariable int id, @RequestBody Country c) {
		
		String msg=service.updateCountry(id,c);
		return msg;
	}
	
	@PostMapping("addemp")
	public String addEmployee27(@RequestBody Employee27 emp) {
		String msg= service.addEmployee27(emp);
		return msg;
	}
	
	@PutMapping("updateemp")
	public String updateEmployee27(@RequestBody Employee27 emp) {
		String msg=service.updateEmployee27(emp);
		return msg;
		
	}
	@DeleteMapping("deleteemp/{id}")
	public String deleteEmployee27(@PathVariable int id) {
		String msg=service.deleteEmployee27(id);
		return msg;
		
	}
	@GetMapping("getallemp")
	public List<Employee27> getAllEmployee27(){
		
		List<Employee27> list=service.getAllEmployee27();
		return list;
		
	}
	
	@GetMapping("getempbyid/{id}")
	public Employee27 getParticularById(@PathVariable int id) {
		
		Employee27 emp=service.getParticularById(id);
		return emp;
		
		
	}
	
	@GetMapping("getempbystatus/{status}")
	public List<Employee27> getEmployee27ByStatus(@PathVariable String status){
		List<Employee27> list= service.getEmployee27ByStatus(status);
		 return list;
		
	}
	
	@PostMapping("login")
	public HashMap loginCheck(@RequestBody Employee27 emp) {
		 HashMap map = service.loginCheck(emp);
		 return map;
		
		
	}
	

		
	}
	



