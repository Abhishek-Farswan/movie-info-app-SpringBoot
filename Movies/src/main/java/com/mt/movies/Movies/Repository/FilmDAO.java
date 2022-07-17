package com.mt.movies.Movies.Repository;

import com.mt.movies.Movies.POJO.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmDAO extends JpaRepository<Film,Integer> {
}
