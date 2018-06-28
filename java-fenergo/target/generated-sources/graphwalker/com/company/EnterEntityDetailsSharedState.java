// Generated by GraphWalker (http://www.graphwalker.org)
package com.company;

import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;
import org.graphwalker.java.annotation.Edge;

@Model(file = "com/company/EnterEntityDetailsSharedState.graphml")
public interface EnterEntityDetailsSharedState {

    @Vertex()
    void v_LandingPage();

    @Edge()
    void e_CorrectData();

    @Edge()
    void e_IncorrectData();

    @Edge()
    void e_LandingPage();

    @Vertex()
    void v_EnterEntityDetailsPage();

    @Vertex()
    void v_IncorrectData();

    @Vertex()
    void v_SearchResults();

    @Edge()
    void e_ContinueNewRequest();

    @Edge()
    void e_ClearData();

    @Vertex()
    void v_ContinueNewRequest();

    @Edge()
    void e_Client_CompleteRequest();

    @Vertex()
    void v_Client_CompleteRequest();

    @Vertex()
    void v_NonClient_CompleteRequest();

    @Edge()
    void e_NonClient_CompleteRequest();
}
