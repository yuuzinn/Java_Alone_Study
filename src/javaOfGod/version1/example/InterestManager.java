package javaOfGod.version1.example;

public class InterestManager {

  public static void main(String[] args) {
    InterestManager manager = new InterestManager();
    double result = 0.0;
//    for (int day = 1; day <= 365; day++) {
//      result += manager.calculateAmount(day, 100_0000);
//    }
    for (int day = 10; day <= 365; day++) {
      if (day % 10 == 0) {
        result += manager.calculateAmount(day, 100_0000);
      }
    }
    System.out.println("result = " + result);
  }
  public double getInterestRate(int day) {
    if (day >= 1 && day <= 90) {
      return 0.05;
    }
    if (day >= 91 && day <= 180) {
      return 0.1;
    }
    if (day >= 181 && day <= 364) {
      return 0.2;
    }
    if (day >= 365) {
      return 0.56;
    }
    return 0;
  }
  public double calculateAmount(int day, long amount) {
    double interestRate = getInterestRate(day);
    return amount + interestRate;
  }
}
