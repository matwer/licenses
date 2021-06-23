/**
 * @author Matthew Werner
 *
 */

package com.shad.licenses.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="persons")
public class Person {
 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @NotNull
	 @Size(min = 3, max = 200, message="First name needs to be at least 3 characters")
	 private String first_name;
	 
	 @NotNull
	 @Size(min = 3, max = 200, message="Last name needs to be at least 3 characters")
	 private String last_name;
	 
	 /**
	  * this tells the system not to update the createdAt field once it's generated
	  */
	 @Column(updatable=false)
	 
	/**
	* formats the @createdAt date
	**/
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date createdAt;
	 
	/**
	 * generate the @createdAt date before the record is saved
	 **/
	 @PrePersist
	 protected void onCreate(){
	   	this.createdAt = new Date();
	 }
	 
	 
	/**
	 * format the @updatedAt date
	 **/
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date updatedAt;
	 
	 
	 /**
	  * @OneToOne Defines the 1:1 relationship with another entity
	  * options are:
	  *   1) mappedBy="person" > maps the license attribute in the Person
	  *     class to the person attribute in the License class. It represents 
	  *     the field that owns the relationship. This is only specified
	  *     on the inverse (non-owning) side of the association
	  *   2) cascade=CascadeType.ALL > the operations must be cascaded to the
	  *     target of the association, ensuring referential integrity is 
	  *     preserved in ALL actions
	  *   3) fetch=FetchType.LAZY > the association is fetched when needed
	  *   4) fetch=FetchType.EAGER > the association is fetched immediately
	  */
	 @OneToOne(mappedBy="person", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	 
	/**
	 * 
	 **/
	 private License license;
	 
	/**
	 *  no params constructor for a Person object - REQUIRED
	 **/
	 public Person() {}
	 
	/**
	 *  constructor for a Person object that takes a first and last name
	 **/
	 public Person(String first_name, String last_name) {
		 this.first_name = first_name;
		 this.last_name = last_name;
	 }

	 
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	
	/**
	 * set the @param to id to id passed in
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	
	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	
	
	/**
	 * set @param first_name to first_name passed in
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	
	
	/**
	 * set @param last_name to last_name passed in
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	
	/**
	 * @return the createdAt date
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	

	/**
	 * set the @param createdAt to the date passed in
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
	/**
	 * @return the updatedAt date
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	
	/**
	 * set the @param updatedAt to the date passed in
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	/**
	 * @return the license
	 */
	public License getLicense() {
		return license;
	}
	
	
	/**
	 * set the @param license to the license passed in 
	 */
	public void setLicense(License license) {
		this.license = license;
	}

}
