package me.myself;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MarkModule {

    private Module module;
    private List<AchievedMark> achievedMarks;

    public MarkModule() {
        achievedMarks = new ArrayList<>();
    }

    public void addMark(AchievedMark achievedMark){
        achievedMarks.add(achievedMark);
    }

    public boolean hasPassed(){
        return achievedMarks
                .stream()
                .mapToInt(AchievedMark::getMark)
                .max()
                .getAsInt() > 5;
    }

    public int getMark(){
        return (int)achievedMarks
                .stream()
                .filter(p -> p.getMark() > 5)
                .mapToDouble(AchievedMark::getMark)
                .max()
                .getAsDouble();
    }
}
