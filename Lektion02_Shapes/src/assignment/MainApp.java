package assignment;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Pane root = initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();

    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(330, 510);
        drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane) {
        // Car list.
        List<Car> cars = new ArrayList<>();

        // The different cars we want to draw. (Limited to six).
        cars.add(new Car("VW UP", Color.BEIGE, "AB 31 298"));

        cars.add(new Car("Citroén Berlingo", Color.YELLOW, "KK 09 022"));
        cars.add(new Car("Saab 900i", Color.SILVER, "AA 29 019"));
        cars.add(new Car("KIA Picanto", Color.SALMON, "FE 14 367"));
        cars.add(new Car("Saab 900i", Color.SILVER, "AA 29 019"));
        cars.add(new Car("Skoda Octavia", Color.RED, "OT 97 163"));
        cars.add(new Car("Test1", Color.BLUE, "Mr Tester"));

        Car printerCar = new Car("TestBrand", Color.ALICEBLUE, "TestPlate");
        printerCar.printInfo();

        if (cars.size() > 6) {
            cars.remove(cars.size() - 1);
        }

        // Car loop.
        int i = 0;
        for (Car car : cars) {
            double x = i * 110 + 5;
            double y = 5;
            if (i > 2) {
                y = 300;
                x -= 330;
            }

            Rectangle carRect = new Rectangle(x, y, 100, 200);
            carRect.setFill(car.getColor());
            carRect.setStroke(Color.BLACK);
            carRect.setStrokeWidth(1);
            pane.getChildren().add(carRect);

            Text carBrandText = new Text(x + 2, y + 15, car.getBrand());
            carBrandText.setFill(Color.BLACK);
            pane.getChildren().add(carBrandText);

            Text carPlateText = new Text(x + 20, y + carRect.getHeight() - 15, car.getRegistrationNumber());
            carPlateText.setFill(Color.BLACK);
            pane.getChildren().add(carPlateText);

            i++;
        }

        // Animation Test
        // Drawing face.
        double faceOffsetY = 250;

        Circle face = new Circle(0, faceOffsetY, 20);
        pane.getChildren().add(face);
        face.setFill(Color.WHITE);
        face.setStroke(Color.BLACK);
        face.setStrokeWidth(1);

        Circle lEye = new Circle(0, faceOffsetY - 5, 3);
        pane.getChildren().add(lEye);
        lEye.setFill(Color.BLACK);

        Circle rEye = new Circle(0, faceOffsetY - 5, 3);
        pane.getChildren().add(rEye);
        rEye.setFill(Color.BLACK);

        Line mouth = new Line(0, faceOffsetY + 5, 0, faceOffsetY + 5);
        pane.getChildren().add(mouth);

        // AnimationTimer handler.
        AnimationTimer anim = new AnimationTimer() {
            @Override
            public void handle(long now) {
                double slowDown = 500000000;
                double distance = (pane.getWidth() - face.getRadius() * 2) / 2;

                double sine = Math.sin(now / slowDown);
                double x = sine * distance + pane.getWidth() / 2;

                face.setCenterX(x);
                lEye.setCenterX(x - 5);
                rEye.setCenterX(x + 5);

                mouth.setStartX(x - 5);
                mouth.setEndX(x + 5);
            }
        };

        anim.start();
    }

}
