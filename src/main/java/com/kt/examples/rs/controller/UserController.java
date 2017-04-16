package com.kt.examples.rs.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kt.examples.rs.api.User;
import com.kt.examples.rs.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Component
@Path("/users")
@Api(value = "users", description = "the users management API")
public class UserController {

  @Autowired
  private UserRepository userRepository;



  @ApiOperation(value = "Users list", response = User.class, responseContainer = "List", tags = {"Users"})
  @ApiResponses( value = {@ApiResponse(code = 200, message = "An array of users", response = User.class),
                          @ApiResponse(code = 500, message = "Unexpected error (todo)", response = User.class)})
  @GET
  @Produces("application/json")
  public List<User> allUsers() {
    return userRepository.findAll();
  }

  /**
   * @return the userRepository
   */
  public UserRepository getUserRepository() {
    return userRepository;
  }

  /**
   * @param userRepository the userRepository to set
   */
  public void setUserRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

}
