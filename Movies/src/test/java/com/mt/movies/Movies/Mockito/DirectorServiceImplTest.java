package com.mt.movies.Movies.Mockito;

import com.mt.movies.Movies.POJO.Director;
import com.mt.movies.Movies.POJO.Film;
import com.mt.movies.Movies.Repository.DirectorDAO;
import com.mt.movies.Movies.Repository.FilmDAO;
import com.mt.movies.Movies.Service.DirectorService;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DirectorServiceImplTest {

    @Autowired
    private DirectorService directorService;

    @MockBean
    private DirectorDAO directorDAO;

    @MockBean
    private FilmDAO filmDAO;


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getDirectors() {
        when(directorDAO.findAll()).thenReturn(Stream
                .of(new Director("Director 1",20,"Male",12),new Director("Director 2",21,"Female",13)).collect(Collectors.toList()));
        assertEquals(2,directorService.getDirectors().size());

    }


    @Test
    public void getDirector() {
        Director tempDir=new Director("Director 1",20,"Male",12);
        String id="Director 1";
          when(directorDAO.existsById(id)).thenReturn(true);
          when(directorDAO.getOne(id)).thenReturn(tempDir);
        String msg="Director founded with details:\n"+directorDAO.getOne(tempDir.getDirName());
        assertEquals(msg,directorService.getDirector(id));
    }

    @Test
    public void addDirector() {
        Director tempDir=new Director("Director 1",20,"Male",12);
        assertEquals("Director Added successfully",directorService.addDirector(tempDir));
    }

    @Test
    public void deleteDirector() {
        Director tempDir=new Director("Director 1",20,"Male",12);
        String id="Director 1";
        when(directorDAO.existsById(id)).thenReturn(true);
        assertEquals("Director deleted successfully.",directorService.deleteDirector(id));
    }

    @Test
    public void updateDirector() {
        Director Dir1=new Director("Director 1",20,"Male",12);
        Director Dir2=new Director("Director 1",21,"Male",13);
        String id="Director 1";
        when(directorDAO.existsById(id)).thenReturn(true);
        when(directorDAO.getOne("Director 1")).thenReturn(Dir1);
        String msg="Director updated successfully.\nUpdated details:\n"+Dir2;
        assertEquals(msg,directorService.updateDirector(Dir2));
    }

    @Test
    public void displayDirectorWork() {
        Director Dir1=new Director("Director 1",20,"Male",12);
        when(directorDAO.existsById(Dir1.getDirName())).thenReturn(true);
        when(directorDAO.getOne(Dir1.getDirName())).thenReturn(Dir1);
        List<Film> filmList=new ArrayList<>();
        List<Director> directorList=new ArrayList<>();
        directorList.add(Dir1);
        filmList.add(new Film("Movie 1",10000.0,5,directorList));
        filmList.add(new Film("Movie 2",90000.0,4,directorList));
        when(filmDAO.findAll()).thenReturn(filmList);
        System.out.println(directorService.displayDirectorWork(Dir1.getDirName()));;
    }
}