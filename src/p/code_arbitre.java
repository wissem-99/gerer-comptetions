package p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class code_arbitre {
	private Connection connexion;
	
	public int sup(arbitre ar  )
	{int t=0;
	loadDatabase();
	try {
	PreparedStatement preparedStatement = connexion.prepareStatement("delete from arbitre where idar = ? and id_c= ? and utili= ?;");
	preparedStatement.setString(1,ar.getIdar());
	preparedStatement.setString(2,ar.getId_c());
	preparedStatement.setString(3,ar.getUtili());
	preparedStatement.executeUpdate();		
	t=1;
	} catch (SQLException e) {
	e.printStackTrace();
	}
		return t;
	}
	public List<arbitre> recar(String id_c,String utili) {
		List<arbitre> utilisateurs = new ArrayList<arbitre>();
		Statement statement = null;
		ResultSet resultat = null;
		loadDatabase();
		try {
		statement = connexion.createStatement();
		// Exécution de la requête
		PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM arbitre where id_c=? and utili=? ;");
		preparedStatement.setString(1,id_c);
		preparedStatement.setString(2,utili);

		resultat = preparedStatement.executeQuery();
		while (resultat.next()) {
		String idar = resultat.getString("idar");
		String nomar = resultat.getString("nomar");
		String pernomar =resultat.getString("prenomar");
	    String paysar=resultat.getString("paysar");
	    String dnar= resultat.getString("dnar");
	arbitre ar = new arbitre();
	    ar.setIdar(idar);
	    ar.setNomar(nomar);
	    ar.setPrenomar(pernomar);
	    ar.setDnar(dnar);
	    ar.setPaysar(paysar);
		utilisateurs.add(ar);
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
		
	
	public int  ajout(arbitre ar) {
		int t=0;
		loadDatabase();
		try { 
		PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO arbitre VALUES(?, ? , ?, ? , ? , ?, ?);");
		preparedStatement.setString(1,ar.getIdar());
		preparedStatement.setString(2,ar.getNomar());
		preparedStatement.setString(3,ar.getPrenomar());
		preparedStatement.setString(4,ar.getDnar());
		preparedStatement.setString(5,ar.getPaysar());
		preparedStatement.setString(6,ar.getId_c());
		preparedStatement.setString(7,ar.getUtili());

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
