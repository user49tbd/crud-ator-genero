package contro;

import javax.swing.JOptionPane;

import Entity.Genero;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class Generoc1 {
	private Generoc genc;
	private TableView tbv1;
	private Generoc12 gen12;
	public Generoc1(Generoc genc,TableView tbv1) {
		this.genc = genc;
		this.tbv1 = tbv1;
		
		gen12 = new Generoc12();
	}
	EventHandler<MouseEvent> evh = new EventHandler(){

		@Override
		public void handle(Event ev) {
			// TODO Auto-generated method stub
			Genero gen = genc.BtoE();
			if((ev.getSource().toString().contains("Inserir") 
					|| ev.getSource().toString().contains("Atualizar"))&&(
					(gen.getNome() == null || gen.getNome().isBlank() == true)||
					(gen.getDescricao() == null || gen.getDescricao().isBlank() == true))) {
				JOptionPane.showMessageDialog(null, "Valores nao podem ser nulos");
			}
			else {
				if((ev.getSource().toString().contains("Excluir") 
						|| ev.getSource().toString().contains("Buscar"))&&
						(gen.getNome() == null || gen.getNome().isBlank() == true)) {
					JOptionPane.showMessageDialog(null, "Nome nao pode ser nulo");
				}
				else {
					if(ev.getSource().toString().contains("Inserir")) {
						System.out.println("Inserindo");
						Genero gen2 = new Genero();
						gen2 = gen12.Buscar(gen, tbv1);
						if(gen2.getNome() != null) {
							JOptionPane.showMessageDialog(null, "Valor ja cadastrado");
						}
						else {
							gen12.Inserir(gen);
						}
					}
					if(ev.getSource().toString().contains("Atualizar")) {
						System.out.println("Atualizando");
						Genero gen2 = new Genero();
						gen2 = gen12.Buscar(gen, tbv1);
						if(gen2.getNome() == null) {
							JOptionPane.showMessageDialog(null, "Valor nao cadastrado");
						}
						else {
							gen12.Atualizar(gen);
						}
					}
					if(ev.getSource().toString().contains("Excluir")) {
						System.out.println("Excluindo");
						Genero gen2 = new Genero();
						gen2 = gen12.Buscar(gen, tbv1);
						if(gen2.getNome() == null) {
							JOptionPane.showMessageDialog(null, "Valor nao cadastrado");
						}
						else {
							gen12.Excluir(gen);
						}
					}
					if(ev.getSource().toString().contains("Buscar")) {
						System.out.println("Buscando");
						//Genero gen2 = new Genero();
						//gen2 = gen12.Buscar(gen, tbv1);
						gen = gen12.Buscar(gen, tbv1);
						if(gen.getNome() != null) {
							genc.EtoB(gen);
						}
						else {
							JOptionPane.showMessageDialog(null,"Genero nao cadastrado");
						}
					}
					if(ev.getSource().toString().contains("Listar")) {
						System.out.println("Listando");
						gen12.Listar(genc, tbv1);
					}
				}
			}
		}
		
	};
	public EventHandler<MouseEvent> getEvh() {
		return evh;
	}
	
}
