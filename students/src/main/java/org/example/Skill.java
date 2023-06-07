package org.example;

import static org.example.Data.RANDOM;
import static org.example.Data.SKILL_CORE;
import static org.example.Data.SKILL_JD2;
import static org.example.Data.TIME_CORE;
import static org.example.Data.TIME_JD2;

public enum Skill {
    CORE(TIME_CORE, SKILL_CORE),
    JD2(TIME_JD2, SKILL_JD2);

    private final int hours;
    private final String name;

    Skill(int hours, String name) {
        this.hours = hours;
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public String getName() {
        return name;
    }

    public static Skill getRandomSkill() {
        return Skill.values()[RANDOM.nextInt(Skill.values().length)];
    }
}
