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

import com.exam.moviesApp.entites.Genre;
import com.exam.moviesApp.entites.Movie;
import com.exam.moviesApp.service.GenreService;
import com.exam.moviesApp.service.MovieService;

@RestController
@RequestMapping("/api/genre/")
public class RestGenreController {

	@Autowired
	GenreService genreservice;
	
	
	@GetMapping()
	public  List<Genre> getAllGenre(){
	return genreservice.getAllGenre();
	}
	@GetMapping("{id}")
	public Genre getGenre (@PathVariable Long id) {
	return genreservice.findGenreById(id);
	}
	@PostMapping("add")
	public Genre addGenre(@RequestBody Genre g)
	{
		return genreservice.addGenre(g);
	}
	
	
	@DeleteMapping("{id}")
	public String deleteGenre(@PathVariable Long id) {
		genreservice.deleteGenre(id);;
	return "Suppression réussite";
	}
	@PutMapping("update")
	public Genre updateGenre(@RequestBody Genre g) {
	return genreservice.addGenre(g);
	}	
}
