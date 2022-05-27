package kuis_ups.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBHelper {

    public static final String USER = "root";
    public static final String DB = "kuis_desktop";
    public static final String MyConn = "jdbc:mysql://localhost/" + DB
            + "?user=" + USER;

    public static Connection getConnection(String driver) {
        Connection conn = null;

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection(MyConn);
                    System.out.println("Koneksi Berhasil");
                } catch (ClassNotFoundException ex) {
                    System.out.println("Library blm ada");
                    Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Koneksi Gagal");
                }
            return conn;
        }
        

        
}

