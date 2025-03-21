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
using System.Collections.ObjectModel;

namespace WpfApp;

/// <summary>
/// Interaction logic for MainWindow.xaml
/// </summary>
/// 



public class Task
{
    public string TaskName { get; set; }
    public string Description { get; set; }
    public string Priority { get; set; }
}
public class Tasks : ObservableCollection<Task>
{
    public Tasks()
    {
        // 初始化数据
        Add(new Task { TaskName = "Task 1", Description = "Description 1", Priority = "High" });
        Add(new Task { TaskName = "Task 2", Description = "Description 2", Priority = "Medium" });
        Add(new Task { TaskName = "Task 3", Description = "Description 3", Priority = "Low" });
    }
}

public partial class MainWindow : Window
{


    public MainWindow()
    {
        InitializeComponent();
        DataContext = this; // 将窗口的 DataContext 设置为当前窗口实例
    }
    public Tasks MyTodoList => new Tasks();
}