

public class SimpleJavaFXApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a Button with text "Click Me!"
        Button btn = new Button();
        btn.setText("Click Me!");

        // Set an action event on the button
        btn.setOnAction(event -> System.out.println("Hello, JavaFX!"));

        // Create a layout and add the button to it
        StackPane root = new StackPane();
        root.getChildren().add(btn);

        // Create a scene with the layout
        Scene scene = new Scene(root, 300, 250);

        // Set the scene on the stage (window)
        primaryStage.setTitle("Simple JavaFX Application");
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);  // Launch the JavaFX application
    }
}
