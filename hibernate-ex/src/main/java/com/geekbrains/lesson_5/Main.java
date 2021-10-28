package com.geekbrains.lesson_5;


public class Main {

    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao(Student.class);
        for (int i = 0; i <100; i++){
            studentDao.save(new Student("igor_" + i, "biology_" + i));
        }
        Student student = studentDao.read(2L);
        student.setFirstName("ANDREY");
        studentDao.update(student);
        studentDao.delete(student);
        System.out.println(student);
        System.out.println(studentDao.findAll());
    }
}
