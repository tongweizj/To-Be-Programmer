using System;

public class Program
{
    // 声明委托
    public delegate int MyDelegate(int a, int b);

    // 定义一个与委托签名匹配的方法
    public static int Add(int a, int b)
    {
        return a + b;
    }

    public static int Subtract(int a, int b)
    {
        return a - b;
    }

    public static void Main()
    {
        // 创建委托实例并指向 Add 方法
        MyDelegate myDelegate = new MyDelegate(Add);

        // 调用委托
        int result = myDelegate(10, 5);
        Console.WriteLine("Addition Result: " + result); // 输出: Addition Result: 15

        // 重新指向 Subtract 方法
        myDelegate = Subtract;
        result = myDelegate(10, 5);
        Console.WriteLine("Subtraction Result: " + result); // 输出: Subtraction Result: 5
    }
}