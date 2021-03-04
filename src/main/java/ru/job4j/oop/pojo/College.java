package ru.job4j.oop.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Ivanov Ivan Petrovich");
        student.setGroup("2A");
        student.setAdmission(new Date());
        System.out.println(student.getFullName() + " , "
                + student.getGroup() + " , "
                + student.getAdmission());
    }
}
