package Model;

public class Articles {
	private int codeArticle;
	private int stock;
	private String Categories;
	private String designation;
	private int prix;
	private String photo;
	
	public Articles(int codeArticle, int stock, String categories, String desination, int prix, String photo) {
		codeArticle = codeArticle;
		this.stock = stock;
		Categories = categories;
		designation = desination;
		this.prix = prix;
		this.photo = photo;
	}
	public int getCodeArticle() {
		return codeArticle;
	}
	public void setCodeArticle(int codeArticle) {
		codeArticle = codeArticle;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCategories() {
		return Categories;
	}
	public void setCategories(String categories) {
		Categories = categories;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesination(String desination) {
		designation = desination;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
