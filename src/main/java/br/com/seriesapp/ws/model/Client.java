package br.com.seriesapp.ws.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String email;
	private String password;
	private List<Serie> profile;
	private List<Serie> watchlist;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Serie> getProfile() {
		return profile;
	}

	public void setProfile(List<Serie> profile) {
		this.profile = profile;
	}

	public List<Serie> getWatchlist() {
		return watchlist;
	}

	public void setWatchlist(List<Serie> watchlist) {
		this.watchlist = watchlist;
	}
	
	public void addSerieToProfile(Serie serie) {
		if (this.profile == null) this.profile = new ArrayList<>();
		
		int index = this.profile.indexOf(serie);
		if (index == -1)
			this.profile.add(serie);
		else
			this.profile.set(index, serie);	//update
	}
	
	public void addSerieToWatchlist(Serie serie) {
		if (this.watchlist == null) this.watchlist = new ArrayList<>();
		
		if (!this.profile.contains(serie))
			this.watchlist.add(serie);
	}
	
	public void removeProfileSerie(String idSerie) {
		for (Serie serie : this.profile) {
			if (serie.getImdbID().equals(idSerie))
				this.profile.remove(serie);
		}
	}
	
	public void removeWatchlistSerie(String idSerie) {
		for (Serie serie : this.watchlist) {
			if (serie.getImdbID().equals(idSerie))
				this.watchlist.remove(serie);
		}
	}
}
