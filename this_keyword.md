# Java `this` 키워드 정리

## 🔍 `this`란?

자바에서 `this` 키워드는 **현재 객체 자기 자신을 참조**하는 키워드입니다. 주로 인스턴스 변수와 매개변수의 이름이 같을 때 이를 **명확히 구분**하기 위해 사용됩니다.

---

## 📌 사용 목적

1. **인스턴스 변수와 매개변수 이름이 같을 때 구분**
2. **현재 객체의 메서드 호출**
3. **현재 객체를 반환하여 메서드 체이닝 구현**
4. **생성자 내부에서 다른 생성자 호출 (`this()`)**

---

## ✅ 예제

### 1. 인스턴스 변수와 매개변수 구분

```java
public class Person {
    String name;

    public Person(String name) {
        this.name = name; // this.name은 인스턴스 변수, name은 매개변수
    }

    public void printName() {
        System.out.println("이름: " + this.name);
    }
}

public class Student {
    String name;
    int grade;

    public Student(String name) {
        this(name, 1); // 아래 생성자 호출
    }

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class Car {
    String color;
    String type;

    public Car setColor(String color) {
        this.color = color;
        return this;
    }

    public Car setType(String type) {
        this.type = type;
        return this;
    }

    public void showInfo() {
        System.out.println("자동차 색상: " + this.color + ", 종류: " + this.type);
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.setColor("Red").setType("SUV").showInfo();
    }
}
```
문제
```java
class A {
    int n = 1;

    public int getN() {
        return n;
    }

    public void setN(int n){
        this.n = n;
    }
}

class B extends A {
    int n = 2;

    @Override
    public int getN() {
        return n;
    }

    @Override
    public void setN(int n){
        this.n = n;
    }
}

A a = new B();
System.out.println(a.n);        // ?
System.out.println(a.getN());   // ?
a.setN(10);
System.out.println(a.n);        // ?
System.out.println(a.getN());   // ?
```
