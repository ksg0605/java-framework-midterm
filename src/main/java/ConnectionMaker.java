import java.sql.Connection;
import java.sql.SQLException;

/**
 * packageName            : PACKAGE_NAME
 * fileName              : ConnectionMaker
 * author                : sunkyu
 * date                  : 2022/04/22
 * description           :
 * ===========================================================
 * DATE              AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2022/04/22           sunkyu             최초 생성
 */
public interface ConnectionMaker {
    Connection getConnection() throws ClassNotFoundException, SQLException;
}
