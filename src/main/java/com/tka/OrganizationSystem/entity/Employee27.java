package com.tka.OrganizationSystem.entity;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Employee27 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String name;
	String department;
	String status;
	String phoneno;
	double salary;
	Date createddtm;
	String createby;
	Date updateddtm;
	String updatedby;
	String emailid;
	
	@ManyToOne
	@JoinColumn(name="c_id")
	Country country;

}
