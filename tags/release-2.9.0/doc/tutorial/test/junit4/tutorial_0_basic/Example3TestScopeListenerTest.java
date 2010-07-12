package junit4.tutorial_0_basic;

import com.google.guiceberry.junit4.GuiceBerryRule;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Scopes;
import com.google.guiceberry.GuiceBerryModule;
import com.google.guiceberry.TestId;
import com.google.guiceberry.TestWrapper;

import org.junit.Rule;
import org.junit.Test;

public class Example3TestScopeListenerTest {

  @Rule
  public final GuiceBerryRule guiceBerry = new GuiceBerryRule(Env.class);

  @Test
  public void testOne() throws Exception {
    System.out.println("Inside testOne");
  }

  @Test
  public void testTwo() throws Exception {
    System.out.println("Inside testTwo");
  }

  public static final class Example3TestScopeListener implements TestWrapper {

    @Inject
    private Provider<TestId> testId;

    public void toRunBeforeTest() {
      System.out.println("Entering scope of: " + testId.get());
    }

    public void toRunAfterTest() {
      System.out.println("Exiting scope of: " + testId.get());
    }
  }

  public static final class Env extends GuiceBerryModule {
    
    @Override
    protected void configure() {
      // TODO Auto-generated method stub
      super.configure();
      bind(TestWrapper.class).to(Example3TestScopeListener.class).in(Scopes.SINGLETON);
    }
  }
}
