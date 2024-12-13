package hupetrik.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.DecimalFormat;


public class HelloController {

    @FXML
    private Button kivonButton;
    @FXML
    private Label eredmenyText;
    @FXML
    private Button szazalekButton;
    @FXML
    private Button szorozButton;
    @FXML
    private Button osszeadButton;
    @FXML
    private Button osztButton;
    @FXML
    private Spinner<Double> szamEgy;
    @FXML
    private Spinner<Double> szamKetto;

    public void initialize() {
        szamEgy.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(-100,1000,1));
        szamKetto.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(-100, 1000, 1));
    }


    private void Hibak(){
        Alert alert = new Alert(Alert.AlertType.WARNING, "Minden mező megadása kötelező!");
        if(szamEgy.getValue().isNaN() || szamKetto.getValue().isNaN()){
            alert.showAndWait();
        }
            try
            {


                Double.parseDouble(szamEgy.getValue().toString());
                Double.parseDouble(szamKetto.getValue().toString());

            }
            catch (NullPointerException | NumberFormatException ex)
            {
               alert.setContentText("Nem számot adott meg!");
               alert.showAndWait();
            }
    }

    @FXML
    public void szorozAction() {
        Hibak();

        double eredmeny= Double.parseDouble(szamEgy.getValue().toString())*Double.parseDouble(szamKetto.getValue().toString());
        eredmenyText.setText(String.valueOf( eredmeny));
    }

    @FXML
    public void osztAction() {
        Hibak();
        DecimalFormat df = new DecimalFormat("#.##");
        double eredmeny= Double.parseDouble(szamEgy.getValue().toString())/Double.parseDouble(szamKetto.getValue().toString());
        eredmenyText.setText(String.valueOf(df.format(eredmeny)));
    }

    @FXML
    public void kivonAction() {
        Hibak();
        double eredmeny= Double.parseDouble(szamEgy.getValue().toString())-Double.parseDouble(szamKetto.getValue().toString());
        eredmenyText.setText(String.valueOf(eredmeny));
    }

    @FXML
    public void osszeadAction() {
        Hibak();
        double eredmeny= Double.parseDouble(szamEgy.getValue().toString())+Double.parseDouble(szamKetto.getValue().toString());
        eredmenyText.setText(String.valueOf(eredmeny));
    }

    @FXML
    public void szazalekAction() {
        Hibak();
        double eredmeny= Double.parseDouble(szamEgy.getValue().toString())*(Double.parseDouble(szamKetto.getValue().toString())/100);
        eredmenyText.setText(String.valueOf(eredmeny));
    }
}