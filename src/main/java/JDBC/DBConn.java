package JDBC;
import java.sql.*;
import java.util.Properties;

public class DBConn extends User {

    private Properties props = new Properties();
    public Connection conn;

    public DBConn() {

        this.props.setProperty("user", this.name);
        this.props.setProperty("password", this.password);

        try {

            this.conn = DriverManager.getConnection(this.url, this.props);

        } catch (Exception exception){

            System.out.println("Database Connection Failed!");
            System.exit(-1);
        }

    }

}