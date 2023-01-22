package contro;

import javax.swing.JOptionPane;

import Entity.Ator;
import javafx.beans.property.StringProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import pack01.AtorScreen;

public class Atorc1 {
	private Ator atc;
	private Ator atc2 = new Ator();
	private Atorc at;
	private Atorc12 at12;
	private TableView tbv1;
	private AtorScreen atsc;
	public Atorc1(Atorc at,TableView tbv1) {
		this.at = at;
		this.tbv1 = tbv1;
		at12 = new Atorc12(atc);
	}
	EventHandler<MouseEvent> rvh = new EventHandler() {

		@Override
		public void handle(Event event) {
			
			atc = at.BtoE();
			// TODO Auto-generated method stub
			if((event.getSource().toString().contains("Inserir") 
					|| event.getSource().toString().contains("Atualizar"))
					&& (atc.getCodigo() == 0 || (atc.getDescricao() == null || atc.getDescricao().isBlank() == true)||
					(atc.getNacio() == null || atc.getNacio().isBlank() == true)||
					(atc.getNasc() == null)||
					(atc.getNome()== null || atc.getNome().isBlank() == true)||
					(atc.getNomeArt()== null || atc.getNomeArt().isBlank() == true)
					
					//atc.getNacio() == null || atc.getNasc() == null ||
					//atc.getNome() == null || atc.getNomeArt() == null
					)) {
				JOptionPane.showMessageDialog(null, "Valores nao podem ser nulos");
			}
			else {
				if((event.getSource().toString().contains("Buscar") 
						|| event.getSource().toString().contains("Excluir"))
						&& (atc.getCodigo() == 0)
						) {
					JOptionPane.showMessageDialog(null, "Codigo nao pode ser nulo");
				}
				else {
					if(event.getSource().toString().contains("Inserir")) {
						System.out.println("inserindo");
						atc2 = at12.Buscar(atc,tbv1);
						if(atc2.getCodigo() != 0) {
							JOptionPane.showMessageDialog(null, "Ator já cadastrado");
						}
						else {
							at12.Inserir(atc);
						}
					}
					if(event.getSource().toString().contains("Atualizar")) {
						System.out.println("Atualizando---->"+atc.getNasc());
						atc2 = at12.Buscar(atc,tbv1);
						
						if(atc2.getCodigo() == 0) {
							JOptionPane.showMessageDialog(null, "Ator não cadastrado");
						}
						else {
							at12.Atualizar(atc);
						}
					}
					if(event.getSource().toString().contains("Buscar")) {
						System.out.println("Buscando");
						atc = at12.Buscar(atc,tbv1);
						if(atc.getCodigo() == 0) {
							JOptionPane.showMessageDialog(null, "Ator não encontrado");
						}
						else {
							at.EtoB(atc);
						}
					}
					if(event.getSource().toString().contains("Excluir")) {
						System.out.println("Excluindo");
						if(atc2.getCodigo() == 0) {
							JOptionPane.showMessageDialog(null, "Ator não cadastrado");
						}
						else {
							at12.Excluir(atc);
						}
					}
					if(event.getSource().toString().contains("Listar")) {
						System.out.println("Listando");
						at12.Listar(tbv1,at.getBusc());
					}
				}
			}
			
			
			
		}
		
	};
	public EventHandler<MouseEvent> getRvh() {
		return rvh;
	}
}
