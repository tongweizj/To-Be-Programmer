using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CarDealerHelp
{
    public class CarInfoEventArgs
    {
        public string Car { get; }
        public CarInfoEventArgs(string car) => Car = car;
    }
}
