package javafx;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;

public class Test01 extends Application {
    int i = 10;
    public static void main(String[] args) {

        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {






        Button button = new Button("按钮");
        button.setPrefHeight(100);
        button.setPrefWidth(200);
        final Group group = new Group();

        group.getChildren().add(button);
        Scene scene = new Scene(group);
        ObservableList<Node> children = group.getChildren();
        group.getChildren().addListener(new ListChangeListener<Node>() {
            public void onChanged(Change<? extends Node> c) {
                System.out.println("当前子组件数量 = " + c.getList().size());
            }
        });




        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Button button1 = new Button("x");
                i=i+30;
                button1.setLayoutX(500);
                button1.setLayoutY(i);

                group.getChildren().add(button1);

            }
        });




        primaryStage.setTitle("JavaFx");
        primaryStage.setScene(scene);
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }
}
