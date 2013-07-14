package com.example.core.service;

import java.io.Serializable;
import java.util.List;

import com.example.core.model.User;

/**
 * Defines the interfaces for services related with {@link User}.
 * 
 * @author Soledad Diez.
 *
 */
public interface UserService extends Serializable {
	
	/**
	 * Gets a specific page in the users list.
	 * 
	 * @param start - The position of the first user to list.
	 * @param limit - The amount of users to list.
	 * @return a list of {@link User}.
	 */
	List<User> getUsersPage(Long start, Long limit);
	
	/**
	 * Gets the user associated with the given id.
	 * 
	 * @param userId - the given id.
	 * @return the {@link User}.
	 */
	User getUserById(Long userId);
	
  /**
   * Persists a new user.
   * 
   * @param user - the new user to persists.
   * @return the new {@link User} instance.
   */
	User addUser(User user);
	
  /**
   * Persists the updates in the repository.
   * 
   * @param user - the updated user.
   * @return the updated {@link User} instance.
   */
	User updateUser(User user);
	
  /**
   * Delete an user from the repository.
   * 
   * @param userId - the id associated with the user that will be deleted.
   */
	void deleteUser(Long userId);

	/**
	 * Gets the amount of users that are currently into the database.
	 * 
	 * @return the total of users.
	 */
  Long getUsersCount();
	
}
