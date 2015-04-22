package test.com.twu.biblioteca;

import com.twu.biblioteca.controller.Book;
import com.twu.biblioteca.controller.IssueDetail;
import com.twu.biblioteca.controller.IssuedHistory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by dabluk on 17/04/15.
 */
public class IssuedHistoryTests {

    IssuedHistory issuedHistory = new IssuedHistory();
    private ArrayList<IssueDetail> issueDetailList = new ArrayList<IssueDetail>();
    @Before
    public void setup(){
        IssueDetail bookissueDetail = new IssueDetail("Dablu",new Book("B1","JAVA","Herbert Schield","Sun"));
        issuedHistory.addIssueDetail(bookissueDetail);

    }
    @Test
    public void ShouldAddAIssueToIssuedHistory(){
        assertEquals(1, issuedHistory.getIssuedStorageDetails().size());
    }

    @Test
    public void ShouldReturnACustomerName(){
        issueDetailList= issuedHistory.getIssuedStorageDetails();
        Book book = (Book)issueDetailList.get(0).getRentableObject();
    //    System.out.println(book.getBookNo());
        assertEquals("Dablu", issuedHistory.getIssueDetail(book));
    }




}
