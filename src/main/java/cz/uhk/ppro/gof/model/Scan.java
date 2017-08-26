package cz.uhk.ppro.gof.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * tabulka scan 
 */
@Entity
@Table(name="scan")
public class Scan{
	
	@Id
	@Column(name="ID_scan", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_player", nullable = false)
	Player player;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_fraction", nullable = false)
	Fraction fraction;	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_flag", nullable = false)
	Flag flag;
	
	@Column(name="fingerprint", nullable = false)
	String fingerprint;	
	
	@Column(name="scanWhen", nullable = false)
	Timestamp scanWhen;
		
	public Scan() {
	}

	public Scan(Player player, Fraction fraction, Flag flag, String fingerprint, Timestamp scanWhen) {
		this.player = player;
		this.fraction = fraction;
		this.flag = flag;
		this.fingerprint = fingerprint;
		this.scanWhen = scanWhen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Fraction getFraction() {
		return fraction;
	}

	public void setFraction(Fraction fraction) {
		this.fraction = fraction;
	}

	public Flag getFlag() {
		return flag;
	}

	public void setFlag(Flag flag) {
		this.flag = flag;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	public Timestamp getScanWhen() {
		return scanWhen;
	}

	public void setScanWhen(Timestamp scanWhen) {
		this.scanWhen = scanWhen;
	}

	
}