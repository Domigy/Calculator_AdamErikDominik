module hupetrik.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens hupetrik.calculator to javafx.fxml;
    exports hupetrik.calculator;
}