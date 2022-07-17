package com.mt.movies.Movies.Service;

import com.mt.movies.Movies.POJO.Film;
import java.util.List;

public interface FilmService {

    public List<Film> getFilms();
    public String getFilm(int filmID);
    public String addFilm(Film film);
    public String deleteFilm(int filmID);
    public String updateFilm(Film film);
    public String getFilmName(String filmName);
    public String deleteFilmName(String filmName);

}
