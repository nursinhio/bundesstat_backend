package com.bundesstat.BundesStat.serivces.impl;

import com.bundesstat.BundesStat.domain.Club;
import com.bundesstat.BundesStat.domain.Player;
import com.bundesstat.BundesStat.repository.ClubRepository;
import com.bundesstat.BundesStat.serivces.ClubService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClubServiceImpl implements ClubService {

    private final ClubRepository repository;

    @Override
    public Club addClub(Club club) {
        return repository.save(club);
    }

    @Override
    public Optional<Club> getClubById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Club> findAll() {
        return repository.findAll().stream().toList();
    }


}
