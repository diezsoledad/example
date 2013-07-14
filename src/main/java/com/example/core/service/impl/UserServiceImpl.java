package com.example.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.core.model.User;
import com.example.core.persistence.UserMapper;
import com.example.core.service.UserService;

/**
 * This class provides a working implementation for all the Services associated
 * with users.
 * 
 * @author Soledad Diez.
 * 
 */
@Service
public class UserServiceImpl implements UserService {

  private static final long serialVersionUID = 1L;

  @Autowired
  private UserMapper userMapper;

  @Override
  public List<User> getUsersPage(final Long start, final Long limit) {
    return userMapper.getUsersPage(start, limit);
  }

  @Override
  public User getUserById(final Long userId) {
    return userMapper.getUser(userId);
  }

  @Override
  public User addUser(final User user) {
    userMapper.insertUser(user);
    return userMapper.getUser(user.getId());
  }

  @Override
  public User updateUser(final User user) {
    userMapper.updateUser(user);
    return userMapper.getUser(user.getId());
  }

  @Override
  public void deleteUser(final Long userId) {
    userMapper.deleteUser(userId);
  }

  @Override
  public Long getUsersCount() {
    return userMapper.getUsersCount();
  }

  public void setUserMapper(final UserMapper userMapper) {
    this.userMapper = userMapper;
  }
}
