import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Flower3D extends Application {
  @Override
  public void start(Stage primaryStage) {
    // create a 3d scene
    Group root = new Group();
    Scene scene = new Scene(root, 600, 600, true);

    // get user input for petal count and color 
    int petalCount=10;
    Color petalColor=Color.RED;

    // create 3d flower
    for(int i = 0; i < petalCount; i++) {
      double angle = 2 * Math.PI * i / petalCount;
      Translate t = new Translate(200, 200, 0);
      Rotate r = new Rotate(angle * 180 / Math.PI, Rotate.Z_AXIS);

      // create petal shape
      Polygon petal = new Polygon();
      petal.getPoints().addAll(
        0.0, 0.0,
        50.0, -20.0,
        100.0, 0.0,
        50.0, 20.0
        );
      petal.setFill(petalColor);
      // combine transformations and petal
      Group petalGroup = new Group(petal);
      petalGroup.getTransforms().addAll(t,r);
      root.getChildren().add(petalGroup);
    }
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  public static void main(String[] args) {
    launch(args);
  }
}
