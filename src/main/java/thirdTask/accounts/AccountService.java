package thirdTask.accounts;

import thirdTask.dbService.DBException;
import thirdTask.dbService.DBService;
import dbService.dao.UsersDAO;
import dbService.dataSets.UsersDataSet;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountService {
    private DBService service;

    public AccountService() {
        service = new DBService();
    }

    public void addNewUser(String name) throws DBException {
        service.addUser(name);
    }

    public UsersDataSet getUserByLogin(String login) throws SQLException, DBException {
        Connection connection = DBService.getH2Connection();
        UsersDAO usersDAO = new UsersDAO(connection);
        long id = usersDAO.getUserId(login);
        return service.getUser(id);
    }
}