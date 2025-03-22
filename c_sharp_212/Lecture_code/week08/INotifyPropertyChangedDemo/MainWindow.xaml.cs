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
using System.ComponentModel;

namespace INotifyPropertyChangedDemo;


public class Person : INotifyPropertyChanged
{
    private string? firstName;
    private string? lastName;
    private string? fullName;

    public string FirstName
    {
        get
        {
            return firstName ?? "First name is null";
        }
        set
        {
            if (firstName != value)
            {
                firstName = value;
                OnPropertyChanged(nameof(FirstName));
                OnPropertyChanged(nameof(FullName));
            }
        }
    }

    public string LastName
    {
        get
        {
            return lastName ?? "Last name is null";
        }
        set
        {
            if (lastName != value)
            {
                lastName = value;
                OnPropertyChanged(nameof(LastName));
                OnPropertyChanged(nameof(FullName));
            }
        }
    }

    public string FullName
    {
        get
        {
            return $"{FirstName} {LastName}";
        }
        set
        {
            if (fullName != value)
            {
                fullName = value;
                OnPropertyChanged(nameof(FullName));
            }
        }
    }

    private void OnPropertyChanged(string propertyName)
    {
        PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
    }

    public event PropertyChangedEventHandler? PropertyChanged;
}

/// <summary>
/// Interaction logic for MainWindow.xaml
/// </summary>
public partial class MainWindow : Window
{
    public MainWindow()
    {
        InitializeComponent();
        // 创建并绑定 Person 对象到 DataContext
        DataContext = new Person();
    }
}