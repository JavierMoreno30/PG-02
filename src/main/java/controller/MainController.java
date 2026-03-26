package controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private Canvas binCanvas;

    @FXML
    private Button btnBinAnimate;

    @FXML
    private Button btnBinClear;

    @FXML
    private Button btnBinGen;

    @FXML
    private Button btnBinSearch;

    @FXML
    private Label lblBinArray;

    @FXML
    private Label lblBinComplex;

    @FXML
    private Label lblBinComps;

    @FXML
    private Label lblBinResult;

    @FXML
    private Label lblBinSize;

    @FXML
    private Label lblBinTime;

    @FXML
    private ListView<?> listSteps;

    @FXML
    private TabPane mainTabPane;

    @FXML
    private ProgressBar progressBarBin;

    @FXML
    private Slider sliderBinSize;

    @FXML
    private TextField txtBinValue;

}
