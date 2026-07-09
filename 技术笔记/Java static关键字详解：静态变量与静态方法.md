# Java static关键字详解：静态变量与静态方法

## static 变量（static variable）
### 概念
- 也叫类变量（class variable）。
- 它属于整个类，不属于某一个对象。类里所有对象共享同一个 static 变量。
- 例子：
```java
// Student类
public class Student {
    //是普通变量，每个学生对象有自己的名字。
    String name;
    //是静态变量，此类里所有学生对象共用一个学校名。
    static String school = "UW-Madison";

    public Student(String name) {
        this.name = name;
    }

    public void printInfo() {
        System.out.println(name + " goes to " + school);
    }
}
```
```java
// Main类
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        s1.printInfo(); //输出：Alice goes to UW-Madison
        s2.printInfo(); //输出：Bob goes to UW-Madison
    }
}
```
### 访问static 变量
- static 变量可以通过类名访问：`System.out.println(Student.school);`
- 例子：
```java
public class Main {
    public static void main(String[] args) {
        System.out.println(Student.school); 
        // 输出：UW-Madison
    }
}
```
### static 变量被所有对象共享
- 例子：
```java
// Student类
public class Student {
    String name;
    static String school = "UW-Madison";

    public Student(String name) {
        this.name = name;
    }
}
```
```java
// Main类
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        System.out.println(s1.school); // UW-Madison
        System.out.println(s2.school); // UW-Madison

        Student.school = "UIUC";
        //将所有student的学校名都改成了UIUC

        System.out.println(s1.school); // UIUC
        System.out.println(s2.school); // UIUC
    }
}
```
## static 方法（static method）
### 概念
- 也叫类方法，属于类本身，不需要创建对象就能调用。
- 调用格式：`ClassName.methodName();`
- 例子：
```java
// 工具类方法：平方
// MathTools类
public class MathTools {
    public static int square(int x) {
        return x * x;
    }
}
```
```java
// Main类
public class Main {
    public static void main(String[] args) {
        int result = MathTools.square(5);
        System.out.println(result); // 输出：25
    }
}
```
- 不用写：
```java
MathTools tool = new MathTools();
tool.square(5);
```
### Java 自带的 static 方法例子:
- 平方根（sqrt）
```java
public class Main {
    public static void main(String[] args) {
        double result = Math.sqrt(25);
        // 返回值类型 变量名 = 类名.静态方法名(参数);
        System.out.println(result); // 输出：5.0
    }
}
```
## static 方法不能直接访问非 static 成员变量
- 错误例子：
```java
public class Student {
    String name = "Alice";

    public static void printName() {
        System.out.println(name); // 错误
    }
}
```
- 正确方式：创建对象，再访问对象变量
```java
// Student类
public class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }

    public static void printName(Student s) {
        System.out.println(s.name);
    }
}
```
```java
// Main类
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Alice");

        Student.printName(s1); // 输出：Alice
    }
}
```
## 非 static 方法可以直接访问 static 成员
- 例子：
```java
public class Student {
    String name;
    static String school = "UW-Madison";

    public Student(String name) {
        this.name = name;
        //当前这个 Student 对象的 name = 传进来的name（参数）
    }

    public void printInfo() {
        System.out.println(name + " goes to " + school);
    }
}
```
```java
public class Main {
    public static void main(String[] args) {
        Student s = new Student("Carrie");
        s.printInfo(); // 输出：Carrie goes to UW-Madison
    }
}
```
## Main方法是static
```java
public static void main(String[] args) {
}
```
## static 和对象数量无关
- 普通变量：每个对象一份；static 变量：整个类只有一份。
```java
public class Dog {
    String name; //普通变量，每只狗对象有不同名字
    static int dogCount = 0; //静态变量：整个类都用一个

    public Dog(String name) {
        this.name = name;
        dogCount++;
        // 每创建一只狗对象，constructor都会执行一次，统计创建了多少个对象。
    }
}
```
```java
public class Main {
    public static void main(String[] args) {
        Dog d1 = new Dog("Coco");
	        Dog d2 = new Dog("Lucky");
        Dog d3 = new Dog("Happy");

        System.out.println(Dog.dogCount); // 输出：3
    }
}
```
## static 常量配合 final 使用：
- static 经常和 final 一起用：`public static final double TAX_RATE = 0.055;`，意思是设定一个变量，初始化赋值后不能被修改值。
- 例子：
```java
public class Store {
    public static final double TAX_RATE = 0.055;

    public static double calculateTotal(double price) {
        return price + price * TAX_RATE;
    }
}
```
```java
public class Main {
    public static void main(String[] args) {
        double total = Store.calculateTotal(100);
        System.out.println(total); // 输出：105.5（100+100*0.055）
    }
}
```
- 常量命名通常全大写！如：`MAX_SCORE`, `PI`, `DEFAULT_SIZE`, `TAX_RATE`。
### Java 自带例子：Math.PI
- PI 是一个 static final 常量，因为它不属于某个 Math 对象，而且数值不应该被修改。
```java
public class Main {
    public static void main(String[] args) {
        double radius = 2.0;
        double area = Math.PI * radius * radius;

        System.out.println(area);
    }
}
```