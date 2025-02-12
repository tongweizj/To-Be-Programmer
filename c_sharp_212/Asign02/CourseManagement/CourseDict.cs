using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CourseManagement
{
    // course Dictionary
    
    internal class CourseDict
    {
        public static Dictionary<int, Course> CourseDictionary { get; set; }
        // 构造器
        public CourseDict() {
            CourseDictionary = new Dictionary<int, Course>();
        }

        // sert
        public static void insert(Course course)
        {
            CourseDictionary.Add(course.Code, course);
        }
        public static void DisplayCourse(int code)
        {
            Console.WriteLine(CourseDictionary[code]);
        }
        // toString
        public static void DisplayAll()
        {
            foreach(var item in CourseDictionary)
            {
                Console.WriteLine(item.ToString());
            }
            
        }
    }
}
