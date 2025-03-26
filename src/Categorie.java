import java.util.ArrayList;
import java.util.Objects;

public class Categorie {
    private String intitule ;
    private int tauxTVA ;
    public static final int TVA20 = 20 , TVA10 = 10 , TVA0 = 0 ;

    private static ArrayList<Categorie> listCategories = new ArrayList<Categorie>();
    //OR
   // static {
       // listCategories = new ArrayList<String>();
   // }
    private ArrayList<Article> articles ;


    public Categorie(String intitule, int tauxTVA) {

        this.intitule = intitule;
        this.tauxTVA = tauxTVA;
        this.articles = new ArrayList<Article>();
        listCategories.add(this);
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public static ArrayList<Categorie> getListCategories() {
        return listCategories;
    }

    public static void setListCategories(ArrayList<Categorie> listCategories) {
        Categorie.listCategories = listCategories;
    }

    public int getTauxTVA() {
        return tauxTVA;
    }

    public void setTauxTVA(int tauxTVA) {
        this.tauxTVA = tauxTVA;
    }


    @Override
    public String toString() {
        return "Categorie[" +
                "intitule='" + intitule + '\'' +
                ", articles=" + articles +
                ", tauxTVA=" + tauxTVA +
                " nombre d'articles" + articles.size() +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Categorie categorie = (Categorie) o;
        return Objects.equals(intitule, categorie.intitule);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(intitule);
    }

    public static Categorie getCategorie(String intituleCategorie) {
        for (Categorie cat : listCategories) {
            if (cat.intitule.equals(intituleCategorie)) {
                return cat;
            }
        }
        return null;
    }

    public static void deleteCategorie(String intituleCategorie) {
        /*Categorie toRemove = null;
        for (Categorie cat : listCategories) {
            if (cat.getIntitule().equals(intituleCategorie)) {
                toRemove = cat;
                break;
            }
        }
        if (toRemove != null) {
            listCategories.remove(toRemove);
        }*/
        Categorie c = getCategorie(intituleCategorie);
        if (c == null) return;
        listCategories.remove(c);
    }

}
