using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace enum_flag
{
    internal class Program
    {
        [Flags]
        enum MyEnum { None = 0, opt1 = 1, opt2 = 2, opt3 = 3, opt4 = 4 }
        static void Main(string[] args)
        {
            Console.WriteLine(MyEnum.opt2.ToString());
            MyEnum temp = MyEnum.opt1 | MyEnum.opt2;
           
            if ((temp & (MyEnum.opt1 | MyEnum.opt2)) == (MyEnum.opt1 | MyEnum.opt2))
            {
                Console.WriteLine("yes-1");
            }

            if ((temp & (MyEnum.opt1)) == MyEnum.opt1 )
            {
                Console.WriteLine("yes-opt1");
            }
            if ((temp & (MyEnum.opt2)) == MyEnum.opt2)
            {
                Console.WriteLine("yes-opt2");
            }
            if (Enum.IsDefined(typeof(MyEnum), temp))
            {
                Console.WriteLine("yes-not");
            }

        }
    }
}
