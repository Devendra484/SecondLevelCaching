package com.hibernate.cahce.SecondLevelCahching;

import javax.persistence.*;
import org.hibernate.annotations.Cache;  
import org.hibernate.annotations.CacheConcurrencyStrategy;  

@Entity
@Table(name="Ipl")
@Cacheable  
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)  
public class Ipl {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private Integer trophies;
	private String capitan;
	private String allTimeBestPlayer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTrophies() {
		return trophies;
	}

	public void setTrophies(Integer trophies) {
		this.trophies = trophies;
	}

	public String getCapitan() {
		return capitan;
	}

	public void setCapitan(String capitan) {
		this.capitan = capitan;
	}

	public String getAllTimeBestPlayer() {
		return allTimeBestPlayer;
	}

	public void setAllTimeBestPlayer(String keyPlayer) {
		this.allTimeBestPlayer = keyPlayer;
	}

	@Override
	public String toString() {
		return "Ipl{" +
				"id=" + id +
				", name='" + name + '\'' +
				", trophies=" + trophies +
				", capitan='" + capitan + '\'' +
				", allTimeBestPlayer='" + allTimeBestPlayer + '\'' +
				'}';
	}
}
