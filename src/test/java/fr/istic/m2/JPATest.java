package fr.istic.m2;

public class JPATest {
  public static void main(String[] args) {
    EntityManagerHelper.beginTransaction();

    try {

    } catch (Exception e) {
      e.printStackTrace();
    }

    EntityManagerHelper.commit();
    EntityManagerHelper.closeEntityManagerFactory();
  }
}
