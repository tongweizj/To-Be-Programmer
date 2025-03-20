using StudentManagement.Data;
using StudentManagement.Model;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudentManagement.ViewModel
{
    public class StudentsViewModel : ViewModelBase
    {
        private StudentItemViewModel? _selectedStudent;

        public ObservableCollection<StudentItemViewModel> students { get; } = new();

        public StudentsViewModel()
        {
            var rawData = DataProvider.GetData();
            if (rawData is not null)
            {
                foreach (var student in rawData)
                {
                    students.Add(new StudentItemViewModel(student));
                }
            }
        }

        public StudentItemViewModel? SelectedStudent
        {
            get => _selectedStudent;
            set
            {
                _selectedStudent = value;
                RaisePropertyChanged();
            }
        }

        internal void Add()
        {
            var student = new Student { FirstName = "New", LastName="New",Program="New Program" };
            var viewModel = new StudentItemViewModel(student);
            students.Add(viewModel);
            SelectedStudent = viewModel;
        }
    }
}
