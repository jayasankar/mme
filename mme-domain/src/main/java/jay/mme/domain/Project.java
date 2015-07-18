package jay.mme.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by gkaiswarya on 21/06/15.
 */
@Entity
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Transient
    private List<Project> subProjects;

    @Transient
    private List<Tag> tags;

    @Transient
    private Schedule schedule;

    @Transient
    private Owner owner;

    @Transient
    private List<Collaborator> collaborators;


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSubProjects(List<Project> subProjects) {
        this.subProjects = subProjects;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setCollaborators(List<Collaborator> collaborators) {
        this.collaborators = collaborators;
    }

    public List<Project> getSubProjects() {
        return subProjects;
    }

    public Owner getOwner() {
        return owner;
    }

    public List<Collaborator> getCollaborators() {
        return collaborators;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public String getDescription() {
        return description;
    }
}
