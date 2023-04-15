package gemini.system.geminibackend.repository;

import org.springframework.data.repository.CrudRepository;
import gemini.system.geminibackend.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import gemini.system.geminibackend.repository.UserRepository;

import gemini.system.geminibackend.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
}