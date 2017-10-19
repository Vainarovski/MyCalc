package calculator;

import org.springframework.stereotype.Component;

@Component
public class RemoveLastNull implements Calc {

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
        if (str.length() > 2)
            if (str.charAt(str.length() - 2) == 46 && str.charAt(str.length() - 1) == 48)
                str = str.replaceFirst("[/.]0", "");
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
