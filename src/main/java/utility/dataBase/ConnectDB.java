package utility.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {

    public Connection returnConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(ConfigDB.URL, ConfigDB.USER, ConfigDB.PASSWORD);
            /*System.out.println("connect DB");*/
        }catch (Exception e) {
            System.out.println(e);
            System.out.println("connect DB field");
        }
        return connection;
    }
}
