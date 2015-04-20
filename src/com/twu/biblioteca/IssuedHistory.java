package com.twu.biblioteca;

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
            //    System.out.println(issueDetail.getBook().getBookNo());
                return issueDetail.getCustomerName();

            }
            //
        }
        return null;
    }
//    public String getPersonName(int bookno){
//        for (int i = 0; i < issueDetails.size(); i++) {
//            if (issueDetails.get(i).getBookno() == bookno)
//                return issueDetails.get(i).getPersonName();
//        }
//        return null;
//    }
}
