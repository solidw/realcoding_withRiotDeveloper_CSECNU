package org.cnu.realcoding.lolcrawler.lolcrawler.api;

import org.cnu.realcoding.lolcrawler.lolcrawler.domain.LeaguePositionSummonerName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenLeaguePositionSummonerNameApiClient {
    @Autowired
    private RestTemplate restTemplate;

    private String requestUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{paramName}?api_key={apiKey}";

    public LeaguePositionSummonerName getLeaguePositionByName(String summonerName) {
        return restTemplate.exchange(requestUrl,
                HttpMethod.GET,
                null,
                LeaguePositionSummonerName.class,
                summonerName,
                "RGAPI-cc5d4edd-28d3-4a8b-ae28-f4e8c4e24c27").getBody();
    }
}
