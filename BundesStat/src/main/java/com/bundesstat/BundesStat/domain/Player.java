package com.bundesstat.BundesStat.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="player_stats")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String nationality;

    private float price;

    private String position;

    @ManyToOne
    @JoinColumn(name="club_id")
    @JsonIgnore
    private Club club;

    private int goals;

    private int assists;
}
