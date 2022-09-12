package com.exam.moviesApp.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Pattern(regexp="^[A-Z]{1,1}[a-z\séè]{4,49}$", message="Le nom de produit dois commencer par une lettre majuscule et dois comporter entre 5 et 50 caractéres")
	private String nom;
	private String synopsis;
	private String photo;
	private int year;
	private int duration;
	@ManyToOne
	Genre genre;
}