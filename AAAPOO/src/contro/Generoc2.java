package contro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.Genero;

public class Generoc2 {
	private Connection c;
	public Generoc2() throws SQLException {
		conn con = new conn();
		c = con.getCon();
	}
	public void Inserir(Genero gen) throws SQLException {
		String sql = "insert into genero values (?,?);";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, gen.getNome());
		ps.setString(2, gen.getDescricao());
		ps.execute();
		ps.close();
	}
	public void Atualizar(Genero gen) throws SQLException {
		StringBuffer sb1 = new StringBuffer();
		sb1.append("update genero ");
		sb1.append("set descricao = ? ");
		sb1.append("where nome = ?;");
		PreparedStatement ps = c.prepareStatement(sb1.toString());
		ps.setString(1, gen.getDescricao());
		ps.setString(2, gen.getNome());
		ps.execute();
		ps.close();
	}
	public void Excluir(Genero gen) throws SQLException {
		StringBuffer sb1 = new StringBuffer();
		sb1.append("delete from genero ");
		sb1.append("where nome = ?;");
		PreparedStatement ps = c.prepareStatement(sb1.toString());
		ps.setString(1,gen.getNome());
		ps.execute();
		ps.close();
	}
	public Genero Buscar(Genero gen) throws SQLException {
		StringBuffer sb1 = new StringBuffer();
		sb1.append("select nome,descricao from genero ");
		sb1.append("where nome = ?;");
		PreparedStatement ps = c.prepareStatement(sb1.toString());
		ps.setString(1,gen.getNome());
		ResultSet rs = ps.executeQuery();
		Genero genr = new Genero();
		if(rs.next()) {
			genr.setNome(rs.getString("nome"));
			genr.setDescricao(rs.getString("descricao"));
		}
		ps.execute();
		ps.close();
		return genr;
	}
	public List<Genero> Listar(String busc) throws SQLException {
		StringBuffer sb1 = new StringBuffer();
		PreparedStatement ps;
		sb1.append("select nome,descricao from genero; ");
		if(busc != null) {
			sb1.delete(0, sb1.length());
			sb1.append("select nome,descricao from genero ");
			sb1.append(" where nome like ?;");
			ps = c.prepareStatement(sb1.toString());
			ps.setString(1,"%"+busc+"%");
		}
		else {
			ps = c.prepareStatement(sb1.toString());
		}
		ResultSet rs = ps.executeQuery();
		List<Genero>ls = new ArrayList();
		while(rs.next()) {
			Genero genr = new Genero();
			genr.setNome(rs.getString("nome"));
			genr.setDescricao(rs.getString("descricao"));
			ls.add(genr);
		}
		ps.execute();
		ps.close();
		return ls;
	}
}














