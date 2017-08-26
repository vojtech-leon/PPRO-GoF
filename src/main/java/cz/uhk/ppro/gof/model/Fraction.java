package cz.uhk.ppro.gof.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/*
 * tabulka fraction + hraci a vlajky dane frakce
 */
@Entity
@Table(name="fraction", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Fraction{
	
	@Id
	@Column(name="ID_fraction", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name", unique = true, nullable = false, length = 50)
	private String name;
	
	@Column(name="description", length = 500)
	private String description;	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fraction")
	private Set<Player> players = new HashSet<Player>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fraction")
	private Set<Flag> flags = new HashSet<Flag>(0);
	
	public Fraction() {
	}

	public Fraction(String name, String description) {
		this.name = name;
		this.description = description;
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

	public Fraction(String name, String description, Set<Player> players, Set<Flag> flags) {
		this.name = name;
		this.description = description;
		this.players = players;
		this.flags = flags;
	}

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

	public Set<Flag> getFlags() {
		return flags;
	}

	public void setFlags(Set<Flag> flags) {
		this.flags = flags;
	}

	
	
	
}