package calculator;

public interface Calc {
    public double totalCalculate(double argument, int codeOperation);//итоговые вычисления всего примера с хоанеием промежуточного рез-та
    public double countAB(double argument1, double argument2);//вычисление математических операций с 2-мя аргументами
    public double countA(double argument);//вычисление математических операций с 1-им аргументом
    public String convert(String str);//преобразование строк с отсечением не математических символов
    public String convert(int code);//для визуального примера, мвссив значков операций (+ - / * =)
    public double convertStrToDouble(String str);//преобразование строк в double числа
    public Integer convertStrToInt(String str);//преобразование строк в int числа

    //запросы в базу данных на запись и чтение истории
    public String inOutDataBase(String userName, String userExample) throws ClassNotFoundException, IllegalAccessException, InstantiationException;
}
