package com.bundesstat.BundesStat.serivces;

import com.bundesstat.BundesStat.domain.Club;

import java.util.List;
import java.util.Optional;

public interface ClubService {
    Club addClub(Club club);
    Optional<Club> getClubById(Long id);

    List<Club> findAll();
}
