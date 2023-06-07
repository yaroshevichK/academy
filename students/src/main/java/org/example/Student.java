package org.example;

import static org.example.Data.CEIL;
import static org.example.Data.MAX_TALENT;
import static org.example.Data.MIN_TALENT;
import static org.example.Data.RANDOM;

public class Student {
    private final ITypeStudent typeStudent;
    private final double talent;

    public Student(ITypeStudent typeStudent, double talent) {
        this.typeStudent = typeStudent;
        this.talent = talent;
    }

    public ITypeStudent getTypeStudent() {
        return typeStudent;
    }

    public double getTalent() {
        return talent;
    }

    public static double getRandomTalent() {
        double result = RANDOM.nextDouble() * CEIL * (MAX_TALENT - MIN_TALENT) + MIN_TALENT + 1;
        return Math.floor(result) / CEIL;
    }
}
