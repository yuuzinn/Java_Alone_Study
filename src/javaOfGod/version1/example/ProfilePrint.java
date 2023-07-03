package javaOfGod.version1.example;

public class ProfilePrint {
  byte age;
  String name;
  boolean isMarried;
  public void setAge(byte age) {
    this.age = age;
  }
  public byte getAge() {
    return age;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getName() {
    return name;
  }
  public void setIsMarried(boolean isMarried) {
    this.isMarried = isMarried;
  }
  public boolean getIsMarried() {
    return isMarried;
  }

  public static void main(String[] args) {
    ProfilePrint profile = new ProfilePrint();
    profile.setAge((byte) 10);
    profile.setName("John");
    profile.setIsMarried(true);
    System.out.println(profile.getAge());
    System.out.println(profile.getName());
    System.out.println(profile.getIsMarried());
  }
}
