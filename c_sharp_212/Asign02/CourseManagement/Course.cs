using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CourseManagement
{
    // course data modelb
    internal class Course
    {
        public int Code { get; set; }
        public string Title { get; set; }
        public string Description { get; set; }
        public Course(int code,string title,string description) {
            this.Code = code;
            this.Title = title;
            this.Description = description;
        }
        public override string ToString() {
            return String.Format("code: {0}, title: {1}, description: {2}", Code, Title, Description);
        }
    }
}
