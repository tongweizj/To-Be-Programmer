using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace DataBindingwithDataGrid
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        List<Person> Employees = new List<Person>();
        public MainWindow()
        {
            InitializeComponent();
            Employees.Add(new Person { FirstName = "Yin", LastName = "Li" });
            Employees.Add(new Person { FirstName = "Cindy", LastName = "Singh" });


            myDataGrid.ItemsSource = Employees;
        }

        private void myDataGrid_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {

        }
    }
}
