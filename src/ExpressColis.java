public class ExpressColis extends  Colis{
   public ExpressColis(int num , Client client){
       super(num  , client);
   }
    @Override
    public double getShippingCost() {
        double totalCost = 0 ;
        for(Article myArticle : getArticles()){
            totalCost += myArticle.getFraisExpedition() ;
        }

        return  (2*totalCost) ;
    }
}
