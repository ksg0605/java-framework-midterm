import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

/**
 * packageName            : PACKAGE_NAME
 * fileName              : DaoFactory
 * author                : sunkyu
 * date                  : 2022/04/22
 * description           :
 * ===========================================================
 * DATE              AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2022/04/22           sunkyu             최초 생성
 */

@Configuration
public class DaoFactory {
    @Value("${db.drivername}")
    private String driverClassName;// "com.mysql.cj.jdbc.Driver"
    @Value("${db.url}")
    private String url;// "jdbc:mysql://localhost/jeju?serverTimezone=UTC"
    @Value("${db.username}")
    private String username;// jeju
    @Value("${db.password}")
    private String password;

    @Bean
    public UserDao userDao() throws ClassNotFoundException {
        return new UserDao(dataSource());
    }

    @Bean
    public DataSource dataSource() throws ClassNotFoundException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(
                (Class<? extends Driver>) Class.forName(driverClassName));
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
