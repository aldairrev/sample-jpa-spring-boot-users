package pe.aldairrev.store.controllers;

import java.util.List;

import pe.aldairrev.store.models.User;
import pe.aldairrev.store.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${apiPrefix:/api}${apiVer:/v1}/users")
public class UserController implements IController<User, Long> {

    @Autowired
    private UserService service;

    @Override
    @GetMapping
    public List<User> index() {
        return service.getAll();
    }

    @Override
    @PostMapping
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @Override
    @DeleteMapping(path = "{id}")
    public User delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @Override
    @GetMapping(path = "{id}")
    public User show(@PathVariable Long id) {
        return service.find(id);
    }

    @Override
    @PutMapping(path = "{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return service.update(user);
    }

    
}
