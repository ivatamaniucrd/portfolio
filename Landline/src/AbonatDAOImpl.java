import java.sql.*;
import java.util.ArrayList;

public class AbonatDAOImpl implements AbonatDAO {
    private Connection conn;

    public AbonatDAOImpl() {
        this.conn = DatabaseConnection.getConnection();
    }

    @Override
    public void adaugaAbonat(Abonat abonat) {
        String sql = "INSERT INTO Abonati(Nume, Adresa, Telefon) VALUES(?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, abonat.getNume());
            pstmt.setString(2, abonat.getAdresa());
            pstmt.setString(3, abonat.getTelefon());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stergeAbonat(String numarTelefon) {
        String sql = "DELETE FROM Abonati WHERE Telefon = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, numarTelefon);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String gasesteNumarTelefon(String nume) {
        String sql = "SELECT Telefon FROM Abonati WHERE Nume = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nume);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("Telefon");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Abonat gasesteAbonat(String numarTelefon) {
        String sql = "SELECT * FROM Abonati WHERE Telefon = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, numarTelefon);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Abonat(rs.getInt("AbonatID"), rs.getString("Nume"), rs.getString("Adresa"), rs.getString("Telefon"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int numaraTelefoaneDupaAn(int an) {
        String sql = "SELECT COUNT(*) AS NumarTelefoane FROM Telefoane WHERE AnInstalare > ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, an);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("NumarTelefoane");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public ArrayList<String> getNumereNorocoase() {
        ArrayList<String> numereNorocoase = new ArrayList<>();
        String sql = "SELECT Telefon FROM Abonati";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String telefon = rs.getString("Telefon");
                if (isNumarNorocos(telefon)) {
                    numereNorocoase.add(telefon);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numereNorocoase;
    }

    private boolean isNumarNorocos(String numar) {
        if (numar.length() != 6) {
            return false;
        }
        int primaSuma = 0;
        for (int i = 0; i < 3; i++) {
            primaSuma += Character.getNumericValue(numar.charAt(i));
        }
        int aDouaSuma = 0;
        for (int i = 3; i < 6; i++) {
            aDouaSuma += Character.getNumericValue(numar.charAt(i));
        }
        return primaSuma == aDouaSuma;
    }

    public void creazaTabela(String strada) {
        String sql = "CREATE TABLE Telefoane_" + strada + " AS SELECT * FROM Telefoane WHERE Strada = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, strada);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<UtilizareTelefon> getEvidentaUtilizare(String luna) {
        ArrayList<UtilizareTelefon> evidenta = new ArrayList<>();
        String sql = "SELECT * FROM UtilizareTelefon WHERE MONTH(DataUtilizare) = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, luna);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                UtilizareTelefon utilizare = new UtilizareTelefon(rs.getInt("UtilizareID"), rs.getInt("AbonatID"), rs.getDate("DataUtilizare"), rs.getInt("DurataMin"));
                evidenta.add(utilizare);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return evidenta;
    }

    public ArrayList<Abonat> getAllAbonati() {
        ArrayList<Abonat> abonati = new ArrayList<>();
        String sql = "SELECT * FROM Abonati";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Abonat abonat = new Abonat(rs.getInt("AbonatID"), rs.getString("Nume"), rs.getString("Adresa"), rs.getString("Telefon"));
                abonati.add(abonat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return abonati;
    }

    public void afiseazaAbonati() {
        ArrayList<Abonat> abonati = getAllAbonati();
        for (Abonat abonat : abonati) {
            System.out.println(abonat);
        }
    }

}
