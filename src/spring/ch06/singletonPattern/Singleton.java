package spring.ch06.singletonPattern;

/**
 * singleton 특징 꼭 기억하기.
 * 1. private 생성자를 갖는다
 * 2. 단일 객체 참조 변수를 정적 속성으로 갖는다.
 * 3. 단일 객체 참조 변수가 참조하는 단일 객체를 리턴하는 getInstance() 정적 메서드를 갖는다.
 * 4. 단일 객체는 쓰기 가능한 속성을 갖지 않는 것이 정석이다. (전역/공유변수 사용 지양과 일맥상통)
 *
 * "클래스의 인스턴스, 즉 객체를 하나만 만들어 사용하는 패턴이다."
 */

public class Singleton {
    static Singleton singletonObject; // 정적 참조 변수

    private Singleton() {} // private 생성자 - new 를 통해 객체 생성 방지용 private

    // 객체 반환 정적 메서드
    public static Singleton getInstance() {
        if (singletonObject == null) { // null 체크
            singletonObject = new Singleton();
        }
        return singletonObject;
    }
}
