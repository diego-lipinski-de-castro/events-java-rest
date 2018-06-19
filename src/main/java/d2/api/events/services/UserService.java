package d2.api.events.services;

import d2.api.events.models.User;
import d2.api.events.repositories.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "users")
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping(path = "/{id}")
    public ResponseEntity<User>  show(@PathVariable Long id) {
        LOG.info("GET - SHOW - DATA: " + id);
        return usersRepository.findById(id).map(user ->
                new ResponseEntity<>(user, HttpStatus.OK)
        ).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @PostMapping(path = "/")
    public ResponseEntity<User> store(@Valid @RequestBody User user) {
        LOG.info("POST - STORE - DATA: " + user.toString());
        return new ResponseEntity<>(usersRepository.saveAndFlush(user), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @Valid @RequestBody User requestUser) {
        LOG.info("PUT - UPDATE- DATA: " + id + " /// " + requestUser.toString());
        return usersRepository.findById(id).map(user -> {
            user.setDisplayName(requestUser.getDisplayName());
            return new ResponseEntity<>(usersRepository.save(user), HttpStatus.OK);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> destroy(@PathVariable Long id) {
        LOG.info("DELETE - DESTROY - DATA: " + id);
        return usersRepository.findById(id).map(user -> {
            usersRepository.delete(user);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {

        LOG.info("POST - LOGIN - DATA: " + email + "///" + password);

        User user = usersRepository.findByEmail(email);

        if(new BCryptPasswordEncoder().matches(password, user.getPassword())) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        throw new ResourceNotFoundException("User not found");

    }
}
