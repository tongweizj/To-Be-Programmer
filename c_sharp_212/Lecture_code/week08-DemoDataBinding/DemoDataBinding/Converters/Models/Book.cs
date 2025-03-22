using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Converters.Models
{
    public class Book
    {
        public Book() { }
        public Book(int id, string title, string publisher, params string[] authors)
        {
            BookId = id;
            Title = title;
            Publisher = publisher;
            Authors = authors;
        }

        public int? BookId { get; set; }

        public string? Title { get; set; }

        public string? Publisher { get; set; }

        public IEnumerable<string>? Authors { get; set; }

        public override string? ToString() => Title;
    }
}
