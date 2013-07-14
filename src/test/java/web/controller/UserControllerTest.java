package web.controller;

import static junit.framework.Assert.assertEquals;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.example.core.model.User;
import com.example.core.service.UserService;
import com.example.web.controller.UserController;
import com.example.web.resources.ResultSet;

public class UserControllerTest {

  UserController controller;
  UserService service;
  
  @Before
  public void setUp() {
    controller = new UserController();
    service = createMock(UserService.class);
    controller.setUserService(service);
  }
  
  @Test
  public void getUsersTest() {
    List<User> users = new ArrayList<User>();
    users.add(new User("name", "email@mail.com", 4L, 28L, "# street", "NZ"));
    users.add(new User("name2", "other@mail.com", 5L, 28L, "# road", "AUS"));

    expect(service.getUsersPage(0L, 10L)).andReturn(users);
    expect(service.getUsersCount()).andReturn(5L);
    
    replay(service);
    ResultSet result = controller.getUsers(0L, 10L);
    verify(service);

    assertNotNull(result);
    assertNotNull(result.getElements());
    assertFalse(result.getElements().isEmpty());
    assertEquals(2, result.getElements().size());
    assertEquals(5, result.getTotal().longValue());
  }
  
  @Test
  public void addUserTest() {
    User user = new User("name2", "other@mail.com", 5L, 28L, "# road", "AUS");
    expect(service.addUser(user)).andReturn(user);

    replay(service);
    controller.addUser(user);
    verify(service);
  }

  @Test
  public void updateUserTest_notEq() {
    User user = new User("name2", "other@mail.com", 5L, 28L, "# road", "AUS");
    controller.updateUser(3L, user);
  }
  
  @Test
  public void updateUserTest_updated() {
    User user = new User("name2", "other@mail.com", 5L, 28L, "# road", "AUS");
    expect(service.updateUser(user)).andReturn(user);

    replay(service);
    controller.updateUser(5L, user);
    verify(service);
  }
  
  @Test
  public void deleteUserTest() {
    service.deleteUser(7L);

    replay(service);
    controller.deleteUser(7L);
    verify(service);
  }
  
}
