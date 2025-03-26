import java.util.ArrayList;
import java.util.List;

public class Client {
    private String email , nomPrenom , adresse , tel ;
    private ArrayList<Colis> colis ;


    public Client(String email, String nomPrenom, String adresse, String tel) {
        this.email = email;
        this.nomPrenom = nomPrenom;
        this.adresse = adresse;
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Colis> getColis() {
        return colis;
    }

    public void setColis(ArrayList<Colis> colis) {
        this.colis = colis;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Client{" +
                "adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", nomPrenom='" + nomPrenom + '\'' +
                ", tel='" + tel + '\'' +
                ", colis=" + colis +
                '}';
    }
}
