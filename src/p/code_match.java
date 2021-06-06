package p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class code_match {
	private Connection connexion;
	public List<match> listematch_non_joues(String id_c,String utili) {
		List<match> utilisateurs = new ArrayList<match>();
		Statement statement = null;
		ResultSet resultat = null;
		loadDatabase();
		try {
		statement = connexion.createStatement();
		// Exécution de la requête
		PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM matcht where id_c=? and utili=? and etat=? ;");
		preparedStatement.setString(1,id_c);
		preparedStatement.setString(2,utili);
		preparedStatement.setString(3,"non_joues");
		resultat = preparedStatement.executeQuery();
		while (resultat.next()) {
		String idm = resultat.getString("idm");
		
	match ma= new match();
	    ma.setIdm(idm);
	
		utilisateurs.add(ma);
		}
		} catch (SQLException e) {
		} finally {
		// Fermeture de la connexion
		try {
		if (resultat != null)
		resultat.close();
		if(statement != null)
		statement.close();
		if (connexion != null)
		connexion.close();
		} catch (SQLException ignore) {
		}
		}
		return utilisateurs;
		}	
	
	
	public List<match> recma(String id_c,String utili) {
		List<match> utilisateurs = new ArrayList<match>();
		Statement statement = null;
		ResultSet resultat = null;
		loadDatabase();
		try {
		statement = connexion.createStatement();
		// Exécution de la requête
		PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM matcht where id_c=? and utili=? ;");
		preparedStatement.setString(1,id_c);
		preparedStatement.setString(2,utili);

		resultat = preparedStatement.executeQuery();
		while (resultat.next()) {
		String idm = resultat.getString("idm");
		String jtm = resultat.getString("jtm");
		String eq1 =resultat.getString("eq1");
	    String eq2=resultat.getString("eq2");
	    String tm= resultat.getString("tm");
	    String dm= resultat.getString("dm");
	    String rm= resultat.getString("rm");
	    String arm= resultat.getString("arm");
	    String etat= resultat.getString("etat");
	match ma= new match();
	    ma.setIdm(idm);
	    ma.setJtm(jtm);
	    ma.setEq1(eq1);
	    ma.setEq2(eq2);
	    ma.setTm(tm);
	    ma.setDm(dm);
	    ma.setArm(arm);
	    ma.setEtat(etat);
	    ma.setRm(rm);
		utilisateurs.add(ma);
		}
		} catch (SQLException e) {
		} finally {
		// Fermeture de la connexion
		try {
		if (resultat != null)
		resultat.close();
		if(statement != null)
		statement.close();
		if (connexion != null)
		connexion.close();
		} catch (SQLException ignore) {
		}
		}
		return utilisateurs;
		}	
		
	
	public int  ajout(match m) {
		int t=0;
		loadDatabase();
		try {
		PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO matcht VALUES (?, ? , ? , ? , ? , ? , ? , ? , ? , ?, ?);");
		preparedStatement.setString(1,m.getIdm());
		preparedStatement.setString(2,m.getJtm());
		preparedStatement.setString(3,m.getEq1());
		preparedStatement.setString(4,m.getEq2());
		preparedStatement.setString(5,m.getTm());
		preparedStatement.setString(6,m.getDm());
		preparedStatement.setString(7,"ne pas joue encore");
		preparedStatement.setString(8,m.getArm());
		preparedStatement.setString(9,"non_joues");
		preparedStatement.setString(10,m.getId_c());
		preparedStatement.setString(11,m.getUtili());
		preparedStatement.executeUpdate();		
		t=1;
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return t;
	
	}
	
	public int  modif(match m) {
		int t=0;
		loadDatabase();
		try {
		PreparedStatement preparedStatement = connexion.prepareStatement("update matcht set etat= ? , rm=? where id_c=? and utili=? and idm= ?;");
		preparedStatement.setString(1,"joué");
		preparedStatement.setString(2,m.getRm());
		preparedStatement.setString(3,m.getId_c());
		preparedStatement.setString(4,m.getUtili());
		preparedStatement.setString(5,m.getIdm());
		preparedStatement.executeUpdate();		
		t=1;
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return t;
	
	}
	
	private void loadDatabase() {
		// Chargement du driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		}
		try {
			connexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/projet", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
