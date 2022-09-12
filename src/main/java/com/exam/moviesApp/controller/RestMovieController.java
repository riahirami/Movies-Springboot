package com.exam.moviesApp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.moviesApp.entites.Movie;
import com.exam.moviesApp.service.MovieService;

@RestController
@RequestMapping("/api/movie/")
public class RestMovieController {

	@Autowired
	MovieService movieservice;
	
	
	@GetMapping()
	public  List<Movie> getAllArticle(){
	return movieservice.getAllMovies();
	}
	@GetMapping("{id}")
	public Movie getMovie (@PathVariable Long id) {
	return movieservice.findMovieById(id);
	}
	@PostMapping("add")
	public Movie addMovie(@RequestBody Movie m)
	{
		return movieservice.AddMovies(m);
	}
	
	
	@DeleteMapping("{id}")
	public String deleteMovie(@PathVariable Long id) {
		movieservice.deleteMovie(id);;
	return "Suppression réussite";
	}
	@PutMapping("update")
	public Movie updateMovie(@RequestBody Movie m) {
	return movieservice.AddMovies(m);
	}	
}
