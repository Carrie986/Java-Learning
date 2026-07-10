# 构造器 constructor

## 概念

- 也叫构造方法。
- 作用：创建对象时自动执行的特殊方法，给对象的成员变量赋初始值。
- 不用构造器，创建对象后的写法：
```java
Student s = new Student();
// 对象刚创建出来时，name 是 null，age 是 0
s.name = "Carrie";
s.age = 18;
```
- 用构造器，创建对象后的写法：
```java
Student s = new Student("Carrie", 18);
```
## 基本语法
- 结构：
` public 类名(参数列表) {`
`初始化代码;`
`} `
- 例子：
```java
public class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```
## 构造器的特点：
### 构造器的名字必须和类名一样
- 例子：
```java
public class Student { // 类名：Student
    String name;

    public Student(String name) { // 构造器名：Student
        this.name = name;
    }
}
```
### 构造器没有返回值类型
- 普通方法有返回值类型：
```java
public void introduce() {
    System.out.println("Hello");
}
```
- 构造器没有返回值类型:
```java
public Student(String name) {
    this.name = name;
}
```
### 构造器在 new 对象时自动调用
- 例子：
```java
public class Dog {
    String name;

    public Dog(String name) {
        this.name = name;
        System.out.println("A dog object is created!");
    }
}
```
```java
public class Main {
    public static void main(String[] args) {
        Dog d = new Dog("Lucky");
        System.out.println(d.name);
        // 输出：A dog object is created!
		// Lucky
    }
}
```
### 构造器可以初始化对象
- 例子：
- 没有构造器版本：赋值前对象状态是
` owner = null`
`balance = 0.0`
```java
public class BankAccount {
    String owner;
    double balance;
}
```
```java
BankAccount account = new BankAccount();

account.owner = "Carrie";
account.balance = 1000.0;
```
- 有构造器的版本

```java
// 初始化银行账户的属性
public class BankAccount {
    String owner;
    double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }
}
```
```java
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Carrie", 1000.0);

        System.out.println(account.owner); // 输出：Carrie
        System.out.println(account.balance); // 输出：1000.0
    }
}
```
### `this`在构造器中的意思和作用
- 当前对象的 name = 传进来的参数 name
- 例子：
```java
public class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }
}
```
- 如果没有加`this.`的话，参数就无法给对象的成员变量赋值，因为当参数和成员变量同名时，Java 会根据就近原则，优先使用参数，两个`name`都是参数。
- 这时输出的话就会输出默认初始化的值：`null`。
## 构造器的类型
### 无参构造器
- 就是没有参数的构造器。
- 适用于没有具体信息时，先给对象一个默认状态。
- 例子：
```java
public class Student {
    String name;
    int age;

    public Student() {
        name = "Unknown";
        age = 0;
    }

    public void introduce() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
```
```java
public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.introduce(); // 输出 Name: Unknown, Age: 0
    }
}
```
### 有参构造器
- 带参数的构造器。
- 例子：
```java
public class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
```
```java
public class Main {
    public static void main(String[] args) {
        Student s = new Student("Carrie", 18);
        s.introduce(); // 输出：Name: Carrie, Age: 18
    }
}
```
### 默认构造器（无参）
- 如果一个构造器都不写，Java 会自动提供一个无参构造器。
- 一旦自己写了有参构造器，Java 就不再自动提供无参构造器。
- 例子：
```java
public class Cat {
    String name;
}
// java自动提供下面这个构造器：
// public Cat() {
// }
```
```java
public class Main {
    public static void main(String[] args) {
        Cat c = new Cat();
        System.out.println(c.name); //输出：null，因为没有手动给 name 赋值
    }
}
```
## 构造器和普通方法的区别
|   属性对比   |  构造器 constructor  |      普通方法 method       |
| :----------: | :------------------: | :------------------------: |
|     作用     | 创建对象时初始化对象 |        执行某个功能        |
|     名字     |    必须和类名一样    |           自定义           |
|  返回值类型  | 没有，`void`也不行！ | 必须有返回值类型或者`void` |
|   调用方式   |  用`new`就自动调用   |   用对象名/类名手动调用    |
| 什么时候调用 |      创建对象时      |        需要时，随时        |
| 是否可以重载 |         可以         |            可以            |
- 普通方法命名：不能以数字开头，不能和Java关键字一模一样。用lower camel case命名法：如`getName`，`printScore`。
## 构造器的调用
### 构造器可以调用另一个构造器
- 如果一个类有多个构造器，可以用：`this()` 调用同一个类里的另一个构造器。
- 注意：如果用 `this()` 调用另一个构造器，它必须放在构造器的第一行！
- 例子：
```java
public class Student {
    String name;
    int age;
    String school;

    public Student() {
        this("Unknown", 0, "Unknown School");
    }

    public Student(String name) {
        this(name, 0, "Unknown School");
    }

    public Student(String name, int age, String school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }

    public void introduce() {
        System.out.println(name + ", " + age + ", " + school);
    }
}
```
```java
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Carrie");
        Student s3 = new Student("Carrie", 18, "UW-Madison");

        s1.introduce(); // 输出：Unknown，0，Unknown School
        s2.introduce(); // 输出：Carrie，0，Unknown School
        s3.introduce(); // 输出：Carrie，18，UW-Madison
    }
}
```
### 构造器不能直接被调用
- 构造器不是普通方法，不能通过对象名调用。
- 错误例子：
```java
s.Student("Alice", 20);
```
- 如果想修改对象信息，应该写普通方法：
```java
public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void introduce() {
        System.out.println("My name is " + name);
    }
}
```
```java
public class Main {
    public static void main(String[] args) {
        Student s = new Student("Carrie");
        s.introduce();

        s.setName("Alice"); // 输出：My name is Alice
        s.introduce(); // 输出：My name is Carrie
    }
}
```
- 构造器负责创建时初始化；普通方法负责对象创建之后的行为或修改。
## 构造器做输入检查
- 能防止对象被创建成不合理状态，保证对象一创建出来就是合理的。
- 例子：银行账户余额不能是负数
```java
public class BankAccount {
    String owner;
    double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;

        if (balance < 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public void printInfo() {
        System.out.println(owner + ": $" + balance);
    }
}
```
```java
public class Main {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("Carrie", 1000);
        BankAccount a2 = new BankAccount("Bob", -50);

        a1.printInfo(); // 输出：Carrie: $1000.0
        a2.printInfo(); // 输出：Bob: $0.0
    }
}
```
## 构造器通常和 private 成员变量一起用
- 比较规范的写法是把成员变量设为 `private`。
- 外部不能乱改数据，只能通过构造器和方法控制。
- 封装 encapsulation
- 例子：
```java
public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;

        if (age < 0) {
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
```
```java
public class Main {
    public static void main(String[] args) {
        Student s = new Student("Carrie", 18);

        System.out.println(s.getName()); // 输出：Carrie
        System.out.println(s.getAge()); // 输出：18
    }
}
```