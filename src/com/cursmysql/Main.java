package com.cursmysql;

import  java.sql.Connection;

public class Main {

    public static void main(String[] args)  {
	// write your code here
    // Connection connection = DbConnector.getDbConnection();
        Students student = new Students("4MM", "Munteanu", "Maria", "2901020344556", "1991-06-08");
        Students.insertStudents(student);
        Students.showStudents();
        //Teachers.showTeachers();

    }
}
