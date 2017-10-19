package calculator;

import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class WriteUserExample implements Calc {

    @Override
    public double totalCalculate(double argument, int codeOperation) {
        return 0;
    }

    @Override
    public double countAB(double argument1, double argument2) {
        return 0;
    }

    @Override
    public double countA(double argument) {
        return 0;
    }

    @Override
    public String convert(String str) {
        return null;
    }

    @Override
    public String convert(int code) {
        return null;
    }

    @Override
    public double convertStrToDouble(String str) {
        return 0;
    }

    @Override
    public Integer convertStrToInt(String str) {
        return null;
    }

    public String inOutDataBase(String enteredName, String enteredExample)  {

        String userName = "root";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3306/" +
                "?verifyServerCertificate=false" +
                "&useSSL=false" +
                "&requireSSL=false" +
                "&useLegacyDatetimeCode=false" +
                "&amp" +
                "&serverTimezone=UTC";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url, userName, password);

             Statement statement = conn.createStatement()) {
//            statement.executeUpdate("DROP TABLE IF EXISTS mysql.calchistory");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS mysql.calchistory(id INT AUTO_INCREMENT, name CHAR(30), example CHAR(200), PRIMARY KEY (`id`))");
//            statement.executeUpdate("CREATE TABLE IF NOT EXISTS mysql.calchistory('" + i + "', name CHAR(30), example CHAR(200), PRIMARY KEY ('" + i + "'))");
            String userNameTable = "INSERT INTO mysql.calchistory (name,example) VALUES('" + enteredName + "','" + enteredExample + "')";
            statement.executeUpdate(userNameTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

}

