/*
 * This file was automatically generated by EvoSuite
 * Mon Jun 10 09:48:21 GMT 2024
 */

package ir.ramtung.sts01;

import org.junit.Test;
import static org.junit.Assert.*;
import ir.ramtung.sts01.Main;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Main_ESTest extends Main_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Main main0 = new Main();
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Main.main((String[]) null);
  }
}
