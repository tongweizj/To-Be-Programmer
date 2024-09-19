using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PetDemo
{
    internal class Pet
    {
        // data

        public string Name { get; set; }
        public  string Owner { get; private set; }
        public int Age { get; set; }
        public string Description { get; set; }
        public bool IsHouseTrained { get; private set; }

        // constractor
        public Pet(string name, int age, string description)
        {
            Name = name;
            Age = age;
            Description = description;
            Owner = "no one";
            IsHouseTrained = false;
        }
        public override string ToString() { 
            return $"Pet's name: {Name}, age: {Age}, it is a {Description}, it's owner is {Owner}, it has traned {IsHouseTrained} ";
        }

        // method

        public void Train()
        {

        }

        public void SetOwner(string owner) 
        { 
        }
    }
}
