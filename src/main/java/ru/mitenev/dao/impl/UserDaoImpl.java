package ru.mitenev.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mitenev.dao.UserDao;
import ru.mitenev.domain.User;

import javax.annotation.Resource;
import java.util.List;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao{
//    private Log log =

    private SessionFactory sessionFactory;


    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return getSessionFactory().getCurrentSession().createQuery("from User u").list();
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void delete(User user) {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
