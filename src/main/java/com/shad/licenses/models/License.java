/**
 * @author Matthew Werner
 *
 */

package com.shad.licenses.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="licenses")
public class License {
 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String number;
	 @NotNull
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date expirationDate;
	 @NotNull
	 private String state;
	 
	 /**
	  * this tells the system not to update the createdAt field once it's generated
	  */
	 @Column(updatable=false)
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date createdAt;
	 
	/**
	 * generate the @createdAt date before the record is saved
	 **/
	 @PrePersist
	 protected void onCreate(){
	   	this.createdAt = new Date();
	 }
	    
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
	  *   
	  *   ...
	  */
	 
	 @OneToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="person_id")   
	 private Person person;
	 
	 /**
	  * no params constructor (required)
	  */
	 public License() {	}
	 
	 
//	 public License(int number, Date expirationDate, String state) {
//		 this.number = number;
//		 this.expirationDate = expirationDate;
//		 this.state = state;
//	 }

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the expirationDate
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
	 
}
