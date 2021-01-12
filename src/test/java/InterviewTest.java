import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class InterviewTest {

    private InterviewTask task = new InterviewTask();

    @Test
    public void testForCharacterRepitition() {
        checkRepititionCount("password", 0, false);
        checkRepititionCount("password", 1, false);
        checkRepititionCount("password", 2, true);

        checkRepititionCount("touchwood", 2, false);
        checkRepititionCount("touchwood", 3, true);

        checkRepititionCount("TheQuickBrownFoxJumpsOverTheLazyDog", 2, false);
        checkRepititionCount("TheQuickBrownFoxJumpsOverTheLazyDog", 3, true);
    }

    @Test
    public void testForSequenceLength() {

        //ascending
        checkSequenceLength("abcdef", 0, false);
        checkSequenceLength("abcdef", 5, false);
        checkSequenceLength("abcdef", 6, true);

        //descending
        checkSequenceLength("fedcba", 0, false);
        checkSequenceLength("fedcba", 5, false);
        checkSequenceLength("fedcba", 6, true);

        //numeric ascending
        checkSequenceLength("0123456789", 9, false);
        checkSequenceLength("0123456789", 10, true);

        //numeric descending
        checkSequenceLength("9876543210", 9, false);
        checkSequenceLength("9876543210", 10, true);

        //ascending - mixed case
        checkSequenceLength("ABCdef", 2, false);
        checkSequenceLength("ABCdef", 5, false);
        checkSequenceLength("ABCdef", 6, true);

        //descending - mixed case
        checkSequenceLength("fedCBA", 2, false);
        checkSequenceLength("fedCBA", 5, false);
        checkSequenceLength("fedCBA", 6, true);

        //Exclude/handle non-alphanumeric chars
        checkSequenceLength("/012345678", 8, false);
        checkSequenceLength("/012345678", 9, true);
        checkSequenceLength("0123456789:", 9, false);
        checkSequenceLength("0123456789:", 10, true);
    }

    private void checkRepititionCount(String password, int maxRepitition, boolean expectedResult) {
        boolean isValid = task.isPasswordPermissible(password, maxRepitition, 99);
        System.out.print(">>> Checking '"+password+"', Allowed repititions:" + maxRepitition + ", Expecting result:" + expectedResult + ", Actual result:" + isValid + " ... ");
        assertEquals("Checking '"+password+"', Allowed reptitions:" + maxRepitition, isValid, expectedResult);
        System.out.println("PASS");
    }

    private void checkSequenceLength(String password, int maxLength, boolean expectedResult) {
        boolean isValid = task.isPasswordPermissible(password, 99, maxLength);
        System.out.print(">>> Checking '"+password+"', Allowed sequence-length:" + maxLength + ", Expecting result:" + expectedResult + ", Actual result:" + isValid + " ... ");
        assertEquals("Checking '"+password+"', Allowed sequence-length:" + maxLength, isValid, expectedResult);
        System.out.println("PASS");

    }


}