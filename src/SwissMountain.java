import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;


public class SwissMountain extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("SwissMountains - Jerome Kettela");
        Group root = new Group();
        Scene scene = new Scene(root, 1000, 800, Color.WHITE);

        SplitPane splitPane = new SplitPane();
        splitPane.prefWidthProperty().bind(scene.widthProperty());
        splitPane.prefHeightProperty().bind(scene.heightProperty());
        splitPane.setOrientation(Orientation.HORIZONTAL);

        VBox topArea = new VBox(10);
        HBox rowBox = new HBox(20);
        final Text topText = TextBuilder.create()
                .text("top ")
                .translateX(20)
                .font(Font.font(null, FontWeight.BOLD, 20))
                .build();

        rowBox.getChildren().add(topText);
        topArea.getChildren().add(rowBox);
        topArea.setMinWidth(50.0);
        topArea.setMaxWidth(50.0);


        SplitPane splitPane2 = new SplitPane();
        splitPane2.setOrientation(Orientation.VERTICAL);
        splitPane2.prefWidthProperty().bind(scene.widthProperty());
        splitPane2.prefHeightProperty().bind(scene.heightProperty());

        HBox leftArea = new HBox();

        final Text upperRight = TextBuilder.create()
                .text("left")
                .font(Font.font(null, FontWeight.BOLD, 35))
                .build();
        leftArea.getChildren().add(upperRight);

        HBox rightArea = new HBox();

        final Text lowerRight = TextBuilder.create()
                .text("Right")
                .font(Font.font(null, FontWeight.BOLD, 35))
                .build();
        rightArea.getChildren().add(lowerRight);

        splitPane.getItems().add(leftArea);
        splitPane.getItems().add(rightArea);

        splitPane2.getItems().add(topArea);

        splitPane2.getItems().add(splitPane);
        splitPane.setDividerPositions(0.2, 0.8);
        HBox hbox = new HBox();
        hbox.getChildren().add(splitPane2);
        root.getChildren().add(hbox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
