package com.bundesstat.BundesStat.serivces.impl;


import com.bundesstat.BundesStat.domain.Club;
import com.bundesstat.BundesStat.domain.Player;
import com.bundesstat.BundesStat.repository.ClubRepository;
import com.bundesstat.BundesStat.repository.PlayerRepository;
import com.bundesstat.BundesStat.serivces.PlayerSevice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerSevice {
    private final PlayerRepository repository;
    private final ClubRepository clubRepository;

    @Override
    public Player save(Player player) {
        return repository.save(player);
    }

    @Override
    public Optional<Player> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Player> getAllPlayer() {
        return repository.findAll().stream().toList();
    }

    @Override
    public List<Player> getPlayersByNation(String nation) {
        return repository.findAll().stream()
                .filter(player -> player.getNationality().equalsIgnoreCase(nation))
                .collect(Collectors.toList());
    }

    public Player addPlayerToClub(Long clubId, Player player) {
        Club club = clubRepository.findById(clubId).orElseThrow(() -> new RuntimeException("Club not found"));
        player.setClub(club);
        repository.save(player);
        return player;
    }

    public List<Player> getPlayersByClubId(Long clubId) {
        return repository.findAll().stream().filter(player -> Objects.equals(player.getClub().getId(), clubId)).toList();
    }

    public List<Player> getPlayersByAmountOfGoals(int min, int max) {
       return repository.findByGoalsBetween(min, max);
    }

    public List<Player> getPlayersByPosition(String position) {
        return repository.findByPositionIgnoreCase(position);
    }

    public List<Player> getPlayersByAmountOfAge(Integer min, Integer max) {
        return repository.findByAgeBetween(min, max);
    }
}
