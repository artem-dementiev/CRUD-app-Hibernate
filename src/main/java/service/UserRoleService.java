package service;

import dao.UserRoleDaoImpl;
import entity.UserRole;

import java.util.List;

public class UserRoleService implements Service<UserRole> {
    @Override
    public void create(UserRole userRole) {
        new UserRoleDaoImpl().add(userRole);
    }

    @Override
    public UserRole get(long role) {
        return new UserRoleDaoImpl().find(role);
    }

    @Override
    public void update(UserRole userRole) {
        new UserRoleDaoImpl().update(userRole);
    }

    @Override
    public void delete(UserRole userRole) {
        new UserRoleDaoImpl().add(userRole);
    }

    @Override
    public List<UserRole> getAll() {
        return new UserRoleDaoImpl().findAll();
    }

    @Override
    public boolean isExist(String role) {
        return new UserRoleDaoImpl().isExist(role);
    }

    public UserRole findByRole(String role) {
        return new UserRoleDaoImpl().findByRole(role);
    }
}
