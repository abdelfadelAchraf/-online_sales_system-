import java.util.Objects;

public class Article {
    private  static  int counter = 1 ;//Pour l'incrémentation automatique du numero d'article
    private int num ;
    private String nom ;
    private double prixHt ;
    private int poids ;
    private  Categorie categorie ;

    public Article(Categorie categorie, String nom, int poids, double prixHt) {
        this.categorie = categorie;
        this.nom = nom;
        this.num = counter++;
        this.poids = poids;
        this.prixHt = prixHt;

        this.categorie.getArticles().add(this);
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public double getPrixHt() {
        return prixHt;
    }

    public void setPrixHt(double prixHt) {
        this.prixHt = prixHt;
    }


    public double getPrixTTC() {
        return prixHt * (1 + categorie.getTauxTVA() / 100.0);
    }

    public double getFraisExpedition() {
        if (poids < 5000) { // less than 5kg
            return 5.0;
        } else if (poids < 15000) { // less than 15kg
            return 15.0;
        } else {
            return 0.75 * poids / 1000.0; // convert g to kg for calculation
        }
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return num == article.num;
    }
/*
    @Override
    public int hashCode() {
        return Objects.hashCode(num);
    }*/

    @Override
    public String toString() {
        return "Article{" +
                "categorie=" + categorie.getIntitule() +
                ", num=" + num +
                ", nom='" + nom + '\'' +
                ", prixHt=" + prixHt +
                ", poids=" + poids +
                '}';
    }
}
