package Model;

public class Client {
	int id;
	String email;
	String nom;
	String adress;
	int codePostal;
	String ville;
	String tel,motPass;
	public Client(int id, String email, String nom, String adress, int codePostal, String ville, String tel,
			String motPass) {
		super();
		this.id = id;
		this.email = email;
		this.nom = nom;
		this.adress = adress;
		this.codePostal = codePostal;
		this.ville = ville;
		this.tel = tel;
		this.motPass = motPass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMotPass() {
		return motPass;
	}
	public void setMotPass(String motPass) {
		this.motPass = motPass;
	}
	
}
