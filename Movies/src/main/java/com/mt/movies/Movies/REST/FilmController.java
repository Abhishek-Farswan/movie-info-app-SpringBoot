package com.mt.movies.Movies.REST;

import com.mt.movies.Movies.POJO.Film;
import com.mt.movies.Movies.Service.FilmServiceImpl;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class FilmController {

    @Autowired
    private FilmServiceImpl filmService;

    //Fetch all films
    @GetMapping("/films")
    public ResponseEntity<List<Film>> getFilms(){
        List<Film> filmList= filmService.getFilms();
        return new ResponseEntity<>(filmList, HttpStatus.OK);
    }

    //Fetch single film
    @GetMapping("/film/{filmID}")
    public ResponseEntity<String> getFilm(@PathVariable(value="filmID") int filmID){
        String film=filmService.getFilm(filmID);
        return new ResponseEntity<>(film, HttpStatus.FOUND);
    }

    //Fetch single film by name
    @GetMapping("/films/{filmName}")
    public ResponseEntity<String> getFilmName(@PathVariable(value="filmName") String filmName){
        String film=filmService.getFilmName(filmName);
        return new ResponseEntity<>(film, HttpStatus.OK);
    }

    //Add film
    @PostMapping("/films")
    public ResponseEntity<String> addFilm(@RequestBody Film film){
        String addFilm=filmService.addFilm(film);
        return new ResponseEntity<>(addFilm, HttpStatus.OK);

    }

    //Update film
    @PutMapping("/films")
    public ResponseEntity<String> updateFilm(@RequestBody Film film){
        String updateFilm=filmService.updateFilm(film);
        return new ResponseEntity<>(updateFilm, HttpStatus.ACCEPTED);
    }

    /*//Delete film
    @DeleteMapping("/films/{filmID}")
    public String deleteFilm(@PathVariable(value="filmID") int filmID){
        return filmService.deleteFilm(filmID);
    }*/

    //Deleting a film by ID
    @DeleteMapping("/films/{filmName}")
    public ResponseEntity<String> deleteFilmName(@PathVariable(value="filmName") String filmName){
        String deleteFilm=filmService.deleteFilmName(filmName);
        return new ResponseEntity<>(deleteFilm, HttpStatus.OK);
    }

}
