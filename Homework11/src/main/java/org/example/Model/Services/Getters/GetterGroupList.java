package org.example.Model.Services.Getters;

import org.example.Model.Groups.Group;

import java.util.List;

public class GetterGroupList<U extends Group> implements GetterGroupImpl{
    List<U> groups;

    public GetterGroupList(List<U> groups) {
        this.groups = groups;
    }

    @Override
    public String showGroupList(int index) {
        StringBuilder sb = new StringBuilder();
        U group = groups.get(index);
        sb.append("Group Leader: ").append(group.getLeader().toString()).append("\n");
        sb.append("Members:\n");
        sb.append(group.getMembers().toString());
        return sb.toString();
    }
}
