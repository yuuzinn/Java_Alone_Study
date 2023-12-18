package javaOfGod.version1.example;

public class Profile {
  String name;
  int age;

  public static void main(String[] args) {
    Profile profile = new Profile();
    profile.setName("Min");
    profile.setAge(20);
    profile.printName(profile);
    profile.printAge(profile);
  }

  public String getName() {
    return name;
  }

  public void setName(String str) {
    this.name = str;
  }
  public void setAge(int val) {
    this.age = val;
  }
  public void printName(Profile profile) {
    System.out.println("My Name is " + profile.name);
  }
  public void printAge(Profile profile) {
    System.out.println("My Age is " + profile.age);
  }
}
