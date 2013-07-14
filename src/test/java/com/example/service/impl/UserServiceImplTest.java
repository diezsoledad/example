package com.example.service.impl;

import static junit.framework.Assert.assertEquals;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.example.core.model.User;
import com.example.core.persistence.UserMapper;
import com.example.core.service.impl.UserServiceImpl;

public class UserServiceImplTest {

  UserServiceImpl service;
  UserMapper mapper;

  @Before
  public void setUp() {
    service = new UserServiceImpl();
    mapper = createMock(UserMapper.class);
    service.setUserMapper(mapper);
  }

  @Test
  public void getUsersPageTest_empty() {
    expect(mapper.getUsersPage(10L, 100L)).andReturn(new ArrayList<User>());

    replay(mapper);
    List<User> result = service.getUsersPage(10L, 100L);
    verify(mapper);

    assertNotNull(result);
    assertTrue(result.isEmpty());
  }

  @Test
  public void getUsersPageTest_withData() {
    List<User> users = new ArrayList<User>();
    users.add(new User("name", "email@mail.com", 4L, 28L, "# street", "NZ"));
    users.add(new User("name2", "other@mail.com", 5L, 28L, "# road", "AUS"));

    expect(mapper.getUsersPage(10L, 100L)).andReturn(users);

    replay(mapper);
    List<User> result = service.getUsersPage(10L, 100L);
    verify(mapper);

    assertNotNull(result);
    assertFalse(result.isEmpty());
    assertEquals(2, result.size());
  }

  @Test
  public void addUserTest_added() {
    User user = new User("name", "email@mail.com", 4L, 28L, "# street", "NZ");

    mapper.insertUser(user);
    expect(mapper.getUser(4L)).andReturn(user);

    replay(mapper);
    User result = service.addUser(user);
    verify(mapper);

    assertNotNull(result);
    assertEquals("name", result.getName());
    assertEquals("email@mail.com", result.getEmail());
    assertEquals(4, result.getId().longValue());
    assertEquals(28, result.getAge().longValue());
    assertEquals("# street", result.getAddress());
    assertEquals("NZ", result.getNationality());

  }

  @Test
  public void updateUserTest_updated() {
    User user = new User("name", "email@mail.com", 4L, 28L, "# street", "NZ");

    mapper.updateUser(user);
    expect(mapper.getUser(4L)).andReturn(user);

    replay(mapper);
    User result = service.updateUser(user);
    verify(mapper);

    assertNotNull(result);
    assertEquals("name", result.getName());
    assertEquals("email@mail.com", result.getEmail());
    assertEquals(4, result.getId().longValue());
    assertEquals(28, result.getAge().longValue());
    assertEquals("# street", result.getAddress());
    assertEquals("NZ", result.getNationality());

  }

  @Test
  public void deleteUserTest() {
    mapper.deleteUser(5L);
    
    replay(mapper);
    service.deleteUser(5L);
    verify(mapper);
  }

  @Test
  public void getUsersCountTest() {
    expect(mapper.getUsersCount()).andReturn(12L);
    
    replay(mapper);
    Long count = service.getUsersCount();
    verify(mapper);
    
    assertEquals(12L, count.longValue());
  }

  @Test
  public void getUserByIdTest() {
    User user = new User("name", "email@mail.com", 4L, 28L, "# street", "NZ");
    
    expect(mapper.getUser(4L)).andReturn(user);
    
    replay(mapper);
    User result = service.getUserById(4L);
    verify(mapper);
    
    assertNotNull(result);
    assertEquals(4L, result.getId().longValue());
  }

}
