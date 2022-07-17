package com.mt.movies.Movies.Service;

import com.mt.movies.Movies.ExceptionHandler.InvalidDataException;
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
public class DirectorServiceImpl implements DirectorService{

    @Autowired
    private DirectorDAO directorDAO;

    @Autowired
    private FilmDAO filmDAO;

    @Override
    public List<Director> getDirectors() {
        List<Director> directorList=directorDAO.findAll();
        log.info("Directors List:"+directorList);
        return directorList;
    }

    @Override
    public String getDirector(String dirName) {
        if(directorDAO.existsById(dirName)){
            log.info("Searched Director with details: "+directorDAO.getOne(dirName));
            return "Director founded with details:\n"+directorDAO.getOne(dirName);
        }
        log.warn("Trying to access invalid Director record with name: "+dirName);
        return "The Director with name:"+dirName+" does not exists in record.";

    }

    @Override
    public String addDirector(Director director) {
        directorDAO.save(director);
        log.info("Director Added successfully");
        return "Director Added successfully";
    }

    @Override
    public String deleteDirector(String dirName) {
        if(directorDAO.existsById(dirName)){
            directorDAO.deleteById(dirName);
            log.info("Director deleted successfully.");
            return "Director deleted successfully.";
        }else{
            log.warn("Trying to access invalid Director record with name: "+dirName);
            return "There doesn't exists any Director with name:"+dirName;
        }
    }

    @Override
    public String updateDirector(Director director) {
        if(directorDAO.existsById(director.getDirName())){
            Director director1=directorDAO.getOne(director.getDirName());

            if(((director.getDirName().equalsIgnoreCase(director1.getDirName())) &&
                    (director.getAge() == director1.getAge()) &&
                    (director.getAwards() == director1.getAwards())
            ))
             throw new InvalidDataException("701","No field is changed, therefore halting update operation");

            director1.setAge(director.getAge());
            director1.setAwards(director.getAwards());
            directorDAO.save(director1);
            log.info("Director updated successfully.\nUpdated details:\n"+directorDAO.getOne(director1.getDirName()));
            return "Director updated successfully.\nUpdated details:\n"+directorDAO.getOne(director1.getDirName());
        }else{
            log.warn("Trying to access invalid Director record with name: "+director.getDirName());
            return "There doesn't exists any Director with name:"+director.getDirName();     }
    }

    @Override
    public String displayDirectorWork(String dirName) {
        String msg="";
        if(directorDAO.existsById(dirName)){
            msg+="Director founded with details:\n"+directorDAO.getOne(dirName);
            msg+="\n\nAll the lifetime work done by the director:\n";
            List<Film> filmList=filmDAO.findAll();
            for(Film film:filmList){
                List<Director> directorList=film.getDirectors();
                for(Director director:directorList){
                    if(director.getDirName().equalsIgnoreCase(dirName)==true){
                        msg+=film.toPreety();
                    }
                }
            }
            log.info("Director "+dirName+" work succesfully displayed.");
            return msg;
        }
        log.warn("Trying to access invalid Director record with name: "+dirName);
        return "The Director with name:"+dirName+" does not exists in record.";
    }
}
