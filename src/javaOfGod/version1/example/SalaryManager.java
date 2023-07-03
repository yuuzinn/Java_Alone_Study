package javaOfGod.version1.example;

public class SalaryManager {

  public static void main(String[] args) {
    SalaryManager manage = new SalaryManager();
    double monthSalary = manage.getMonthSalary(20_000_000);
    System.out.println("최종 결과 = " + monthSalary);
  }
  public double getMonthSalary(int yearlySalary) { // 한 달 월급
    double monthSalary = yearlySalary / 12.0;
    double tax = calculateTax(monthSalary);
    double pension = calculateNationalPension(monthSalary);
    double healthInsurance = calculateHealthInsurance(monthSalary);
    System.out.println("monthsSalary = " + monthSalary);
    System.out.println("공제해야할 세금 = " + tax);
    System.out.println("공제해야할 연금 = " + pension);
    System.out.println("공제해야할 건강 보험료 = " + healthInsurance);
    double deduct = tax + pension + healthInsurance;
    System.out.println(deduct);
    monthSalary -= deduct;
    return monthSalary;
  }
  public double calculateTax(double monthSalary) { // 근로 소득세
    return monthSalary * 0.125;
  }
  public double calculateNationalPension(double monthSalary) {
    return monthSalary * 0.081;
  }
  public double calculateHealthInsurance(double monthSalary) {
    return monthSalary * 0.135;
  }
}
