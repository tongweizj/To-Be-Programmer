using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
// Add the necessary namespace
using System.Xml.Serialization;
using System.Web;
// using System.Web.Script.Serialization;
using System.Xml.Serialization;

namespace Atom
{
    internal class Program
    {
        static void Main(string[] args)
        {
            
            //Create static methods that does the following and then called them from your main
            //Create class methods to do the following:
            // Atom atom = new Atom("demo", 1,2,3.2,"12345");
            Atom atom = new Atom();
            //1 - Display all the items in the collection elements
            Console.WriteLine("1 - Display all the items in the collection elements");   
            Console.WriteLine(atom);
            List<Atom> atomList = Atom.GetAtoms();
            foreach(Atom atomItem in atomList){
                Console.WriteLine(atomItem);    
            }

            //2 - Serialize the first item using xml format and save to a suitable file
            Console.WriteLine("2 - Serialize the first item using xml format and save to a suitable file");  
            System.Xml.Serialization.XmlSerializer xmlSerializer = new System.Xml.Serialization.XmlSerializer(atomList[0].GetType());
            TextWriter itemWriter = new StreamWriter("item2xml.txt");
            xmlSerializer.Serialize(itemWriter, atomList[0]);
            itemWriter.Close();

            //3 - Read the above file and display the item
            Console.WriteLine("3 - Read the above file and display the item");
            TextReader reader = new StreamReader("item2xml.txt");          
            XmlSerializer ser = new XmlSerializer(typeof(Atom));
            Atom item;
            item = (Atom)ser.Deserialize(reader);
            Console.WriteLine(item);  
            reader.Close();

            //4 - Serialize the entire collection using xml format and save to a suitable file  
            Console.WriteLine("4 - Serialize the entire collection using xml format and save to a suitable file"); 
            atomList = Atom.GetAtoms();         
            TextWriter listlWriter = new StreamWriter("list2xml.txt");
            xmlSerializer = new System.Xml.Serialization.XmlSerializer(atomList.GetType());
            xmlSerializer.Serialize(listlWriter, atomList);
            listlWriter.Close();

            //5 - Read the above file and display the all the items

            Console.WriteLine("5 - Read the list item xml file");
            reader = new StreamReader("list2xml.txt");          
            ser = new XmlSerializer(typeof(List<Atom>));
            List<Atom> itemList;
            itemList = (List<Atom>)ser.Deserialize(reader);
            reader.Close();
            foreach(Atom atomItem in itemList){
                Console.WriteLine(atomItem);    
            }
            //6 - Serialize the first item using json format and save to a suitable file

            //7 - Read the above file and display the item

            //8 - Serialize the entire collection using json format and save to a suitable file 

            //9 - Read the above file and display all the items

        }

        static void WriteJson(List<Atom> atoms, string filename)
        {

        }

        // 1) deserialize
        // 2) display
        static void ReadJson(string filename)
        {

        }
    }
}
