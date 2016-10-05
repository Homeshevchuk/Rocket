package com.example.Endpoints;

import com.example.Entities.User;
import com.example.JsonViews;
import com.example.Services.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Created by PC on 28.09.2016.
 */
@RestController
public class UserController {
    @Autowired
    UserService service;
    @RequestMapping(value = "/api/registration", method = RequestMethod.POST)
    @ResponseBody
    public HttpStatus register(@RequestBody User user) {
        try {
            service.register(user);
        }catch (IllegalArgumentException e){
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }
    @JsonView(JsonViews.UserSummary.class)
    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> getUser(Principal principal) {
      User result;
      try {
          result = service.getUser(principal.getName());

      }
      catch (IllegalArgumentException e){
          return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
      }
      return new ResponseEntity(result, HttpStatus.OK);


    }
}
