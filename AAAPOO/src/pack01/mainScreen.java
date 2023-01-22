package pack01;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class mainScreen extends Changer{
	private Stage a;
	private VBox vbm = new VBox();
	private double x;
	private double y;
	
	private Button btAScreen;
	private Button btGScreen;
	
	//private AtorScreen as;
	//private GenereScreen gs;
	
	private VBox vba;
	private VBox vbg;
	
	public mainScreen(Stage a,double x,double y) {
		this.a = a;
		this.x = x;
		this.y = y;
		
		
	}
	public VBox getVbmain() {
		vba = new AtorScreen(a, x, y,vbm).getVb1();
		vbg = new GenereScreen(a, x, y,vbm).getVb1();
		//as = new AtorScreen(a,x,y);
		//gs = new GenereScreen(a, x, y);
		//vb1 = new VBox();
		Label lbcrud = new Label("Ator - Genero");
		FlowPane fwp1 = new FlowPane();
		lbcrud.setStyle("-fx-text-fill: radial-gradient(radius 90%,GREY, derive(GREY, 100%),derive(GREY, -10%));"+
				"-fx-font-size: 50");
		fwp1.getChildren().add(lbcrud);
		fwp1.setStyle("-fx-background-color: radial-gradient(radius 90%, derive(RED, 50%), derive(RED, -50%))");
		fwp1.setAlignment(Pos.TOP_CENTER);
		
		FlowPane fwp2 = new FlowPane();
		
		btAScreen = new Button("Ator");
		btAScreen.setPrefHeight(200);
		btAScreen.setPrefWidth(300);
		btAScreen.setStyle("-fx-text-fill: radial-gradient(radius 90%,GREY, derive(GREY, 100%),derive(GREY, -10%));"+
				"-fx-font-size: 50;"+
				"-fx-background-color: radial-gradient(radius 90%, derive(RED, 50%), derive(RED, -50%));"+
		"-fx-border-color: radial-gradient(radius 90%,GREY, derive(GREY, 100%),derive(GREY, -10%));"+
				"-fx-border-width: 10;"+"-fx-border-radius: 20;"+"-fx-background-radius: 25;");
		btGScreen = new Button("Genero");
		btGScreen.setPrefHeight(200);
		btGScreen.setPrefWidth(300);
		btGScreen.setStyle("-fx-text-fill: radial-gradient(radius 90%,GREY, derive(GREY, 100%),derive(GREY, -10%));"+
				"-fx-font-size: 50;"+
				"-fx-background-color: radial-gradient(radius 90%, derive(RED, 50%), derive(RED, -50%));"+
		"-fx-border-color: radial-gradient(radius 90%,GREY, derive(GREY, 100%),derive(GREY, -10%));"+
				"-fx-border-width: 10;"+"-fx-border-radius: 20;"+"-fx-background-radius: 25;");
		fwp2.getChildren().addAll(btAScreen,btGScreen);
		fwp2.setAlignment(Pos.TOP_CENTER);
		fwp2.setHgap(50);
		fwp2.setStyle("-fx-background-color: radial-gradient(radius 90%, derive(RED, 50%), derive(RED, -50%));"+
		"-fx-border-color: radial-gradient(radius 90%,GREY, derive(GREY, 100%),derive(GREY, -10%));"+
				"-fx-border-width: 10;"+"-fx-border-radius: 20;"+"-fx-background-radius: 25;"+
		"-fx-padding: 50,50,50,05");
		
		
		vbm.getChildren().addAll(fwp1,fwp2);
		vbm.setMargin(fwp2, new Insets(20,50,0,50));
		//btAScreen.addEventHandler(MouseEvent.MOUSE_CLICKED,changer(a,as.getVb1(),"Ator"));
		/*
		EventHandler<MouseEvent> evh = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent ar) {
				// TODO Auto-generated method stub
				if(ar.getSource().toString().contains("Ator")) {
					change(a,as.getVb1());
				}
				if(ar.getSource().toString().contains("Genero")) {
					change(a,gs.getVb1());
				}
			}
			};
			*/
		btAScreen.addEventHandler(MouseEvent.MOUSE_CLICKED, changer(a, vba));//evh);
		btGScreen.addEventHandler(MouseEvent.MOUSE_CLICKED, changer(a, vbg));//evh);
		return vbm;
	}
	public void change(Stage a,VBox vb2) {
		Scene sc = new Scene(vb2,x,y);
		a.setScene(sc);
	}
}
