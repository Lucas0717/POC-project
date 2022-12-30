package com.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name = "user")
@JsonDeserialize(builder = User.Builder.class)
public class User implements Serializable {
	
	@Id
	private Long id;
	
	@Column(nullable = false, name ="password")
	private String password;
	
	@Column(nullable = false, name ="email")
	private String email;
	
	@Column(nullable = false, name ="first_name")
	private String firstName;
	
	@Column(nullable = false, name ="last_name")
	private String lastName;
	
	
	public User() {}


	public User(Builder builder) {
		super();
		this.id = builder.id;
		this.password = builder.password;
		this.email = builder.email;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public static class Builder {
		@JsonProperty("id")
		private Long id;
		
		@JsonProperty("password")
		private String password;
		
		@JsonProperty("email")
		private String email;
		
		@JsonProperty("first_name")
		private String firstName;
		
		@JsonProperty("last_name")
		private String lastName;
		
		public Builder setId(Long id) {
			this.id = id;
			return this;
		}
		
		public Builder setPassword(String password) {
			this.password = password;
			return this;
		}
		
		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}
		
		public Builder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		public Builder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public User build() {
            return new User(this);
        }
		
	}
	
	
}
