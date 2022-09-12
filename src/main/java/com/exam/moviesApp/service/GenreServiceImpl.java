package com.exam.moviesApp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.moviesApp.entites.Genre;
import com.exam.moviesApp.repository.GenreRepository;

@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	GenreRepository genreRepository;
	
	@Override
	public List<Genre> getAllGenre() {
		return genreRepository.findAll();
		
	}

	@Override
	public Genre addGenre(Genre c) {
		// TODO Auto-generated method stub
		return genreRepository.save(c);
	}

	@Override
	public void deleteGenre(Long id) {
		// TODO Auto-generated method stub
		genreRepository.deleteById(id);
	}

	@Override
	public Genre findGenreById(Long id) {
		// TODO Auto-generated method stub
		return genreRepository.getById(id);
		
	}

	@Override
	public List<Genre> findGenreByNom(String nom) {
		// TODO Auto-generated method stub
		return genreRepository.findByNomContains(nom);
	}

	
	

	
}
