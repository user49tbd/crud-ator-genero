package pack01;

import java.time.LocalDate;

import Entity.Ator;
import Entity.Genero;
import contro.Generoc;
import contro.Generoc1;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GenereScreen extends Changer{
	private Stage a;
	private VBox vb1 = new VBox();
	private double x;
	private double y;
	private Button bt1;
	
	//-----------------------------------------------------------------------------------------------------------
	
	private TextField tfnome;
	private TextArea tadesc;
	
	//-----------------------------------------------------------------------------------------------------------
	
	TextField tfproc;
	private TableView tbv1;
	
	private Button btInserir;
	private Button btAtualizar;
	private Button btExcluir;
	private Button btBuscar;
	private Button btListar;
	
	private mainScreen ms;
	private VBox vbchanger;
	
	public GenereScreen(Stage a,double x,double y,VBox vb) {
		this.a = a;
		this.x = x;
		this.y = y;
		this.vbchanger = vb;
	}
	public VBox getVb1() {
		ms = new mainScreen(a,x,y);
		//vb1 = new VBox();
		VBox vb2 = new VBox();
		Label lb1 = new Label();
		bt1 = new Button("VOLTAR");
		lb1.setText("GENERO");
		//System.out.println(x);
		bt1.setPrefWidth(x);
		bt1.setPrefHeight(30);
		vb2.getChildren().addAll(bt1,lb1);
		vb2.setMargin(bt1, new Insets(10,0,0,0));
		vb2.setAlignment(Pos.TOP_CENTER);
		bt1.setStyle("-fx-background-color: radial-gradient(radius 90%, derive(RED, 50%), derive(RED, -50%));"
				+ "-fx-border-width: 5px;"+
				"-fx-border-color: radial-gradient(radius 90%,GREY, derive(GREY, 100%),derive(GREY, -10%));"
				+"-fx-border-radius: 50;"+
				"-fx-text-fill: radial-gradient(radius 90%,GREY, derive(GREY, 100%),derive(GREY, -10%));"+
				"-fx-background-radius: 60;");
		lb1.setStyle("-fx-text-fill: radial-gradient(radius 90%,GREY, derive(GREY, 100%),derive(GREY, -10%));"+
				"-fx-font-size: 20");
		vb2.setStyle("-fx-background-color: radial-gradient(radius 90%, derive(RED, 50%), derive(RED, -50%))");
		//--------------------------------------------------------------------------------------------------------
		
		FlowPane fwp1 = new FlowPane();
		VBox vb3= new VBox();
		GridPane gp = new GridPane();
		Label lbnome = new Label("Nome: ");
		lbnome.setStyle("-fx-text-fill: radial-gradient(radius 90%,GREY, derive(GREY, 100%),derive(GREY, -10%));"+
				"-fx-font-size: 35");
		tfnome = new TextField();
		tfnome.setStyle("-fx-background-color: rgba(0, 0, 0, 0);"+
				"-fx-border-color: radial-gradient(radius 90%,GREY, derive(GREY, 100%),derive(GREY, -10%));"+
				"-fx-border-width: 2px;"+"-fx-font-size: 15");
		Label lbdesc = new Label("Descricao: ");
		lbdesc.setStyle("-fx-text-fill: radial-gradient(radius 90%,GREY, derive(GREY, 100%),derive(GREY, -10%));"+
				"-fx-font-size: 35");
		tadesc = new TextArea();
		
		gp.addRow(0,lbnome,tfnome);
		gp.addRow(1, lbdesc);
		gp.setAlignment(Pos.TOP_CENTER);
		gp.setHgap(50);
		gp.setVgap(10);
		
		tadesc.setPrefWidth(lbnome.getWidth()+tfnome.getWidth()+gp.getHgap());
		vb3.getChildren().addAll(gp,tadesc);
		vb3.setAlignment(Pos.TOP_CENTER);
		
		vb3.setMargin(gp, new Insets(20,0,20,0));
		vb3.setStyle("-fx-background-color: radial-gradient(radius 90%, derive(RED, 50%), derive(RED, -50%));"
				+ "-fx-border-width: 5px;"
				+ "-fx-border-color: radial-gradient(radius 90%,GREY, derive(GREY, 100%),derive(GREY, -10%));"+
				"-fx-padding: 20,20,20,20");
		
		fwp1.getChildren().addAll(vb3);
		//-------------------------------------------------------------------------------------------------------
		VBox vb4 = new VBox();
		HBox hb = new HBox();
		Label lbproc = new Label("Buscar:  ");
		lbproc.setStyle("-fx-text-fill: radial-gradient(radius 90%,GREY, derive(GREY, 100%),derive(GREY, -10%));"+
				"-fx-font-size: 20");
		tfproc = new TextField();
		tfproc.setStyle("-fx-background-color: rgba(0, 0, 0, 0)");
		hb.getChildren().addAll(lbproc,tfproc);
		hb.setAlignment(Pos.TOP_LEFT);
		tbv1 = new TableView();
		
		TableColumn<Genero,String> colgen =new TableColumn("Genero");
		colgen.setStyle("-fx-background-color: radial-gradient(radius 90%, derive(RED, 50%), derive(RED, -50%));"+
		"-fx-font-size: 12");
		
		TableColumn<Genero,String> colnome =new TableColumn("Nome");
		colnome.setCellValueFactory(new PropertyValueFactory("nome"));
		
		TableColumn<Genero,String> coldesc =new TableColumn("Descricao");
		coldesc.setCellValueFactory(new PropertyValueFactory("descricao"));
		
		
		colgen.getColumns().addAll(colnome,coldesc);
		tbv1.getColumns().addAll(colgen);
		tbv1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		tbv1.setPrefWidth(725);
		tbv1.setPrefHeight(300);
		
		FlowPane fwp2 = new FlowPane();
		btInserir = new Button("Inserir");
		btAtualizar = new Button("Atualizar");
		btExcluir = new Button("Excluir");
		btBuscar = new Button("Buscar");
		btListar = new Button("Listar");
		
		btInserir.setPrefWidth(130);
		btInserir.setPrefHeight(50);
		btInserir.setStyle(null);
		
		btAtualizar.setPrefWidth(130);
		btAtualizar.setPrefHeight(50);
		
		btExcluir.setPrefWidth(130);
		btExcluir.setPrefHeight(50);
		
		btBuscar.setPrefWidth(130);
		btBuscar.setPrefHeight(50);
		
		btListar.setPrefWidth(130);
		btListar.setPrefHeight(50);
		
		fwp2.getChildren().addAll(btInserir,btAtualizar,btExcluir,btBuscar,btListar);
		fwp2.setHgap(10);
		fwp2.setAlignment(Pos.TOP_CENTER);
		
		vb4.getChildren().addAll(hb,tbv1,fwp2);
		vb4.setStyle("-fx-background-color: radial-gradient(radius 90%, derive(RED, 50%), derive(RED, -50%));"
				+ "-fx-border-width: 5px;"
				+ "-fx-border-color: radial-gradient(radius 90%,GREY, derive(GREY, 100%),derive(GREY, -10%));"+
				"-fx-padding: 20,20,20,20;");
		vb4.setMargin(hb, new Insets(0,0,20,0));
		vb4.setMargin(tbv1, new Insets(0,0,20,0));
		vb4.setMargin(fwp2, new Insets(0,0,20,0));
		fwp1.getChildren().addAll(vb4);
		fwp1.setHgap(20);
		vb1.getChildren().addAll(vb2,fwp1);
		vb1.setMargin(vb2, new Insets(0,0,10,0));
		vb1.setMargin(fwp1, new Insets(0,20,0,20));
		//-------------------------------------------------------------------------------------------------------
		//bt1.addEventHandler(MouseEvent.MOUSE_CLICKED, changer(a, ms.getVbmain(),"VOLTAR"));
		Generoc gnc= new Generoc();
		
		Bindings.bindBidirectional(tfnome.textProperty(), gnc.getNome());
		Bindings.bindBidirectional(tadesc.textProperty(),gnc.getDescricao());
		
		Generoc1 genc1 = new Generoc1(gnc, tbv1);
		
		btInserir.addEventHandler(MouseEvent.MOUSE_CLICKED, genc1.getEvh());
		btAtualizar.addEventHandler(MouseEvent.MOUSE_CLICKED, genc1.getEvh());
		btExcluir.addEventHandler(MouseEvent.MOUSE_CLICKED, genc1.getEvh());
		btBuscar.addEventHandler(MouseEvent.MOUSE_CLICKED, genc1.getEvh());
		btListar.addEventHandler(MouseEvent.MOUSE_CLICKED, genc1.getEvh());
		
		bt1.addEventHandler(MouseEvent.MOUSE_CLICKED, changer(a, vbchanger));/*new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent ar) {
				// TODO Auto-generated method stub
				if(ar.getSource().toString().contains("VOLTAR")) {
					change(a,ms.getVbmain());
				}
				
			}
			});
			*/
		tfproc.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				gnc.setBusc(tfproc.getText());
			}
			
		});
		return vb1;
	}
	public void change(Stage a,VBox vb2) {
		Scene sc = new Scene(vb2,x,y);
		a.setScene(sc);
	}
	
}
