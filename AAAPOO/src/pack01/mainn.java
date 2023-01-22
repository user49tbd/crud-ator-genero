package pack01;
import java.sql.Connection;

import contro.conn;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class mainn extends Application{
	private double x;
	private double y;
	private String cs;
	public static void main(String[]args) {
		launch(args);
	}
	@Override
	public void start(Stage pr) throws Exception {
		// TODO Auto-generated method stub
		VBox vb = new VBox();
		x = 1300;
		y = 600;
		mainScreen ms = new mainScreen(pr, x, y);
		Scene sc = new Scene(ms.getVbmain(),1300,600);
		pr.setScene(sc);
		pr.show();
		pr.setResizable(false);
	}
}
