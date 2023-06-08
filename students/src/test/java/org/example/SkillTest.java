package org.example;

import org.junit.Assert;
import org.junit.Test;

import static org.example.Data.RANDOM;
import static org.junit.Assert.*;

public class SkillTest {
    public static final int COUNT_ITERATION = 30;
    public static final String INDEX_BOUND_OF_ARRAY = "Index bound of array: ";

    @Test
    public void shouldGenerateIndexOfSkill() {
        for (int i = 0; i < COUNT_ITERATION; i++) {
            int index = RANDOM.nextInt(Skill.values().length);
            Assert.assertTrue(INDEX_BOUND_OF_ARRAY + index, (index < Skill.values().length));
        }
    }
}