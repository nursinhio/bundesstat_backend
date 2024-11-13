package com.bundesstat.BundesStat.controllers;

import com.bundesstat.BundesStat.domain.Player;
import com.bundesstat.BundesStat.serivces.impl.ClubServiceImpl;
import com.bundesstat.BundesStat.serivces.impl.PlayerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController
@AllArgsConstructor
@RequestMapping("api/player")
public class PlayerController {

    @Autowired
    PlayerServiceImpl playerService;
    @Autowired
    ClubServiceImpl clubService;


    @PostMapping(path = "/addPlayer")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player savedPlayer = playerService.save(player);
        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
    }

    @PostMapping(path = "/addPlayersToClub")
    public ResponseEntity<List<Player>> addPlayerToExistingClub(@RequestParam Long clubId,@RequestBody List<Player> players){
        players.forEach(player -> playerService.addPlayerToClub(clubId, player));
        return new ResponseEntity<>(players, HttpStatus.CREATED);
    }

    @GetMapping(path = "/players")
    public List<Player> getAllPlayers(){
        return playerService.getAllPlayer();
    }

    @GetMapping(path="/players/{id}")
    public ResponseEntity<Optional<Player>> getPlayerById(@PathVariable("id")Long id){
        Optional<Player> found = playerService.findById(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping(path = "/players/nationality/{nation}")
    public List<Player> getPlayerByNation(@PathVariable("nation") String nation) {
        return playerService.getPlayersByNation(nation);
    }

    @DeleteMapping(path="/players/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id")Long id){
        playerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/getPlayerByClub/{clubId}")
    public List<Player> getPlayersByClubId(@PathVariable("clubId") Long clubId) {
        return playerService.getPlayersByClubId(clubId);
    }

    @GetMapping(path="/getPlayersByAmountOfGoals")
    public List<Player> getPlayersByAmountOfGoals(@RequestParam int min, @RequestParam int max){
        return playerService.getPlayersByAmountOfGoals(min, max);
    }

    @GetMapping(path="/getPlayersByPosition/{position}")
    public List<Player> getPlayersByPosition(@PathVariable("position")String position){
        return playerService.getPlayersByPosition(position);
    }

    @GetMapping(path="/getPlayersByAge")
    public List<Player> getPlayersByAmountOfAge(@RequestParam Integer min, @RequestParam Integer max){
        return playerService.getPlayersByAmountOfAge(min, max);
    }

}
