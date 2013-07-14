package com.example.core.model;

import java.io.Serializable;

/**
 * Represents an User object from the database.
 * 
 * @author Soledad Diez.
 * 
 */
public class User implements Serializable {

  /**
   * The serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The database id.
   */
  private Long id;
  /**
   * The name.
   */
  private String name;
  /**
   * The email.
   */
  private String email;
  /**
   * The address.
   */
  private String address;
  /**
   * The nationality.
   */
  private String nationality;
  /**
   * The age at the moment when the user is registered.
   */
  private Long age;

  /**
   * Empty constructor. Required by myBatis.
   * 
   */
  public User() {
    super();
  }

  /**
   * Creates a new user with the given data.
   * 
   * @param name
   *          The name.
   * @param email
   *          The email.
   * @param id
   *          The id.
   * @param age
   *          The current age.
   * @param address
   *          The address.
   * @param nationality
   *          The nationality.
   */
  public User(String name, String email, Long id, Long age, String address,
      String nationality) {
    this.name = name;
    this.email = email;
    this.id = id;
    this.age = age;
    this.nationality = nationality;
    this.address = address;
  }

  /**
   * Gets the id.
   * 
   * @return the id.
   */
  public Long getId() {
    return id;
  }

  /**
   * Gets the name.
   * 
   * @return the name.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the email address.
   * 
   * @return the email.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Gets the address.
   * 
   * @return the address.
   */
  public String getAddress() {
    return address;
  }

  /**
   * Gets the nationality.
   * 
   * @return the nationality.
   */
  public String getNationality() {
    return nationality;
  }

  /**
   * Gets the reported age.
   * 
   * @return the reported age.
   */
  public Long getAge() {
    return age;
  }

}
