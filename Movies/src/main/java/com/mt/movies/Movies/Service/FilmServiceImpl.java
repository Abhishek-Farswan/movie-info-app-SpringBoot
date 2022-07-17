package com.mt.movies.Movies.Service;

import com.mt.movies.Movies.ExceptionHandler.InvalidNameException;
import com.mt.movies.Movies.POJO.Director;
import com.mt.movies.Movies.POJO.Film;
import com.mt.movies.Movies.Repository.DirectorDAO;
import com.mt.movies.Movies.Repository.FilmDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FilmServiceImpl implements FilmService{

    @Autowired
    private FilmDAO filmDAO;

    @Autowired
    private DirectorDAO directorDAO;

    @Override
    public List<Film> getFilms() {
        log.info("Returned whole Movie List");
        return filmDAO.findAll();
    }

    @Override
    public String getFilm(int filmID) {
        if(filmDAO.existsById(filmID)){
            log.info("Founded film with ID: "+filmID);
           return "Film founded with details:\n"+filmDAO.getOne(filmID);
        }
        log.warn("Searched invalid movie id: "+filmID);
        return "The Film with Film ID:"+filmID+" does not exists in record.";
    }

    @Override
    public String addFilm(Film film) {
        List<Director> directors=film.getDirectors();
        boolean f=true;
        String mismatch="\n";
        for(Director director:directors){
            if(directorDAO.existsById(director.getDirName())==false){
                f=false;
                mismatch=director.getDirName()+"\n";
            }
        }
        if(f){
        filmDAO.save(film);
            log.info("Film added successfully to servers");
            return "Film Added successfully";
        }
        else{
            log.warn("Trying to save a movie with invalid Director name's:"+film.getDirectors());
            return "The directors you specified does not exists in our records. " +
                    "They are give below:\n"+mismatch;
        }
    }

    @Override
    public String deleteFilm(int filmID) {
        if(filmDAO.existsById(filmID)){
            filmDAO.deleteById(filmID);
            log.info("Film deleted successfully with ID:"+filmID);
            return "Film deleted successfully.";
        }else{
            log.warn("There doesn't exists any Film with Film ID:"+filmID);
            return "There doesn't exists any Film with Film ID:"+filmID;
        }
    }

    @Override
    public String updateFilm(Film film) {
        if(filmDAO.existsById(film.getFilmID())){
            filmDAO.save(film);
            log.info("Film updated with details:\n"+filmDAO.getOne(film.getFilmID()));
            return "Film updated successfully.\nUpdated details:\n"+filmDAO.getOne(film.getFilmID());
        }else{
            log.warn("There doesn't exists any Film with Film ID:"+film.getFilmID());
            return "There doesn't exists any Film with Film ID:"+film.getFilmID();
        }
    }

    @Override
    public String getFilmName(String filmName) {
        List<Film> films=filmDAO.findAll();
        boolean flag=false;
        int found=0;
        for(Film film:films){
            if(film.getMovieName().equalsIgnoreCase(filmName)==true){
                flag=true;
                found=film.getFilmID();
                break;
            }
        }

        if(flag){
            log.info("Film founded successfully.");
            return "Film founded with details:\n"+filmDAO.getOne(found);
        }
        log.warn("The Film with Film Name:"+filmName+" does not exists in record.");
        return "The Film with Film Name:"+filmName+" does not exists in record.";
    }

    @Override
    public String deleteFilmName(String filmName){
        List<Film> filmList=filmDAO.findAll();
        boolean flag=false;

        for(Film film:filmList){
            if(film.getMovieName().equalsIgnoreCase(filmName)){
                flag=true;
                filmDAO.delete(film);
            }
        }

        if(flag){
            log.info("Film deleted successfully with name "+filmName);
            return "Film deleted successfully.";
        }else{
            String msg="";
                List<Film> filmList1= filmDAO.findAll();
                for(Film film:filmList1)
                    msg+=film.toPreety();
                log.error("601","There doesn't exists any Film with Film name:"+filmName+"\n",msg);
                throw new InvalidNameException("601","There doesn't exists any Film with Film name:"+filmName+"\n",msg);
        }
    }

}
