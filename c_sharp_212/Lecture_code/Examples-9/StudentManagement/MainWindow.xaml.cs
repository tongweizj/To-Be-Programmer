﻿using StudentManagement.Data;
using StudentManagement.ViewModel;
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

namespace StudentManagement
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private StudentsViewModel _viewModel;

        public MainWindow()
        {
            InitializeComponent();
            _viewModel = new StudentsViewModel();
            DataContext = _viewModel;
        }

        public void ButtonAdd_Click(object sender, RoutedEventArgs e)
        {
            _viewModel.Add();
        }


    }
}
