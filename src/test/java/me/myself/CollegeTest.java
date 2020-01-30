package me.myself;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollegeTest {
    private College college;
    private Student s;

    @BeforeEach
    public void setUp(){
       s = new Student();
       college = new College();
    }

    @Test
    public void calculateStudentCountTest(){
        college.addStudent(s);
        assertEquals(1, college.calculateStudentCount());
    }
}