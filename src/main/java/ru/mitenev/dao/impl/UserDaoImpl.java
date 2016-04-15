package ru.mitenev.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

    private Log log = LogFactory.getLog(UserDaoImpl.class);

    private SessionFactory sessionFactory;


    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return getSessionFactory().getCurrentSession().createQuery("from User u").list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getUsersWithKnowledges() {
        return sessionFactory.getCurrentSession().getNamedQuery("User.findAllWithKnowledges").list();
    }

    @Override
    public User getById(Long id) {
        return (User) sessionFactory.getCurrentSession().getNamedQuery("User.findById").setParameter("id", id).uniqueResult();
    }

    @Override
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
        log.info("User with id " + user.getId() + " was deleted.");
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
