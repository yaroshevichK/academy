package org.example;

import java.util.HashMap;

import static org.example.Data.STUDENTS_FIRST_TYPE;
import static org.example.Data.STUDENTS_SECOND_TYPE;
import static org.example.Data.STUDENTS_THIRD_TYPE;

public class App {
    public static void main(String[] args) {
        HashMap<Student, Skill> students = fillList();

        students.forEach((key, value) ->
                key.getTypeStudent().getLearnTime(
                        key.getTalent(), value));
    }

    public static HashMap<Student, Skill> fillList() {
        HashMap<Student, Skill> students = new HashMap<>();
        ITypeStudent firstTypeStudent = new FirstTypeStudent();
        for (int i = 0; i < STUDENTS_FIRST_TYPE; i++) {
            double talent = Student.getRandomTalent();
            students.put(new Student(firstTypeStudent, talent), Skill.getRandomSkill());
        }

        ITypeStudent secondTypeStudent = new SecondTypeStudent();
        for (int i = 0; i < STUDENTS_SECOND_TYPE; i++) {
            double talent = Student.getRandomTalent();
            students.put(new Student(secondTypeStudent, talent), Skill.getRandomSkill());
        }

        ITypeStudent thirdTypeStudent = new ThirdTypeStudent();
        for (int i = 0; i < STUDENTS_THIRD_TYPE; i++) {
            double talent = Student.getRandomTalent();
            students.put(new Student(thirdTypeStudent, talent), Skill.getRandomSkill());
        }
        return students;
    }
}
