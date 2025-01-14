/*
 * This file was automatically generated by EvoSuite
 * Mon Jun 10 09:38:30 GMT 2024
 */

package ir.ramtung.impl2;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import ir.ramtung.impl2.Book;
import ir.ramtung.impl2.Document;
import ir.ramtung.impl2.Magazine;
import ir.ramtung.impl2.Prof;
import ir.ramtung.impl2.Reference;
import ir.ramtung.impl2.Student;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Person_ESTest extends Person_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Prof prof0 = new Prof("w%qtx");
      Reference reference0 = new Reference("w%qtx", (-666));
      reference0.day = 0;
      prof0.borrow(reference0);
      prof0.timePass();
      prof0.timePass();
      assertEquals(10000, prof0.getPenalty());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Student student0 = new Student("<", "<");
      Magazine magazine0 = new Magazine("<", (-13), (-13), (-13));
      magazine0.day = (-13);
      student0.borrow(magazine0);
      student0.timePass();
      student0.returnDoc("<");
      assertEquals(2000, student0.getPenalty());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Prof prof0 = new Prof("o,TY},YY?");
      Magazine magazine0 = new Magazine("o,TY},YY?", 0, 0, 0);
      prof0.borrow(magazine0);
      prof0.borrow(magazine0);
      prof0.returnDoc("");
      assertEquals(0, prof0.getPenalty());
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Prof prof0 = new Prof("w%qtx");
      Reference reference0 = new Reference("w%qtx", (-666));
      reference0.day = 0;
      prof0.borrow(reference0);
      prof0.timePass();
      prof0.extend("w%qtx");
      assertEquals(5000, prof0.getPenalty());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Prof prof0 = new Prof("w%qtx");
      Reference reference0 = new Reference("w%qtx", (-666));
      reference0.day = 0;
      prof0.borrow(reference0);
      prof0.timePass();
      int int0 = prof0.getPenalty();
      assertEquals(5000, int0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Student student0 = new Student("", "");
      student0.penalty = (-78);
      int int0 = student0.getPenalty();
      assertEquals((-78), int0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Prof prof0 = new Prof((String) null);
      prof0.getName();
      assertEquals(0, prof0.getPenalty());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Prof prof0 = new Prof("9\"");
      String string0 = prof0.getName();
      assertNotNull(string0);
      assertEquals(0, prof0.getPenalty());
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Prof prof0 = new Prof("");
      prof0.canBorrow();
      assertEquals(0, prof0.getPenalty());
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Student student0 = new Student("ir.ramtung.impl2.Student", "ir.ramtung.impl2.Student");
      Reference reference0 = new Reference("ir.ramtung.impl2.Student", (-856));
      Book book0 = new Book("ir.ramtung.impl2.Student", (-856));
      student0.borrow(book0);
      student0.borrow(reference0);
      boolean boolean0 = student0.canBorrow();
      assertFalse(student0.canBorrow());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Student student0 = new Student("ir.ramtung.impl2.Prof", "ir.ramtung.impl2.Prof");
      LinkedList<Integer> linkedList0 = new LinkedList<Integer>();
      student0.dayBorrow = (List<Integer>) linkedList0;
      linkedList0.add((Integer) null);
      // Undeclared exception!
      try { 
        student0.timePass();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("ir.ramtung.impl2.Person", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Student student0 = new Student("ir.ramtung.impl2.Book", "ir.ramtung.impl2.Book");
      Magazine magazine0 = new Magazine("ir.ramtung.impl2.Book", (-1316), 0, 3846);
      student0.borrow(magazine0);
      LinkedList<Document> linkedList0 = new LinkedList<Document>();
      student0.timePass();
      student0.docsBorrow = (List<Document>) linkedList0;
      student0.timePass();
      // Undeclared exception!
      try { 
        student0.timePass();
        fail("Expecting exception: IndexOutOfBoundsException");
      
      } catch(IndexOutOfBoundsException e) {
         //
         // Index: 0, Size: 0
         //
         verifyException("java.util.LinkedList", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Prof prof0 = new Prof("o,TY},YY?");
      Magazine magazine0 = new Magazine((String) null, 0, 0, (-3991));
      prof0.borrow(magazine0);
      // Undeclared exception!
      try { 
        prof0.returnDoc("");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Student student0 = new Student("", "");
      Book book0 = new Book("", 0);
      student0.borrow(book0);
      LinkedList<Integer> linkedList0 = new LinkedList<Integer>();
      student0.dayBorrow = (List<Integer>) linkedList0;
      // Undeclared exception!
      try { 
        student0.returnDoc("");
        fail("Expecting exception: IndexOutOfBoundsException");
      
      } catch(IndexOutOfBoundsException e) {
         //
         // Index: 0, Size: 0
         //
         verifyException("java.util.LinkedList", e);
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Prof prof0 = new Prof((String) null);
      LinkedList<Document> linkedList0 = new LinkedList<Document>();
      Magazine magazine0 = new Magazine("cant extend", (-1444), (-1142), (-680));
      linkedList0.add((Document) magazine0);
      prof0.docsBorrow = (List<Document>) linkedList0;
      // Undeclared exception!
      try { 
        prof0.extend("cant extend");
        fail("Expecting exception: IndexOutOfBoundsException");
      
      } catch(IndexOutOfBoundsException e) {
         //
         // Index: 0, Size: 0
         //
         verifyException("java.util.ArrayList", e);
      }
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Prof prof0 = new Prof((String) null);
      prof0.docsBorrow = null;
      // Undeclared exception!
      try { 
        prof0.canBorrow();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("ir.ramtung.impl2.Prof", e);
      }
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Student student0 = new Student("", "");
      LinkedList<Boolean> linkedList0 = new LinkedList<Boolean>();
      student0.canExtend = (List<Boolean>) linkedList0;
      student0.canExtend = null;
      Magazine magazine0 = new Magazine("", 0, 0, 1);
      // Undeclared exception!
      try { 
        student0.borrow(magazine0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("ir.ramtung.impl2.Person", e);
      }
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Student student0 = new Student("", "");
      LinkedList<Boolean> linkedList0 = new LinkedList<Boolean>();
      Boolean boolean0 = Boolean.FALSE;
      linkedList0.add(0, boolean0);
      student0.canExtend = (List<Boolean>) linkedList0;
      Magazine magazine0 = new Magazine("7Ij_ERfFe0oUcR@e", 0, 0, 0);
      student0.borrow(magazine0);
      try { 
        student0.extend("7Ij_ERfFe0oUcR@e");
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // cant extend
         //
         verifyException("ir.ramtung.impl2.Person", e);
      }
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Student student0 = new Student("", "");
      Book book0 = new Book("", 0);
      student0.borrow(book0);
      assertTrue(student0.canBorrow());
      
      student0.extend("");
      assertEquals(0, student0.getPenalty());
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      Prof prof0 = new Prof(";");
      LinkedList<Document> linkedList0 = new LinkedList<Document>();
      prof0.docsBorrow = (List<Document>) linkedList0;
      Book book0 = new Book(";", 6);
      linkedList0.push(book0);
      try { 
        prof0.extend(":");
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // cant extend
         //
         verifyException("ir.ramtung.impl2.Person", e);
      }
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Prof prof0 = new Prof("");
      Book book0 = new Book((String) null, 3);
      prof0.borrow(book0);
      // Undeclared exception!
      try { 
        prof0.extend("");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
      }
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      Prof prof0 = new Prof("");
      String string0 = prof0.getName();
      assertNotNull(string0);
      assertEquals(0, prof0.getPenalty());
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Prof prof0 = new Prof("");
      int int0 = prof0.getPenalty();
      assertEquals(0, int0);
  }
}
