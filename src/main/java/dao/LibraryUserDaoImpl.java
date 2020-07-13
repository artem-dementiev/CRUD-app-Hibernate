package dao;

import entity.LibraryUser;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.criteria.*;
import java.util.List;

public class LibraryUserDaoImpl implements EntityDao<LibraryUser> {

    @Override
    public void add(LibraryUser libraryUser) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory()
                .openSession()) {
            transaction = session.beginTransaction();
            session.save(libraryUser);
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
    }

    @Override
    public void update(LibraryUser libraryUser) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(libraryUser);
            session.getTransaction().commit();
        }
    }

    @Override
    public LibraryUser find(long id) {
        LibraryUser libraryUser;
        try (Session session = HibernateUtil.getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            libraryUser= session.get(LibraryUser.class, id);
            transaction.commit();
        }
        return libraryUser;
    }

    public LibraryUser findByLogin(String login) {
        LibraryUser libraryUser;
        try (Session session = HibernateUtil.getSessionFactory()
                .openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<LibraryUser> criteria = builder
                    .createQuery(LibraryUser.class);
            Root<LibraryUser> from = criteria.from(LibraryUser.class);
            criteria.where(builder.equal(from.get("login"), login));
            libraryUser = session.createQuery(criteria).getSingleResult();
        }
        return libraryUser;
    }

    @Override
    public List<LibraryUser> findAll() {
        try (Session session = HibernateUtil.getSessionFactory()
                .openSession()) {
            return session.createQuery("from " + LibraryUser.class.getName(),
                    LibraryUser.class).list();
        }
    }

    @Override
    public void delete(LibraryUser libraryUser) {
        try (Session session = HibernateUtil.getSessionFactory()
                .openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaDelete<LibraryUser> criteriaDelete = builder
                    .createCriteriaDelete(LibraryUser.class);
            Root<LibraryUser> root = criteriaDelete.from(LibraryUser.class);
            criteriaDelete
                    .where(builder.equal(root.get("id"), libraryUser.getId()));

            Transaction transaction = session.beginTransaction();
            session.createQuery(criteriaDelete).executeUpdate();
            transaction.commit();
        }
    }

    @Override
    public boolean isExist(String login) {
        try (Session session = HibernateUtil.getSessionFactory()
                .openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<LibraryUser> criteria = builder
                    .createQuery(LibraryUser.class);
            Root<LibraryUser> from = criteria.from(LibraryUser.class);
            criteria.where(builder.equal(from.get("login"), login));
            LibraryUser libraryUser = session.createQuery(criteria).getSingleResult();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
