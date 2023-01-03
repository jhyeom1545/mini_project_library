package mini_project_library.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class Example extends Application {
   public void start(Stage stage) {
      //Creating buttons
      Button left = new Button("Left");
      left.setPrefSize(200, 100);
      Button right = new Button("Right");
      right.setPrefSize(200, 100);
      Button top = new Button("Top");
      top.setPrefSize(595, 100);
      Button bottom = new Button("Buttom");
      bottom.setPrefSize(595, 100);
      Button center = new Button("Center");
      center.setPrefSize(200, 100);
      //Creating the border pane
      BorderPane pane = new BorderPane();
      //Setting the top, bottom, center, right and left nodes to the pane
      pane.setTop(top);
      pane.setBottom(bottom);
      pane.setLeft(left);
      pane.setRight(right);
      pane.setCenter(center);
      //Setting the Scene
      Scene scene = new Scene(pane, 595, 300);
      stage.setTitle("Border Pane");
      stage.setScene(scene);
      stage.show();
   }
   public static void main(String args[]){
      launch(args);
   }
}
