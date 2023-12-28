package db;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.jdbi.v3.core.Jdbi;

import java.sql.Connection;

public class JDBIConnector {
    private  static Jdbi jdbi;

    public static Connection connect(){
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://"+DBProperties.host+":"+DBProperties.port+"/"+DBProperties.dbName);
        System.out.println("jdbc:mysql://"+DBProperties.host+":"+DBProperties.port+"/"+DBProperties.dbName);
        dataSource.setUser(DBProperties.username);
        dataSource.setPassword(DBProperties.pass);

        try {
            dataSource.setAutoReconnect(true);
            dataSource.setUseCompression(true);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
        jdbi = Jdbi.create(dataSource);
        return null;
    }
    public JDBIConnector(){}

    public static Jdbi me(){
        if (jdbi==null) connect();
        return jdbi;
    }
}
