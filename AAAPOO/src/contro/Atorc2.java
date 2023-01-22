package contro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import Entity.Ator;

public class Atorc2 {
	private Connection c;
	public Atorc2() {
		conn con = new conn();
		try {
			c = con.getCon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Inserir(Ator at) throws SQLException {
		String sql = "insert into ator values (?,?,?,?,?,?);";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, at.getCodigo());
		ps.setString(2, at.getNomeArt());
		ps.setString(3, at.getNome());
		ps.setString(4, at.getNacio());
		ps.setString(5, at.getNasc().toString());
		ps.setString(6, at.getDescricao());
		ps.execute();
		ps.close();
	}
	public void Atualizar(Ator at) throws SQLException {
		StringBuffer sb1 = new StringBuffer();
		sb1.append("update ator ");
		sb1.append("set nomeArt = ?,nome = ?, ");
		sb1.append("nacio = ?,nasc = ? ,descricao = ? ");
		sb1.append("where codigo = ? ;");
		PreparedStatement ps = c.prepareStatement(sb1.toString());
		ps.setString(1, at.getNomeArt());
		ps.setString(2, at.getNome());
		ps.setString(3, at.getNacio());
		ps.setString(4, at.getNasc().toString());
		ps.setString(5, at.getDescricao());
		ps.setInt(6, at.getCodigo());
		ps.execute();
		ps.close();
	}
	public void Excluir(Ator at) throws SQLException {
		StringBuffer sb1 = new StringBuffer();
		sb1.append("delete from ator ");
		sb1.append("where codigo = ?; ");
		PreparedStatement ps = c.prepareStatement(sb1.toString());
		ps.setInt(1, at.getCodigo());
		ps.execute();
		ps.close();
	}
	public Ator Buscar(Ator at) throws SQLException {
		StringBuffer sb1 = new StringBuffer();
		sb1.append("select codigo,nomeArt,nome,nacio, ");
		sb1.append("nasc, ");
		sb1.append("descricao from ator ");
		sb1.append("where codigo = ?; ");
		PreparedStatement ps = c.prepareStatement(sb1.toString());
		ps.setInt(1, at.getCodigo());
		ResultSet rs = ps.executeQuery();
		Ator a = new Ator();
		DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		if(rs.next()) {
			a.setCodigo(at.getCodigo());
			a.setDescricao(rs.getString("descricao"));
			a.setNacio(rs.getString("nacio"));
			a.setNasc(rs.getDate("nasc").toLocalDate());
			a.setNasc2(rs.getDate("nasc").toLocalDate().format(form));
			a.setNome(rs.getString("nome"));
			a.setNomeArt(rs.getString("nomeArt"));
		}
		ps.execute();
		ps.close();
		return a;
	}
	public List<Ator> Listar(String busc) throws SQLException, ParseException{
		String sql = "select codigo,nomeArt,nome,nacio,nasc,descricao from ator;";
		PreparedStatement ps;
		System.out.println("buscar------>"+busc);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		if(busc != null) {
			System.out.println(busc);
			sql = "select codigo,nomeArt,nome,nacio,nasc,descricao from ator where nomeArt like ?;";
			ps = c.prepareStatement(sql);
			ps.setString(1,"%"+busc+"%");
		}
		else {
			ps = c.prepareStatement(sql);
		}
		ResultSet rs = ps.executeQuery();
		List<Ator> ls = new ArrayList();
		DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		while(rs.next()) {
			Ator at = new Ator();
			at.setCodigo(rs.getInt("codigo"));
			at.setDescricao(rs.getString("descricao"));
			at.setNacio(rs.getString("nacio"));
			//a.setNasc(rs.getDate("nasc").toLocalDate());
			at.setNasc2(rs.getDate("nasc").toLocalDate().format(form));
			at.setNome(rs.getString("nome"));
			at.setNomeArt(rs.getString("nomeArt"));
			ls.add(at);
		}
		ps.execute();
		ps.close();
		return ls;
	}
	
}
