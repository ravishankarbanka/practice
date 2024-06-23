package com.banka.practice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Setter
@Getter
// Class 
public class Department { 

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	
private Long departmentId; 
	private String departmentName; 
	private String departmentAddress; 
	private String departmentCode; 
}

