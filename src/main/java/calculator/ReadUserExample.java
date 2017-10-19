package calculator;

import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class ReadUserExample implements Calc {

    public String inOutDataBase() {
        String history = "";
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
            // запрос на чтение таблицы
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mysql.calchistory");
            while (resultSet.next()) {
                // построчно записываем историю данные
                history += resultSet.getString(2) + ": " + resultSet.getString(3) + "\n"; // "\r"
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return history;
    }

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

    @Override
    public String inOutDataBase(String userName, String userExample) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return null;
    }
}
