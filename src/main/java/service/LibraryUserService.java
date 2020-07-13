package service;

import dao.LibraryUserDaoImpl;
import entity.LibraryUser;

import java.util.List;

public class LibraryUserService implements Service<LibraryUser> {
    @Override
    public void create(LibraryUser libraryUser) {
        new LibraryUserDaoImpl().add(libraryUser);
    }

    @Override
    public LibraryUser get(long login) {
        return new LibraryUserDaoImpl().find(login);
    }

    @Override
    public void update(LibraryUser libraryUser) {
        new LibraryUserDaoImpl().update(libraryUser);
    }

    @Override
    public void delete(LibraryUser libraryUser) {
        new LibraryUserDaoImpl().delete(libraryUser);
    }

    @Override
    public List<LibraryUser> getAll() {
        return new LibraryUserDaoImpl().findAll();
    }

    @Override
    public boolean isExist(String login) {
        return new LibraryUserDaoImpl().isExist(login);
    }

    public LibraryUser getByLogin(String login) {
        return new LibraryUserDaoImpl().findByLogin(login);
    }
}
