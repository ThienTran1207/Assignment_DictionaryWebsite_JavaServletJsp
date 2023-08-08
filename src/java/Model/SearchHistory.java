/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Peanut
 */
public class SearchHistory {

    private String username, searchedWord;
    private String dateAndTime;

    public SearchHistory() {
        connect();
    }

    public SearchHistory(String username) {
        this.username = username;
        connect();
    }
    
    

    public SearchHistory(String username, String searchedWord) {
        this.username = username;
        this.searchedWord = searchedWord;
        connect();
    }

    public SearchHistory(String username, String searchedWord, String dateAndTime) {
        this.username = username;
        this.searchedWord = searchedWord;
        this.dateAndTime = dateAndTime;
        connect();
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSearchedWord() {
        return searchedWord;
    }

    public void setSearchedWord(String searchedWord) {
        this.searchedWord = searchedWord;
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

    public void addHistory() {
        try {
            String strInsert = "insert into SearchHistory values (?, ?, ?)";
            pstm = cnn.prepareStatement(strInsert);
            pstm.setString(1, username);
            pstm.setString(2, searchedWord);
            pstm.setString(3, dateAndTime);
            pstm.execute();
            System.out.println("Word Added to History!!");
        } catch (Exception e) {
            System.out.println("addHistory(): " + e.getMessage());
        }
    }

    public ArrayList<SearchHistory> getListHistory() {
        ArrayList<SearchHistory> data = new ArrayList<SearchHistory>();
        try {
            String strSelect = "select * from SearchHistory where UserName = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, username);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String userName = rs.getString(1);
                String searchWord = rs.getString(2);
                String dateAndTime = rs.getString(3);
                data.add(new SearchHistory(userName, searchWord, dateAndTime));
            }
        } catch (Exception e) {
            System.out.println("getListHistory(): " + e.getMessage());
        }
        return data;
    }
}
