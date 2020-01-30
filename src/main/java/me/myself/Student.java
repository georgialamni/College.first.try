package me.myself;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Student {

    private Course course;
    private List<MarkModule> markModules;
    private int id;
    private List<Module> enrolledModules;
    private final int MIN_PASS_PASS = 5;

    public Student(){
        markModules = new ArrayList<>();
        enrolledModules = new ArrayList<>();
    }

    public void addMarkModule(MarkModule m){
        markModules.add(m);
    }

    public void addEnrollModule(Module enrollm){
        enrolledModules.add(enrollm);
    }

    public double getAverageMark(){
        return markModules
                .stream()
                .mapToDouble(MarkModule :: getMark )
                .average()
                .getAsDouble();
    }

    public boolean checkIfAllModulesPassed(){
        return markModules
                .stream()
                .map(MarkModule::hasPassed)
                .allMatch(p -> p == true);
    }
}
