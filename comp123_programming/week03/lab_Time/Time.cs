using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab_Time
{
    enum TimeFormat { Mil, Hour12, Hour24}
    internal class Time
    {
        public TimeFormat TIME_FORMAT { get; private set; }
        public int Hour { get; }
        public int Minute { get; }

        // Constructor
        public Time(int hour=0, int minute=0) {
            Hour = hour; 
            Minute = minute;
            TIME_FORMAT = TimeFormat.Hour12;
        }
        public override string ToString() 
        {
            string hour = Hour < 12 ? $"0{Hour}" : Hour.ToString();
            string min = Minute.ToString();
            
            if (Minute < 10)
            {
                min = $"0{min}";
            }
            string date = "";
            if (TIME_FORMAT == TimeFormat.Mil)
            {
                date = $"{hour}{min}";
            }
            else if (TIME_FORMAT == TimeFormat.Hour24)
            {
                date = $"{hour}:{min}";
            }
            else 
            {
                if (Hour > 12) { 
                    hour = (Hour-12).ToString();
                    date = $"{hour}:{min} PM";
                }
                else
                {
                    hour = Hour.ToString();
                    date = $"{hour}:{min} AM";
                }


            }
            return date;
        }

        public void SetFormat(TimeFormat format)
        {
            TIME_FORMAT = format;
        }
    }
}
