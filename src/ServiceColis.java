import java.util.ArrayList;
import java.util.Calendar;

public class ServiceColis {
    private int annee ;
    private ArrayList<Colis> listColis ;

    public ServiceColis() {
        this.listColis = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        this.annee = cal.get(Calendar.YEAR);
    }


    //DEFINITION DES METHODES
    public void ajoutClient(int numColis ,  Client client){
        NormalColis colis = new NormalColis(numColis , client);
        listColis.add(colis);
    }
    public Client getClientByEmail(String email){
        for(Colis c : listColis){
            if(c.getClient().getEmail().equals(email))
                return  c.getClient();
        }
        return  null ;
    }
    public Colis getColisByNum(int num){
      for(Colis c : listColis){
          if(c.getNum() == num)
              return  c ;
      }
        return  null;
    }

    //GETTERS AND SETTERS
    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public ArrayList<Colis> getListColis() {
        return listColis;
    }

    public void setListColis(ArrayList<Colis> listColis) {
        this.listColis = listColis;
    }


    @Override
    public String toString() {
        return "ServiceColis{" +
                "annee=" + annee +
                ", listColis=" + listColis +
                '}';
    }
}
