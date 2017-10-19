package calculator;

import org.springframework.stereotype.Component;

@Component
public class ReplaseSymbols implements Calc {

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

    public String convert(String str) {
        // заменить первую запятую на точку, убрать все символы кроме цифр и первой точки
        str = str.replaceFirst(",", ".");
        str = str.replaceAll("P", "");
        str = str.replaceFirst("[/.]", "P");
        str = str.replaceAll("[/.]", "");
        str = str.replaceFirst("P", ".");
        str = str.replaceAll("[^\\d /.]", "");
        return str;
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
