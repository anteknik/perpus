package fungsi;

import java.util.*;
import java.util.logging.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class koneksiDB
{
    Connection con;
    
    public void panggilDriver() {
        try {
            final String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            System.out.println("Memanggil driver sukses");
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("Pesan Error : " + cnfe);
        }
    }
    
    public Connection condb() throws SQLException {
        final Properties prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
        }
        catch (IOException ex) {
            Logger.getLogger(koneksiDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection koneksi = null;
        try {
            final String url = "jdbc:mysql://" + prop.getProperty("HOST") + ":" + prop.getProperty("PORT") + "/" + prop.getProperty("DATABASE") + "?zeroDateTimeBehavior=convertToNull";
            final String user = prop.getProperty("USER");
            final String pass = prop.getProperty("PAS");
            koneksi = DriverManager.getConnection(url, user, pass);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
        return koneksi;
    }
}
