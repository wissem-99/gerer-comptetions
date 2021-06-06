package p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;



public class code_inscrit {
	private Connection connexion;
	
	public boolean verif(client c) {
		boolean test;
		test=false;
	Statement statement = null;
	ResultSet resultat = null;
	loadDatabase();
	try {
	statement = connexion.createStatement();
	// Exécution de la requête
	PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM client where email = ? ;");
	preparedStatement.setString(1, c.getMail());
	resultat = preparedStatement.executeQuery();
	// Récupération des données
	boolean n= resultat.next();
	if (n)
	{test=true;}
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
	return test;
	}
	
	
	
	public int  ajout(client c) {
		int t=0;
		loadDatabase();
		try {
		PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO client(nom, prenom,email,mdp,adr,dn) VALUES(?, ? , ?, ? , ? , ?);");
		preparedStatement.setString(1, c.getNom());
		preparedStatement.setString(2, c.getPrenom());
		preparedStatement.setString(3,c.getMail());
		preparedStatement.setString(4, c.getMdp());
		preparedStatement.setString(5, c.getAdr());
		preparedStatement.setString(6, c.getDn());
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
