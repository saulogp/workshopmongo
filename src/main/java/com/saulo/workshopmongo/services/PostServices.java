package com.saulo.workshopmongo.services;

import com.saulo.workshopmongo.domain.Post;
import com.saulo.workshopmongo.domain.User;
import com.saulo.workshopmongo.dto.UserDTO;
import com.saulo.workshopmongo.repository.PostRepository;
import com.saulo.workshopmongo.repository.UserRepository;
import com.saulo.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServices {

    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        //return repo.findByTitleContainingIgnoreCase(text);
        return  repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date((maxDate.getTime() + 24 * 60 * 60 * 1000));
        return repo.fullSearch(text,minDate,maxDate);
    }

}
