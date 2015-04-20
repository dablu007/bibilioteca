package com.twu.biblioteca.controller;

import java.util.ArrayList;

/**
 * Created by dabluk on 17/04/15.
 */
public class IssuedHistory {
    private ArrayList<IssueDetail> issueDetails = new ArrayList<IssueDetail>();;

    public IssuedHistory() {
        ArrayList<IssueDetail> storageDetails = new ArrayList<IssueDetail>();

    }


    public void addIssueDetail(IssueDetail issueDetail) {
        issueDetails.add(issueDetail);
    }
    public ArrayList<IssueDetail> getIssuedStorageDetails() {
        return issueDetails;
    }

    public String getCustomerName(int bookno,ArrayList<IssueDetail> issuedetails) {
        for(IssueDetail issueDetail:issuedetails){
            System.out.println(issueDetail.getBook());
            if (issueDetail.getBook().getBookNo() == bookno ){
                return issueDetail.getCustomerName();
            }

        }
        return null;
    }

}
