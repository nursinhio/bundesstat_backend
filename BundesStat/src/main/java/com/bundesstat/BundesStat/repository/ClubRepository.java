package com.bundesstat.BundesStat.repository;

import com.bundesstat.BundesStat.domain.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {
}
