package me.myself;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //Course course = new Course();
        Module m1 = new Module("Programming"
                , new Course("SQL", "Athens", Cohort.SEPT_2019_JUN_2020)
                , "John Smith", ModuleType.MANDATORY);
        Module m2 = new Module("Programming"
                , new Course("JAVA", "Athens", Cohort.SEPT_2019_JUN_2020)
                , "Ema Jones", ModuleType.OPTIONAL);
        AchievedMark achievedMark = new AchievedMark(new Date(119, 0, 2), 2);
        MarkModule markModule1 = new MarkModule();
        markModule1.setModule(m1);
        markModule1.addMark(achievedMark);
        MarkModule markModule2 = new MarkModule();
        markModule1.setModule(m2);
        markModule1.addMark(achievedMark);
        Student s = new Student();
        Student s1 = new Student();
        s.addMarkModule(markModule1);
        s.addMarkModule(markModule2);
        s.setId(2);
        s1.setId(3);
        s1.addMarkModule(markModule1);
        s1.addMarkModule(markModule2);
        College c = new College();
        c.addStudent(s);
        c.addStudent(s1);
        System.out.println(c.calculateStudentAvgMarks());
    }
}
