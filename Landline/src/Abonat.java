public class Abonat {
    private int abonatID;
    private String nume;
    private String adresa;
    private String telefon;

    public Abonat(int abonatID, String nume, String adresa, String telefon) {
        this.abonatID = abonatID;
        this.nume = nume;
        this.adresa = adresa;
        this.telefon = telefon;
    }

    public int getAbonatID() {
        return abonatID;
    }

    public void setAbonatID(int abonatID) {
        this.abonatID = abonatID;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Abonat{" +
                "abonatID=" + abonatID +
                ", nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
