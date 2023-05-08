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
@Table(name = "gender",schema = "public")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gender")
    private long id;
    @NotBlank(message = "Name may not be empty")
    private String name;
}




/*
public enum Gender {
    MAN("Man"),
    WOMAN("Woman"),
    TRANSGENDER_MAN("Transman"),
    TRANSGENDER_WOMAN("Transwoman"),
    NONBINARY("Non-binary"),
    INTERSEX("Intersex"),
    GENDERQUEER("Genderqueer"),
    GENDERFLUID("Genderfluid"),
    AGENDER("Agender"),
    OMNIGENDER("Omnigender"),
    OPTIMUS_PRIME("Optimus Prime"),
    MULTIGENDER("Multigender"),
    XENOGENDER("Xenogender"),
    XENOMORPH("Xenomorph"),
    PENGUIN("Penguin"),
    HELICOPTER("Helicopter"),
    ;

    private String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

 */
