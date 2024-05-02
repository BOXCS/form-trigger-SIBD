package Trigger.koneksi;

import java.sql.DriverManager;
import java.sql.Statement;

public class Connection {

    public static java.sql.Connection con;
    public static Statement stm;

    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost/penyimpanan";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(url, user, pass);
            stm = con.createStatement();

            System.out.println("Koneksi Berhasil");
        } catch (Exception e) {
            System.out.println("Gagal" + e.getMessage());
        }
    }
}
