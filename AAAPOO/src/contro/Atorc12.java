package contro;

import java.sql.SQLException;
import java.text.ParseException;

import Entity.Ator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class Atorc12 {
	private Ator at;
	private Atorc2 at2;
	public Atorc12(Ator at) {
		this.at = at;
		at2 = new Atorc2();
	}
	public void Inserir(Ator a) {
		try {
			at2.Inserir(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Atualizar(Ator a) {
		try {
			at2.Atualizar(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Excluir(Ator a) {
		try {
			at2.Excluir(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Ator Buscar(Ator a, TableView tbv1) {
		ObservableList<Ator> obs = FXCollections.observableArrayList();
		try {
			a = at2.Buscar(a);
			obs.add(a);
			tbv1.setItems(obs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public void Listar(TableView tbv1,String busc) {
		ObservableList<Ator> obs = FXCollections.observableArrayList();
		try {
			obs.addAll(at2.Listar(busc));
			tbv1.setItems(obs);
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
