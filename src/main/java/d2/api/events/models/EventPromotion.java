package d2.api.events.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "events_promotions")
public class EventPromotion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Id
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

//    @Id
    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;

    @JsonFormat(pattern = "dd/MM/y HH:mm")
    private Date applied_date = new Date();

    public EventPromotion() { }

    public EventPromotion(Event event, Promotion promotion) {
        this.event = event;
        this.promotion = promotion;
    }

    @Override
    public String toString() {
        return "EventPromotion{" +
                "event=" + event +
                ", promotion=" + promotion +
                ", applied_date=" + applied_date +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Date getApplied_date() {
        return applied_date;
    }

    public void setApplied_date(Date applied_date) {
        this.applied_date = applied_date;
    }
}
