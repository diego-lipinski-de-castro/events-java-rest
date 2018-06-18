package d2.api.events.models;

import d2.api.events.models.location.Location;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

//    @Temporal(TemporalType.TIMESTAMP)
    private String start_date;

//    @Temporal(TemporalType.TIMESTAMP)
    private String end_date;

    private String location;
    private String photoUrl;
    private String description;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long created_by;

    public Event() {
        super();
    }

    public Event(Long id, String name, String start_date, String end_date, String location, String photoUrl, String description, Long created_by) {
        super();
        this.id = id;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.location = location;
        this.photoUrl = photoUrl;
        this.description = description;
        this.created_by = created_by;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", location='" + location + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", description='" + description + '\'' +
                ", created_by=" + created_by +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCreated_by() {
        return created_by;
    }

    public void setCreated_by(Long created_by) {
        this.created_by = created_by;
    }
}
