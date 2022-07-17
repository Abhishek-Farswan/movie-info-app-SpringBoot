package com.mt.movies.Movies.POJO;

import javax.persistence.*;
import java.util.List;

@Entity
public class Film {

    @Id
    @Column(name="FilmID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmID;

    @Column(name="Name")
    private String movieName;

    @Column(name="BoxOffice")
    private double collect;

    @Column(name="Ratings")
    private int ratings;

    @ManyToMany
    @JoinTable(name="Directors_Assigned")
    private List<Director> directors;

    public Film(){}


    public Film(String movieName, double collect, int ratings, List<Director> directors) {
        this.movieName = movieName;
        this.collect = collect;
        this.ratings = ratings;
        this.directors = directors;
    }

    public int getFilmID() {
        return filmID;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public double getCollect() {
        return collect;
    }

    public void setCollect(double collect) {
        this.collect = collect;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    @Override
    public String toString() {
        String dir="";
        for(Director director:directors){
         dir+="\n"+director;
        }
        return
                "\nFilm ID=" + filmID +
                ", Movie Name='" + movieName + '\'' +
                "\nBox Office Collections=" + collect +
                ", Ratings=" + ratings +
                "\n\nDirectors of this movie:" + dir +"\n";

    }

    public String toPreety(){
        return
                "\nFilm ID=" + filmID +
                        ", Movie Name='" + movieName + '\'' +
                        "\nBox Office Collections=" + collect +
                        ", Ratings=" + ratings+"\n";
    }
}
