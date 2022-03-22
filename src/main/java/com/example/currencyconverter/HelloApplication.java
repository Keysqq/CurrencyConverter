package com.example.currencyconverter;
//DEV: Justin Fredericks
//Class: 171
//Date:3/18/2022
//Script:usd / cad converter
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // create a pane to place nodes in using a grid concept
        GridPane grid = new GridPane();

        //style the grid with padding fields
        grid.setPadding(new Insets(10,10,10,10));
        grid.setHgap(10);
        grid.setVgap(8);

        //create nodes and set values
        Label label1 = new Label("USD");

        TextField tf1 = new TextField();
        tf1.setPrefWidth(150);

        Label label2 = new Label("CAD");

        TextField tf2 = new TextField();
        tf2.setPrefWidth(150);

        Button btn = new Button("Convert");
        GridPane.setHalignment(btn, HPos.RIGHT);

        //position nodes within spec col,row
        GridPane.setConstraints(label1,0,0);
        GridPane.setConstraints(tf1,1,0);
        GridPane.setConstraints(label2,0,1);
        GridPane.setConstraints(tf2,1,1);
        GridPane.setConstraints(btn,1,2);

        //add nodes to the pane
        grid.getChildren().addAll(label1,tf1,label2,tf2,btn);

        //set an on click action for convert button
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //check for textfield input
                //convert data and display calculation if input was entered
                if(tf1.getText().isEmpty()==false) {
                    double usd = Integer.parseInt(tf1.getText());
                    double cad = usd * 1.5;
                    tf2.setText(Double.toString(cad));
                }
            }
        });

        Scene scene = new Scene(grid);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}