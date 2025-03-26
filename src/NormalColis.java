public class NormalColis extends  Colis{

    public NormalColis(int num , Client client){
        super(num , client);
    }
    @Override
    public double getShippingCost() {
        double totalCost = 0 ;
        for(Article myArticle : getArticles()){
            totalCost += myArticle.getFraisExpedition();
        }
        return  totalCost ;
    }
}
