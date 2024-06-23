import java.sql.Date;

public class UtilizareTelefon {
    private int utilizareID;
    private int abonatID;
    private Date dataUtilizare;
    private int durataMin;

    public UtilizareTelefon(int utilizareID, int abonatID, Date dataUtilizare, int durataMin) {
        this.utilizareID = utilizareID;
        this.abonatID = abonatID;
        this.dataUtilizare = dataUtilizare;
        this.durataMin = durataMin;
    }

    public int getUtilizareID() {
        return utilizareID;
    }

    public void setUtilizareID(int utilizareID) {
        this.utilizareID = utilizareID;
    }

    public int getAbonatID() {
        return abonatID;
    }

    public void setAbonatID(int abonatID) {
        this.abonatID = abonatID;
    }

    public Date getDataUtilizare() {
        return dataUtilizare;
    }

    public void setDataUtilizare(Date dataUtilizare) {
        this.dataUtilizare = dataUtilizare;
    }

    public int getDurataMin() {
        return durataMin;
    }

    public void setDurataMin(int durataMin) {
        this.durataMin = durataMin;
    }

    @Override
    public String toString() {
        return "UtilizareTelefon{" +
                "utilizareID=" + utilizareID +
                ", abonatID=" + abonatID +
                ", dataUtilizare=" + dataUtilizare +
                ", durataMin=" + durataMin +
                '}';
    }
}
