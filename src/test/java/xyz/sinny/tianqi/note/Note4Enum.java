package xyz.sinny.tianqi.note;

enum Season {
    //一、枚举常量
    // 需要在第一行列出常量
    // 常量可以通过Enum.values()列出
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER;

    //直接switch一个枚举常量
    public void judge(Season s){
        switch (s){
            case AUTUMN:
                System.out.println("1");
            case SPRING:
                System.out.println("2");
            case SUMMER:
                System.out.println("3");
            case WINTER:
                System.out.println("4");
            default:
                System.out.println("5");
        }
    }

    public void main1(){
        //常量可以通过Enum.values()列出
        for (Season s : Season.values()) {
            System.out.println(s);
        }
        //使用.的方式访问枚举常量
        judge(Season.AUTUMN);
    }

    //二、枚举的成员变量、方法和构造器
    // 当定义一个枚举类型时，每一个枚举类型成员都可以看作是枚举类型的
    // 一个实例，这些枚举类型成员默认都被final、public、static所
    // 修饰，所以当使用枚举类型成员时直接使用枚举类型名称调用枚举类型
    // 成员即可
    public String name;

    public void main2(){
        //通过Enum.valueOf(class,enum const)获取枚举值
        //或者说使用Enum类构造一个枚举常量的对象
        Season s = Enum.valueOf(Season.class, "AUTUMN");
        //直接为枚举对象内部的变量赋值
        s.name = "秋天";
        //直接访问枚举对象
        System.out.println("现在"+s+"代表"+s.name);
    }
    //枚举变量通常应该设计为不可变的量，应该用private final修饰
    //如果这样，就应该在实例化对象的同时传入构造的参数
    /*
    WINTER("冬天");

    private String name;
    private Season(String name){
        this.name=name;
    }
    */


}

interface IntF{
    public int getValue();
    public String getDescription();
}
enum SeasonE implements IntF{
    //三、实现接口的枚举类
    // 在枚举常量后面加花括号的这种语法，在创建WINTER、AUTUMN实例
    // 时，并不是创建SeasonE的实例，而是相当于创建Season的匿名子
    // 类的实例
    WINTER{
        @Override
        public String nextSeason() {
            return "next Season is 春天";
        }

        @Override
        public int getValue() {
            return 4;
        }

        @Override
        public String getDescription() {
            return "冬天";
        }
    },
    AUTUMN{
        @Override
        public String nextSeason() {
            return "next Season is 冬天";
        }

        @Override
        public int getValue() {
            return 1;
        }

        @Override
        public String getDescription() {
            return "秋天";
        }
    };
    public void main3(){
        //通过Enum.values()遍历所有枚举常量
        for (SeasonE se : SeasonE.values()) {
            System.out.println("枚举成员："+se+"值"+se.getValue()+"，描述"+se.getDescription());
        }
    }

    //四、包含抽象方法的枚举类
    // 抽象方法在枚举类内部，实现过程在常量中
    // 枚举类里定义抽象方法时不能使用abstract关键字将枚举类定义成抽
    // 象类(因为系统自动会为它添加abstract关键字)，但因为枚举类需要
    // 显示创建枚举值，而不是作为父类，所以定义每个枚举值时必须为抽象
    // 方法提供实现，否则将出现编译错误
    public abstract String nextSeason();
    public void main4(){
        System.out.println(SeasonE.AUTUMN.nextSeason());
        System.out.println(SeasonE.WINTER.nextSeason());
    }
}

/* 反编译之后形式如下

final class Season extends Enum{
    public static final Season SPRING = new Season();
    public static final Season SUMMER = new Season();
    public static final Season AUTUMN = new Season();
    public static final Season WINTER = new Season();

    private Season(){}
    ...
}
*/
/**
 *  由此可知枚举类<br>
 *      1.枚举类可以实现一个或多个接口，使用enum定义的枚举类默认继承
 *      java.lang.Enum类，而不是默认继承Object类，因此枚举类不能
 *      显示继承其他父类，其中java.lang.Enum类实现了Serializable
 *      和Comparable两个接口<br>
 *      2.使用enum定义、非抽象的枚举类默认会使用final修饰，因此枚举
 *      类不能派生子类<br>
 *      3.枚举类的构造器只能使用private访问控制符，如果省略了构造器的
 *      访问控制符，则默认使用private修饰；如果强制指定访问控制符，则
 *      只能指定private修饰符<br>
 *      4.枚举类的所有实例必须在枚举类的第一行显示列出，否则这个枚举类
 *      永远不能产生实例。列出这些实例时，系统会自动添加
 *      <b>public static final</b>修饰，无需我们显式添加<br>
 *  枚举的本质还是以类的形式存在
 *
 *
 */
