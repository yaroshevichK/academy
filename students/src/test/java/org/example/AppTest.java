package org.example;

import org.junit.Test;

import java.util.HashMap;

import static org.example.Data.STUDENTS_FIRST_TYPE;
import static org.example.Data.STUDENTS_SECOND_TYPE;
import static org.example.Data.STUDENTS_THIRD_TYPE;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void shouldFillList() {
        HashMap<Student, Skill> listStudents = App.fillList();
        assertEquals((STUDENTS_FIRST_TYPE + STUDENTS_SECOND_TYPE + STUDENTS_THIRD_TYPE), listStudents.size());
    }
}
