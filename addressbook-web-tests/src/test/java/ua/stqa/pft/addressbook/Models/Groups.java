package ua.stqa.pft.addressbook.Models;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Groups extends ForwardingSet<GroupData> {

    private Set<GroupData> delegate;

    public Groups(Groups groups) {
        this.delegate = new HashSet<GroupData>(groups.delegate);
    }

    public Groups() {
        this.delegate = new HashSet<GroupData>();
    }

    @Override
    protected Set<GroupData> delegate() {
        return delegate;
    }

    public Groups withAdded(GroupData group) {
        Groups groups = new Groups(this);
        groups.add(group);
        return groups;
    }

    public Groups without (GroupData group) {
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }

    public Groups withChanged (GroupData before, GroupData after) {
        Groups groups = new Groups(this);
        groups.remove(before);
        groups.add(after);
        return groups;
    }
}