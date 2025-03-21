using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemoINotifyPropertyChange
{
    public class Person : INotifyPropertyChanged
    {
        private string? firstName;
        private string? lastName;
        private string? fullName;
        public string FirstName
        {
            get
            {
                if (firstName is not null) return firstName;
                else return "first name is null";
                }
            set
            {
                if (firstName != value)
                {
                    firstName = value;
                    OnPropertyChanged("FirstName");
                    OnPropertyChanged("FullName");
                }
            }
        }
        public string LastName
        {
            get {
                if (lastName is not null) return lastName;
                else return "last name is null";
               
                 }
            set
            {
                if (lastName != value)
                {
                    lastName = value;
                    OnPropertyChanged("LastName");
                    OnPropertyChanged("FullName");
                }
            }
        }
        public string FullName
        {
            get { return FirstName + " " + LastName; }
            set
            {
                if (fullName != value)
                {
                    fullName = value;
                    OnPropertyChanged("FullName");
                }
            }
        }

        private void OnPropertyChanged(string property)
        {
            if (PropertyChanged != null)
            {
                PropertyChanged(this, new PropertyChangedEventArgs(property)); //raise an event
            }
        }

        public event PropertyChangedEventHandler? PropertyChanged;
    }
}
