package com.cursmysql;

import java.sql.*;

public class Students {
    private String numar_matricol;
    private String nume;
    private String prenume;
    private String cnp;
    private String data_nasterii;

    public Students(String numar_matricol, String nume, String prenume, String cnp, String data_nasterii) {
        this.numar_matricol = numar_matricol;
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
        this.data_nasterii = data_nasterii;
    }

    public static void showStudents() {
        String sql = "SELECT *FROM studenti";
        Connection connection = DbConnector.getDbConnection();
        Statement statement;
        ResultSet result;

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            int count = 0;
            //STEP 5 Extract data from result set

            while (result.next()) {
                //Retrive by column order
                Integer id = result.getInt(1);
                String nrMatricol = result.getString(2);
                String nume = result.getString(3);
                String prenume = result.getString(4);
                ++count;

                System.out.println("Student: Nr - " + count + " ID: " + id + " Nr. Matricol: " + nrMatricol + " Nume: " + nume + " Prenume: " + prenume);


            }

        } catch (SQLException e) {
            System.err.println("Querry error.");
        }


    }

    public static void insertStudents(Students student) {
        String sql = "INSERT INTO studenti " +
                "(`numar_matricol` , `nume`, `prenume`, `cnp`, `data_nasterii` )" +
                " VALUES (' " +
                student.getNumar_matricol() +"' , ' "+
                student.getNume() + "' , '" +
                student.getPrenume() + "' , '" +
                student.getCnp() + "' , '" +
                student.getData_nasterii() + "' ) ;" ;

        System.out.println(sql);
        Connection connection = DbConnector.getDbConnection();
        Statement statement;

        try {
            statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public String getNumar_matricol() {
        return numar_matricol;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getCnp() {
        return cnp;
    }

    public String getData_nasterii() {
        return data_nasterii;
    }


}

