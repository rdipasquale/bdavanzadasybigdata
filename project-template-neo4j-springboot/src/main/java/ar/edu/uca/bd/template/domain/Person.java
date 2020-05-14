package ar.edu.uca.bd.template.domain;

import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


@NodeEntity
public class Person {
    @Id @GeneratedValue
    Long id;

    private String name;
    private int born;

    @Relationship(type = "ACTED_IN")
    private List<Movie> movies;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public int getBorn() {
        return born;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBorn(int born) {
        this.born = born;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

}
