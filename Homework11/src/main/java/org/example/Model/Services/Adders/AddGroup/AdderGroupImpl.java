package org.example.Model.Services.Adders.AddGroup;

import java.util.List;

public interface AdderGroupImpl<U1, U2, U3> {
    String name();
    U1 leader();
    List<U2> members();

    U3 newGroup();
}
