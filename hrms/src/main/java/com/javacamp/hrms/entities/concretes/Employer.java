package com.javacamp.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="user_id", referencedColumnName = "id")
@Table(name="employers")
public class Employer extends User{

	@NotBlank
	@Column(name="web_address")
	private String webAddress;
	
	@NotBlank
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank
	@Column(name="phone_number")
	private String phoneNumber;
	
	@JsonIgnore
	@Column(name="is_verified")
	private boolean isVerified = false;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvert> jobAdvert;
	
}
