package jay.mme.web.events;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by gkaiswarya on 06/07/15.
 */

@Entity
public class EventStore implements Serializable {

    @Id
    private Long id;

    @Column
    private String eventName;

    @Column
    private Event event;

    public EventStore() {

    }

    public EventStore(String eventName, Event event) {
        this.eventName = eventName;
        this.event = event;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
