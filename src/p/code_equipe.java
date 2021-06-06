package p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class code_equipe {
	private Connection connexion;
	
	public int sup(equipe eq)
	{int t=0;
	loadDatabase();
	try {
	PreparedStatement preparedStatement = connexion.prepareStatement("delete from equipe where id_e = ? and id_c= ? and utili= ?;");
	preparedStatement.setString(1,eq.getId_e());
	preparedStatement.setString(2,eq.getId_c());
	preparedStatement.setString(3,eq.getUtili());
	preparedStatement.executeUpdate();		
	t=1;
	} catch (SQLException e) {
	e.printStackTrace();
	}
		return t;
	}
	public int  modif(equipe eq) {
		int t=0;
		loadDatabase();
		try {
		PreparedStatement preparedStatement = connexion.prepareStatement("update equipe set nom_e=? , nomp_e = ? , nom_t= ? where id_e = ? and id_c= ? and utili= ?;");
		preparedStatement.setString(4,eq.getId_e() );
		preparedStatement.setString(1,eq.getNom_e() );
		preparedStatement.setString(2,eq.getNomp_e());
		preparedStatement.setString(3,eq.getNom_t());
		preparedStatement.setString(5,eq.getId_c());
		preparedStatement.setString(6,eq.getUtili());
		preparedStatement.executeUpdate();		
		t=1;
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return t;
	
	}
	
	public int  ajout(equipe eq) {
		int t=0;
		loadDatabase();
		try {
		PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO equipe VALUES(?, ? , ?, ? , ? , ?, ? , ?);");
		preparedStatement.setString(1,eq.getId_e() );
		preparedStatement.setString(2,eq.getNom_e() );
		preparedStatement.setString(3,eq.getNomp_e());
		preparedStatement.setInt(4, 0);
		preparedStatement.setString(5,eq.getDf());
		preparedStatement.setString(6,eq.getNom_t());
		preparedStatement.setString(7,eq.getId_c());
		preparedStatement.setString(8,eq.getUtili());
		preparedStatement.executeUpdate();		
		t=1;
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return t;
	
	}
	
	public List<equipe> rec(String id_c,String utili) {
		List<equipe> utilisateurs = new ArrayList<equipe>();
		Statement statement = null;
		ResultSet resultat = null;
		loadDatabase();
		try {
		statement = connexion.createStatement();
		// Exécution de la requête
		PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM equipe where id_c=? and utili=? ;");
		preparedStatement.setString(1,id_c);
		preparedStatement.setString(2,utili);
	
		resultat = preparedStatement.executeQuery();
		while (resultat.next()) {
		String id_e = resultat.getString("id_e");
		String nom_e = resultat.getString("nom_e");
		String nomp_e =resultat.getString("nomp_e");
	    int nbj =resultat.getInt("nbj");
	    String df=resultat.getString("df");
	    String nom_t =resultat.getString("nom_t");
	
	    equipe utilisateur=new equipe();
	    utilisateur.setId_e(id_e);
	    utilisateur.setNom_e(nom_e);
	    utilisateur.setNomp_e(nomp_e);
	    utilisateur.setNbj(nbj);
	    utilisateur.setNom_t(nom_t);
	    utilisateur.setDf(df);
		utilisateurs.add(utilisateur);
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
