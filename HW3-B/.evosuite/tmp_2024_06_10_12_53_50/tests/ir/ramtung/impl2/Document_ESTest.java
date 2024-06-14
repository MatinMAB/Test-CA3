/*
 * This file was automatically generated by EvoSuite
 * Mon Jun 10 09:49:03 GMT 2024
 */

package ir.ramtung.impl2;

import org.junit.Test;
import static org.junit.Assert.*;
import ir.ramtung.impl2.Book;
import ir.ramtung.impl2.Magazine;
import ir.ramtung.impl2.Reference;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Document_ESTest extends Document_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Reference reference0 = new Reference("I", 0);
      reference0.title = "sa{CL^0rl05";
      reference0.title = null;
      reference0.getTitle();
      assertEquals(0, reference0.getCopies());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Magazine magazine0 = new Magazine("", 484, 2498, 0);
      String string0 = magazine0.getTitle();
      assertNotNull(string0);
      assertEquals(0, magazine0.getCopies());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Book book0 = new Book("", 1390);
      book0.day = 0;
      int int0 = book0.getDay();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Reference reference0 = new Reference("&(dw5K^<OEt-", (-1712));
      reference0.day = (-106);
      int int0 = reference0.getDay();
      assertEquals((-106), int0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Book book0 = new Book("G6TluDu0>!hkW=!{n>", 0);
      int int0 = book0.getCopies();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Magazine magazine0 = new Magazine("", 2592, 2592, 2592);
      int int0 = magazine0.getCopies();
      assertEquals(2592, int0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Reference reference0 = new Reference("&(dw5K^<OEt-", (-1712));
      reference0.calculatePenalty(1390);
      assertEquals((-1712), reference0.getCopies());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Magazine magazine0 = new Magazine("ta(ESDMQs~n0/u`.rs!", (-87), (-87), (-87));
      int int0 = magazine0.getCopies();
      assertEquals((-87), int0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Magazine magazine0 = new Magazine("ta(ESDMQs~n0/u`.rs!", (-87), (-87), (-87));
      magazine0.returnBook();
      assertEquals((-86), magazine0.getCopies());
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Magazine magazine0 = new Magazine("ta(ESDMQs~n0/u`.rs!", (-87), (-87), (-87));
      String string0 = magazine0.getTitle();
      assertNotNull(string0);
      assertEquals((-87), magazine0.getCopies());
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Magazine magazine0 = new Magazine("ta(ESDMQs~n0/u`.rs!", (-87), (-87), (-87));
      int int0 = magazine0.getDay();
      assertEquals(2, int0);
      assertEquals((-87), magazine0.getCopies());
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Magazine magazine0 = new Magazine("ta(ESDMQs~n0/u`.rs!", (-87), (-87), (-87));
      magazine0.barrowBook();
      assertEquals((-88), magazine0.getCopies());
  }
}
