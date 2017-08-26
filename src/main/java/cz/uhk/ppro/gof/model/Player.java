package cz.uhk.ppro.gof.model;

import java.sql.Timestamp;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * tabulka player s frakcemi a scany 
 */
@Entity
@Table(name="player", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class Player{
	
	@Id
	@Column(name="ID_player", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "username", unique = true, nullable = false, length = 50)
	private String username;
	
	@Column(name = "password", nullable = false, length = 50)
	private String password;
	
	@Column(name="userId",length = 50)
	private String userId;	

	@Column(name="nickname",length = 30)
	private String nickname;
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_fraction", nullable = false)
	private Fraction fraction;

	@Column(name="changeFractionWhen", nullable = false)
	private Timestamp changeFractionWhen;
	
	@Column(name="score", nullable = false, length = 10)
	private int score;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "role_player", joinColumns = {
		@JoinColumn(name = "ID_player", nullable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "ID_role", nullable = false) })
	private Role role;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "player")
	private Set<Scan> scans = new HashSet<Scan>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "player")
	private Set<Flag> flags = new HashSet<Flag>(0);
	
	public Player() {
	}

	public Player(String username, String password, String userId, String nickname, Fraction fraction,
			Timestamp changeFractionWhen, int score, Role role) {
		this.username = username;
		this.password = password;
		this.userId = userId;
		this.nickname = nickname;
		this.fraction = fraction;
		this.changeFractionWhen = changeFractionWhen;
		this.score = score;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Fraction getFraction() {
		return fraction;
	}

	public void setFraction(Fraction fraction) {
		this.fraction = fraction;
	}

	public Timestamp getChangeFractionWhen() {
		return changeFractionWhen;
	}

	public void setChangeFractionWhen(Timestamp changeFractionWhen) {
		this.changeFractionWhen = changeFractionWhen;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Player(String username, String password, String userId, String nickname, Fraction fraction,
			Timestamp changeFractionWhen, int score, Role role, Set<Scan> scans, Set<Flag> flags) {
		this.username = username;
		this.password = password;
		this.userId = userId;
		this.nickname = nickname;
		this.fraction = fraction;
		this.changeFractionWhen = changeFractionWhen;
		this.score = score;
		this.role = role;
		this.scans = scans;
		this.flags = flags;
	}

	public Set<Scan> getScans() {
		return scans;
	}

	public void setScans(Set<Scan> scans) {
		this.scans = scans;
	}

	public Set<Flag> getFlags() {
		return flags;
	}

	public void setFlags(Set<Flag> flags) {
		this.flags = flags;
	}

}