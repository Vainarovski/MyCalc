package calculator;

import org.springframework.stereotype.Component;

@Component
public class BackMeIntFromStr implements Calc {
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

    public Integer convertStrToInt(String str) {
        int takeNumber = 0;
        // проверка на пустое значение
        if (str != null) {
            // проверка - есть ли строковое значение
            boolean isEmtryStr = str.equals("");
            if (!isEmtryStr) {
                // преобразовать строку в число integer
                takeNumber = Integer.valueOf(str);
            }
        }
        return takeNumber;
    }

    @Override
    public String inOutDataBase(String userName, String userExample) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return null;
    }
}

