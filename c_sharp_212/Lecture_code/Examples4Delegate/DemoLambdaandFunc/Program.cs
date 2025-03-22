namespace DemoLambdaandFunc
{
    internal class Program
    {
        public delegate string Del(string name);
        static void Main(string[] args)
        {
            string mid = ",middle part, ";

            Del del = (message) =>
            {
                message += mid;
                message += " and this was added to the message ";
                 return message;
            };

            Func< string, string > del2 = param =>
            {
                param += mid;
                param += " and this was added to the message ";
                return param;
            };

            Func<int, int, int> cal = (x, y) =>
            {
                return x + y;
            };


            Func<int, int,int> cal1 = delegate (int x,int y) { return x+y; };


            Console.WriteLine(del("Start of string"));

            Console.WriteLine(del("Test Func<string,string>"));

            Console.WriteLine(cal(10,20));

            Console.WriteLine(cal1(20,20));

            Console.ReadKey();
        }
    }
}