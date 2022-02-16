package Tamrin3;

public class Main {
    public static void main(String[] args) {
      final CheckingAccount ca = new CheckingAccount(100);
      Runnable r = new Runnable() {
          @Override
          public void run() {
               String name = Thread.currentThread().getName();
              for (int i = 0; i < 10; i++) {
                  System.out.println(name + "withdraws $10: " + ca.withdraw(10));

              }
          }
      };
      Thread thdHusband = new Thread(r);
      thdHusband.setName("Husband");
      Thread thdWife = new Thread(r);
      thdWife.setName("wife");
      thdHusband.start();
      thdWife.start();
    }
}
