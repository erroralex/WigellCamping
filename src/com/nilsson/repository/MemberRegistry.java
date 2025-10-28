package com.nilsson.repository;

import com.nilsson.model.Member;
import com.nilsson.utils.PrintColor;
import java.util.*;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public class MemberRegistry {

    private List<Member> membersList = new ArrayList<>();

//── Konstruktorer ─────────────────────────────────────────────────────────────────────────────────────────────────────

    private MemberRegistry() {
        initializeMembers();
    }

//── Getters & Setters ─────────────────────────────────────────────────────────────────────────────────────────────────

    public static MemberRegistry getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final MemberRegistry INSTANCE = new MemberRegistry();
    }

//── Metoder ───────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void addMember(Member member) {
        membersList.add(member);
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public List<Member> getMembers() {
        return membersList;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    private int getUniqueID() {
        Random random = new Random();
        Set<Integer> usedIDs = new HashSet<>();

        while (true) {
            int id = 1000 + random.nextInt(9000);
            if (usedIDs.add(id)) {
                return id;
            }
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    private void initializeMembers() {

        Member member1 = new Member(getUniqueID(),"Mikael", "Persbrandt", "Premium", new ArrayList<>());
        Member member2 = new Member(getUniqueID(),"Peter", "Forsberg", "Standard", new ArrayList<>());
        Member member3 = new Member(getUniqueID(),"Viktoria", "Bernadotte", "Standard", new ArrayList<>());
        Member member4 = new Member(getUniqueID(),"Mia", "Parnevik", "Student", new ArrayList<>());
        Member member5 = new Member(getUniqueID(),"Kurt", "Olsson", "Premium", new ArrayList<>());
        Member member6 = new Member(getUniqueID(),"Stellan", "Skarsgård", "Student", new ArrayList<>());

        this.addMember(member1);
        this.addMember(member2);
        this.addMember(member3);
        this.addMember(member4);
        this.addMember(member5);
        this.addMember(member6);
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void editMember(Scanner scanner) {
        if (membersList.isEmpty()) {
            PrintColor.red("\nDet finns inga medlemmar att redigera! Tryck [ENTER] för att fortsätta: ");
            scanner.nextLine();
            return;
        }

        printMembers();
        PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
        PrintColor.green("Välj medlem att redigera genom att ange [medlems-ID]: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();

        Member memberToEdit = null;
        for (Member member : membersList) {
            if (member.getId() == memberId) {
                memberToEdit = member;
                break;
            }
        }

        if (memberToEdit == null) {
            PrintColor.red("\nIngen medlem hittades med det angivna medlems-nummret! Tryck [ENTER] för att fortsätta: ");
            scanner.nextLine();
            return;
        }

        PrintColor.green("\nVad vill du göra med medlem " + memberToEdit.getFirstName() + " " + memberToEdit.getLastName() + "?");
        PrintColor.cyan("1: Redigera medlem");
        PrintColor.red("2: Ta bort medlem");
        PrintColor.red("0: Avbryt och gå tillbaka");
        PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
        PrintColor.green("Ange ditt val och tryck ENTER: ");

        int actionChoice = scanner.nextInt();
        scanner.nextLine();

        if (actionChoice == 2) {
            Iterator<Member> iterator = membersList.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().getId() == memberId) {
                    iterator.remove();
                    PrintColor.green("Medlem borttagen! Tryck [ENTER] för att fortsätta: ");
                    scanner.nextLine();
                    return;
                }
            }

        } else if (actionChoice == 1) {

            String newFirstName;

            while (true) {
                PrintColor.green("\nFörnamn [nuvarande: " + memberToEdit.getFirstName() + "]: ");
                newFirstName = scanner.nextLine();
                if (newFirstName.isEmpty()) {
                    PrintColor.red("Förnamn får inte vara tomt! Försök igen.");
                } else {
                    memberToEdit.setFirstName(newFirstName);
                    break;
                }
            }

            String newLastName;

            while (true) {
                PrintColor.green("Efternamn [nuvarande: " + memberToEdit.getLastName() + "]: ");
                newLastName = scanner.nextLine();
                if (newLastName.isEmpty()) {
                    PrintColor.red("Efternamn får inte vara tomt! Försök igen.");
                } else {
                    memberToEdit.setLastName(newLastName);
                    break;
                }
            }

            String newMembershipLevel;

            while (true) {
                PrintColor.green("\nMedlemsnivå [nuvarande: " + memberToEdit.getMembershipLevel() + "]: ");
                PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
                memberLevelInfo();
                PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
                PrintColor.green("Skriv in [medlemsnivå] och [ENTER]:");
                newMembershipLevel = scanner.nextLine();

                if (newMembershipLevel.equalsIgnoreCase("Student") ||
                        newMembershipLevel.equalsIgnoreCase("Standard") ||
                        newMembershipLevel.equalsIgnoreCase("Premium")) {
                    memberToEdit.setMembershipLevel(newMembershipLevel);
                    break;

                } else {
                    PrintColor.red("Ogiltlig medlemsnivå! Ange Student, Standard eller Premium.");
                }
            }
            PrintColor.green("Medlemensuppgifter uppdaterade! Tryck [ENTER] för att fortsätta: ");
            scanner.nextLine();
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void printMembers() {
        PrintColor.green("Registrerade medlemmar:");
        System.out.println();
        int i = 1;
        for (Member member : membersList) {
            System.out.println(i + ": " + member.toString());
            i++;
        }
        if (membersList.isEmpty()) {
            PrintColor.red("\nInga registrerade medlemmar!");
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void printAndSortMembers() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            PrintColor.green("Registrerade medlemmar - Välj sorteringsalternativ:");
            PrintColor.cyan("\n1: Sortera efter ID");
            PrintColor.cyan("2: Sortera alfabetiskt (efternamn)");
            PrintColor.cyan("3: Sortera efter medlemsnivå");
            PrintColor.red("0: Gå tillbaka till meny");
            PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
            PrintColor.green("Ange ditt val och tryck ENTER: ");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                PrintColor.red("Ogiltig inmatning! Ange en siffra.");
                scanner.nextLine();
                continue;
            }

            List<Member> sortedList = new ArrayList<>(membersList);
            if (membersList.isEmpty()) {
                PrintColor.red("\nInga registrerade medlemmar!");
                return;
            }

            if (choice == 1) {
                sortedList.sort(Comparator.comparingInt(Member::getId));

            } else if (choice == 2) {
                sortedList.sort(Comparator.comparing(member -> member.getLastName().toLowerCase()));

            } else if (choice == 3)  {
                sortedList.sort(Comparator.comparing(member -> member.getMembershipLevel().toLowerCase()));

            } else if (choice == 0) {
                return;

            } else {
                PrintColor.red("Ogiltigt val! Försök igen.");
                continue;
            }

            System.out.println();
            int i = 1;
            for (Member member : sortedList) {
                System.out.println(i + ": " + member.toString());
                i++;
            }
            System.out.println();
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void createNewMember(MemberRegistry memberRegistry, Scanner scanner) {

        System.out.println("\nFyll i information för nytt medlemsskap:");

        String firstName;

        while (true) {
            PrintColor.green("Förnamn: ");
            firstName = scanner.nextLine();

            if (!firstName.isEmpty()) {
                break;
            }
        PrintColor.red("Du måste ange ett förnamn!");
        }

        String lastName;

        while (true) {
            PrintColor.green("Efternamn: ");
            lastName = scanner.nextLine();
            if (!lastName.isEmpty()) {
                break;
            }
            PrintColor.red("Du måste ange ett efternamn!");
        }

        String membershipLevel;

        while (true) {
        PrintColor.green("\nMedlemsnivå:");
        memberLevelInfo();
        PrintColor.green("Skriv in [medlemsnivå] och [ENTER]:");
        membershipLevel = scanner.nextLine();
        if (membershipLevel.equalsIgnoreCase("Student") ||
            membershipLevel.equalsIgnoreCase("Standard") ||
            membershipLevel.equalsIgnoreCase("Premium")) {
            break;

            } else {
                PrintColor.red("Ogiltlig medlemsnivå! Ange Student, Standard eller Premium");
            }
        }
        PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
        Member newMember = new Member(memberRegistry.getUniqueID(), firstName, lastName, membershipLevel, new ArrayList<>());
        memberRegistry.addMember(newMember);

        System.out.print("Nytt medlemsskap skapat! Tryck [ENTER]: ");
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void memberLevelInfo() {
        String info = """                
                \n[Student]: 80:-/mån. Samma som Standard, men 20% rabatt för våra studerande medlemmar.
              \t\t\tStudenter har även en liten rabatt på grundpriset.
                \n[Standard]: 100:-/mån. Vårat trygga val. Försäkring på grundnivå med en självrisk på 3000:- för fordon.
              \t\t\tStandardmedlemmar betalar grundpris.
                \n[Premium]: 150:-/mån. För kunden som vill vara trygg. Allrisk, helförsäkring och självrisk på endast 1000:- för fordon.
              \t\t\tPremium-medlemmar betalar lite mer för bättre försäkring och service och kan hyra utrustning längre.
              """;
        System.out.println(info);
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void printAllRentalHistories() {
        if (membersList.isEmpty()) {
            PrintColor.red("Ingen medlem finns registrerad. Tryck [ENTER] för att fortsätta: ");
            return;
        }

        PrintColor.green("Utlånings- & återlämningshistorik för alla medlemmar:");
        PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");

        for (Member member : membersList) {
            System.out.println("Medlem: " + member.getFirstName() + " " + member.getLastName() + " (ID: " + member.getId() + ")");

            List<String> history = member.getHistory();
            if (history == null || history.isEmpty()) {
                System.out.println("  Ingen historik.");
            } else {
                for (String entry : history) {
                    System.out.println("  - " + entry);
                }
            }
            PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
