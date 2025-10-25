package com.nilsson.entity;

import com.nilsson.utils.Menu;
import com.nilsson.utils.PrintColor;
import java.util.*;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

public class MemberRegistry {

    private List<Member> membersList = new ArrayList<>();
    Menu menu = new Menu();

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    private MemberRegistry() {
        initializeMembers();
    }
//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public static MemberRegistry getInstance() {
        return SingletonHolder.INSTANCE;
    }

    // Static inner class for singleton pattern
    private static class SingletonHolder {
        private static final MemberRegistry INSTANCE = new MemberRegistry();
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

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

    public void printMembers() {
        System.out.println("Registrerade medlemmar:");
        int i = 1;
        for (Member member : membersList) {
            System.out.println(i + ": " + member.toString());
            i++;
        }
        if (membersList.isEmpty()) {
            PrintColor.red("\nInga registrerade medlemmar!");
        }
        PrintColor.green("\nTryck [ENTER] för att fortsätta: ");
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    /**
     * Behöver felhantering!
     */
    public void createNewMember(MemberRegistry memberRegistry, Scanner scanner) {

        System.out.println("\nFyll i information för nytt medlemsskap:");

        PrintColor.green("Förnamn: ");
        scanner.nextLine();
        String firstName = scanner.nextLine();

        PrintColor.green("Efternamn: ");
        String lastName = scanner.nextLine();

        PrintColor.green("\nMedlemsnivå:");
        System.out.println("[Student]: 80:-/mån. Samma som Standard, men 20% rabatt för våra studerande medlemmar.");
        System.out.println("[Standard]: 100:-/mån. Vårat trygga val. Försäkring på grundnivå med en självrisk på 3000:- för fordon");
        System.out.println("[Premium]: 150:-/mån. För kunden som vill vara trygg. Allrisk, helförsäkring och självrisk på endast 1000:- för fordon");
        PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
        PrintColor.green("Skriv in [medlemsnivå] och [ENTER]:");
        String membershipLevel = scanner.nextLine();

        Member newMember = new Member(memberRegistry.getUniqueID(), firstName, lastName, membershipLevel, null);
        memberRegistry.addMember(newMember);

        System.out.println("Nytt medlemsskap skapat! Tryck [ENTER] för att fortsätta: ");
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
