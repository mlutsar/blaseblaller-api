package com.blaller.blaseblallerApi.endpoint;

import com.blaller.blaseblallerApi.blaseApi.BlaseOneDivision;
import com.blaller.blaseblallerApi.blaseApi.BlaseOneTeam;
import com.blaller.blaseblallerApi.data.Division;
import com.blaller.blaseblallerApi.data.Team;
import com.blaller.blaseblallerApi.util.ConnectionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivisionsEndpoint {

    private final static String BLASEBALL_SITE_URL = "https://www.blaseball.com";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<Division> getDivisions() {
        String url = BLASEBALL_SITE_URL + "/database/allDivisions";
        String payload = ConnectionUtil.getJson(url);

        try {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            List<BlaseOneDivision> blaseDivisions = objectMapper.readValue(payload,
                    new TypeReference<List<BlaseOneDivision>>(){});

            List<Division> allDivisions = new ArrayList<>();
            for (BlaseOneDivision blaseDivision : blaseDivisions) {
                Division division = new Division();
                division.setId(blaseDivision.getId());
                division.setName(blaseDivision.getName());
                division.setTeams(teamArrayToList(blaseDivision.getTeams()));
                allDivisions.add(division);
            }
            return allDivisions;
        } catch (JsonProcessingException exception)  {
            exception.printStackTrace();
        }

        return null;
    }

    public static List<String> teamArrayToList(String[] teamArray) {
        return new ArrayList<>(Arrays.asList(teamArray));
    }

}
