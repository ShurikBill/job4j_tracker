package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double resultScore = 0;
        int resultSubject = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                resultScore += subject.score();
                resultSubject ++;
            }
        }
        return resultSubject == 0 ? 0D : resultScore / resultSubject;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double resultScore = 0;
            for (Subject subject : pupil.subjects()) {
                resultScore += subject.score();
            }
            double avarage = pupil.subjects().isEmpty() ? 0D : resultScore / pupil.subjects().size();
            labels.add(new Label(pupil.name(), avarage));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String subjectName = subject.name();
                Integer subjectScore = subject.score();
                subjectScores.put(subjectName,subjectScores.getOrDefault(subjectName, 0) + subjectScore);
            }
        }
        List<Label> labels = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : subjectScores.entrySet()) {
            String subjectName = entry.getKey();
            int resultScore = entry.getValue();
            double average = (double) resultScore / pupils.size();
            labels.add(new Label(subjectName, average));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double resultScore = 0;
            for (Subject subject : pupil.subjects()) {
                resultScore += subject.score();
            }
            labels.add(new Label(pupil.name(), resultScore));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String subjectName = subject.name();
                Integer subjectScore = subject.score();
                subjectScores.put(subjectName,subjectScores.getOrDefault(subjectName, 0) + subjectScore);
            }
        }
        List<Label> labels = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : subjectScores.entrySet()) {
            labels.add(new Label(entry.getKey(), (double) entry.getValue()));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}