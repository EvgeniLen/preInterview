package ru.lenivtsev.lesson5;

import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HiberUtil.getSessionFactory();

        StudentRepository userService = new StudentRepository(sessionFactory);

        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new Student("Ivan" + i, 4));
        }
        //SAVE ALL
        userService.saveAll(list);

        Student student1 = new Student("Bob", 2);
        //SAVE ONE STUDENT
        userService.save(student1);

        //FIND ALL
        System.out.println(userService.findAll());
        //FIND BY ID
        System.out.println(userService.find(400));

        //UPDATE
        Student student = userService.find(400).get();
        student.setName("Dima");
        student.setMark(3);
        userService.update(student);

        System.out.println(userService.find(400));

        //DELETE
        userService.delete(400);
        System.out.println(userService.find(400));

        //FIND BY NAME
        System.out.println(userService.findAllByName("Ivan101"));

        HiberUtil.sessionFactoryClose();
    }
}
