package org.project.entities;

import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "station", schema = "public")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_station")
    private long id;
    @NotBlank(message = "Name may not be empty")
    private String name;
    private String description;
    @ManyToMany
    @JoinTable(
            name = "station_worker",
            joinColumns = {@JoinColumn(name = "id_station")},
            inverseJoinColumns = {@JoinColumn(name = "id_worker")}
    )
    private List<Worker> workers;
    @ManyToOne
    @JoinColumn(name = "id_goal")
    private Goal goal;
}
