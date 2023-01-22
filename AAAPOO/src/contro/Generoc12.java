package contro;

import java.sql.SQLException;

import Entity.Genero;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class Generoc12 {
	Generoc2 gc2;
	public Generoc12() {
		try {
			gc2 = new Generoc2();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Inserir(Genero gen) {
		try {
			gc2.Inserir(gen);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Atualizar(Genero gen) {
		try {
			gc2.Atualizar(gen);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Excluir(Genero gen) {
		try {
			gc2.Excluir(gen);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Genero Buscar(Genero gen,TableView tbv1) {
		ObservableList<Genero> obs = FXCollections.observableArrayList();
		try {
			gen = gc2.Buscar(gen);
			obs.add(gen);
			tbv1.setItems(obs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gen;
	}
	public void Listar(Generoc gen,TableView tbv1) {
		ObservableList<Genero> obs = FXCollections.observableArrayList();
		try {
			obs.addAll(gc2.Listar(gen.getBusc()));
			tbv1.setItems(obs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
