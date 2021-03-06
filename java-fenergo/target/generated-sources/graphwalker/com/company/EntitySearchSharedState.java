// Generated by GraphWalker (http://www.graphwalker.org)
package com.company;

import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;
import org.graphwalker.java.annotation.Edge;

@Model(file = "com/company/EntitySearchSharedState.graphml")
public interface EntitySearchSharedState {

    @Vertex()
    void v_LandingPage();

    @Edge()
    void e_LandingPage();

    @Vertex()
    void v_EntitySearchPage();

    @Edge()
    void e_EnterLegalEntityName();

    @Vertex()
    void v_LEName_SearchResults();

    @Vertex()
    void v_LEID_SearchResults();

    @Edge()
    void e_EnterLegalEntityId();
}
