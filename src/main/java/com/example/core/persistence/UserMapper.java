package com.example.core.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.core.model.User;

/**
 * This class defines and implements the access to the database. This particular
 * one is prepare to work over a mySQL database. Should be reimplemented if the
 * DBMS or some table definition change.
 * 
 * @author Soledad Diez.
 * 
 */
public interface UserMapper {

  final String SELECT_ALL = "SELECT * FROM user LIMIT #{limit} OFFSET #{start}";
  final String SELECT_BY_ID = "SELECT * FROM user WHERE id = #{id}";
  final String UPDATE = "UPDATE user SET email = #{email}, name = #{name} WHERE id = #{id}";
  final String DELETE = "DELETE FROM user WHERE id = #{id}";
  final String INSERT = "INSERT INTO user (name, email, address, nationality, age) VALUES (#{name}, #{email}, #{address}, #{nationality}, #{age})";
  final String COUNT_ALL = "SELECT COUNT(*) FROM user";

  @Select(SELECT_ALL)
  List<User> getUsersPage(@Param("start") final Long start,
      @Param("limit") final Long limit);

  @Select(SELECT_BY_ID)
  User getUser(@Param("id") final Long id);

  @Insert(INSERT)
  @Options(useGeneratedKeys = true)
  void insertUser(final User newUser);

  @Update(UPDATE)
  void updateUser(final User updatedUser);

  @Delete(DELETE)
  void deleteUser(@Param("id") final Long id);
  
  @Select(COUNT_ALL)
  Long getUsersCount();
}