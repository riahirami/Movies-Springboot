package com.exam.moviesApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.moviesApp.entites.Genre;
import com.exam.moviesApp.entites.Movie;

public interface GenreRepository extends JpaRepository<Genre, Long> {

	public List<Genre> findByNomContains(String nom);


}
