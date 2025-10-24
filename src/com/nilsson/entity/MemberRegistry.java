package com.nilsson.entity;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

import com.nilsson.utils.PrintColor;

import java.util.*;

public class MemberRegistry {

    private List<Member> membersList;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public MemberRegistry() {
        this.membersList = new ArrayList<>();
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

    public MemberRegistry getInitializedMembers() {
        initializeMembers();
        return this;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void printMembers() {
        System.out.println("Registrerade medlemmar:");
        for (Member member : membersList) {
            System.out.println(member.toString());
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
        String firstName = scanner.nextLine();

        PrintColor.green("Efternamn: ");
        String lastName = scanner.nextLine();

        PrintColor.green("Medlemsnivå (Premium/Standard/Student): ");
        String membershipLevel = scanner.nextLine();

        Member newMember = new Member(memberRegistry.getUniqueID(), firstName, lastName, membershipLevel, null);
        memberRegistry.addMember(newMember);

        System.out.println("Nytt medlemsskap skapat! Tryck [ENTER] för att fortsätta: ");
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
