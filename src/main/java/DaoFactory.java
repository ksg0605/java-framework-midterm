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

public class DaoFactory {
    public UserDao getUserDao() {
        return new UserDao(getConnectionMaker());
    }

    public JejuConnectionMaker getConnectionMaker() {
        return new JejuConnectionMaker();
    }
}
