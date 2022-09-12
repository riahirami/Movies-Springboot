package com.exam.moviesApp.service;

import java.util.List;

import com.exam.moviesApp.entites.Movie;

public interface MovieService {
	
	public List <Movie> getAllMovies();
	public Movie AddMovies(Movie m);
	public void deleteMovie(Long id);
	public Movie findMovieById(Long id);
	public List<Movie> findMoviesByNom(String Nom);
	public List<Movie> findMoviesByCat(Long id);
	List<Movie> findMoviesByGenre(Long id);
	


}
