package web.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.example.core.model.User;
import com.example.web.resources.ResultSet;

public class ResultSetTest {

  @Test
  public void createResultSetTest () {
    List<User> set = new ArrayList<User>();
    set.add(new User("name", "email@mail.com", 4L, 28L, "# street", "NZ"));
    set.add(new User("name2", "other@mail.com", 5L, 28L, "# road", "AUS"));
    
    ResultSet rs = ResultSet.createResultSet(set, 8L);
    
    assertNotNull(rs);
    assertEquals(8L, rs.getTotal().longValue());
    assertEquals(set, rs.getElements());
  }
}
