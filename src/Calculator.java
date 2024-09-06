import java.util.ArrayList;

public class Calculator {
    private ArrayList<String> calcHistoryItems;

    public ArrayList<String> getCalcHistoryItems() {
        return calcHistoryItems;
    }

    public void setCalcHistoryItems(ArrayList<String> calcHistoryItems) {
        this.calcHistoryItems = calcHistoryItems;
    }

    public Calculator() {

    }

    public void removeFirstResult() {
        if(!calcHistoryItems.isEmpty()) {
            calcHistoryItems.remove(0);
        }
    }

    public double calculate(int firstNum, int secondNum, String operator) {
        double result = 0.0;

        switch (operator) {
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
            case "*":
                result = firstNum * secondNum;
                break;
            case "/":
                result = (double) firstNum / secondNum;
                break;
            default:
                break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(firstNum);
        sb.append(operator);
        sb.append(secondNum);
        sb.append("=");
        sb.append(result);
        calcHistoryItems.add(sb.toString());
        return result;
    }
}
