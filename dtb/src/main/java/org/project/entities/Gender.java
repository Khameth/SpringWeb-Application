package org.project.entities;

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
