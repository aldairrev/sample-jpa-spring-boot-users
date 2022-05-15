package pe.aldairrev.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.aldairrev.store.models.User;
import pe.aldairrev.store.repositories.UserRepository;

@Service
public class UserService implements IService<User, Long> {

    @Autowired
    private UserRepository repository;

    @Override
    public User create(User t) {
        Optional<User> userByEmail = repository.findByEmail(t.getEmail());
        if (userByEmail.isPresent()) {
            String message = "This email already exist in our database.";
            throw new IllegalStateException(message);
        }
        return repository.save(t);
    }

    @Override
    public User delete(Long id) {
        Optional<User> user = repository.findById(id);
        if (!user.isPresent()) {
            String message = "User with id: " + id + ", does no exist.";
            throw new IllegalStateException(message);
        }
        repository.deleteById(id);
        return user.get();
    }

    @Override
    public User find(Long id) {
        Optional<User> user = repository.findById(id);
        if (!user.isPresent()) {
            String message = "User with id: " + id + ", does no exist.";
            throw new IllegalStateException(message);
        }
        return user.get();
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User update(User t) {
        Optional<User> old_user = repository.findById(t.getId());
        if (!old_user.isPresent()) {
            String message = "User with id: " + t.getId() + ", does no exist.";
            throw new IllegalStateException(message);
        }

        Optional<User> userByEmail = repository.findByEmail(t.getEmail());
        boolean isSameEmail = old_user.get().getEmail().equals(t.getEmail());
        if (userByEmail.isPresent() && !isSameEmail) {
            String message = "This email already exist in our database.";
            throw new IllegalStateException(message);
        }
        
        return repository.save(t);
    }
}
