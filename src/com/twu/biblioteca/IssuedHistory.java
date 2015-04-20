package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by dabluk on 17/04/15.
 */
public class IssuedHistory {
    private ArrayList<IssueDetail> storageDetails;

    public IssuedHistory() {
        ArrayList<IssueDetail> storageDetails = new ArrayList<IssueDetail>();

    }
    public void addIssueDetail(IssueDetail issueDetail){
        storageDetails.add(issueDetail);
    }
    public ArrayList<IssueDetail> getStorageDetails() {
        return storageDetails;
    }
    public String getPersonName(int bookno){
        for (int i = 0; i < storageDetails.size(); i++) {
            if (storageDetails.get(i).getBookno() == bookno)
                return storageDetails.get(i).getPersonName();
        }
        return null;
    }
}
