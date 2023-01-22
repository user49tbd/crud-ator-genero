package contro;

import java.time.LocalDate;

import Entity.Ator;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Atorc {
	private IntegerProperty pcodigo = new SimpleIntegerProperty();
	private StringProperty pnomeart = new SimpleStringProperty();
	private StringProperty pnome	= new SimpleStringProperty();
	private StringProperty pnacio	= new SimpleStringProperty();
	private ObjectProperty<LocalDate> pnasc = new SimpleObjectProperty<LocalDate>();
	private StringProperty pdescricao	= new SimpleStringProperty();
	private String busc;
	
	public Ator BtoE() {
		Ator at = new Ator();
		at.setCodigo(pcodigo.get());
		at.setNomeArt(pnomeart.get());
		at.setNome(pnome.get());
		at.setNacio(pnacio.get());
		at.setNasc(pnasc.get());
		at.setDescricao(pdescricao.get());
		System.out.println(pcodigo.get()+" ator-->"+at.getCodigo());
		return at;
	}
	public void EtoB(Ator a) {
		pcodigo.set(a.getCodigo());
		pnomeart.set(a.getNomeArt());
		pnome.set(a.getNome());
		pnacio.set(a.getNacio());
		pnasc.set(a.getNasc());
		pdescricao.set(a.getDescricao());
	}
	public void clear() {
		Ator at = new Ator();
		EtoB(at);
	}
	public IntegerProperty getPcodigo() {
		return pcodigo;
	}
	public void setPcodigo(IntegerProperty pcodigo) {
		this.pcodigo = pcodigo;
	}
	public StringProperty getPnomeart() {
		return pnomeart;
	}
	public void setPnomeart(StringProperty pnomeart) {
		this.pnomeart = pnomeart;
	}
	public StringProperty getPnome() {
		return pnome;
	}
	public void setPnome(StringProperty pnome) {
		this.pnome = pnome;
	}
	public StringProperty getPnacio() {
		return pnacio;
	}
	public void setPnacio(StringProperty pnacio) {
		this.pnacio = pnacio;
	}
	public ObjectProperty<LocalDate> getPnasc() {
		return pnasc;
	}
	public void setPnasc(ObjectProperty<LocalDate> pnasc) {
		this.pnasc = pnasc;
	}
	public StringProperty getPdescricao() {
		return pdescricao;
	}
	public void setPdescricao(StringProperty pdescricao) {
		this.pdescricao = pdescricao;
	}
	public void setBusc(String busc) {
		this.busc = busc;
	}
	public String getBusc() {
		return busc;
	}
	
}
