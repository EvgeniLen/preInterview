package ru.lenivtsev.lesson5.dao;

import ru.lenivtsev.lesson5.Student;

import java.util.List;

public interface StudentsDao extends CrudDao<Student>{

    List<Student> findAllByName(String name);
}
