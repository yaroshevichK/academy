package org.example;

import java.util.Random;

public class Data {
    public static final Random RANDOM = new Random();
    public static final double MIN_TALENT=0.1;
    public static final double MAX_TALENT=1;
    public static final int CEIL=10;
    public static final int STUDENTS_FIRST_TYPE=3;
    public static final int STUDENTS_SECOND_TYPE=3;
    public static final int STUDENTS_THIRD_TYPE=3;
    public static final String SKILL_CORE="Core";
    public static final String SKILL_JD2="JD2";
    public static final int TIME_CORE=198;
    public static final int TIME_JD2=220;
    public static final int FIRST_PARTS=3;
    public static final int SECOND_PARTS=2;
    public static final int THIRD_PARTS=1;
    public static final int SPEED_FIRST=1;
    public static final int SPEED_SECOND=2;
    public static final int SPEED_THIRD=3;

    public static final String DATA_STUDENT="Студент %s типа: талант %.1f";
    public static final String FIRST_TYPE=" первого ";
    public static final String SECOND_TYPE=" второго ";
    public static final String THIRD_TYPE=" третьего ";
    public static final String FIRST_PART="Время на разбор: %.1f ;";
    public static final String SECOND_PART="Время на практику: %.1f ;";
    public static final String THIRD_PART="Время в потоке: %.1f \n";
    public static final String TOTAL_TIME="Общее время: %.1f \n";

}
