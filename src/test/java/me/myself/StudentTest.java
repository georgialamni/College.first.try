package me.myself;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private College college;
    private Student s;
    private Course course;
    private MarkModule m;
    private MarkModule m2;
    private AchievedMark achievedMark;
    private AchievedMark achievedMark2;


    @BeforeEach
    public void setUp(){
        s = new Student();
        college = new College();
        course = new  Course();
        m = new MarkModule();
        achievedMark = new AchievedMark(new Date(), 6);
        achievedMark2 = new AchievedMark(new Date(), 24);
        m2 = new MarkModule();
    }

    @Test
    public void getAverageMarkTest(){
        m.addMark(achievedMark);
        m.addMark(achievedMark);
        m2.addMark(achievedMark2);
        s.addMarkModule(m);
        s.addMarkModule(m2);
        double average = s.getAverageMark();
        assertEquals(15.0, average);
    }

}