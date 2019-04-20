package org.cnu.realcoding.lolcrawler.lolcrawler.controller;

import org.cnu.realcoding.lolcrawler.lolcrawler.api.OpenLeaguePositionEncryptedIDApiClient;
import org.cnu.realcoding.lolcrawler.lolcrawler.api.OpenLeaguePositionSummonerNameApiClient;
import org.cnu.realcoding.lolcrawler.lolcrawler.domain.LeaguePositionEncryptedID;
import org.cnu.realcoding.lolcrawler.lolcrawler.domain.LeaguePositionSummonerName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiotController {
    @Autowired
    private OpenLeaguePositionSummonerNameApiClient openLeaguePositionSummonerNameApiClient;
    private LeaguePositionSummonerName leaguePositionSummonerName;

    @Autowired
    private OpenLeaguePositionEncryptedIDApiClient openLeaguePositionEncryptedIDApiClient;
    private LeaguePositionEncryptedID leaguePositionEncryptedID;

    @RequestMapping("/")
    public String index() {
        return "Go to localhost:8080/index.html";
    }

    @RequestMapping("/Summoner/{name}")
    public LeaguePositionSummonerName index(@PathVariable String name) {
        leaguePositionSummonerName = openLeaguePositionSummonerNameApiClient.getLeaguePositionByName(name);
        return leaguePositionSummonerName;
    }

    @RequestMapping("/ID/{ID}")
    public LeaguePositionEncryptedID indexFromID(@PathVariable String ID) {
        leaguePositionEncryptedID = openLeaguePositionEncryptedIDApiClient.getLeaguePositionEncryptedID(ID);

        return leaguePositionEncryptedID;
    }
}