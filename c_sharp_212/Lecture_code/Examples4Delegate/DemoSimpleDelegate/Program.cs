namespace DemoSimpleDelegate
{
    internal class Program
    {
        public delegate void Del(string message);

        static void Main(string[] args)
        {
            // Instantiate the delegate.
            Del handler = DelegateMethod2;

            Del handler2 = new Del(DelegateMethod);

            // Call the delegate.
            handler("Hello World");
            handler2.Invoke("this is through invoke: Hello World");

            Console.ReadKey();
        }

        public static void DelegateMethod(string message)
        {
            System.Console.WriteLine(message);
        }

        public static void DelegateMethod2(string name)
        {
            System.Console.WriteLine("hello " + name);
        }
    }
}