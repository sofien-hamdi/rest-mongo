package com.kt.examples.rs.api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="kt_col_user")
public class User {

  @Id
  private String id;
  private String firstName;
  private String lastName;
  
  /**
   * @return the id
   */
  public String getId() {
    return id;
  }
  
  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = id;
  }
  
  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }
  
  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }
  
  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

}
