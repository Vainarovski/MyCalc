package calculator;

import org.springframework.stereotype.Component;

@Component
public class Plus implements Calc{

    @Override
    public double totalCalculate(double argument, int codeOperation) {
        return 0;
    }

    public double countAB(double a, double b) {
        return a + b;
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
