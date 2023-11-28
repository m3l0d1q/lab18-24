package lab22.task2;

public class CalculatorApp {
    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();
        CalculatorModel model = new CalculatorModel();
        CalculatorController controller = new CalculatorController(view, model);
        view.setVisible(true);
    }
}
