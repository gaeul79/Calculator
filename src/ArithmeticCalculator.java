import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

public class ArithmeticCalculator<T> {
    private ArrayList<T> calcHistoryItems;

    public ArrayList<T> getCalcHistoryItems() {
        return calcHistoryItems;
    }
    
    public void setCalcHistoryItems(ArrayList<T> calcHistoryItems) {
        this.calcHistoryItems = calcHistoryItems;
    }



    public T calculate(T firstNum, T secondNum, T operator) {
        Double result;
        double num1 = (double)firstNum; // 이렇게 해도 되는걸까..ㅠ
        double num2 = (double)secondNum;

        if(operator == OperatorType.ADD) {
            result = num1 + num2;
            calcHistoryItems.add((T)result);
        }
        else if(operator == OperatorType.SUBTRACT) {
            result = num1 - num2;
            calcHistoryItems.add((T)result);
        }
        else if(operator == OperatorType.MULTIPLY) {
            result = num1 * num2;
            calcHistoryItems.add((T)result);
        }
        else {
            result = num1 / num2;
            calcHistoryItems.add((T)result);
        }

        return calcHistoryItems.get(calcHistoryItems.size()-1);
    }
}
