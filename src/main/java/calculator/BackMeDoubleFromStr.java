package calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BackMeDoubleFromStr implements Calc {
    @Autowired
    @Qualifier("replaseSymbols")
    private Calc verificationStr;

    @Autowired
    @Qualifier("firstSymbolPoint")
    private Calc checkFirstPoint;

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

    public double convertStrToDouble(String str) {
        double takeNumber = 0;
        // проверка на пустое значение
        if (str != null) {
            // проверка - есть ли строковое значение
            boolean isEmtryStr = str.equals("");
            if (!isEmtryStr) {
                // убрать все символы, кроме цифр
                str = verificationStr.convert(str);
                // если первая точка - подставляем ноль целых едениц
                str = checkFirstPoint.convert(str);
                //проверка - пустая строка после преобразований или осталась только точка
                if (str.length() == 0 || (str.length() == 1 && str.equals(".") )) return 0;
                // преобразовать строку в число double
                takeNumber = Double.valueOf(str);
            }
        }
        return takeNumber;
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
