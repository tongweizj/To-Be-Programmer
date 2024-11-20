using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BankingApplication
{
    internal abstract class Account
    {
        public readonly List<Person> Holders = new List<Person>();
        public readonly List<Transaction> Transactions = new List<Transaction>();
        public readonly String Number;
        private int LAST_NUMBER;

        public Double Balance { get; protected set; }
        public Double LowestBalance { get; protected set; }

        public Account(string type, double balance)
        {
            Balance = balance;
            LowestBalance = balance;
            Number = type + LAST_NUMBER;
            LAST_NUMBER++;
        }
    }
}
