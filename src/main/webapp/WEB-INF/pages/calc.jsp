<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyCalc</title>
    <style>
        .button {
            width: 90px;
            height: 90px;
        }
    </style>
</head>
<body>
<form action="/calc" method="post">
    <table align="center">
        <tr>
            <td colspan="4">
                КАЛЬКУЛЯТОР
            </td>
            <td>
            </td>
            <td>
            </td>
            <td>
            </td>
        </tr>
        <tr>
            <td colspan="4">
                итоговый пример
            </td>
            <td>
            </td>
            <td>
            </td>
            <td>
            </td>

        </tr>
        <tr>
            <td colspan="4">
                ${total}
            </td>
            <td>
            </td>
            <td>
            </td>
            <td>
            </td>

        </tr>
        <tr>
            <td colspan="4">
                текущий результат = ${result}
            </td>
            <td>
            </td>
            <td>
            </td>
            <td>
            </td>

        </tr>
        <tr>
            <td colspan="4">
                введите число
            </td>
            <td>
            </td>
            <td>
            </td>
            <td>
            </td>

        </tr>
        <tr>
            <td colspan="4">
                <input type="text" name="enteredNum" autofocus/>
            </td>
            <td>
            </td>
            <td>
            </td>
            <td>
            </td>

        </tr>
        <tr>
            <td colspan="4">
                выберите действие
            </td>
            <td>
            </td>
            <td>
            </td>
            <td>
            </td>

        </tr>

        <tr>
            <td>
                <button type="submit" name="button" value="1" class="button">+</button>
            </td>
            <td>
                <button type="submit" name="button" value="2" class="button">-</button>
            </td>
            <td>
                <button type="submit" name="button" value="19" class="button">=</button>
            </td>
            <td>
                <button type="submit" name="button" value="20" class="button">C</button>
            </td>
        </tr>
        <tr>
            <td>
                <button type="submit" name="button" value="21" class="button">История</button>
            </td>
        </tr>
    </table>
</form>
<p align="center">${history}</p>
</body>
</html>
