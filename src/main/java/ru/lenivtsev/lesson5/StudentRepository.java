package ru.lenivtsev.lesson5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.lenivtsev.lesson5.dao.StudentsDao;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

public class StudentRepository implements StudentsDao {
    private final Session session;

    public StudentRepository(SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }

    @Override
    public Optional<Student> find(Integer id){
        Student Student = null;
        try {
            Student = session.createQuery("FROM Student students where students.id = :id", Student.class).setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Students c id=" + id + " - не найден");
        }
        return Optional.ofNullable(Student);
    }

    @Override
    public void save(Student student) {
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
    }

    @Override
    public void update(Student student) {
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Integer id) {
        Student student = find(id).get();
        session.beginTransaction();
        session.delete(student);
        session.getTransaction().commit();
    }

    @Override
    public List<Student> findAll() {
        return session.createQuery("FROM Student s", Student.class).getResultList();
    }

    @Override
    public void saveAll(List<Student> list) {
        session.beginTransaction();
        for (Student student : list) {
            session.save(student);
        }
        session.getTransaction().commit();
    }

    @Override
    public List<Student> findAllByName(String name) {
        return session.createQuery("FROM Student s WHERE name = :name", Student.class).setParameter("name", name).getResultList();
    }
}
