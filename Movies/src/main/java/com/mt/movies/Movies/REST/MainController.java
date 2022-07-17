package com.mt.movies.Movies.REST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/film")
    public String film() {
        return "film";
    }

    //Films Controller
    @RequestMapping(value = "/all-films")
    public String allfilms() {
        return "all-films";
    }

    @RequestMapping(value = "/film-name")
    public String filmName() {
        return "film-name";
    }

    @RequestMapping(value = "/add-film")
    public String addfilm() {
        return "add-film";
    }

    @RequestMapping(value = "/delete-film")
    public String deletefilm() {
        return "delete-film";
    }

    @RequestMapping(value = "/update-film")
    public String updatefilm() {
        return "update-film";
    }

    @RequestMapping(value = "/single-film")
    public String singlefilm() {
        return "single-film";
    }

    //Director Controller

    @RequestMapping(value = "/director")
    public String director() {
        return "director";
    }

    @RequestMapping(value = "/all-directors")
    public String allDirectors() {
        return "all-directors";
    }

    @RequestMapping(value = "/add-director")
    public String adddirector() {
        return "add-director";
    }

    @RequestMapping(value = "/delete-director")
    public String deletedirector() {
        return "delete-director";
    }

    @RequestMapping(value = "/director-name")
    public String directorName() {
        return "director-name";
    }


    @RequestMapping(value = "/update-director")
    public String updatedirector() {
        return "update-director";
    }
}
