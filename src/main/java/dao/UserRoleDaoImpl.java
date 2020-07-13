package dao;

import entity.UserRole;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

public class UserRoleDaoImpl implements EntityDao<UserRole> {

    @Override
    public void add(UserRole userRole) {
        try (Session session = HibernateUtil.getSessionFactory()
                .openSession()) {
            session.beginTransaction();
            session.save(userRole);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override public void update(UserRole userRole) {
        try (Session session = HibernateUtil.getSessionFactory()
                .openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaUpdate<UserRole> criteriaUpdate = builder
                    .createCriteriaUpdate(UserRole.class);
            Root<UserRole> root = criteriaUpdate.from(UserRole.class);
            criteriaUpdate.set("roleName", userRole.getRoleName());
            criteriaUpdate
                    .where(builder.equal(root.get("id"), userRole.getId()));

            Transaction transaction = session.beginTransaction();
            session.createQuery(criteriaUpdate).executeUpdate();
            transaction.commit();
        }
    }

    @Override public UserRole find(long role) {
        UserRole userRole;
        try (Session session = HibernateUtil.getSessionFactory()
                .openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<UserRole> criteria = builder
                    .createQuery(UserRole.class);
            Root<UserRole> from = criteria.from(UserRole.class);
            criteria.where(builder.equal(from.get("id"), role));
            Query query = session.createQuery(criteria);
            userRole = (UserRole) query.getSingleResult();
        }
        return userRole;
    }

    public UserRole findByRole(String role) {
        UserRole userRole;
        try (Session session = HibernateUtil.getSessionFactory()
                .openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<UserRole> criteria = builder
                    .createQuery(UserRole.class);
            Root<UserRole> from = criteria.from(UserRole.class);
            criteria.where(builder.equal(from.get("roleName"), role));
            Query query = session.createQuery(criteria);
            userRole = (UserRole) query.getSingleResult();
        }
        return userRole;
    }

    @Override public List<UserRole> findAll() {
        try (Session session = HibernateUtil.getSessionFactory()
                .openSession()) {
            return session.createQuery("from " + UserRole.class.getName(),
                    UserRole.class).list();
        }
    }

    @Override public void delete(UserRole userRole) {
        try (Session session = HibernateUtil.getSessionFactory()
                .openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaDelete<UserRole> criteriaDelete = builder
                    .createCriteriaDelete(UserRole.class);
            Root<UserRole> root = criteriaDelete.from(UserRole.class);
            criteriaDelete
                    .where(builder.equal(root.get("id"), userRole.getId()));

            Transaction transaction = session.beginTransaction();
            session.createQuery(criteriaDelete).executeUpdate();
            transaction.commit();
        }
    }
//test2
    @Override public boolean isExist(String role) {
        UserRole userRole;
        try (Session session = HibernateUtil.getSessionFactory()
                .openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<UserRole> criteria = builder
                    .createQuery(UserRole.class);
            Root<UserRole> from = criteria.from(UserRole.class);
            criteria.where(builder.equal(from.get("role"), role));
            Query query = session.createQuery(criteria);
            userRole = (UserRole) query.getSingleResult();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
