package com.saulo.workshopmongo.config;

import com.saulo.workshopmongo.domain.Post;
import com.saulo.workshopmongo.domain.User;
import com.saulo.workshopmongo.repository.PostRepository;
import com.saulo.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiations implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();
        User maria = new User(null, "Maria Brown", "m@gmaail.com");
        User alex = new User(null, "Alex Green", "a@gmaail.com");
        User bob = new User(null, "Bob grey", "b@gmaail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2021"), "Fogo no parquinho", "Pegou fogo no parquinho ontem de noite", maria);
        Post post2 = new Post(null, sdf.parse("21/04/2021"), "Gelo no parquinho", "Caiu neve no parquinho ontem de noite", maria);

        userRepository.save(maria);
        userRepository.save(alex);
        userRepository.save(bob);

        postRepository.save(post1);
        postRepository.save(post2);
    }
}
