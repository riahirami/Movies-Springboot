package com.exam.moviesApp.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.exam.moviesApp.entites.Movie;
import com.exam.moviesApp.service.GenreService;
import com.exam.moviesApp.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	MovieService movieService ;
	@Autowired
	GenreService genreService ;
	
	private String uploadDirectory = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\photos" ;
	
	
	@GetMapping("all")
	public String index (Model model) {
		model.addAttribute("movies",movieService.getAllMovies());
		model.addAttribute("nombre",movieService.getAllMovies().size());
		model.addAttribute("genres",genreService.getAllGenre());
		return "index";
	}
	
	
	@GetMapping("add")
	public String showForm (Model model) {
		model.addAttribute("genres",genreService.getAllGenre());
		model.addAttribute("movie", new Movie());
		return "addMovie";
	}
	
	@PostMapping("add")
	public String addMovie (@Validated Movie m,BindingResult result,Model model,@RequestParam("file") MultipartFile multipartfile) {
		if (result.hasErrors()) {
			model.addAttribute("genres",genreService.getAllGenre());
			
			return "addMovie";
		}
		String fileName=multipartfile.getOriginalFilename();
		Path fileNameAndPath = Paths.get(uploadDirectory,fileName) ;
		
		try {
			Files.write(fileNameAndPath, multipartfile.getBytes());
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		m.setPhoto(fileName);
		movieService.AddMovies(m);
		
		
		return "redirect:/movie/all";
	}
	
	@GetMapping("delete/{id}")
	public String suppMovie (@PathVariable Long id) {
		movieService.deleteMovie(id);
		return "redirect:/movie/all";
	}
	
	
	@GetMapping("edit/{id}")
	public String editerMovie (@PathVariable Long id,Model model) {
		
		model.addAttribute("movie",movieService.findMovieById(id));
		model.addAttribute("genres",genreService.getAllGenre());
		return "editMovie";
	}
	
	@PostMapping("update")
	public String updateMovie (Movie m) {
		movieService.AddMovies(m);
		return "redirect:/movie/all";
	}
	
	@PostMapping("search")
	public String updateMovie (@RequestParam String nom ,Model model) {
		model.addAttribute("movies",movieService.findMoviesByNom(nom));
		return "index";
	}
	
	@PostMapping("parcat")
	public String findMovieByCat (@RequestParam Long idcat ,Model model) {
		
		if (idcat!=0L) {
		model.addAttribute("movies",movieService.findMoviesByCat(idcat));
		model.addAttribute("nombre",movieService.findMoviesByCat(idcat).size());
		}
		
		else {
			model.addAttribute("movies",movieService.getAllMovies());
			model.addAttribute("nombre",movieService.getAllMovies().size());
		}
		model.addAttribute("genres",genreService.getAllGenre());
		model.addAttribute("id",idcat);
		
		return "index";
		
	}
	
	@GetMapping("detail/{id}")
	public String showDetail (Model model,@PathVariable Long id) {
		model.addAttribute("genres",genreService.getAllGenre());
		model.addAttribute("movie", movieService.findMovieById(id));
		model.addAttribute("ida",id);

		return "Detail";
	}
	
	@PostMapping("show")
	public String showmovi (Model model,Movie a) {
		Movie mv=movieService.findMovieById(a.getId());
		model.addAttribute("movie",mv);

		return "redirect:Detail";
	}
}
