package d2.api.events.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "promotions")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String label;
    private int duration;

    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private BigDecimal price;

    @JsonFormat(pattern = "dd/MM/y HH:mm")
    private Date available_from;

    @JsonFormat(pattern = "dd/MM/y HH:mm")
    private Date available_to;

    private String description;

//    @JsonIgnore
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = EventPromotion.class)
    private List<EventPromotion> eventPromotions;

    public Promotion() { }

    public Promotion(String label, int duration, BigDecimal price, Date available_from, Date available_to, String description) {
        this.label = label;
        this.duration = duration;
        this.price = price;
        this.available_from = available_from;
        this.available_to = available_to;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "label='" + label + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                ", available_from=" + available_from +
                ", available_to=" + available_to +
                ", description='" + description + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getAvailable_from() {
        return available_from;
    }

    public void setAvailable_from(Date available_from) {
        this.available_from = available_from;
    }

    public Date getAvailable_to() {
        return available_to;
    }

    public void setAvailable_to(Date available_to) {
        this.available_to = available_to;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<EventPromotion> getEventPromotions() {
        return eventPromotions;
    }

    public void setEventPromotions(List<EventPromotion> eventPromotions) {
        this.eventPromotions = eventPromotions;
    }

    public void addEventPromotion(EventPromotion eventPromotion) {
        this.eventPromotions.add(eventPromotion);
    }
}
