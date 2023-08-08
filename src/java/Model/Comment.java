/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Peanut
 */
public class Comment {
    private String userName, comment, wordWantToAdd;

    public Comment() {
        connect();
    }

    public Comment(String userName, String comment, String wordWantToAdd) {
        this.userName = userName;
        this.comment = comment;
        this.wordWantToAdd = wordWantToAdd;
        connect();
    }

    public Comment(String userName) {
        this.userName = userName;
        connect();
    }
    
    

    public Comment(String userName, String comment) {
        this.userName = userName;
        this.comment = comment;
        connect();
    }

    public String getWordWantToAdd() {
        return wordWantToAdd;
    }

    public void setWordWantToAdd(String wordWantToAdd) {
        this.wordWantToAdd = wordWantToAdd;
    }
    
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public void addComment() {
        try {
            String strInsert = "insert into Comment values (?, ?, ?)";
            pstm = cnn.prepareStatement(strInsert);
            pstm.setString(1, userName);
            pstm.setString(2, comment);
            pstm.setString(3, wordWantToAdd);
            pstm.execute();
            System.out.println("Comment Added!!");
        } catch (Exception e) {
            System.out.println("addComment(): " + e.getMessage());
        }
    }

    public ArrayList<Comment> getListComment() {
        ArrayList<Comment> data = new ArrayList<Comment>();
        try {
            String strSelect = "select * from Comment ";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String userName = rs.getString(1);
                String comment = rs.getString(2);
                String wordWantToAdd = rs.getString(3);
                data.add(new Comment(userName, comment, wordWantToAdd));
            }
        } catch (Exception e) {
            System.out.println("getListComment(): " + e.getMessage());
        }
        return data;
    }

    public void deleteComment() {
        try {
            String strDelete = "DELETE FROM Comment WHERE [User Full Name] = ? ";
            pstm = cnn.prepareStatement(strDelete);
            pstm.setString(1, userName);
            pstm.execute();
            System.out.println("Comment Deleted!!");
        } catch (Exception e) {
            System.out.println("deleteComment(): " + e.getMessage());
        }
    }

    public String getUserWord() {
        String wordWantToAdd2 = "";
        try {
            String strSelect = "select * from Comment where [User Full Name] = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, userName);
            rs = pstm.executeQuery();
            while (rs.next()) {
                wordWantToAdd2 = rs.getString(3);
            }
        } catch (Exception e) {
            System.out.println("getUserWord(): " + e.getMessage());
        }
        return wordWantToAdd2;
    }

    
}
