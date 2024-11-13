package com.bundesstat.BundesStat.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;



@Entity
@Table(name ="club")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @OneToMany(mappedBy = "club", cascade= CascadeType.ALL)
    private List<Player> players;
}
