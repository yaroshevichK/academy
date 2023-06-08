package org.example;

import static org.example.Data.CEIL;
import static org.example.Data.DATA_STUDENT;
import static org.example.Data.FIRST_PART;
import static org.example.Data.SECOND_PART;
import static org.example.Data.SPEED_THIRD;
import static org.example.Data.THIRD_PART;
import static org.example.Data.THIRD_PARTS;
import static org.example.Data.THIRD_TYPE;
import static org.example.Data.TOTAL_TIME;

public class ThirdTypeStudent implements ITypeStudent {
    @Override
    public void getLearnTime(double talent, Skill skill) {
        double totalLearnTime = getTotalLearnTime(talent, skill);
        double learnTime = getTime(totalLearnTime);

        System.out.println(skill.getName() + "( " + skill.getHours() + " )");
        System.out.printf(DATA_STUDENT, THIRD_TYPE, talent);
        System.out.println();
        System.out.printf(FIRST_PART, learnTime);
        System.out.printf(SECOND_PART, 0f);
        System.out.printf(THIRD_PART, 0f);
        System.out.printf(TOTAL_TIME, totalLearnTime);
    }

    private double getTime(double totalLearnTime) {
        return Math.floor(totalLearnTime / THIRD_PARTS * CEIL) / CEIL;
    }

    private double getTotalLearnTime(double talent, Skill skill) {
        return Math.floor(skill.getHours() / talent * SPEED_THIRD * CEIL) / CEIL;
    }
}
