import java.util.ArrayList;

public interface AbonatDAO {
    public void adaugaAbonat(Abonat abonat);
    public void stergeAbonat(String numarTelefon);
    public String gasesteNumarTelefon(String nume);
    public Abonat gasesteAbonat(String numarTelefon);
    public int numaraTelefoaneDupaAn(int an);
    public ArrayList<String> getNumereNorocoase();
    public void creazaTabela(String strada);
    public ArrayList<UtilizareTelefon> getEvidentaUtilizare(String luna);
    public void afiseazaAbonati();
}
