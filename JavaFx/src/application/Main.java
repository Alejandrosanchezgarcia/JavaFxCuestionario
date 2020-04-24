package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application implements EventHandler<ActionEvent> {
	ComboBox<String> cb;
	Button b1;
	Button b2;
	Label l1;
	Label l2;
	Label l3;
	TextField t1;
	TextField t2;
	TextField t3;
	@Override
	public void start(Stage primaryStage) {
		
		
		try {
			b1 = new Button("Enviar");
			b1.setOnAction(this);
			b2 = new Button("Borrar");
			b2.setOnAction(this);
			VBox vb = new VBox();
			HBox hb = new HBox();
			HBox hb1= new HBox();
			HBox hb2 = new HBox();
			HBox hb3 = new HBox();
			HBox hb4 = new HBox();
			hb.getChildren().addAll(b1,b2);
			hb.setSpacing(15.00);
			
			
			
			
			l1= new Label("Ingresa tu nombre");
			t1 = new TextField();
			hb1.getChildren().addAll(l1,t1);
			
			l2 =  new Label("Ingresa tu apellido");
			t2= new TextField();
			hb2.getChildren().addAll(l2,t2);
			
			l3 = new Label("Ingresa tu edad");
			t3 = new TextField();
			hb3.getChildren().addAll(l3,t3);
			
			cb= new ComboBox<String>();
			cb.setOnAction(this);
			cb.setPromptText("Elija el deporte");
			cb.getItems().addAll("Futbol","baloncesto","rugby");
			hb4.getChildren().addAll(cb);
			
			
			
			
			
			
			
			
			
			vb.getChildren().addAll(hb1,hb2,hb3,hb4);
			
		
			
			
			BorderPane root = new BorderPane();
			root.setBottom(hb);
			hb.setAlignment(Pos.BOTTOM_RIGHT);
			hb1.setAlignment(Pos.CENTER);
			hb2.setAlignment(Pos.CENTER);
			hb3.setAlignment(Pos.CENTER);
			hb4.setAlignment(Pos.CENTER);
			hb1.setSpacing(10.00);
			hb2.setSpacing(10.00);
			hb3.setSpacing(10.00);
			hb4.setSpacing(10.00);
			hb1.setPadding(new Insets(5,5,5,5));
			hb2.setPadding(new Insets(5,5,5,5));
			hb3.setPadding(new Insets(5,5,5,5));
			hb4.setPadding(new Insets(5,5,5,5));
			root.setCenter(vb);
			vb.setAlignment(Pos.CENTER);
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Titulo");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void handle(ActionEvent event){
		if((Button)event.getSource() instanceof Button) {
			if((Button)event.getSource()==b1) {
				if(t1.getText()!="" && t2.getText()!="" && t3.getText()!="" && cb.getValue()!=null) {
					Alert a1 =  new Alert(AlertType.INFORMATION);
					a1.setTitle("Informacion valida");
					a1.setHeaderText("Buenas");
					a1.setContentText("Su usuario es: " + t1.getText() + t2.getText() + " y su edad es: " + t3.getText() + " y ha elegido el deporte: " + cb.getValue());
					a1.showAndWait();
				}else {
					Alert a2 =  new Alert(AlertType.INFORMATION);
					a2.setTitle("ERROR: Faltan datos por rellenar");
					a2.showAndWait();
				}
			}else if((Button)event.getSource()==b2) {
				t1.clear();
				t2.clear();
				t3.clear();
				cb.setValue(null);
				
			}
				
		}else if(event.getSource() instanceof ComboBox<?>) { //se le pone ? para que coja todo tipo de datos.
			System.out.println("El deporte elegido es: " + cb.getValue());
		}
  		
		
	}
}
