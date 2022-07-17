package com.mt.movies.Movies.Mockito;

import com.mt.movies.Movies.POJO.Director;
import com.mt.movies.Movies.POJO.Film;
import com.mt.movies.Movies.Repository.DirectorDAO;
import com.mt.movies.Movies.Repository.FilmDAO;
import com.mt.movies.Movies.Service.FilmService;
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
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FilmServiceImplTest {



    @Autowired
    private FilmService filmService;

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
    public void getFilms() {
        List<Director> directorList=new ArrayList<>();
        Director Dir1=new Director("Director 1",20,"Male",12);
        directorList.add(Dir1);
        List<Film> filmList=new ArrayList<>();
        Film film1=new Film("Movie 1",10000.0,5,directorList);
        Film film2=new Film("Movie 2",23000.0,4,directorList);
        filmList.add(film1);
        filmList.add(film2);
        when(filmDAO.findAll()).thenReturn(filmList);
        assertEquals(filmService.getFilms().size(),2);
        System.out.println(filmService.getFilms());
    }

    @Test
    public void getFilm() {
        Director Dir1=new Director("Director 1",20,"Male",12);
        List<Director> directorList=new ArrayList<>();
        directorList.add(Dir1);
        Film film=new Film("Movie 1",10000.0,5,directorList);
        when(filmDAO.existsById(0)).thenReturn(true);
        when(filmDAO.getOne(0)).thenReturn(film);
        System.out.println(""+filmService.getFilm(0));
    }

    @Test
    public void addFilm() {
        Director Dir1=new Director("Director 1",20,"Male",12);
        List<Director> directorList=new ArrayList<>();
        directorList.add(Dir1);
        Film film=new Film("Movie 1",10000.0,5,directorList);
        when(directorDAO.existsById(anyString())).thenReturn(true);
        assertEquals("Film Added successfully",filmService.addFilm(film));
    }

    @Test
    public void deleteFilm() {
        Director Dir1=new Director("Director 1",20,"Male",12);
        List<Director> directorList=new ArrayList<>();
        directorList.add(Dir1);
        Film film=new Film("Movie 1",10000.0,5,directorList);
        when(filmDAO.existsById(0)).thenReturn(true);
        assertEquals("Film deleted successfully.",filmService.deleteFilm(0));
    }

    @Test
    public void updateFilm() {
        Director Dir1=new Director("Director 1",20,"Male",12);
        List<Director> directorList=new ArrayList<>();
        directorList.add(Dir1);
        Film film=new Film("Movie 1",10000.0,5,directorList);
        when(filmDAO.existsById(0)).thenReturn(true);
        when(filmDAO.getOne(0)).thenReturn(film);
        assertEquals("Film updated successfully.\nUpdated details:\n"+filmDAO.getOne(0)
                ,filmService.updateFilm(film));
    }

    @Test
    public void getFilmName() {
        Director Dir1=new Director("Director 1",20,"Male",12);
        List<Director> directorList=new ArrayList<>();
        directorList.add(Dir1);
        Film film=new Film("Movie 1",10000.0,5,directorList);
        List<Film> filmList=new ArrayList<>();
        filmList.add(film);
        when(filmDAO.findAll()).thenReturn(filmList);
        when(filmDAO.getOne(0)).thenReturn(film);
        System.out.println(filmService.getFilmName(film.getMovieName()));
    }

    @Test
    public void deleteFilmName() {
        Director Dir1=new Director("Director 1",20,"Male",12);
        List<Director> directorList=new ArrayList<>();
        directorList.add(Dir1);
        Film film=new Film("Movie 1",10000.0,5,directorList);
        List<Film> filmList=new ArrayList<>();
        filmList.add(film);
        when(filmDAO.findAll()).thenReturn(filmList);
        assertEquals( "Film deleted successfully.",filmService.deleteFilmName(film.getMovieName()));
    }
}