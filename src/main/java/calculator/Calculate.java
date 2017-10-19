package calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Calculate implements Calc {
    private double firstArgument = 0;
    private int saveCodeOperation = 0;

    @Autowired
    @Qualifier("plus")
    private Calc operationPlus;

    @Autowired
    @Qualifier("minus")
    private Calc operationMinus;

    public double totalCalculate(double enteredNum, int codeCalculateOperation) {

        int saveCode = 0;
        double result = 0;
        double secondtArgument = 0;

        //проверка - введён код очистки, стереть буферы аргументов и пераций, вернуть результат 0
        if (codeCalculateOperation == 20) {
            firstArgument = 0;
            saveCodeOperation = 0;
            return 0;
        }

        // проверка - если первое полученное число, то запомнить как первый аргумент
        if (firstArgument == 0) firstArgument = enteredNum;
            // если первый аргумент есть - заполняем второй
        else secondtArgument = enteredNum;

        //проверка кода операции - операция с двумя аргумнтами или "равно"
        if (codeCalculateOperation <= 10 || codeCalculateOperation == 19) {
            //проверка - первая ли операция, с двумя и более аргументами
            if (saveCodeOperation == 0 && firstArgument == 0) saveCodeOperation = codeCalculateOperation;
            //проверка - последующая ли операция, с двумя и более аргументами
            if (saveCodeOperation > 0) {
                //запоминаем текущую операцию
                saveCode = codeCalculateOperation;
                //ставим на исполнение операцию из буфера
                codeCalculateOperation = saveCodeOperation;
            }// записать текущую операцию в буфер
            else saveCode = codeCalculateOperation;
        }

        // поиск введённой операции
        switch (codeCalculateOperation) {
            case 1: // сложение
            {
                if (secondtArgument > 0) result = operationPlus.countAB(firstArgument, secondtArgument);
                else result = firstArgument;
                //запишем промежуточный результат
                firstArgument = result;
                break;
            }
            case 2: // вычитание
            {
                if (secondtArgument > 0) result = operationMinus.countAB(firstArgument, secondtArgument);
                else result = firstArgument;
                //запишем промежуточный результат
                firstArgument = result;
                break;
            }

            case 19: // равно
            {
                // случай сключение - равно есть, операции нет
                if (secondtArgument == 0) result = firstArgument;
                break;
            }

        }
        //пример завершён - очистить промежуточный результат
        if (saveCodeOperation == 19) {
            firstArgument = 0;
            saveCodeOperation = 0;
            saveCode = 0;
        }
        //сохраним запись последней операции
        saveCodeOperation = saveCode;

        return result;
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
