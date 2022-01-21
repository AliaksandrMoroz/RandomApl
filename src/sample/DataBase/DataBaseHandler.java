package sample.DataBase;

import sample.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHandler extends Config {
    static Connection connection;
    static List<Student> listStudent = new ArrayList<>();

    public static List<Student> getListStudent() {
        return listStudent;
    }

    public static void setListStudent(List<Student> listStudent) {
        DataBaseHandler.listStudent = listStudent;
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        return connection = DriverManager.getConnection(Config.URL, Config.USER, Config.PASSWORD);
    }

    public static void deleteStudentFromDB(String lastname, String name) {
        String delete = "DELETE FROM " + Constant.STUDENT_TABLE + " WHERE lastname = '" + lastname + "' and name = '" + name+"'";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(delete);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void addStudentFromDB(String lastname, String name) {
        String insert = "INSERT INTO " + Constant.STUDENT_TABLE + " (" + Constant.LASTNAME + "," + Constant.NAME + ","
                + Constant.QUESTION+","+Constant.ANSWER+","+Constant.BONUS_BALL+")" +
                " VALUES(?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(insert);
            preparedStatement.setString(1, lastname);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, "x");
            preparedStatement.setString(4, "x");
            preparedStatement.setString(5, "x");

            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void setQuestionAndAnswerAndBalls(Student student){
        String setQuestionAndAnswerAndBallsSQL = "UPDATE " + Constant.STUDENT_TABLE + " SET question = '" + student.getQuestion() + "' , "
                + "answer= '" + student.getAnswer() + "' , " + " bonusBall= '"+student.getBonusBall()+ "' WHERE id= "+student.getId();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(setQuestionAndAnswerAndBallsSQL);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void setStudentFromDB(String lastname, String name, String newLastName, String newName) {
        String set = "UPDATE " + Constant.STUDENT_TABLE + " SET lastname = '" + newLastName + "' , " + "name= '"
                + newName + "' WHERE lastname= '"+lastname+"' and name= '"+name+"'";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(set);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static List<Student> getAllStudentsFromDB() {
        ResultSet resultSet = null;
        String getAllStudentSQL = "SELECT * from " + Constant.STUDENT_TABLE + ";";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(getAllStudentSQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listStudent.add(new Student(resultSet.getInt(Constant.STUDENT_ID),
                        resultSet.getString(Constant.NAME),
                        resultSet.getString(Constant.LASTNAME),
                        resultSet.getString(Constant.QUESTION),
                        resultSet.getString(Constant.ANSWER),
                        resultSet.getString(Constant.BONUS_BALL)
                ));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listStudent;

    }
}
