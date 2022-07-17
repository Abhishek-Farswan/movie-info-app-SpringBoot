package com.mt.movies.Movies.Service;

import com.mt.movies.Movies.POJO.Director;
import com.mt.movies.Movies.POJO.Film;

import java.util.List;

public interface DirectorService {

    public List<Director> getDirectors();
    public String getDirector(String dirName);
    public String addDirector(Director director);
    public String deleteDirector(String dirName);
    public String updateDirector(Director director);
    public String displayDirectorWork(String dirName);
}
