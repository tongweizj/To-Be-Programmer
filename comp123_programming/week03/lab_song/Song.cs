using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab_song
{
    enum SongGenre 
    { 
        Unclassified = 0, 
        Pop = 0b1,
        Rock = 0b10,
        Blues = 0b100,
        Country = 0b1_000,
        Metal = 0b10_000,
        Soul = 0b1000_000 
    }
    internal class Song
    {
        public string Artist { get; }
        public string Title { get; }
        public double Length { get; }
        public SongGenre Genre { get; }

        // constructor
        public Song(string title,string artist, double length, SongGenre genre)
        {
            Title = title;
            Artist = artist;
            Length = length;
            Genre = genre;
        }
        public override string ToString()
        {
            return $"{Title} by {Artist} ({Genre}) {Length}min";
        }
        public static SongGenre operator |(SongGenre lhs, SongGenre rhs)
            =>
       
    }
}
