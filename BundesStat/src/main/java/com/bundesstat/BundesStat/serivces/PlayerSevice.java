package com.bundesstat.BundesStat.serivces;

import com.bundesstat.BundesStat.domain.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerSevice {
    Player save(Player player);
    Optional<Player> findById(Long id);
    void deleteById(Long id);
    List<Player> getAllPlayer();
    List<Player> getPlayersByNation(String nation);
}
