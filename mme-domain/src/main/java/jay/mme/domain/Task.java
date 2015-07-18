package jay.mme.domain;

import java.util.List;

/**
 * Created by gkaiswarya on 21/06/15.
 */
public class Task {

    private final Long id;

    private final String description;

    private final Schedule schedule;

    private final List<Task> tasks;


    public Task(Long id, String description, List<Task> tasks, Schedule schedule) {
        this.id = id;
        this.description = description;
        this.tasks = tasks;
        this.schedule = schedule;
    }

    public Long getId() {
        return id;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public String getDescription() {
        return description;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
