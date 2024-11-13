package com.bundesstat.BundesStat.repository;

import com.bundesstat.BundesStat.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT p FROM Player p WHERE p.age BETWEEN :min AND :max")
    List<Player> findByAgeBetween(@Param("min") Integer min, @Param("max") Integer max);

    @Query("SELECT p FROM Player p WHERE p.goals BETWEEN :min AND :max")
    List<Player> findByGoalsBetween(@Param("min") int min, @Param("max") int max);

    @Query("SELECT p FROM Player p WHERE LOWER(p.position) = LOWER(:position)")
    List<Player> findByPositionIgnoreCase(@Param("position") String position);
}
