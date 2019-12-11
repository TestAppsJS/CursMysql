package com.cursmysql;

//STEP 1. Import required packages
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import  java.sql.*;


public class Students {
    private String numar_matricol;
    private String nume;
    private String prenume;
    private String cnp;
    private String data_nasterii;

    public Students(String nrMatricol, String name, String prenume, String cnp, String dataNasterii){
        this.numar_matricol = nrMatricol;
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
        this.data_nasterii = dataNasterii;
    }

    public String getNumar_matricol() { return numar_matricol; }
    public String getNume() { return nume; }
    public String getPrenume() { return prenume; }
    public String getCnp() { return cnp; }
    public String getData_nasterii() { return data_nasterii; }

    public static void showStudents(){
        String sql = "SELECT * FROM studenti";
        Connection connection = DbConnector.getDbConnection();
        Statement statement;
        ResultSet result;
        try{
            //STEP 4: Execute a query
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            int count = 0;
            //STEP 5: Extract data from result set
            while (result.next()) {
                // Retrieve by column order
                Integer id = result.getInt(1);
                String nrMatricol = result.getString(2);
                String nume = result.getString(3);
                String prenume = result.getString(4);
//               String output = "Student #%d: - %s - %s - %s";
//               System.out.println(String.format(output, ++count, id, nrMatricol, nume, prenume));
                ++count;
                System.out.println("Stundent: Nr - "+count+" ID: "+id+" Nr. Matricol: "+nrMatricol+ " Nume: "+nume+ " Prenume: "+prenume);

            }
        }
        catch (SQLException e){
            System.out.println("Query error.");
        }
        catch (NullPointerException e) {
            System.out.println("Element not found.");
        }
    }



}
