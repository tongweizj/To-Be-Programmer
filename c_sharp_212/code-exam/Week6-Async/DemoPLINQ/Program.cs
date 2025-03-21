namespace DemoPLINQ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var random = new Random();

            // create array with size of 1 million of random integers in the range 1-999
            int[] values = Enumerable.Range(1, 200000000)
                                     .Select(x => random.Next(1, 1000))
                                     .ToArray();

            // time the Min, Max and Average LINQ extension methods
            Console.WriteLine("Min, Max and Average with LINQ to Objects using a single core");
            var linqStart = DateTime.Now; // get time before method calls
            var linqMin = values.Min();
            var linqMax = values.Max();
            var linqAverage = values.Average();
            var linqEnd = DateTime.Now; // get time after method calls

            // display results and total time in milliseconds
            var linqTime = linqEnd.Subtract(linqStart).TotalMilliseconds;
            DisplayResults(linqMin, linqMax, linqAverage, linqTime);

            // time the Min, Max and Average PLINQ extension methods
            Console.WriteLine("\nMin, Max and Average with PLINQ using multiple cores");
            var plinqStart = DateTime.Now; // get time before method calls
            var plinqMin = values.AsParallel().Min();
            var plinqMax = values.AsParallel().Max();
            var plinqAverage = values.AsParallel().Average();
            var plinqEnd = DateTime.Now; // get time after method calls

            // display results and total time in milliseconds
            var plinqTime = plinqEnd.Subtract(plinqStart).TotalMilliseconds;
            DisplayResults(plinqMin, plinqMax, plinqAverage, plinqTime);

            // display time difference as a percentage
            Console.WriteLine("\nPLINQ took " +
               $"{((linqTime - plinqTime) / linqTime):P0}" +
               " less time than LINQ");

            Console.ReadKey();
        }

        // displays results and total time in milliseconds
        static void DisplayResults(int min, int max, double average, double time)
        {
            Console.WriteLine($"Min: {min}\nMax: {max}\n" +
               $"Average: {average:F}\nTotal time in milliseconds: {time:F}");
        }
        
        }
    }