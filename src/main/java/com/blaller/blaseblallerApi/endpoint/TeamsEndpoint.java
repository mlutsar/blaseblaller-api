package com.blaller.blaseblallerApi.endpoint;

import com.blaller.blaseblallerApi.blaseApi.BlaseTeams;
import com.blaller.blaseblallerApi.blaseApi.BlaseOneTeam;
import com.blaller.blaseblallerApi.data.Team;
import com.blaller.blaseblallerApi.util.ConnectionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class TeamsEndpoint {

    private final static String BLASEBALL_SITE_URL = "https://www.blaseball.com";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<Team> getTeams() {
        String url = BLASEBALL_SITE_URL + "/database/allTeams";
        String payload = ConnectionUtil.getJson(url);

        try {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            List<BlaseOneTeam> blaseTeams = objectMapper.readValue(payload, new TypeReference<List<BlaseOneTeam>>(){});

            List<Team> allTeams = new ArrayList<>();
            for (BlaseOneTeam blaseTeam : blaseTeams) {
                Team team = new Team();
                team.setFullName(blaseTeam.getFullName());
                team.setMainColor(blaseTeam.getMainColor());
                team.setChampionships(blaseTeam.getChampionships());
                allTeams.add(team);
            }
            return allTeams;
        } catch (JsonProcessingException exception)  {
            exception.printStackTrace();
        }

        return null;
    }

    public static List<Team> getTeamNamesAndIds() {
        String url = BLASEBALL_SITE_URL + "/database/allTeams";
        String payload = ConnectionUtil.getJson(url);

        try {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            List<BlaseOneTeam> blaseTeams = objectMapper.readValue(payload, new TypeReference<List<BlaseOneTeam>>(){});

            List<Team> teamData = new ArrayList<>();
            for (BlaseOneTeam blaseOneTeam : blaseTeams) {
                Team team = new Team();
                team.setId(blaseOneTeam.getId());
                team.setFullName(blaseOneTeam.getFullName());
                team.setChampionships(blaseOneTeam.getChampionships());
                teamData.add(team);
            }
            return teamData;
        } catch (JsonProcessingException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
