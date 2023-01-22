package contro;

import Entity.Genero;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Generoc {
	private StringProperty nome = new SimpleStringProperty();
	private StringProperty descricao = new SimpleStringProperty();
	private String busc;
	
	public Genero BtoE() {
		Genero gen = new Genero();
		gen.setNome(nome.get());
		gen.setDescricao(descricao.get());
		return gen;
	}
	public void EtoB(Genero g) {
		nome.set(g.getNome());
		descricao.set(g.getDescricao());
	}
	public StringProperty getNome() {
		return nome;
	}
	public void setNome(StringProperty nome) {
		this.nome = nome;
	}
	public StringProperty getDescricao() {
		return descricao;
	}
	public void setDescricao(StringProperty descricao) {
		this.descricao = descricao;
	}
	public String getBusc() {
		return busc;
	}
	public void setBusc(String busc) {
		this.busc = busc;
	}
	
}
