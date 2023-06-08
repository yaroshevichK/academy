package org.example;

import org.junit.Assert;
import org.junit.Test;

import static org.example.Data.MAX_TALENT;
import static org.example.Data.MIN_TALENT;

public class StudentTest {
    public static final int COUNT_ITERATION = 30;
    public static final String MESSAGE = "Talent should be between %.1f and %.1f : ";

    @Test
    public void ShouldGenerateTalent() {
        for (int i = 0; i < COUNT_ITERATION; i++) {
            double talent = Student.getRandomTalent();
            Assert.assertTrue(String.format(MESSAGE, MIN_TALENT, MAX_TALENT) + talent,
                    (talent >= Data.MIN_TALENT && talent <= MAX_TALENT));
        }
    }
}