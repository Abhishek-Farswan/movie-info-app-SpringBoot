package com.mt.movies.Movies.Repository;

import com.mt.movies.Movies.POJO.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorDAO extends JpaRepository<Director,String> {
}
