package lab22.task2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorView view;
    private CalculatorModel model;

    public CalculatorController(CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;

        view.setNumberButtonListener(new NumberButtonListener());
        view.setOperatorButtonListener(new OperatorButtonListener());
        view.setEqualsButtonListener(new EqualsButtonListener());
        view.setDecimalButtonListener(new DecimalButtonListener());
        view.setClearButtonListener(new ClearButtonListener());
    }

    class NumberButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String number = e.getActionCommand();
            String currentText = view.getTextFieldText();
            view.setTextFieldText(currentText + number);
        }
    }

    class OperatorButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String operator = e.getActionCommand();
            String currentText = view.getTextFieldText();
            view.setTextFieldText(currentText + operator);
        }
    }

    class EqualsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String expression = view.getTextFieldText();
            String result = model.calculate(expression);
            view.setTextFieldText(result);
        }
    }

    class DecimalButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String decimal = e.getActionCommand();
            String currentText = view.getTextFieldText();
            view.setTextFieldText(currentText + decimal);
        }
    }

    class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setTextFieldText("");
        }
    }
}
