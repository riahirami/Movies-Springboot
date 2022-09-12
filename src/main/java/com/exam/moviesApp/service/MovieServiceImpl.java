package com.exam.moviesApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.moviesApp.entites.Movie;
import com.exam.moviesApp.repository.GenreRepository;
import com.exam.moviesApp.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService  {

	
	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
		
	}

	@Override
	public Movie AddMovies(Movie m) {
		// TODO Auto-generated method stub
		return movieRepository.save(m);
	}

	@Override
	public void deleteMovie(Long id) {
		// TODO Auto-generated method stub
		movieRepository.deleteById(id);
	}

	@Override
	public Movie findMovieById(Long id) {
		// TODO Auto-generated method stub
		return movieRepository.getById(id);
		
	}

	@Override
	public List<Movie> findMoviesByNom(String Nom) {
		// TODO Auto-generated method stub
		return movieRepository.findByNomContains(Nom);
	}

	@Override
	public List<Movie> findMoviesByGenre(Long id) {
		// TODO Auto-generated method stub
		return movieRepository.rechercherParGenre(id);
	}

	@Override
	public List<Movie> findMoviesByCat(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



}
