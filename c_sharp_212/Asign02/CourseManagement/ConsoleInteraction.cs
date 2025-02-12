using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CourseManagement
{
    internal class ConsoleInteraction
    {
        // mthod 文字沟通
        String prompt;
        int answerTimes = 1;
        public ConsoleInteraction(String prompt)
        {
            this.prompt = prompt;
        }
        void setPrompt(String prompt)
        {
            this.prompt = prompt;
        }
        public void setAnswerTimes(int answerTimes) { }
        void setUserPrompter(int command)
        {

            switch (command)
            {
                case 1:
                    //显示提示信息
                    string output = "Please select command\n"+
                    "1.Insert new course;\n" +
                    "2.Search specific course;\n"+
                    "3.display all course;\n"+
                    "4.close application;\n"+
                    "Please input number(1-3): ";
                    //Console.WriteLine(output);
                    setPrompt(output);
                    break;
                case 2:
                    //显示提示信息
                    setPrompt("Please input course name and code!");
                    
                    break;
                case 3:
                    setPrompt("Display all course!");
                    break;
            }
        }
        void runUserCommand(int command)
        {
            switch (command)
            {
                case 1:
                    Console.WriteLine("Insert a new course! ");
                    Course newCourse = new Course(123, "demo", "demoDescription!");
                    //CourseDict courseDict = new CourseDict();
                    CourseDict.insert(newCourse);
                    break;
                //setPrompt(getPrompt() + ". Please answer Y or N: ");
                case 2:
                    Console.WriteLine("display the courses!");
                    CourseDict.DisplayCourse(123);
                    break;
                case 3:
                    Console.WriteLine("display all courses!");
                    CourseDict.DisplayAll();
                    break;
            }
        }
        int getUserInput(int command)
        {
            try
            {
                string answer = null;
                while (answer == null || answer.Length < 1)
                {
                    setUserPrompter(0);
                    Console.WriteLine(this.prompt + " ");
                    answer = Console.ReadLine();
                   
                }
                return int.Parse(answer);
            }
            catch (IOException ioe)
            {
                Console.WriteLine(ioe.ToString());
                // if console I/O fails there is no recovery
                return 0;
            }
        }

         public bool getAnswer(){
            int tryNum=0;
            int command = 1;
            setUserPrompter(command);
            int answer = 0;
            while (answer == 0 && tryNum < this.answerTimes)
            {
                answer = getUserInput(command);
                tryNum++;
            }

            if (answer > 0 && answer < 4)
            {
                runUserCommand(answer);
                Console.WriteLine(answer);
            }
            else
            {
                return false;
            }
            
            return true;
        }

    }
    
}
