package com.exam.moviesApp.entites;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Genre {

	
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String nom;
		@JsonIgnore
		@OneToMany(mappedBy = "genre")
		List<Movie> movies;
		
		

	
}
