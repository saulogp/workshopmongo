package com.saulo.workshopmongo.config;

import com.saulo.workshopmongo.domain.User;
import com.saulo.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
@Configuration
public class Instantiations implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        User maria = new User(null, "Maria Brown", "m@gmaail.com");
        User alex = new User(null, "Alex Green", "a@gmaail.com");
        User bob = new User(null, "Bob grey", "b@gmaail.com");

        userRepository.save(maria);
        userRepository.save(alex);
        userRepository.save(bob);
    }
}
