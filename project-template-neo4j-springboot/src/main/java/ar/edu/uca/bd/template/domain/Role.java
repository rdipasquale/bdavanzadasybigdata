package ar.edu.uca.bd.template.domain;

import java.util.Collection;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "ACTED_IN")
public class Role {
    @Id @GeneratedValue
	Long id;
    private Collection<String> roles;
    @StartNode
    private Person person;
    @EndNode
    private Movie movie;

    public Role() {
    }

    public Collection<String> getRoles() {
        return roles;
    }

    public Person getPerson() {
        return person;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setRoles(Collection<String> roles) {
        this.roles = roles;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
