package com.exam.moviesApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.moviesApp.entites.Genre;
import com.exam.moviesApp.entites.Movie;
import com.exam.moviesApp.service.GenreService;
import com.exam.moviesApp.service.MovieService;

@Controller
@RequestMapping("/genre")
public class GenreController {

	
	@Autowired
	MovieService movieService ;
	@Autowired
	GenreService genreService ;
	
	@GetMapping("all")
	public String index (Model model) {
		model.addAttribute("movies",movieService.getAllMovies());
		model.addAttribute("nombre",genreService.getAllGenre().size());
		model.addAttribute("genres",genreService.getAllGenre());
		return "indexg";
	}
	
	
	@GetMapping("add")
	public String showForm (Model model) {
		model.addAttribute("genres",genreService.getAllGenre());
		model.addAttribute("genre", new Genre());
		return "addGenre";
	}

	@GetMapping("edit/{id}")
	public String editerGenre (@PathVariable Long id,Model model) {
		model.addAttribute("genres",genreService.findGenreById(id));
		model.addAttribute("movies",movieService.getAllMovies());
		return "editGenre";
	}
	
	@PostMapping("update")
	public String updateGenre (Genre g) {
		genreService.addGenre(g);
		return "redirect:/genre/all";
	}
	
	@PostMapping("search")
	public String updateMovie (@RequestParam String nom ,Model model) {
		model.addAttribute("genres",genreService.findGenreByNom(nom));
		return "indexg";
	}
	
	@GetMapping("delete/{id}")
	public String suppGenre (@PathVariable Long id) {
		genreService.deleteGenre(id);
		return "redirect:/genre/all";
	}
	
	@PostMapping("bgenre")
	public String findMovieByCat (@RequestParam Long idcat ,Model model) {
		
		if (idcat!=0L) {
		model.addAttribute("genre",genreService.findGenreById(idcat));
		}
		
		else {
			model.addAttribute("genres",genreService.getAllGenre());
			model.addAttribute("nombre",genreService.getAllGenre().size());
		}
		model.addAttribute("genres",genreService.getAllGenre());
		model.addAttribute("id",idcat);
		
		return "indexg";
		
	}
}
