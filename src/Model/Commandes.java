package Model;

public class Commandes {
	int numCommande;
	int codeClient;
	String dateCommande;
	public Commandes(int numCommande, int codeClient, String dateCommande) {
		super();
		this.numCommande = numCommande;
		this.codeClient = codeClient;
		this.dateCommande = dateCommande;
	}
	public int getNumCommande() {
		return numCommande;
	}
	public void setNumCommande(int numCommande) {
		this.numCommande = numCommande;
	}
	public int getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(int codeClient) {
		this.codeClient = codeClient;
	}
	public String getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}
	
}
