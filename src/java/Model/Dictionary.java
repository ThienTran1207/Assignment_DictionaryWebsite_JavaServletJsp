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
public class Dictionary {

    private String englishWord, vietnameseWord, example;

    public Dictionary() {
        connect();
    }

    public Dictionary(String englishWord) {
        this.englishWord = englishWord;
        connect();
    }

    public Dictionary(String englishWord, String vietnameseWord) {
        this.englishWord = englishWord;
        this.vietnameseWord = vietnameseWord;
        connect();
    }

    public Dictionary(String englishWord, String vietnameseWord, String example) {
        this.englishWord = englishWord;
        this.vietnameseWord = vietnameseWord;
        this.example = example;
        connect();
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public String getVietnameseWord() {
        return vietnameseWord;
    }

    public void setVietnameseWord(String vietnameseWord) {
        this.vietnameseWord = vietnameseWord;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
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

    public boolean checkEnglishWord() {
        try {
            String strSelect = "select * from EngVie "
                    + "where EnglishWord=? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, englishWord);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkEnglishWord():" + e.getMessage());
        }
        return false;
    }

    public String getResult() {
        try {
            String strSelect = "select * from EngVie "
                    + "where EnglishWord=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, englishWord);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String vietnameseWord = rs.getString(2);
                return vietnameseWord;
            }
        } catch (Exception e) {
            System.out.println("getResult():" + e.getMessage());
        }
        return "";
    }

    public boolean checkVietnameseWord() {
        try {
            String strSelect = "select * from EngVie "
                    + "where VietnameseWord = ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, vietnameseWord);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkVietnameseWord():" + e.getMessage());
        }
        return false;
    }

    public String getResult2() {
        try {
            String strSelect = "select * from EngVie "
                    + "where VietnameseWord = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, vietnameseWord);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String englishWord = rs.getString(1);
                return englishWord;
            }
        } catch (Exception e) {
            System.out.println("getResult2():" + e.getMessage());
        }
        return "";
    }

    public void getDetail() {
        try {
            String strSelect = "select * from EngVie "
                    + "where EnglishWord=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, englishWord);
            rs = pstm.executeQuery();
            while (rs.next()) {
                englishWord = rs.getString(1);
                vietnameseWord = rs.getString(2);
                example = rs.getString(3);
            }
        } catch (Exception e) {
            System.out.println("getResult():" + e.getMessage());
        }
    }

    public void deleteWord() {
        try {
            String strDelete = "DELETE FROM EngVie WHERE EnglishWord = ? ";
            pstm = cnn.prepareStatement(strDelete);
            pstm.setString(1, englishWord);
            pstm.execute();
            System.out.println("Word Deleted!!");
        } catch (Exception e) {
            System.out.println("deleteWord(): " + e.getMessage());
        }
    }

    public boolean checkWordExist() {
        try {
            String strSelect = "select * from EngVie "
                    + "where EnglishWord=? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, englishWord);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkWordExist():" + e.getMessage());
        }
        return false;
    }

    public void insertWord() {
        try {
            String strInsert = "insert into EngVie values (?, ?, ?)";
            pstm = cnn.prepareStatement(strInsert);
            pstm.setString(1, englishWord);
            pstm.setString(2, vietnameseWord);
            pstm.setString(3, example);
            pstm.execute();
            System.out.println("Word Added!!");
        } catch (Exception e) {
            System.out.println("insertWord(): " + e.getMessage());
        }
    }
}
