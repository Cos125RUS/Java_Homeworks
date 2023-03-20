package org.example.Model.Groups;

import java.util.List;

public abstract class Group<U1, U2>{
    U1 leader;
    List<U2> members;


    public Group(U1 leader, List<U2> members) {
        this.leader = leader;
        this.members = members;
    }

    public U1 getLeader() {
        return leader;
    }

    public List<U2> getMembers() {
        return members;
    }
}
