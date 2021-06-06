package p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class code_joueur {
private Connection connexion;

public int  modif(joueur jo) {
	int t=0;
	loadDatabase();
	try {
	PreparedStatement preparedStatement = connexion.prepareStatement("update joueur set stj =?  where idj = ? and id_c= ? and utili= ?;");
	preparedStatement.setString(1,jo.getStj() );
	preparedStatement.setString(2,jo.getIdj() );
	preparedStatement.setString(3,jo.getId_c() );
	preparedStatement.setString(4,jo.getUtili());
	preparedStatement.executeUpdate();		
	t=1;
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return t;

}

public int sup(joueur jo )
{int t=0;
loadDatabase();
try {
PreparedStatement preparedStatement = connexion.prepareStatement("delete from joueur where idj = ? and id_c= ? and utili= ?;");
preparedStatement.setString(1,jo.getIdj());
preparedStatement.setString(2,jo.getId_c());
preparedStatement.setString(3,jo.getUtili());
preparedStatement.executeUpdate();		
t=1;
} catch (SQLException e) {
e.printStackTrace();
}
	return t;
}


public List<joueur> recj(String id_c,String utili) {
	List<joueur> utilisateurs = new ArrayList<joueur>();
	Statement statement = null;
	ResultSet resultat = null;
	loadDatabase();
	try {
	statement = connexion.createStatement();
	// Exécution de la requête
	PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM joueur where id_c=? and utili=? ;");
	preparedStatement.setString(1,id_c);
	preparedStatement.setString(2,utili);

	resultat = preparedStatement.executeQuery();
	while (resultat.next()) {
	String idj = resultat.getString("idj");
	String nomj = resultat.getString("nomj");
	String pernomj =resultat.getString("prenomj");
    String pays=resultat.getString("pays");
  String stj=resultat.getString("stj");
String dnj=resultat.getString("dnj");
    joueur jo = new joueur();
    jo.setIdj(idj);
    jo.setNomj(nomj);
    jo.setPrenomj(pernomj);
    jo.setPays(pays);
    jo.setDnj(dnj);
    jo.setStj(stj);
	utilisateurs.add(jo);
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

public int updatnbeq_moins(joueur jo)
{
int t=0;
	loadDatabase();
	try {
		PreparedStatement 	preparedStatement = connexion.prepareStatement("update equipe set nbj=nbj-1 where id_c=? and utili=? and id_e= ? ; ");
	preparedStatement.setString(1,jo.getId_c());
	preparedStatement.setString(2,jo.getUtili());
	preparedStatement.setString(3,jo.getStj());
	preparedStatement.executeUpdate();
	t=1;
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return t;
}

	public int updatnbeq(joueur jo)
	{
int t=0;
		loadDatabase();
		try {
			PreparedStatement 	preparedStatement = connexion.prepareStatement("update equipe set nbj=nbj+1 where id_c=? and utili=? and id_e= ? ; ");
		preparedStatement.setString(1,jo.getId_c());
		preparedStatement.setString(2,jo.getUtili());
		preparedStatement.setString(3,jo.getStj());
		preparedStatement.executeUpdate();
		t=1;
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return t;
	}
	public int  ajout(joueur jo) {
		int t=0;
		loadDatabase();
		try {
		PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO joueur VALUES(?, ? , ?, ? , ? , ?, ? , ?);");
		preparedStatement.setString(1,jo.getIdj());
		preparedStatement.setString(2,jo.getNomj());
		preparedStatement.setString(3,jo.getPrenomj());
		preparedStatement.setString(4,jo.getDnj());
		preparedStatement.setString(5,jo.getPays());
		preparedStatement.setString(6,jo.getId_c());
		preparedStatement.setString(7,jo.getUtili());
		preparedStatement.setString(8,jo.getStj());
		
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
