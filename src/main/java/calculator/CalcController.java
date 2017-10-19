package calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping()
public class CalcController {
    private String nameUser = "";
    private String totalExample = "";
    private String resultLastOperation = "";
    private int codeLastButtonClick = 0;
    private double lastEnteredNumber = 0;

    @Autowired
    @Qualifier("backMeDoubleFromStr")
    private Calc returnDouble;

    @Autowired
    @Qualifier("backMeIntFromStr")
    private Calc returnInt;

    @Autowired
    @Qualifier("calculate")
    private Calc calcThis;

    @Autowired
    @Qualifier("returnTheSignOfOperation")
    private Calc getOperand;

    @Autowired
    @Qualifier("removeLastNull")
    private Calc remNull;

    @Autowired
    @Qualifier("writeUserExample")
    private Calc writeExample;

    @Autowired
    @Qualifier("readUserExample")
    private Calc readExample;

    @RequestMapping(path = "/calc", method = RequestMethod.POST)
    public String calc(HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        String numberRewrite = "";
        //проверка - имя пользователя не заполнено
        boolean nameUserEmtry = nameUser.equals("");
        //сохранить имя введённого пользователя
        if (nameUserEmtry && request.getParameter("nickName") != null) nameUser = request.getParameter("nickName");
            //иначе имя пользователя по умолчанию
        else nameUser = "user";

        // Чтение из формы что за цифра введена
        String getNum = request.getParameter("enteredNum");

        // Чтение из формы что за кнопка нажата
        String getButton = request.getParameter("button");

        // Преобразование введённого числа в тип double
        lastEnteredNumber = returnDouble.convertStrToDouble(getNum);

        // Преобразование кода нажатой кнопки в тип Integer
        codeLastButtonClick = returnInt.convertStrToInt(getButton);

        // Проверка - есть ли действие
        if (codeLastButtonClick > 0) {
            // Проверка - есть действие на прочие операции
            if (codeLastButtonClick > 20) {
                // просмотр истории
                if (codeLastButtonClick == 21) request.setAttribute("history", readExample.inOutDataBase("",""));
            }
            // очистка
            else if (codeLastButtonClick == 20) {
                resultLastOperation = "";
                totalExample = "";
                calcThis.totalCalculate(lastEnteredNumber, 20);
                request.setAttribute("total", "");
                request.setAttribute("result", "");
                request.setAttribute("history", "");
            }
            // Выполнить действие на вычисление
            else {
                // Отформатируем число - отсечение пустой дробной части
                numberRewrite += lastEnteredNumber;
                numberRewrite = remNull.convert(numberRewrite);
                // Добавление введённого числа и операции в визуализацию
                totalExample += numberRewrite + " " + getOperand.convert(codeLastButtonClick) + " ";
                // Вычисление полученной операации и отсечение пустой дробной части
                resultLastOperation = "" + calcThis.totalCalculate(lastEnteredNumber, codeLastButtonClick);
                resultLastOperation = remNull.convert(resultLastOperation);
                // Проверка - если нажата кнопка "равно" добавить конечный результат в визуадизацию
                if (codeLastButtonClick == 19) totalExample += resultLastOperation;
            }
        }
        // Визуализация примера и результата
        request.setAttribute("total", totalExample);
        request.setAttribute("result", resultLastOperation);

        //Проверка - был ли закончен пример
        if (codeLastButtonClick == 19) {
            // Запись в БД примера и пользователя
            writeExample.inOutDataBase(nameUser, totalExample);
            // Очистка примера
            totalExample = "";
        }

        return "pages/calc";
    }
}
