package com.javacamp.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_adverts")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPosition","employer","city"})
public class JobAdvert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@Column(name="published_at")
	private Date publishedAt;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@Column(name="deadline")
	private Date deadline;
	
	@Column(name="minimum_salary")
	private int minimumSalary;
	
	@Column(name="maksimumSalary")
	private int maksimumSalary;
	
	
	@Column(name="is_open")
	private boolean isOpen = true;
	
	@NotBlank
	@Column(name="description")
	private String description;
	
	@Column(name="open_position_count")
	private int openPositionCount;
	
	@ManyToOne
	@JoinColumn(name="job_position_id")
	JobPosition jobPosition;
	
	@ManyToOne
	@JoinColumn(name="employer_id")
	Employer employer;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
}
