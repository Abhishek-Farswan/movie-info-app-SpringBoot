package com.mt.movies.Movies.POJO;

import javax.persistence.*;
import java.util.List;

@Entity
public class Director {

    @Id
    @Column(name="Director_Name")
    private String dirName;

    @Column(name="Age")
    private int age;

    @Column(name="Gender")
    private String gender;

    @Column(name="Awards")
    private int awards;

    @ManyToMany(mappedBy = "directors")
    private List<Film> films;

    public Director(){}

    public Director(String dirName, int age, String gender, int awards) {
        this.dirName = dirName;
        this.age = age;
        this.gender = gender;
        this.awards = awards;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAwards() {
        return awards;
    }

    public void setAwards(int awards) {
        this.awards = awards;
    }

    @Override
    public String
    toString() {
        return "Director: " +
                "Name='" + dirName + '\'' +
                ", Age=" + age +
                ", Gender='" + gender + '\'' +
                ", Awards won=" + awards ;
    }
}
