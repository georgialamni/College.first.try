package me.myself;

import lombok.Data;
import org.json.JSONArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Data
public class College {

    private List<Student> students;

    public College() {
        students = new ArrayList<>();
    }

    public void addStudent(Student s){
        students.add(s);
    }

    public int calculateStudentCount(){
        return students.size();
    }

    public double calculateStudentAvgMarks(){
        return students
                .stream()
                .mapToDouble(Student::getAverageMark)
                .sum() / calculateStudentCount();
    }

    public int printListToConsole(){
        return students.size();
    }

    public String getStudentsAsJson(){
        JSONArray jsArray = new JSONArray(students);
        return jsArray.toString();
    }

    public boolean saveJsonToFile(String filename)
    {
        try (PrintWriter pw = new PrintWriter(
                new File(filename))) {

            pw.println( getStudentsAsJson());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
