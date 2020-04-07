package com.Ajay.flightReservation.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="role")
public class Role extends SuperClass implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Column(name="NAME")
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private Set<Users> users;

	public Set<Users> getUsers() {
		return users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}

	@Override
	public String getAuthority() {
		return name;
	}
}
