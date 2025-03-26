import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public abstract class Colis implements Comparable<Colis> {
    private int num;
    private ArrayList<Article> articles;
    private Client client;
    private boolean expedie;
    private Date dateExpedition;

    static SimpleDateFormat formatter = new SimpleDateFormat("E d MMM yyyy, H:m:s", Locale.FRANCE);

    public Colis(int num, Client client) {
        this.num = num;
        this.client = client;
        this.articles = new ArrayList<>();
        this.expedie = false;
        this.dateExpedition = null;
     //   client.addColis(this);
    }

    public int getNum() {
        return num;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public Client getClient() {
        return client;
    }

    public boolean isExpedie() {
        return expedie;
    }

    public Date getDateExpedition() {
        return dateExpedition;
    }

    public void setDateExpedition(Date dateExpedition) {
        this.dateExpedition = dateExpedition;
    }

    public String getFormattedDate() {
        if (dateExpedition == null) {
            return "Non expédié";
        }
        return formatter.format(dateExpedition);
    }


    public void ship() {
        this.expedie = true;
        this.dateExpedition = new Date();
    }

    public void addArticle(Article article) {
        if (!expedie) {
            articles.add(article);
        } else {
            throw new IllegalStateException("Impossible d'ajouter un article à un colis déjà expédié");
        }
    }

    public abstract double getShippingCost();

    public double overallPrice() {
        double sum = 0;
        for (Article article : articles) {
            sum += article.getPrixTTC();
        }
        return sum;
    }

    public double totalAmount() {
        return overallPrice() + getShippingCost();
    }

    public int getTotalWeight() {
        int totalWeight = 0;
        for (Article article : articles) {
            totalWeight += article.getPoids();
        }
        return totalWeight;
    }

    @Override
    public int compareTo(Colis other) {
        return Integer.compare(this.getTotalWeight(), other.getTotalWeight());
    }

    @Override
    public String toString() {
        return "Colis{" +
                "num=" + num +
                ", articles=" + articles.size() +
                ", client=" + client.getEmail() +
                ", expedie=" + expedie +
                ", dateExpedition=" + getFormattedDate() +
                '}';
    }
}
