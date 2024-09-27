using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
// Add the necessary namespace
using System.Xml.Serialization;
using System.Web;
using System.Web.Script.Serialization;
namespace SerializationDemo
{
    class Pet
    {
        public string Name { get; set; }
        public string Specis { get; set; }
        public int Age { get; set; }
        public bool IsFemale { get; set; }
        public double Weight { get; set; }

        public Pet(string name, string specis, int age, bool isFemale, double weight)
        {
            Name = name;
            Specis = specis;
            Age = age;
            Weight = weight;
            IsFemale = isFemale;
        }
        public override string ToString()
        {
            return $"{Name} {Specis} {Age}mnt, {(IsFemale ? "F" : "M")} {Weight:F}g ";
        }

        public static List<Pet> CreatePets()
            {
            return new List<Pet>()
            {
                new Pet("Name-G", "cat", 9, true, 900),
                new Pet("Name-A", "cat", 9, true, 900),
                new Pet("Name-B", "cat", 9, true, 900),
                new Pet("Name-C", "cat", 9, true, 900),
            };
        }    
    }
    internal class Program
    {
        static void Main(string[] args)
        {
            // get a list of Pets
            List<Pet> pets = Pet.CreatePets();

            // display on screen
            foreach (Pet pet in pets) { 
                Console.WriteLine(pet.ToString());
            }

            // print raw

            var serializer = new JavaScriptSerializer();
            var serializedResult = serializer.Serialize(pets);
            // Create and initialise a serializer object
           

//    (You will also need a writable stream such as a TextWriter)
//TextWriter writer = new StreamWriter(filename);

//    Use the Serialize method to serialize the object
//    serializer.Serialize(writer, student);

    // serial and print
    // desserialze
    }

        static List<Pet> SerializFromFile(string path, List<Pet> pets)
        {
            JavaScriptSerializer serializer = new JavaScriptSerializer();
            return serializer.Deserialize<List<Pet>>(path);
        }
        static List<Pet> DeserializFromFile(string path)
        {
            JavaScriptSerializer serializer = new JavaScriptSerializer();
            File.WritAllText(path, s)
            return "";
        }
}
}
