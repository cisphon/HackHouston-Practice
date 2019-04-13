import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class JavaFXPractice extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
    	
        Label label = new Label("Jamie");
        Label label2 = new Label("Jesse");
        Label label3 = new Label("David");
        Label label4 = new Label("Shane");
        /*
        label.setAlignment(Pos.BOTTOM_RIGHT);
        label2.setAlignment(Pos.TOP_LEFT);
        label3.setAlignment(Pos.BOTTOM_LEFT);
        label4.setAlignment(Pos.TOP_RIGHT);
        */
        
        Pane p = new Pane();
        p.getChildren().add(label);
        p.getChildren().add(label2);
        p.getChildren().add(label3);
        p.getChildren().add(label4);
        
        label.setLayoutX(50);
        label.setLayoutY(50);
        
        label2.setLayoutX(50);
        label2.setLayoutY(0);
        
        
        label3.setLayoutX(0);
        label3.setLayoutY(50);
        
        
        
        
        primaryStage.setScene(new Scene(p, 300, 250));
        primaryStage.setTitle("Hello World Application");
        primaryStage.show();
    }
    
    public static void main(String[] args)
    {
    	launch();
    }
}
