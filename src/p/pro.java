package p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class pro {
	private Connection connexion;
public int update( client c ,String em)
{int t=0;
loadDatabase();
try {
PreparedStatement preparedStatement = connexion.prepareStatement("update client set nom= ? ,prenom = ?,adr =? ,dn= ? , mdp= ? where email = ?");
preparedStatement.setString(1, c.getNom());
preparedStatement.setString(2,c.getPrenom());
preparedStatement.setString(3,c.getAdr());
preparedStatement.setString(4,c.getDn());
preparedStatement.setString(5,c.getMdp());
preparedStatement.setString(6, em);

preparedStatement.executeUpdate();		
t=1;
} catch (SQLException e) {
e.printStackTrace();
}
return t;

}
	public List<client> rec(String c) {
	List<client> utilisateurs = new ArrayList<client>();
	Statement statement = null;
	ResultSet resultat = null;
	loadDatabase();
	try {
	statement = connexion.createStatement();
	// Exécution de la requête
	PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM client where email = ? ;");
	preparedStatement.setString(1,c);
	resultat = preparedStatement.executeQuery();
	while (resultat.next()) {
	String nom = resultat.getString("nom");
	String prenom = resultat.getString("prenom");
	String adr =resultat.getString("adr");
    String dn =resultat.getString("dn");
    String mdp=resultat.getString("mdp");
	client utilisateur = new client();
	utilisateur.setNom(nom);
	utilisateur.setPrenom(prenom);
	utilisateur.setAdr(adr);
	utilisateur.setDn(dn);
	utilisateur.setMdp(mdp);
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
