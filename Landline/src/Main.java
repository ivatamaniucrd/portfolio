import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AbonatDAO abonatDAO = new AbonatDAOImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selectați o opțiune:");
            System.out.println("1. Adăugați un nou abonat");
            System.out.println("2. Ștergeți un abonat");
            System.out.println("3. Găsiți numărul de telefon al unui abonat");
            System.out.println("4. Găsiți un abonat");
            System.out.println("5. Numărați telefoanele după an");
            System.out.println("6. Obțineți numerele norocoase");
            System.out.println("7. Creați o tabelă");
            System.out.println("8. Obțineți evidența utilizării telefonului fix");
            System.out.println("9. Afișați toți abonații");
            System.out.println("10. Ieșiți");

            int optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune) {
                case 1:
                    System.out.println("Introduceți numele, adresa și numărul de telefon al noului abonat:");
                    String nume = scanner.nextLine();
                    String adresa = scanner.nextLine();
                    String telefon = scanner.nextLine();
                    Abonat abonatNou = new Abonat(0, nume, adresa, telefon);
                    abonatDAO.adaugaAbonat(abonatNou);
                    System.out.println("Abonatul a fost adăugat: " + abonatNou);
                    break;
                case 2:
                    System.out.println("Introduceți numărul de telefon al abonatului pe care doriți să îl ștergeți:");
                    String numarTelefon = scanner.nextLine();
                    abonatDAO.stergeAbonat(numarTelefon);
                    System.out.println("Abonatul cu numărul de telefon '" + numarTelefon + "' a fost șters.");
                    break;
                case 3:
                    System.out.println("Introduceți numele abonatului pentru care doriți să găsiți numărul de telefon:");
                    String numeCautare = scanner.nextLine();
                    String numarTelefonGasit = abonatDAO.gasesteNumarTelefon(numeCautare);
                    System.out.println("Numărul de telefon al abonatului cu numele '" + numeCautare + "' este: " + numarTelefonGasit);
                    break;
                case 4:
                    System.out.println("Introduceți numărul de telefon al abonatului pe care doriți să îl găsiți:");
                    String numarTelefonCautare = scanner.nextLine();
                    Abonat abonatGasit = abonatDAO.gasesteAbonat(numarTelefonCautare);
                    System.out.println("Abonatul cu numărul de telefon '" + numarTelefonCautare + "' este: " + abonatGasit);
                    break;
                case 5:
                    System.out.println("Introduceți anul după care doriți să numărați telefoanele:");
                    int an = scanner.nextInt();
                    int numarTelefoane = abonatDAO.numaraTelefoaneDupaAn(an);
                    System.out.println("Numărul de telefoane instalate după anul " + an + " este: " + numarTelefoane);
                    break;
                case 6:
                    ArrayList<String> numereNorocoase = abonatDAO.getNumereNorocoase();
                    System.out.println("Numerele norocoase sunt: " + numereNorocoase);
                    break;
                case 7:
                    System.out.println("Introduceți denumirea străzii pentru care doriți să creați tabela:");
                    String strada = scanner.nextLine();
                    abonatDAO.creazaTabela(strada);
                    System.out.println("Tabela pentru telefoanele de pe strada '" + strada + "' a fost creată.");
                    break;
                case 8:
                    System.out.println("Introduceți luna pentru care doriți să obțineți evidența utilizării telefonului fix:");
                    String luna = scanner.nextLine();
                    ArrayList<UtilizareTelefon> evidenta = abonatDAO.getEvidentaUtilizare(luna);
                    System.out.println("Evidența utilizării telefonului fix în luna " + luna + " este: " + evidenta);
                    break;
                case 9:
                    abonatDAO.afiseazaAbonati();
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.out.println("Opțiune invalidă. Vă rugăm să selectați o opțiune validă.");
            }
        }
    }
}
