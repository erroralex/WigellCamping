package com.nilsson.repository;

import com.nilsson.model.Member;
import com.nilsson.utils.Menu;
import com.nilsson.utils.PrintColor;
import java.util.*;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public class MemberRegistry {

    private List<Member> membersList = new ArrayList<>();
    Menu menu = new Menu();

//── Konstruktorer ─────────────────────────────────────────────────────────────────────────────────────────────────────

    private MemberRegistry() {
        initializeMembers();
    }

//── Getters & Setters ─────────────────────────────────────────────────────────────────────────────────────────────────

    public static MemberRegistry getInstance() {
        return SingletonHolder.INSTANCE;
    }

    // Static inner class for singleton pattern
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

        Member member1 = new Member(getUniqueID(),"Johan", "Smith", "Premium", null);
        Member member2 = new Member(getUniqueID(),"Karl", "Svensson", "Standard", null);
        Member member3 = new Member(getUniqueID(),"Oskar", "Karlsson", "Standard", null);
        Member member4 = new Member(getUniqueID(),"Johanna", "Alfredsson", "Student", null);

        this.addMember(member1);
        this.addMember(member2);
        this.addMember(member3);
        this.addMember(member4);
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void editMember(Scanner scanner) {
        if (membersList.isEmpty()) {
            PrintColor.red("\nDet finns inga medlemmar att redigera!");
            return;
        }

        PrintColor.green("\nVälj medlem att redigera:");
        printMembers();
        PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
        PrintColor.green("Ange medlems-ID: ");
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
            PrintColor.red("\nIngen medlem hittades med det angivna medlems-nummret!");
            return;
        }

        System.out.println("Redigera medlemsuppgifter för: " +
                memberToEdit.getFirstName() + " " + memberToEdit.getLastName());

        PrintColor.green("\nFörnamn [nuvarande: " + memberToEdit.getFirstName() + "]: ");
        String newFirstName = scanner.nextLine();

        if (!newFirstName.isEmpty()) {
            memberToEdit.setFirstName(newFirstName);
        }

        PrintColor.green("Efternamn [nuvarande: " + memberToEdit.getLastName() + "]: ");
        String newLastName = scanner.nextLine();
        if (!newLastName.isEmpty()) {
            memberToEdit.setLastName(newLastName);
        }

        PrintColor.green("\nMedlemsnivå [nuvarande: " + memberToEdit.getMembershipLevel() + "]: ");
        PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
        memberLevelInfo();
        PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
        PrintColor.green("Skriv in [medlemsnivå] och [ENTER]:");
        String newMembershipLevel = scanner.nextLine();
        if (!newMembershipLevel.isEmpty()) {
            memberToEdit.setMembershipLevel(newMembershipLevel);
        }

        PrintColor.green("Medlemensuppgifter uppdaterade! Tryck [ENTER] för att fortsätta: ");
        scanner.nextLine();
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

    /**
     * Behöver felhantering!
     */
    public void createNewMember(MemberRegistry memberRegistry, Scanner scanner) {

        System.out.println("\nFyll i information för nytt medlemsskap:");

        PrintColor.green("Förnamn: ");
        //scanner.nextLine();
        String firstName = scanner.nextLine();

        PrintColor.green("Efternamn: ");
        String lastName = scanner.nextLine();

        PrintColor.green("\nMedlemsnivå:");
        memberLevelInfo();
        PrintColor.green("Skriv in [medlemsnivå] och [ENTER]:");
        String membershipLevel = scanner.nextLine();
        PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
        Member newMember = new Member(memberRegistry.getUniqueID(), firstName, lastName, membershipLevel, null);
        memberRegistry.addMember(newMember);

        System.out.println("Nytt medlemsskap skapat!");
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

    public Member findMemberById(int memberId) {
        for (Member member : membersList) {
            if (member.getId() == memberId) {
                return member;
            }
        }
        return null;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
