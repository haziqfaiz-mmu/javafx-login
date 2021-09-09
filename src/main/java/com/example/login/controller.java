package com.example.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class controller {
    @FXML
    Button loginButton;
    @FXML
    TextField nameTextField;
    @FXML
    AnchorPane scenePane;
    @FXML
    Button logoutButton;

    private Stage stage;
    private Parent root;
    private Scene scene;


    public void logIn(ActionEvent event) throws IOException {

        String username = nameTextField.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("greeting.fxml"));
        root = loader.load();

        controller2 controller2 = loader.getController();
        controller2.displayName(username);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void logOut(ActionEvent event) throws IOException{

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to log out");
        alert.setContentText("Do you want to save before exiting");

        if(alert.showAndWait().get() == ButtonType.OK) {

            //to make sure we are at the current stage we want to log out from
            //stage = (Stage) scenePane.getScene().getWindow();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            System.out.println("You successfully logged out");
            stage.close();
        }
    }
}
