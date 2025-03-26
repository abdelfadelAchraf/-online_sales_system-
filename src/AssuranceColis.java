public class AssuranceColis extends  Colis{
    private double valAssure ;
    public AssuranceColis(int num , Client client , double valAssure){
        super(num , client);
        this.valAssure= valAssure ;

    }

    public double getValAssure() {
        return valAssure;
    }

    public void setValAssure(double valAssure) {
        this.valAssure = valAssure;
    }

    @Override
    public double getShippingCost() {
        double normalShippingCost = 0 ;
        for(Article myArticle : getArticles()){
            normalShippingCost += myArticle.getFraisExpedition();
        }

        double surcharge = valAssure < 100 ? 10.0 : 0.05*valAssure ;

        return normalShippingCost + surcharge;
    }
}
