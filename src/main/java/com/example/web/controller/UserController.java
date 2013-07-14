package com.example.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.core.model.User;
import com.example.core.service.UserService;
import com.example.web.resources.ResultSet;

/**
 * This Controller is responsible for tasks related with Users CRUD.
 * 
 * @author Soledad Diez.
 * 
 */
@Controller
@RequestMapping("/users")
public class UserController {

  /**
   * The user service implementation.
   */
  @Autowired
  private UserService userService;

  /**
   * Gets a specific page of users.
   * 
   * @param start - The position of the first user to list.
   * @param limit - The amount of users to list.
   * @return a {@link ResultSet}.
   */
  @RequestMapping(method = RequestMethod.GET)
  public @ResponseBody
  ResultSet getUsers(
      @RequestParam(value = "start", required = true) final Long start,
      @RequestParam(value = "limit", required = true) final Long limit) {
    List<User> listUsers = new ArrayList<User>();
    if (userService != null) {
      listUsers = userService.getUsersPage(start, limit);
    }
    ResultSet resultSet = ResultSet.createResultSet(listUsers, userService.getUsersCount());
    return resultSet;
  }

  /**
   * Handles the request for persists a new user in the repository.
   * 
   * @param newUser - the new user to persists.
   * @return the new {@link User} instance.
   */
  @RequestMapping(method = RequestMethod.POST)
  public @ResponseBody
  User addUser(@RequestBody final User newUser) {
    return userService.addUser(newUser);
  }

  /**
   * Handles the request for persists the user updates in the repository.
   * The id received as part of the path should be the same that the one included 
   * into the updatedUser.
   * 
   * @param id - the id related with the updated user.
   * @param updatedUser - the updated user.
   * @return the updated {@link User} instance.
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public @ResponseBody
  User updateUser(@PathVariable("id") final Long id,
      @RequestBody final User updatedUser) {
    if (updatedUser.getId().equals(id)) {
      return userService.updateUser(updatedUser);
    }
    return null;
  }

  
  /**
   * Handles the request for delete an user from the repository.
   * 
   * @param id - the id associated with the user that will be deleted.
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public @ResponseBody
  void deleteUser(@PathVariable("id") final Long id) {
    userService.deleteUser(id);
  }
  
  public void setUserService(final UserService userService) {
    this.userService = userService;
  }
}