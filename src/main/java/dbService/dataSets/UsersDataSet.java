package dbService.dataSets;

@SuppressWarnings("UnusedDeclaration")
public class UsersDataSet {
    private long id;
    private String loginName;
    private String password;

    public UsersDataSet(long id, String loginName) {
        this.id = id;
        this.loginName = loginName;
        this.password = loginName;
    }


    public String getloginName() {
        return loginName;
    }

    public String getPassword() {
        return loginName;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "UsersDataSet{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                '}';
    }
}
