using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_Atom
{
    internal class Atom
    {
        public string Name {  get; set; }
        public string Symbol {  get; set; }
        public int Proton { get; set; }
        public int Neutron { get; set; }
        public double Weight { get; set; }

        public Atom() { }
        public  Atom(string name,int proton, int neutron, double weight, string symbol)
        {
            Name = name;
            Symbol = symbol;
            Proton = proton;
            Neutron = neutron;
            Weight = weight;

        }
       
        public override string ToString()
        {
            return base.ToString();
        }

        public static Atom Parse(string objectData)
        {
            List<String> objectDataList = objectData.Split(',').ToList();
            return new Atom(objectDataList[0], int.Parse(objectDataList[1]), int.Parse(objectDataList[2]), double.Parse(objectDataList[3]), objectDataList[4]);
        }
        public static List<Atom> GetAtoms()
        {
            return new List<Atom>();
        }
    }
}
