using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace FallbackAndSringFormat
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {   public string firstName { get; set; } = "John";
        public string lastName { get; set; } = "Smith";
        public string userName { get; set; } = "john.smith";
        public double salary { get; set; } = 150000;
        public string email { get; set; }

        public MainWindow()
        {
            DataContext = this;
            InitializeComponent();
        }
    }
}