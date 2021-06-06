package p;


public class client {
String nom ;
String prenom ;
String adr ;
String mail;
String dn;


public String getDn() {
	return dn;
}
public void setDn(String dn) {
	this.dn = dn;
}
public String getAdr() {
	return adr;
}
public void setAdr(String adr) {
	this.adr = adr;
}
String mdp;
public client() {
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}


public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getMdp() {
	return mdp;
}
public void setMdp(String mdp) {
	this.mdp = mdp;
}
}