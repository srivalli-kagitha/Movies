package com.sri.movie_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sri.movie_app.config.JwtService;
import com.sri.movie_app.config.exceptions.UserNotFoundException;
import com.sri.movie_app.model.User;
import com.sri.movie_app.repository.UserRepository;

@Service
public class UserService {
  private final UserRepository repository;
  
  private final PasswordEncoder encoder;
  private final JwtService jwtService;

    public UserService(UserRepository repository,PasswordEncoder encoder,JwtService jwtService){
      this.jwtService = jwtService;
      this.repository = repository;
      this.encoder=encoder;
    }

    public List<User> getAllUsers(){
      return repository.findAll();
    }

    public User register(User user) throws Exception{
      Optional<User> foundUser = repository.findByEmail(user.getEmail());
        if (foundUser.isPresent()){
            throw new Exception("User already exists");
        }
      String encodedPassword = encoder.encode(user.getPassword()); 
      user.setPassword(encodedPassword);
      return repository.save(user);
    }

    public String login(String email,String password) throws Exception{
      //step 1 -> find user by email
        Optional<User> foundUser = repository.findByEmail(email);
        if (!foundUser.isPresent()){
            throw new UserNotFoundException();
        }
        //step 2 -> check if password is correct 
        User user = foundUser.get();
        boolean matches = encoder.matches(password,user.getPassword());

        if(!matches){
          throw new RuntimeException("Invalid Password");
        }
        return jwtService.generateToken(email);
    }

}