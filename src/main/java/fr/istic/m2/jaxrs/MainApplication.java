package fr.istic.m2.jaxrs;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class MainApplication extends Application {
  @Override
  public Set<Class<?>> getClasses() {
    final Set<Class<?>> classes = new HashSet<Class<?>>();

    //classes.add();
    return classes;
  }
}
