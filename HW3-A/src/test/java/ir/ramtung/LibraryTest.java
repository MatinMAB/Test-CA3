package ir.ramtung.impl1;
import ir.ramtung.sts01.LibraryException;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.Before;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeThat;

import java.util.*;

@RunWith(JUnitQuickcheck.class)
public class LibraryTest {

    private Library library;

    @Before
    public void setUp() {
        library = new Library();
    }

    @Property
    public void addingStudentMemberIncreasesMemberCount(
            @From(NonEmptyStringGenerator.class) String studentId,
            @From(NonEmptyStringGenerator.class) String studentName) throws LibraryException {
        int initialCount = library.members.size();
        library.addStudentMember(studentId, studentName);
        int newCount = library.members.size();
        assertEquals(initialCount + 1, newCount);
    }

    @Property
    public void addingBookIncreasesDocumentCount(
            @From(NonEmptyStringGenerator.class) String bookTitle,
            @InRange(minInt = 1) int copies) throws LibraryException {
        int initialCount = library.availableTitles().size();
        library.addBook(bookTitle, copies);
        assertTrue(library.availableTitles().size() >= initialCount);
    }

    @Property
    public void borrowingBookDecreasesAvailableCopies(
            @From(NonEmptyStringGenerator.class) String studentId,
            @From(NonEmptyStringGenerator.class) String studentName,
            @From(NonEmptyStringGenerator.class) String bookTitle,
            @InRange(minInt = 1) int copies) throws LibraryException {
        library.addStudentMember(studentId, studentName);
        library.addBook(bookTitle, copies);
        int initialCopies = library.availableTitles().size();
        library.borrow(studentName, bookTitle);
        assertTrue(library.availableTitles().size() <= initialCopies);
    }

    @Property
    public void returningBookIncreasesAvailableCopies(
            @From(NonEmptyStringGenerator.class) String studentId,
            @From(NonEmptyStringGenerator.class) String studentName,
            @From(NonEmptyStringGenerator.class) String bookTitle,
            @InRange(minInt = 1) int copies) throws LibraryException {
        library.addStudentMember(studentId, studentName);
        library.addBook(bookTitle, copies);
        library.borrow(studentName, bookTitle);
        int initialCopies = library.availableTitles().size();
        library.returnDocument(studentName, bookTitle);
        assertTrue(library.availableTitles().size() >= initialCopies);
    }

    @Property
    public void extendingLoanExtendsDueDate(
            @From(NonEmptyStringGenerator.class) String studentId,
            @From(NonEmptyStringGenerator.class) String studentName,
            @From(NonEmptyStringGenerator.class) String bookTitle,
            @InRange(minInt = 1) int copies,
            @InRange(minInt = 1) int days) throws LibraryException {
        library.addStudentMember(studentId, studentName);
        library.addBook(bookTitle, copies);
        library.borrow(studentName, bookTitle);
        int initialDueDate = library.getLoanDueDate(studentName, bookTitle);
        int loanDuration = library.getDocumentLoanDuration(bookTitle);
        library.timePass(days);
        library.extend(studentName, bookTitle);
        int extendedDueDate = library.getLoanDueDate(studentName, bookTitle);
        assertEquals(initialDueDate + loanDuration, extendedDueDate);
    }

    @Property
    public void overdueBooksIncurPenalty(
            @From(NonEmptyStringGenerator.class) String studentId,
            @From(NonEmptyStringGenerator.class) String studentName,
            @From(NonEmptyStringGenerator.class) String bookTitle,
            @InRange(minInt = 1) int copies,
            @InRange(minInt = 1) int days) throws  LibraryException {
        library.addStudentMember(studentId, studentName);
        library.addBook(bookTitle, copies);
        library.borrow(studentName, bookTitle);
        library.timePass(days);
        int penalty = library.getTotalPenalty(studentName);
        assertTrue(days <= 10 ? penalty == 0 : penalty > 0);
    }

    @Property
    public void addingDuplicateMemberThrowsException(
            @From(NonEmptyStringGenerator.class) String studentId,
            @From(NonEmptyStringGenerator.class) String studentName) {
        try {
            library.addStudentMember(studentId, studentName);
            library.addStudentMember(studentId, studentName);
            fail("Expected DuplicateMemberEx to be thrown");
        } catch (DuplicateMemberEx e) {
            // Expected exception
        } catch (LibraryException e) {
            fail("Unexpected exception");
        }
    }


    @Property
    public void borrowingMoreThanAllowedThrowsException(
            @From(NonEmptyStringGenerator.class) String studentId,
            @From(NonEmptyStringGenerator.class) String studentName,
            @From(NonEmptyStringGenerator.class) String bookTitle1,
            @From(NonEmptyStringGenerator.class) String bookTitle2,
            @From(NonEmptyStringGenerator.class) String bookTitle3) {
        try {
            library.addStudentMember(studentId, studentName);
            library.addBook(bookTitle1, 1);
            library.addBook(bookTitle2, 1);
            library.addBook(bookTitle3, 1);
            library.borrow(studentName, bookTitle1);
            library.borrow(studentName, bookTitle2);
            library.borrow(studentName, bookTitle3);
            fail("Expected CannotBorrowEx to be thrown");
        } catch (CannotBorrowEx e) {
            // Expected exception
        } catch (LibraryException e) {
            fail("Unexpected exception");
        }
    }

    @Property
    public void returningBookOnDueDateNoPenalty(
            @From(NonEmptyStringGenerator.class) String studentId,
            @From(NonEmptyStringGenerator.class) String studentName,
            @From(NonEmptyStringGenerator.class) String bookTitle,
            @InRange(minInt = 1) int copies) throws LibraryException {
        library.addStudentMember(studentId, studentName);
        library.addBook(bookTitle, copies);
        library.borrow(studentName, bookTitle);
        int dueDate = library.getLoanDueDate(studentName, bookTitle);
        library.timePass(dueDate - library.getLoanDueDate(studentName, bookTitle));
        library.returnDocument(studentName, bookTitle);
        assertEquals(0, library.getTotalPenalty(studentName));
    }

    @Property
    public void returningBookAfterDueDatePenalizes(
            @From(NonEmptyStringGenerator.class) String studentId,
            @From(NonEmptyStringGenerator.class) String studentName,
            @From(NonEmptyStringGenerator.class) String bookTitle,
            @InRange(minInt = 1) int copies,
            @InRange(minInt = 1) int daysLate) throws LibraryException {
        library.addStudentMember(studentId, studentName);
        library.addBook(bookTitle, copies);
        library.borrow(studentName, bookTitle);
        int dueDate = library.getLoanDueDate(studentName, bookTitle);
        library.timePass(dueDate + daysLate - library.getLoanDueDate(studentName, bookTitle));
        library.returnDocument(studentName, bookTitle);
        assertTrue(library.getTotalPenalty(studentName) > 0);
    }

    @Property
    public void professorCannotBorrowMoreThanFiveDocuments(
            @From(NonEmptyStringGenerator.class) String profName,
            @From(NonEmptyStringGenerator.class) List<String> bookTitles) throws LibraryException {
        assumeThat(bookTitles.size() , greaterThanOrEqualTo(5));
        library.addProfMember(profName);
        for (int i = 0; i < 5; i++) {
            library.addBook(bookTitles.get(i), 1);
            library.borrow(profName, bookTitles.get(i));
        }
        library.addBook(bookTitles.get(5), 1);
        library.borrow(profName, bookTitles.get(5));
        fail("Professor should not be able to borrow more than 5 documents");
    }
}