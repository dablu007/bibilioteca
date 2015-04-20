package test.com.twu.biblioteca;

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
    IssueDetail bookissueDetail;
    IssuedHistory storageDetails;
    private ArrayList<IssueDetail> bookStoreDetails = new ArrayList<IssueDetail>();
    @Before
    public void setup(){
        bookissueDetail = new IssueDetail("Dablu",1);
        storageDetails = new IssuedHistory(bookissueDetail);
        bookissueDetail = new IssueDetail("Vinnet",2);
        storageDetails = new IssuedHistory(bookissueDetail);
    }
    @Test
    public void ShouldReturnABookAgainstBookNo(){
        bookStoreDetails = storageDetails.getStorageDetails();
        assertEquals("Dablu", storageDetails.getPersonName(1));
    }

}
