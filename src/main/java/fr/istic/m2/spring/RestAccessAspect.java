package fr.istic.m2.spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestAccessAspect {
  @Before("execution(* fr.istic.m2.spring.*Controller.*(..))")
  public void logRestRouteAccess() {
    System.out.println("REST Route accessed");
  }
}
