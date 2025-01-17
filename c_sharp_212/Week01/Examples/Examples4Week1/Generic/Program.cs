namespace Generic
{
    internal class Program
    {
        static void Main(string[] args)
        {
           

            var a = new NamedContainer<int>(42, "The grade for midterm exam");
            var b = new NamedContainer<string>("Programming III", "Course title");

            Console.WriteLine(a);
            Console.WriteLine(b);
        }
    }
}