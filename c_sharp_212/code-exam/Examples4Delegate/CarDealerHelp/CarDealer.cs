using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CarDealerHelp
{
    public class CarDealer
    {
        public event EventHandler<CarInfoEventArgs> NewCarInfo;

        /* 
        private EventHandler<CarInfoEventArgs> _newCarInfo;
        public event EventHandler<CarInfoEventArgs> NewCarInfo
        {
            add => _newCarInfo += value;
            remove => _newCarInfo -= value;
        }
        */
        public virtual void OnNewCarInfo(string car)
        {
            //Console.WriteLine($"CarDealer, new {car}");
            NewCarInfo?.Invoke(this, new CarInfoEventArgs(car));
        }
    }
}
