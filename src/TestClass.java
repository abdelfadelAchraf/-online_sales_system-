
public class TestClass {
    public static void main(String[] args) {
        //------------------------Creer les categories
        Categorie alimentaire = new Categorie("Alimentaire" ,Categorie.TVA10);
        Categorie livres = new Categorie("Livres" ,Categorie.TVA20);
        Categorie cosmetique = new Categorie("Cosmétique", Categorie.TVA20);
        //------------------------Creer les articles
        Article a1 = new Article(alimentaire ,"Chocolat" ,200 ,5.50 );
        Article a2 = new Article(livres , "Roman" , 300 , 15.99);
        Article a3 = new Article(cosmetique , "Crème visage" , 150 , 22.50);
        Article a4 = new Article(alimentaire , "Lait" , 200 , 25.50);

        //------------------------Creer les clients
        Client c1 = new Client("c1@email.com","Ahmed Zaatra" ,"123 Rue de Paris" , "0612345677");
        Client c2 = new Client("c2@email.com","Sara Farah" ,"255 Rue de Marseille" , "060367271");

        //------------------------Creer une service
        ServiceColis service = new ServiceColis();

        //------------------------Creer & gerer les colis
        NormalColis colis1 = new NormalColis(1 , c1);
        colis1.addArticle(a1);
        colis1.addArticle(a2);

        ExpressColis colis2 = new ExpressColis(2 , c2);
        colis2.addArticle(a3);
        colis2.addArticle(a4);

        AssuranceColis colis3 = new AssuranceColis(3 , c2 , 120);
        colis3.addArticle(a3);

        //------------------------ajouter des colis au service
        service.getListColis().add(colis1);
        service.getListColis().add(colis2);
        service.getListColis().add(colis3);

        //------------------------Ship des colis
        colis1.ship();
        colis2.ship();

        System.out.println("Liste des colis");
        for(Colis c : service.getListColis()){
            System.out.println("Colis #" + c.getNum());
            System.out.println("Client: " + c.getClient());
            System.out.println("Prix global: " + c.overallPrice() + " $");
            System.out.println("Frais d'expédition: " + c.getShippingCost() + " $");
            System.out.println("Montant total: " + c.totalAmount() + " $");
            System.out.println("Statut: " + (c.isExpedie() ? "Expédié le " + c.getFormattedDate() : "Non expédié"));
            System.out.println("-----------------------------");
        }

        //------------------------Comparer les colis
        if(colis1.compareTo(colis2) > 0){
            System.out.println("Le colis 1 est plus lourd que le colis 2");
        }else if(colis1.compareTo(colis2) < 0){
            System.out.println("Le colis 1 est plus léger que le colis 2");
        }else{
            System.out.println("Les colis 1 et 2 ont le meme poids");
        }


    }
}