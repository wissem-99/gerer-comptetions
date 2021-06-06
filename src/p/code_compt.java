package p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class code_compt {
private Connection connexion;

public boolean verif(String cu ,String id)
{
	boolean test;
	test=false;
Statement statement = null;
ResultSet resultat = null;
loadDatabase();
try {
statement = connexion.createStatement();
// Exécution de la requête
PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM compt where cu= ? and id= ?;");
preparedStatement.setString(1, cu);
preparedStatement.setString(2, id);
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

public List<compt> rec(String c) {
	List<compt> utilisateurs = new ArrayList<compt>();
	Statement statement = null;
	ResultSet resultat = null;
	loadDatabase();
	try {
	statement = connexion.createStatement();
	// Exécution de la requête
	PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM compt where cu = ? ;");
	preparedStatement.setString(1,c);
	resultat = preparedStatement.executeQuery();
	while (resultat.next()) {
	String id = resultat.getString("id");
	String nom = resultat.getString("nom");
	String dec =resultat.getString("dec");
    int nbe =resultat.getInt("nbe");
    String f=resultat.getString("f");
    String db=resultat.getString("db");
    String df=resultat.getString("df");
    String con =resultat.getString("con");
    String gen=resultat.getString("gen");
    String cat=resultat.getString("cat");
    		
    compt utilisateur=new compt();
    utilisateur.setIc(id);
    utilisateur.setNc(nom);
    utilisateur.setCd(dec);
    utilisateur.setNbe(nbe);
    utilisateur.setF(f);
    utilisateur.setDb(db);
    utilisateur.setDf(df);
    utilisateur.setCon(con);
    utilisateur.setGen(gen);
    utilisateur.setCat(cat);
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
	
public List<compt> rectous( ) {
	List<compt> utilisateurs = new ArrayList<compt>();
	Statement statement = null;
	ResultSet resultat = null;
	loadDatabase();
	try {
	statement = connexion.createStatement();
	// Exécution de la requête
	PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM compt  ;");
	
	resultat = preparedStatement.executeQuery();
	while (resultat.next()) {
	String id = resultat.getString("id");
	String dec=resultat.getString("dec");
	String nom = resultat.getString("nom");
    int nbe =resultat.getInt("nbe");
    String f=resultat.getString("f");
    String db=resultat.getString("db");
    String df=resultat.getString("df");
    String con =resultat.getString("con");
    String gen=resultat.getString("gen");
    String cat=resultat.getString("cat");
    		
    compt utilisateur=new compt();
    utilisateur.setIc(id);
    utilisateur.setNc(nom);
    utilisateur.setCd(dec);
    utilisateur.setNbe(nbe);
    utilisateur.setF(f);
    utilisateur.setDb(db);
    utilisateur.setDf(df);
    utilisateur.setCon(con);
    utilisateur.setGen(gen);
    utilisateur.setCat(cat);
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
	
	
	
	
	
	
	
	
	
	
	
	
	public int sup(compt c)
	{int t=0;
	loadDatabase();
	try {
	PreparedStatement preparedStatement = connexion.prepareStatement("delete from compt where id =? and cu=?");
	preparedStatement.setString(1,c.getIc());
	preparedStatement.setString(2,c.getCu());
	preparedStatement.executeUpdate();		
	t=1;
	} catch (SQLException e) {
	e.printStackTrace();
	}
		return t;
	}
	public int mod(compt c)
	{int t=0;
	loadDatabase();
	try {
	PreparedStatement preparedStatement = connexion.prepareStatement("update compt set f=?	, nbe= ? where id =? and cu=?");
	preparedStatement.setString(1, c.getF());
	preparedStatement.setInt(2,c.getNbe());
	preparedStatement.setString(3,c.getIc());
	preparedStatement.setString(4,c.getCu());
	preparedStatement.executeUpdate();		
	t=1;
	} catch (SQLException e) {
	e.printStackTrace();
	}
		return t;
	}
	
	public int  ajout(compt c) {
		int t=0;
		loadDatabase();
		try {
		PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO compt VALUES(? ,?,?,?,?,?,? ,?,? ,?,?);");
		preparedStatement.setString(1, c.getIc());
		preparedStatement.setString(2, c.getNc());
		preparedStatement.setString(3, c.getCd());
        preparedStatement.setInt(4,c.getNbe());
        preparedStatement.setString(5, c.getCu());
        preparedStatement.setString(6,c.getF());
        preparedStatement.setString(7,c.getDb());
        preparedStatement.setString(8,c.getDf());
        preparedStatement.setString(9,c.getCon());
        preparedStatement.setString(10,c.getGen());
        preparedStatement.setString(11,c.getCat());
		preparedStatement.executeUpdate();		
		t=1;
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return t;
	
	}
	public List<compt> recd(String c,String ic) {
		List<compt> utilisateurs = new ArrayList<compt>();
		Statement statement = null;
		ResultSet resultat = null;
		loadDatabase();
		try {
		statement = connexion.createStatement();
		// Exécution de la requête
		PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM compt where cu = ? and id= ?;");
		preparedStatement.setString(1,c);
		preparedStatement.setString(2,ic);
		resultat = preparedStatement.executeQuery();
		while (resultat.next()) {
		String id = resultat.getString("id");
		String nom = resultat.getString("nom");
		String dec =resultat.getString("dec");
	    int nbe =resultat.getInt("nbe");
	    String f=resultat.getString("f");
	    String db=resultat.getString("db");
	    String df=resultat.getString("df");
	    String con =resultat.getString("con");
	    String gen=resultat.getString("gen");
	    String cat=resultat.getString("cat");
	    		
	    compt utilisateur=new compt();
	    utilisateur.setIc(id);
	    utilisateur.setNc(nom);
	    utilisateur.setCd(dec);
	    utilisateur.setNbe(nbe);
	    utilisateur.setF(f);
	    utilisateur.setDb(db);
	    utilisateur.setDf(df);
	    utilisateur.setCon(con);
	    utilisateur.setGen(gen);
	    utilisateur.setCat(cat);
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
