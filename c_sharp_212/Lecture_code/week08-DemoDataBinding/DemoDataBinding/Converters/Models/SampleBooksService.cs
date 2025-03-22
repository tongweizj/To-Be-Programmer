using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Converters.Models
{
    public class SampleBooksService
    {
        public static IEnumerable<Book> GetAll()
        {
            yield return new Book(1, "Professional C# and .NET - 2021 Edition", "Wrox Press", "Christian Nagel");
            yield return new Book(2, "Professional C# 7 and .NET Core 2", "Wrox Press", "Christian Nagel");
            yield return new Book(3, "Professional C# 6 and .NET Core 1.0", "Wrox Press", "Christian Nagel");
            yield return new Book(4, "Professional C# 5.0 and .NET 4.5.1", "Wrox Press", "Christian Nagel", "Jay Glynn", "Morgan Skinner");
            yield return new Book(5, "Enterprise Services with the .NET Framework", "AWL", "Christian Nagel");
        }
    }
}
