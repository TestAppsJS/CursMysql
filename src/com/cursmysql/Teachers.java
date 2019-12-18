package com.cursmysql;


import  java.sql.*;

public class Teachers {
    private int id;
    private String cod_profesor;
    private String nume;
    private String prenume;
    private String adresa;
    private String data_nasterii;
    private String grad_didactic;

    public Teachers(String cod_profesor, String nume, String prenume, String adresa, String data_nasterii, String grad_didactic) {
        this.cod_profesor = cod_profesor;
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.data_nasterii = data_nasterii;
        this.grad_didactic = grad_didactic;

    }


    public static void showTeachers() {
        String tableName = "profesori";
        String sql = "CREATE TABLE `profesori` (" +
                "  `id` int(10) unsigned NOT NULL AUTO_INCREMENT," +
                "  `cod_profesor` varchar(45) NOT NULL," +
                "  `nume` varchar(45) DEFAULT NULL," +
                "  `prenume` varchar(45) DEFAULT NULL," +
                "  `adresa` text," +
                "  `data_nasterii` date DEFAULT NULL," +
                "  `grad_didactic` enum('I','II','III') DEFAULT NULL," +
                "  PRIMARY KEY (`id`)," +
                "  UNIQUE KEY `numeunic` (`nume`,`prenume`)" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        Connection connection = DbConnector.getDbConnection();
        Statement statement;
        System.out.println(sql);
        try {
           statement = connection.createStatement();
           statement.execute(sql);
            System.out.println("Created table successfully...");

        } catch (SQLException e) {
           e.printStackTrace();
        }
    }
}