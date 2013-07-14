package com.example.model;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;
import com.example.core.model.User;

public class UserTest {

  @Test
  public void newUserTest() {
    User newUser = new User("name", "email@mail.com", 4L, 28L, "# street", "NZ");
    
    assertEquals("name", newUser.getName());
    assertEquals("email@mail.com", newUser.getEmail());
    assertEquals(4, newUser.getId().longValue());
    assertEquals(28, newUser.getAge().longValue());
    assertEquals("# street", newUser.getAddress());
    assertEquals("NZ", newUser.getNationality());
    
  }

}
