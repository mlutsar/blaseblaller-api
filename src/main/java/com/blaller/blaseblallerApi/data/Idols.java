package com.blaller.blaseblallerApi.data;

import java.util.List;

/**
 * Idol Leaderboard contents from the Blaseball site. Contains a list of player UUIDs 
 * in Idol Leaderboard order.
 * @author mlutsar
 *
 */
public class Idols {
	private List<String> idols;

	public List<String> getIdols() {
		return idols;
	}

	public void setIdols(List<String> idols) {
		this.idols = idols;
	}	
}
