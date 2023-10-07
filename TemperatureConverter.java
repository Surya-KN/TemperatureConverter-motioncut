package week2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConverter extends JFrame {
    private JTextField celsiusField;
    private JTextField fahrenheitField;

    public TemperatureConverter() {
        createView();

        setTitle("Temperature Converter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void createView() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        getContentPane().add(panel);

        JLabel celsiusLabel = new JLabel("Celsius:");
        celsiusLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(celsiusLabel);

        celsiusField = new JTextField(5);
        celsiusField.setFont(new Font("Arial", Font.PLAIN, 14));
        celsiusField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String celsiusText = celsiusField.getText();
                if (!celsiusText.isEmpty()) {
                    double tempCelsius = Double.parseDouble(celsiusText);
                    double tempFahrenheit = tempCelsius * 9.0/5.0 + 32;
                    fahrenheitField.setText(String.format("%.2f", tempFahrenheit));
                } else {
                    fahrenheitField.setText("");
                }
            }
        });
        panel.add(celsiusField);

        JLabel fahrenheitLabel = new JLabel("Fahrenheit:");
        fahrenheitLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(fahrenheitLabel);

        fahrenheitField = new JTextField(5);
        fahrenheitField.setFont(new Font("Arial", Font.PLAIN, 14));
        fahrenheitField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String fahrenheitText = fahrenheitField.getText();
                if (!fahrenheitText.isEmpty()) {
                    double tempFahrenheit = Double.parseDouble(fahrenheitText);
                    double tempCelsius = (tempFahrenheit - 32) * 5.0/9.0;
                    celsiusField.setText(String.format("%.2f", tempCelsius));
                } else {
                    celsiusField.setText("");
                }
            }
        });
        panel.add(fahrenheitField);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TemperatureConverter().setVisible(true));
    }
}
