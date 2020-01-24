package com.nsnieto.keepinmind.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "word")
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Word {
    @Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; 
    
   public Word() {
	   
   }

    @Column(name = "name")
    private String name; 

    @Column(name = "mean")
    private String mean; 

}