package test.com.twu.biblioteca;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.IssueDetail;
import com.twu.biblioteca.IssuedHistory;
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
        IssueDetail bookissueDetail = new IssueDetail("Dablu",new Book(1,"JAVA","Herbert Schield","Sun"));
        issuedHistory.addIssueDetail(bookissueDetail);

    }
    @Test
    public void ShouldAddAIssueToIssuedHistory(){
        assertEquals(1, issuedHistory.getIssuedStorageDetails().size());
    }

    @Test
    public void ShouldReturnACustomerName(){
        issueDetailList= issuedHistory.getIssuedStorageDetails();
        Book book = issueDetailList.get(0).getBook();
    //    System.out.println(book.getBookNo());
        assertEquals("Dablu", issuedHistory.getCustomerName(book.getBookNo(),issueDetailList));
    }




}
