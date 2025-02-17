namespace CarDealerHelp
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var dealer = new CarDealer();
            var cindy = new Consumer("Cindy");
            dealer.NewCarInfo += cindy.NewCarIsHere;
            dealer.OnNewCarInfo("BMW X5 2020 model");

            var john = new Consumer("John");
            dealer.NewCarInfo += john.NewCarIsHere;

            dealer.OnNewCarInfo("Mercedes");

            Console.ReadKey();
        }
    }
}