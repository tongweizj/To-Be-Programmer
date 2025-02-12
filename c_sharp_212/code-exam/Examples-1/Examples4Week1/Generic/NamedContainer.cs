using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Generic
{
    public class NamedContainer<T>(T item, string description)
    {
        public T Item { get; } = item;
        public string Description { get; } =description;

        public override string ToString() { return $"{Item}, {Description}"; }
    }
}
