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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * tabulka flag + scany dane vlajky
 */
@Entity
@Table(name="flag", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Flag{
	
	@Id
	@Column(name="ID_flag", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_fraction", nullable = false)
	Fraction fraction;	
	
	@Column(name="name", unique = true, nullable = false, length = 50)
	String name;	
	
	@Column(name="flagWhen", nullable = false)
	Timestamp flagWhen;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_player", nullable = false)
	Player player;
	
	@Column(name="floor", nullable = false, length = 20)
	String floor;
	
	@Column(name="x", nullable = false, length = 11)
	int x;
	
	@Column(name="y", nullable = false, length = 11)
	int y;
	
	@Column(name="description", nullable = false, length = 100)
	String description;
	
	@Column(name="qrCode", nullable = false, length = 100)
	String qrCode;
	
	@Column(name="taken", nullable = false, length = 11)
	int taken;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flag")
	private Set<Scan> scans = new HashSet<Scan>(0);
	
	public Flag() {
	}

	public Flag(Fraction fraction, String name, Timestamp flagWhen, Player player, String floor, int x, int y,
			String description, String qrCode, int taken) {
		this.fraction = fraction;
		this.name = name;
		this.flagWhen = flagWhen;
		this.player = player;
		this.floor = floor;
		this.x = x;
		this.y = y;
		this.description = description;
		this.qrCode = qrCode;
		this.taken = taken;
	}

	public Flag(Fraction fraction, String name, Timestamp flagWhen, Player player, String floor, int x, int y,
			String description, String qrCode, int taken, Set<Scan> scans) {
		this.fraction = fraction;
		this.name = name;
		this.flagWhen = flagWhen;
		this.player = player;
		this.floor = floor;
		this.x = x;
		this.y = y;
		this.description = description;
		this.qrCode = qrCode;
		this.taken = taken;
		this.scans = scans;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Fraction getFraction() {
		return fraction;
	}

	public void setFraction(Fraction fraction) {
		this.fraction = fraction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getFlagWhen() {
		return flagWhen;
	}

	public void setFlagWhen(Timestamp flagWhen) {
		this.flagWhen = flagWhen;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public int getTaken() {
		return taken;
	}

	public void setTaken(int taken) {
		this.taken = taken;
	}

	public Set<Scan> getScans() {
		return scans;
	}

	public void setScans(Set<Scan> scans) {
		this.scans = scans;
	}

	
	
}