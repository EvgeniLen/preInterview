package ru.lenivtsev.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.lenivtsev.CreationFactory;
import ru.lenivtsev.model.User;

import java.util.List;


@Repository
public class UserRepository {

    private final CreationFactory creationFactory;

    @Autowired
    public UserRepository(CreationFactory creationFactory) {
        this.creationFactory = creationFactory;
    }

    public List<User> findAll() {
        return creationFactory.executeEntityManager(entityManager ->
            entityManager.createNamedQuery("findAllUsers", User.class).getResultList());
    }

    public User findUserByName(String name) {
        return creationFactory.executeEntityManager(entityManager ->
                entityManager.createNamedQuery("findUserByName", User.class).setParameter("name", name).getSingleResult());
    }

    public User findById(long id) {
        return creationFactory.executeEntityManager(entityManager ->
                entityManager.find(User.class, id));
    }

    public void saveOrUpdate(User user) {
        creationFactory.executeInTransaction(entityManager ->{
            if (user.getId()!=null){
                entityManager.persist(user);
            } else {
                entityManager.merge(user);
            }
        });
    }

    public void delete(long id) {
        creationFactory.executeInTransaction(entityManager ->
                entityManager.createNamedQuery("deleteUserById")
                        .setParameter("id", id)
                        .executeUpdate());
    }

}
