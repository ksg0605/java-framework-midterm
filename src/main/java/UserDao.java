import java.sql.*;

/**
 * packageName            : PACKAGE_NAME
 * fileName              : UserDao
 * author                : sunkyu
 * date                  : 2022/04/22
 * description           :
 * ===========================================================
 * DATE              AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2022/04/22           sunkyu             최초 생성
 */
public class UserDao {

    private final ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionmaker) {
        this.connectionMaker = connectionmaker;
    }

    public User get(Integer id) throws ClassNotFoundException, SQLException {
        Connection connection = connectionMaker.getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("select * from userinfo where id = ?");
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        resultSet.close();
        preparedStatement.close();
        connection.close();
        return user;
    }

    public void insert(User user) throws ClassNotFoundException, SQLException {
        Connection connection = connectionMaker.getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("insert into userinfo (name, password) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());

        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        resultSet.next();

        user.setId(resultSet.getInt(1));


        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
