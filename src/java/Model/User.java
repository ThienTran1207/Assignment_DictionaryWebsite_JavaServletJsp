/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Peanut
 */
public class User {

    private String account, password, email, name;

    public User() {
    }

    public User(String account) {
        this.account = account;
        connect();
    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
        connect();
    }

    public User(String account, String password, String email, String name) {
        this.account = account;
        this.password = password;
        this.email = email;
        this.name = name;
        connect();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Connection cnn;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;

    private void connect() {
        try {
            cnn = (new DBContext()).connection;
            if (cnn != null) {
                System.out.println("Connect success");
            } else {
                System.out.println("Connect fail!");
            }
        } catch (Exception e) {
        }
    }

    public boolean checkUser() {
        try {
            String strSelect = "select * from Users "
                    + "where UserName=? "
                    + "and Password=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkUser():" + e.getMessage());
        }
        return false;
    }

    public String getNameByAccount() {
        try {
            String strSelect = "select * from Users "
                    + "where UserName=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String name = rs.getString(4);
                return name;
            }
        } catch (Exception e) {
            System.out.println("getNameByAccount():" + e.getMessage());
        }
        return "";
    }

    public void add() {
        try {
            String strInsert = "insert into Users values (?, ?, ?, ?)";
            pstm = cnn.prepareStatement(strInsert);
            pstm.setString(1, account);
            pstm.setString(2, password);
            pstm.setString(3, email);
            pstm.setString(4, name);
            pstm.execute();
            System.out.println("Account Added!!");
        } catch (Exception e) {
            System.out.println("add(): " + e.getMessage());
        }
    }

    public User getUser() {
        User u3 = new User();
        try {
            String strSelect = "select * from Users "
                    + "where UserName=? "
                    + "and Password=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String username = rs.getString(1);
                String pass = rs.getString(2);
                String email = rs.getString(3);
                String fullname = rs.getString(4);
                u3 = new User(username, pass, email, fullname);
            }
        } catch (Exception e) {
            System.out.println("getUser():" + e.getMessage());
        }
        return u3;
    }

    public void getUpdateProfile() {
        try {
            String strSelect = "select * from Users where UserName = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            rs = pstm.executeQuery();
            while (rs.next()) {
                account = rs.getString(1);
                password = rs.getString(2);
                email = rs.getString(3);
                name = rs.getString(4);
            }
        } catch (Exception e) {
            System.out.println("getUpdateProfile(): " + e.getMessage());
        }
    }

    public void update() {
        try {
            String strUpdate = "update Users "
                    + "set Password=?, "
                    + "Email=?, "
                    + "FullName=? "
                    + "where UserName=?";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, password);
            pstm.setString(2, email);
            pstm.setString(3, name);
            pstm.setString(4, account);
            pstm.execute();
            System.out.println("Account Updated!!!");
        } catch (Exception e) {
            System.out.println("update(): " + e.getMessage());
        }
    }

    public boolean checkUserExist() {
        try {
            String strSelect = "select * from Users "
                    + "where UserName=? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkUserExist():" + e.getMessage());
        }
        return false;
    }

    public User getUserStayLogin() {
        User u3 = new User();
        try {
            String strSelect = "select * from Users "
                    + "where UserName=? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String username = rs.getString(1);
                String pass = rs.getString(2);
                String email = rs.getString(3);
                String fullname = rs.getString(4);
                u3 = new User(username, pass, email, fullname);
            }
        } catch (Exception e) {
            System.out.println("getUserStayLogin():" + e.getMessage());
        }
        return u3;
    }

    public void deleteAccount() {
        try {
            String strDelete = "DELETE FROM Users WHERE UserName = ? ";
            pstm = cnn.prepareStatement(strDelete);
            pstm.setString(1, account);
            pstm.execute();
            System.out.println("Account Deleted!!");
        } catch (Exception e) {
            System.out.println("deleteAccount(): " + e.getMessage());
        }
    }
}
