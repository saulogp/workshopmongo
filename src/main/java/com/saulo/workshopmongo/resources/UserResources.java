package com.saulo.workshopmongo.resources;

import com.saulo.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1", "Maria", "m@gmail");
        User alex = new User("2", "Alex", "a@gmail");
        List<User> list = new ArrayList<>();
        list.add(maria);
        list.add(alex);
        return ResponseEntity.ok().body(list);
    }
}
