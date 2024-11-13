package com.bundesstat.BundesStat.controllers;

import com.bundesstat.BundesStat.domain.Club;
import com.bundesstat.BundesStat.serivces.ClubService;
import com.bundesstat.BundesStat.serivces.impl.ClubServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@RestController
@RequestMapping("api/club")
public class ClubController {
    private final ClubServiceImpl clubService;

    @GetMapping(path="/getClubById/{id}")
    public ResponseEntity<Optional<Club>> getClubById(@PathVariable("id")Long id){
        return new ResponseEntity<>(clubService.getClubById(id), HttpStatus.FOUND);
    }

    @PostMapping(path="/addClubs")
    public ResponseEntity<List<Club>> addClubsList(@RequestBody List<Club> clubs){
        clubs.forEach(clubService::addClub);
        return new ResponseEntity<>(clubs, HttpStatus.CREATED);
    }

    @GetMapping(path = "/clubs")
    public ResponseEntity<List<Club>> getAllClubs(){
        return new ResponseEntity<>(clubService.findAll(), HttpStatus.FOUND);
    }
}
