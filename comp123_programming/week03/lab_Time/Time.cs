using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab_Time
{
    enum TimeFormat {Mil, Hour12, Hour24}
    internal class Time
    {
        private static TimeFormat TIME_FORMAT;
        public int Hour { get; }
        public int Minute { get; }

        // Constructor
        public Time(int hour = 0, int minute = 0)
        {
            Hour = hour>24?0:hour;
            Minute = minute>60?0:minute;
            TIME_FORMAT = TimeFormat.Hour12;
        }
        public override string ToString()
        {
            string hour = Hour < 10 ? $"0{Hour}" : Hour.ToString();
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
                if (Hour > 12)
                {
                    hour = (Hour - 12).ToString();
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

        public static void SetTimeFormat(TimeFormat time_format)
        {
            TIME_FORMAT = time_format;
        }
    }
}
