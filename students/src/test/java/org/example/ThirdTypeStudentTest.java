package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.example.Data.CEIL;
import static org.example.Data.SPEED_THIRD;
import static org.example.Data.THIRD_PARTS;

@RunWith(Parameterized.class)
public class ThirdTypeStudentTest {
    private final Skill skill;
    private final double talent;
    private final double totalTime;

    public ThirdTypeStudentTest(Skill skill, double talent, double totalTime) {
        this.skill = skill;
        this.talent = talent;
        this.totalTime = totalTime;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Skill.CORE, 0.1, 1980},
                {Skill.CORE, 0.2, 990},
                {Skill.CORE, 0.3, 660},
                {Skill.CORE, 0.4, 495},
                {Skill.CORE, 0.5, 396},
                {Skill.CORE, 0.6, 330},
                {Skill.CORE, 0.7, 282},
                {Skill.CORE, 0.8, 247.5},
                {Skill.CORE, 0.9, 220},
                {Skill.CORE, 1.0, 198},
        });
    }

    @Test
    public void shouldGetTotalLearnTime() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        double actual = Math.floor(skill.getHours() / talent * SPEED_THIRD * CEIL) / CEIL;

        Class<ThirdTypeStudent> thirdTypeStudentClass = ThirdTypeStudent.class;
        Method getTotalLearnTime = thirdTypeStudentClass.getDeclaredMethod("getTotalLearnTime", double.class, Skill.class);
        getTotalLearnTime.setAccessible(true);
        double result = (double) getTotalLearnTime.invoke(new ThirdTypeStudent(), talent, skill);

        Assert.assertEquals(result, actual, 0.1);
    }

    @Test
    public void shouldGetLearnTime() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        double actual = Math.floor(totalTime / THIRD_PARTS * CEIL) / CEIL;

        Class<ThirdTypeStudent> thirdTypeStudentClass = ThirdTypeStudent.class;
        Method getTime = thirdTypeStudentClass.getDeclaredMethod("getTime", double.class);
        getTime.setAccessible(true);
        double result = (double) getTime.invoke(new ThirdTypeStudent(), totalTime);

        Assert.assertEquals(result, actual, 0.1);
    }
}




