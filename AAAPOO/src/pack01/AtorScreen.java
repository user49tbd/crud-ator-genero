package pack01;

import java.time.LocalDate;

import Entity.Ator;
import contro.Atorc;
import contro.Atorc1;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class AtorScreen extends Changer{
	private Stage a;
	private VBox vb1 = new VBox();
	private double x;
	private double y;
	private Button bt1;
	
	//-----------------------------------------------------------------------------------------------------------
	
	private TextField tfcod;
	private TextField tfnomeart;
	private TextField tfnome;
	private ComboBox cbnacio;
	private DatePicker dpnasc;
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
	
	public AtorScreen(Stage a,double x,double y,VBox vb) {
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
		lb1.setText("ATOR");
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
		Label lbcod = new Label("Codigo: ");
		lbcod.setStyle("-fx-text-fill: radial-gradient(radius 90%,GREY, derive(GREY, 100%),derive(GREY, -10%));"+
				"-fx-font-size: 20");
		tfcod = new TextField();
		tfcod.setStyle("-fx-background-color: rgba(0, 0, 0, 0);"+
				"-fx-border-color: radial-gradient(radius 90%,GREY, derive(GREY, 100%),derive(GREY, -10%));"+
				"-fx-border-width: 2px;");
		Label lbnomeart = new Label("Nome Artistico: ");
		lbnomeart.setStyle("-fx-text-fill: radial-gradient(radius 90%,GREY, derive(GREY, 100%),derive(GREY, -10%));"+
				"-fx-font-size: 20");
		tfnomeart = new TextField();
		tfnomeart.setStyle("-fx-background-color: rgba(0, 0, 0, 0);"+
				"-fx-border-color: radial-gradient(radius 90%,GREY, derive(GREY, 100%),derive(GREY, -10%));"+
				"-fx-border-width: 2px;");
		Label lbnome = new Label("Nome: ");
		lbnome.setStyle("-fx-text-fill: radial-gradient(radius 90%,GREY, derive(GREY, 100%),derive(GREY, -10%));"+
				"-fx-font-size: 20");
		tfnome = new TextField();
		tfnome.setStyle("-fx-background-color: rgba(0, 0, 0, 0);"+
				"-fx-border-color: radial-gradient(radius 90%,GREY, derive(GREY, 100%),derive(GREY, -10%));"+
				"-fx-border-width: 2px;");
		Label lbnacio = new Label("Nacionalidade: ");
		lbnacio.setStyle("-fx-text-fill: radial-gradient(radius 90%,GREY, derive(GREY, 100%),derive(GREY, -10%));"+
				"-fx-font-size: 20");
		cbnacio = new ComboBox();
		String [] nacao = {"FRANCES","INGLES","ESTADUNIDENSE","ALEMAO","BRASILEIRO","ITALIANO",
				"MEXICANO","CHINES","JAPONES","TURCO"};
		cbnacio = new ComboBox(FXCollections.observableArrayList(nacao));
		cbnacio.getSelectionModel().select(0);
		Label lbnasc = new Label("Data de Nascimento: ");
		lbnasc.setStyle("-fx-text-fill: radial-gradient(radius 90%,GREY, derive(GREY, 100%),derive(GREY, -10%));"+
				"-fx-font-size: 20");
		dpnasc = new DatePicker();
		Label lbdesc = new Label("Descricao: ");
		lbdesc.setStyle("-fx-text-fill: radial-gradient(radius 90%,GREY, derive(GREY, 100%),derive(GREY, -10%));"+
				"-fx-font-size: 20");
		dpnasc.setEditable(false);
		tadesc = new TextArea();
		
		gp.addRow(0,lbcod,tfcod);
		gp.addRow(1,lbnomeart,tfnomeart);
		gp.addRow(2,lbnome,tfnome);
		gp.addRow(3,lbnacio,cbnacio);
		gp.addRow(4,lbnasc,dpnasc);
		gp.addRow(5, lbdesc);
		gp.setAlignment(Pos.TOP_CENTER);
		gp.setHgap(50);
		gp.setVgap(10);
		
		tadesc.setPrefWidth(lbnomeart.getWidth()+tfnomeart.getWidth()+gp.getHgap());
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
		
		TableColumn<Ator,String> colator =new TableColumn("Ator");
		colator.setStyle("-fx-background-color: radial-gradient(radius 90%, derive(RED, 50%), derive(RED, -50%));"+
		"-fx-font-size: 12");
		
		TableColumn<Ator,Integer> colcod =new TableColumn("Codigo");
		colcod.setCellValueFactory(new PropertyValueFactory("codigo"));
		
		TableColumn<Ator,String> colnomeart =new TableColumn("Nome Artistico");
		colnomeart.setCellValueFactory(new PropertyValueFactory("nomeArt"));
		
		TableColumn<Ator,String> colnome =new TableColumn("Nome");
		colnome.setCellValueFactory(new PropertyValueFactory("nome"));
		
		TableColumn<Ator,String> colnacio =new TableColumn("Nacionalidade");
		colnacio.setCellValueFactory(new PropertyValueFactory("nacio"));
		/*
		TableColumn<Ator,LocalDate> colnasc =new TableColumn("Data de Nascimento");
		colnasc.setCellValueFactory(new PropertyValueFactory("nasc"));
		*/
		TableColumn<Ator,String> colnasc =new TableColumn("Data de Nascimento");
		colnasc.setCellValueFactory(new PropertyValueFactory("nasc2"));
		
		colator.getColumns().addAll(colcod,colnomeart,colnome,colnacio,colnasc);
		tbv1.getColumns().addAll(colator);
		tbv1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		tbv1.setPrefWidth(724);
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
		Atorc ca = new Atorc();
		
		StringConverter<? extends Number> sn = new NumberStringConverter();
		
		Bindings.bindBidirectional(tfcod.textProperty(), ca.getPcodigo(),(StringConverter<Number>)sn);
		Bindings.bindBidirectional(tfnomeart.textProperty(), ca.getPnomeart());
		Bindings.bindBidirectional(tfnome.textProperty(), ca.getPnome());
		Bindings.bindBidirectional(cbnacio.valueProperty(), ca.getPnacio());
		Bindings.bindBidirectional(dpnasc.valueProperty(), ca.getPnasc());
		Bindings.bindBidirectional(tadesc.textProperty(), ca.getPdescricao());
		
		//Ator at = new Ator();
		//at = ca.BtoE();
		Atorc1 atc1 = new Atorc1(ca,tbv1);
		
		
		btInserir.addEventFilter(MouseEvent.MOUSE_CLICKED, atc1.getRvh());
		btAtualizar.addEventFilter(MouseEvent.MOUSE_CLICKED, atc1.getRvh());
		btExcluir.addEventFilter(MouseEvent.MOUSE_CLICKED, atc1.getRvh());
		btBuscar.addEventFilter(MouseEvent.MOUSE_CLICKED, atc1.getRvh());
		btListar.addEventFilter(MouseEvent.MOUSE_CLICKED, atc1.getRvh());
		
		
		//-------------------------------------------------------------------------------------------------------
		bt1.addEventHandler(MouseEvent.MOUSE_CLICKED,changer(a, vbchanger));/* new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent ar) {
				// TODO Auto-generated method stub
				if(ar.getSource().toString().contains("VOLTAR")) {
					change(a,ms.getVbmain());
				}
				
			}
			});
			*/
		tfproc.textProperty().addListener(new ChangeListener() {

			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				ca.setBusc(tfproc.getText());
			}
			
		});
		return vb1;
	}
	public void change(Stage a,VBox vb2) {
		Scene sc = new Scene(vb2,x,y);
		a.setScene(sc);
	}
	
}
