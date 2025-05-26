package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Aleksandr Bilichenko");
        student.setGroup("Programmer");
        student.setCreated(new Date());

        System.out.println(student.getFullName() + " has a group - " + student.getGroup() + " : " + student.getCreated());
    }
}
