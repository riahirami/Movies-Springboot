package com.exam.moviesApp.service;

import java.util.List;

import com.exam.moviesApp.entites.Genre;

public interface GenreService {

		public List <Genre> getAllGenre();
		public Genre addGenre(Genre c);
		public void deleteGenre(Long id);
		public Genre findGenreById(Long id);
		public List<Genre> findGenreByNom(String nom);
		

	}


