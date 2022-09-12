package com.exam.moviesApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exam.moviesApp.entites.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	public List<Movie> findByNomContains(String Nom);
	
	@Query ("select m from Movie m where m.genre.id=?1")
	public List<Movie> rechercherParGenre(Long id);
}
