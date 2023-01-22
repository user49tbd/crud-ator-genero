package pack01;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Changer {
	public EventHandler<MouseEvent> changer (Stage a,VBox vb) {
		EventHandler<MouseEvent> evh = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				a.getScene().setRoot(vb);
			}
			
		};
		return evh;
	}
}
