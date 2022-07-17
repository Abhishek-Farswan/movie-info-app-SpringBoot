package com.mt.movies.Movies.REST;

import com.mt.movies.Movies.POJO.Director;
import com.mt.movies.Movies.Service.DirectorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DirectorController {

    @Autowired
    private DirectorServiceImpl directorService;

    //Fetch all directors

    @GetMapping("/directors")
    public List<Director> getDirectors()
    {
        List<Director> directorList=directorService.getDirectors();
        return directorList;
    }

    //Fetch single director
    @GetMapping("/directors/{dirName}")
    public ResponseEntity<String> getDirector(@PathVariable(value="dirName") String dirName){
        String director=directorService.getDirector(dirName);
        return new ResponseEntity<>(director,HttpStatus.FOUND);
    }

    //Add director
    @PostMapping("/directors")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        String addDir= directorService.addDirector(director);
        return new ResponseEntity<>(addDir,HttpStatus.CREATED);
    }

    //Update director
    @PutMapping("/directors")
    public ResponseEntity<String> updateDirector(@RequestBody Director director){
        String updateDir= directorService.updateDirector(director);
        return new ResponseEntity<>(updateDir,HttpStatus.ACCEPTED);
    }

    //Delete director
    @DeleteMapping("/directors/{dirName}")
    public ResponseEntity<String> deleteDirector(@PathVariable(value="dirName") String dirName){
        String deleteDir=directorService.deleteDirector(dirName);
        return new ResponseEntity<>(deleteDir,HttpStatus.OK);
    }

    //Displaying all work of Director
    @GetMapping("/directors/work/{dirName}")
    public ResponseEntity<String> displayDirectorWork(@PathVariable(value="dirName") String dirName){
        String workDir=directorService.displayDirectorWork(dirName);
        return new ResponseEntity<>(workDir,HttpStatus.OK);
    }
}
