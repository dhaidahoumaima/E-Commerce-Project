package Model;

public class Categories {
	int RefCat;
	String Cat;
	
	public Categories() {
		super();
	}
	public Categories(int refCat, String cat) {
		super();
		RefCat = refCat;
		Cat = cat;
	}
	public int getRefCat() {
		return RefCat;
	}
	public void setRefCat(int refCat) {
		RefCat = refCat;
	}
	public String getCat() {
		return Cat;
	}
	public void setCat(String cat) {
		Cat = cat;
	}
	
	
}
