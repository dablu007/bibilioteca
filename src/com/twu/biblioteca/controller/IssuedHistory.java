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

    public IssueDetail getIssueDetail(int bookno) {
        for(IssueDetail issueDetail: issueDetails){
            if (issueDetail.getBook().getBookNo() == bookno ){
                return issueDetail;
            }

        }
        return null;
    }

}
