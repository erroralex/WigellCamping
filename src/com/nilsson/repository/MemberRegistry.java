package com.nilsson.repository;

import com.nilsson.model.Member;
import java.util.*;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public class MemberRegistry {

    private List<Member> membersList = new ArrayList<>();
    private Set<Integer> usedIDs = new HashSet<>();

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

    public int getUniqueID() {
        Random random = new Random();

        while (true) {
            int id = 1000 + random.nextInt(9000);
            if (usedIDs.add(id)) {
                return id;
            }
        }
    }

    public List<Member> getMembers() {
        return membersList;
    }

//── Metoder ───────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void addMember(Member member) {
        membersList.add(member);
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

}
