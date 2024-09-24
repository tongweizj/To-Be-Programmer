using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab_song
{

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
            return $"{Title} by {Artist} ({genreToStr(Genre)}) {Length}min";
        }

        private string genreToStr(SongGenre genre)
        {
            String genreStr = "";
            //if (!Enum.IsDefined(typeof(SongGenre), Genre))
            //{
            //    genreStr = $"{SongGenre.Unclassified}";
            //}

            if ((genre & SongGenre.Rock) == SongGenre.Rock)
                {
                genreStr = (genreStr == "") ? $"{SongGenre.Rock}" : $"{genreStr}, {SongGenre.Rock}";
            }
            if ((genre & SongGenre.Blues) == SongGenre.Blues)
            {
                genreStr = (genreStr == "") ? $"{SongGenre.Blues}" : $"{genreStr}, {SongGenre.Rock}";
            }
            if ((genre & SongGenre.Country) == SongGenre.Country)
            {
                genreStr = (genreStr == "") ? $"{SongGenre.Country}" : $"{genreStr}, {SongGenre.Country}";
            }
            if ((genre & SongGenre.Soul) == SongGenre.Soul)
            {
                genreStr = (genreStr == "") ? $"{SongGenre.Soul}" : $"{genreStr}, {SongGenre.Soul}";
            }
            if ((genre & SongGenre.Pop) == SongGenre.Pop)
            {
                genreStr = (genreStr == "") ? $"{SongGenre.Pop}" : $"{genreStr}, {SongGenre.Pop}";
            }
            if ((genre & SongGenre.Metal) == SongGenre.Metal)
            {
                genreStr = (genreStr == "") ? $"{SongGenre.Metal}" : $"{genreStr}, {SongGenre.Metal}";
            }
            return genreStr;
        }
    }
}
