import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * packageName            : PACKAGE_NAME
 * fileName              : StatementStrategy
 * author                : sunkyu
 * date                  : 2022/04/22
 * description           :
 * ===========================================================
 * DATE              AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2022/04/22           sunkyu             최초 생성
 */
public interface StatementStrategy {
    public PreparedStatement makeStatement(Connection connection) throws SQLException;
}
