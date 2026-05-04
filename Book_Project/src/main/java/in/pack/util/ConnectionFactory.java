package in.pack.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static DataSource ds=null;

    public static Connection getConnection() throws Exception {

        if(ds==null){
            FileInputStream fis = new FileInputStream(new File("G:\\Java Workplace\\ServletWorkplace\\Book_Project\\dbCOnfig.properties"));

            Properties p = new Properties();
            p.load(fis);

            String url = p.getProperty("db.url");
            String username = p.getProperty("db.username");
            String pass = p.getProperty("db.password");

            HikariConfig config = new HikariConfig();
            config.setUsername(username);
            config.setPassword(pass);
            config.setJdbcUrl(url);
            config.setDriverClassName("com.mysql.cj.jdbc.Driver");


            ds = new HikariDataSource(config);
        }


        return  ds.getConnection();




    }
}
