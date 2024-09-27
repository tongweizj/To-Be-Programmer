using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RefDemo
{
    internal class Program
    {
        class PersonClass
        {
            public string Name { get; set; }
            public int Age { get; set; }

            public override string ToString()
            {
                return $"{Name} {Age}yrs";
            }
        }

        struct PersonStruct
        {
            public string Name;
            public int Age;
            public override string ToString()
            {
                return $"{Name} {Age}yrs";
            }
        }
        static void Main(string[] args)
        {
            DemoA();
            DemoB();

        }

        public static void DemoA()
        {
            PersonClass c1 = new PersonClass() { Age = 19, Name = "Chester" };
            PersonClass c2 = c1;
            PersonClass c3 = c1;
            Console.WriteLine(c1);
            Console.WriteLine(c2);
            Console.WriteLine(c3);

        }

        public static void DemoB()
        {
            PersonStruct c1 = new PersonStruct() { Age = 19, Name = "Chester" };
            PersonStruct c2 = c1;
            PersonStruct c3 = c1;
            Console.WriteLine(c1);
            Console.WriteLine(c2);
            Console.WriteLine(c3);

        }

    }
}

