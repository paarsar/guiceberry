/*
 * Copyright (C) 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.inject.testing.guiceberry;

import com.google.guiceberry.GuiceBerryJunit3Test;
import com.google.inject.testing.guiceberry.controllable.IcMasterTest;
import com.google.inject.testing.guiceberry.controllable.InterceptingBindingsBuilderTest;
import com.google.inject.testing.guiceberry.util.MutableSingletonScopeTest;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

  public static Test suite() {
    TestSuite suite =
        new TestSuite("Test for com.google.inject.testing.guiceberry.junit3");
    //$JUnit-BEGIN$
    suite.addTestSuite(GuiceBerryJunit3Test.class);
    suite.addTestSuite(IcMasterTest.class);
    suite.addTestSuite(InterceptingBindingsBuilderTest.class);
    suite.addTestSuite(MutableSingletonScopeTest.class);
    //$JUnit-END$
    return suite;
  }

}
