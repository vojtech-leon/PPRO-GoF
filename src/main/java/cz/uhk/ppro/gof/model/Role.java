package cz.uhk.ppro.gof.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/*
 * tabulka role + vypis vsech playeru dane role 
 */
@Entity
@Table(name="role", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Role{
	
	@Id
	@Column(name="ID_role", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name", unique = true, nullable = false, length = 50)
	private String name;
	
	@Column(name="description", length = 500)
	private String description;	

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "role_player", joinColumns = {
		@JoinColumn(name = "ID_role", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "ID_player", nullable = false, updatable = false) })
	private Set<Player> players = new HashSet<Player>(0);
	
	public Role() {
	}

	public Role(String name, String description, Set<Player> players) {
		this.name = name;
		this.description = description;
		this.players = players;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

}