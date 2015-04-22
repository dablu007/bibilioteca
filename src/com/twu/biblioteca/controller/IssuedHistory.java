package com.twu.biblioteca.controller;

import java.util.ArrayList;

/**
 * Created by dabluk on 17/04/15.
 */
public class IssuedHistory {
    private ArrayList<IssueDetail> issueDetails;

    public IssuedHistory() {
        issueDetails = new ArrayList<IssueDetail>();
    }


    public void addIssueDetail(IssueDetail issueDetail) {
        issueDetails.add(issueDetail);
    }

    public ArrayList<IssueDetail> getIssuedStorageDetails() {
        return issueDetails;
    }

    public IssueDetail getIssueDetail(IRentableObject rentableObject) {
        for(IssueDetail issueDetail: issueDetails){
            if ( isSimilar( issueDetail.getRentableObject() , rentableObject)){
                return issueDetail;
            }
        }
        return null;
    }

    private boolean isSimilar(IRentableObject rentableObjectfirst, IRentableObject rentableObjectSecond) {
        return (rentableObjectfirst.gethashcode() == rentableObjectSecond.gethashcode());
    }

}
