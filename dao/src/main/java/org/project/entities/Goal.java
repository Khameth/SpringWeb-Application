package org.project.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "goal", schema = "public")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_goal")
    private long id;
    @NotBlank(message = "Name may not be empty")
    private String name;
    @NotBlank(message = "Description may not be empty")
    private String description;
    @OneToOne
    @JoinColumn(name = "id_timeperiod")
    private TimePeriod goalTimePeriod;

}
