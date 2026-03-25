package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TabPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML private TabPane mainTabPane;
    @FXML private ScrollPane scrollFactTree;
    @FXML private Canvas canvasTree;

    @FXML private Slider sliderFactN;
    @FXML private Label lblFactN;
    @FXML private Button btnFactReset;
    @FXML private Button btnFactCalc;
    @FXML private Label lblComplexity;
    @FXML private Label lblFactCalls;
    @FXML private Label lblFactResult;
    @FXML private ListView<String> listSteps;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupFactTab();
        resetFactTab();
    }

    private void setupFactTab() {
        sliderFactN.setMin(1);
        sliderFactN.setMax(12);
        sliderFactN.setValue(5);
        sliderFactN.setMajorTickUnit(1);
        sliderFactN.setMinorTickCount(0);
        sliderFactN.setSnapToTicks(true);

        lblFactN.setText(String.valueOf((int) sliderFactN.getValue()));

        sliderFactN.valueProperty().addListener((obs, oldVal, newVal) ->
                lblFactN.setText(String.valueOf((int) newVal.doubleValue())));

        btnFactCalc.setOnAction(e -> runFactorial());
        btnFactReset.setOnAction(e -> resetFactTab());
    }

    private void resetFactTab() {
        sliderFactN.setValue(5);
        lblFactN.setText("5");
        lblComplexity.setText("--");
        lblFactCalls.setText("--");
        lblFactResult.setText("--");
        listSteps.setItems(FXCollections.observableArrayList());
    }

    private void runFactorial() {
        int n = (int) sliderFactN.getValue();

        ObservableList<String> steps = FXCollections.observableArrayList();
        long[] calls = new long[1];

        long result = factorial(n, steps, calls);

        lblFactResult.setText(String.valueOf(result));
        lblFactCalls.setText(String.valueOf(calls[0]));
        lblComplexity.setText("O(n)");
        listSteps.setItems(steps);
    }

    private long factorial(int n, ObservableList<String> steps, long[] calls) {
        calls[0]++;
        steps.add("factorial(" + n + ")");

        if (n <= 1) {
            steps.add("return 1");
            return 1;
        }

        long partial = factorial(n - 1, steps, calls);
        long result = n * partial;
        steps.add(n + " * factorial(" + (n - 1) + ") = " + result);
        return result;
    }
}