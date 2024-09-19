using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace demo_date
{
    internal class Date
    {
        int days;
        public int Days {
            get => days % 30;

        }
        public int Month {
            get => days / 30;
        }
        public int Year
        {
            get => days / 365;
        }
        public override string ToString()
        {
            return $"{Days:d2}/{Month:d2}/{Year:d4}";
        }

        public Date(int days) { this.days = days; }
        public static Date operator +(Date lhs, Date rhs)
           => new Date(lhs.days + rhs.days);

    }
}
