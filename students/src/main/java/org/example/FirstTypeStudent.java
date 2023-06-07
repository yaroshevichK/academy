package org.example;

import static org.example.Data.CEIL;
import static org.example.Data.DATA_STUDENT;
import static org.example.Data.FIRST_PART;
import static org.example.Data.FIRST_PARTS;
import static org.example.Data.FIRST_TYPE;
import static org.example.Data.SECOND_PART;
import static org.example.Data.SPEED_FIRST;
import static org.example.Data.THIRD_PART;
import static org.example.Data.TOTAL_TIME;

public class FirstTypeStudent implements ITypeStudent {

    @Override
    public void getLearnTime(Double talent, Skill skill) {
        double totalLearnTime = Math.floor(skill.getHours() / talent * SPEED_FIRST * CEIL) / CEIL;
        double learnTime = Math.floor(totalLearnTime / FIRST_PARTS * CEIL) / CEIL;

        System.out.println(skill.getName() + "( " + skill.getHours() + " )");
        System.out.printf(DATA_STUDENT, FIRST_TYPE, talent);
        System.out.println();
        System.out.printf(FIRST_PART, learnTime);
        System.out.printf(SECOND_PART, learnTime);
        System.out.printf(THIRD_PART, learnTime);
        System.out.printf(TOTAL_TIME, totalLearnTime);
    }
}
