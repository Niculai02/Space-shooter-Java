package com.company.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DataBase {

    protected static DataBase instance = null;
    static Scanner sc = new Scanner(System.in);
    Connection c = null;
    Statement stmt = null;

    private DataBase(){
        System.out.println("se creeaza baza de date");
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:jocles.db");
            stmt = c.createStatement();
            String sql = "CREATE TABLE GAME " +
                    "(LEVEL INT NOT NULL," +
                    " SCORE INT NOT NULL)";
            stmt.execute(sql);
            stmt.executeUpdate("INSERT INTO GAME VALUES (1, 0)");
            stmt.executeUpdate("INSERT INTO GAME VALUES (2, 0)");
            stmt.executeUpdate("INSERT INTO GAME VALUES (3, 0)");
            // stmt.executeUpdate("UPDATE GAME set SCORE = 99 where LEVEL =1;");
            ResultSet rs = stmt.executeQuery("SELECT * FROM GAME;");
            int scor = rs.getInt("SCORE");
            System.out.println(scor);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

    public static DataBase GetInstance(){
        if(instance == null){
            instance = new DataBase();
        }
        return instance;
    }

    void reset(){
        instance = null;
    }

    public void setScore(int Score, int Level){
        try{
            c = DriverManager.getConnection("jdbc:sqlite:jocles.db");
            stmt = c.createStatement();
            stmt.executeUpdate("UPDATE GAME set SCORE = "+Score+" where LEVEL = "+Level+" ;");
            stmt.close();
            c.close();
        }catch (Exception e){
            System.out.println("eroare la adaugat scorul");
        }
    }

    public int getScore(int Level){
        int scor = 0;
        try{
            c = DriverManager.getConnection("jdbc:sqlite:jocles.db");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM GAME;");
            if(Level == 1){
                rs.next();
                scor = rs.getInt("SCORE");}

            else if(Level == 2){
                rs.next();
                rs.next();
                scor = rs.getInt("SCORE");
            }

            else {
                rs.next();
                rs.next();
                rs.next();
                scor = rs.getInt("SCORE");
            }
            stmt.close();
            c.close();
        }catch (Exception e){
            System.out.println("eroare la extras scorul");
        }
        return scor;
    }

}