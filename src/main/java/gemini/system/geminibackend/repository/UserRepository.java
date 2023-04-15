package gemini.system.geminibackend.repository;

import gemini.system.geminibackend.model.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}