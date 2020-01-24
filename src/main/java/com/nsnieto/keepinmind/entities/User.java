package com.nsnieto.keepinmind.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "userKeep")
@Data
@AllArgsConstructor
public class User {

	@Id
	@Column(name = "id")
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public User() {

	}

	@Column(name = "nickname", unique = true)
	private String nickName;

	@Column(name = "password")
	@JsonIgnore
	
	private String password;

}