package d2.api.events.services;

import d2.api.events.models.Event;
import d2.api.events.repositories.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "events")
public class EventService {

    @Autowired
    private EventsRepository eventsRepository;

    @GetMapping(path = "/")
    public List<Event> index() {
        return eventsRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Event> show(@PathVariable Long id) {
        return eventsRepository.findById(id);
    }

    @PostMapping(path = "/")
    public Event store(@RequestParam Event event) {
        eventsRepository.save(event);
        return event;
    }

    @PutMapping(path = "/")
    public void update(@RequestParam Event event) {
        eventsRepository.save(event);
    }

    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable Long id) {
        eventsRepository.deleteById(id);
    }

}
