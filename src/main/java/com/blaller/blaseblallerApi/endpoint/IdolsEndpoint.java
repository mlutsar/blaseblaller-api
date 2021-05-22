package com.blaller.blaseblallerApi.endpoint;

import com.blaller.blaseblallerApi.blaseApi.BlaseIdols;
import com.blaller.blaseblallerApi.data.Idols;
import com.blaller.blaseblallerApi.util.ConnectionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Endpoint for Idols.
 * 
 * @author mlutsar
 *
 */
public class IdolsEndpoint {
	
	private final static String BLASEBALL_SITE_URL = "https://www.blaseball.com";
	private static ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * Gets the contents of Idol Leaderboard from Blaseball site. Returns  
	 * @return Idols an Idols object, or null when there is an issue with 
	 * reading the URL or with mapping the URL contents.
	 */
	public static final Idols getIdols() {
		String url = BLASEBALL_SITE_URL + "/api/getIdols";
		String payload = ConnectionUtil.getJson(url);
		
		try {
			BlaseIdols blaseIdols = mapper.readValue(payload, BlaseIdols.class);
			if (blaseIdols.getIdols() != null) {
				Idols idols = new Idols();
				idols.setIdols(blaseIdols.getIdols());
				return idols;
			}
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
