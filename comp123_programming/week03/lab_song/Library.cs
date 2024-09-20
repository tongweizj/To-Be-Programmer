using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab_song
{
    internal class Library
    {
        private static List<Song> songs = new List<Song>();
        public static void LoadSongs(string filename)
        {
            songs.Clear();
            TextReader textReader = new StreamReader(filename);
            string line;
            bool next = true;
            int type = 0;
            string title = "";
            string artist = "";
            double length = 0.0;
            SongGenre genre = SongGenre.Unclassified;
            while (next)
            {
                line = textReader.ReadLine();
                if (line == null)
                {
                    next = false;
                }
                switch (type) 
                {
                    case 0: 
                        title = line;
                        type++;
                        break;
                    case 1: 
                        artist = line;
                        type++;
                        break;
                     case 2:
                        length = Convert.ToDouble(line);
                        type++;
                        break;
                    case 3:
                        Enum.TryParse(line, out genre);
                        songs.Add(new Song(title,artist,length,genre));
                        type = 0;
                        break;
                }
            };
            textReader.Close();
        }
        public static void DisplaySongs()
        {
            foreach (Song song in songs)
            {

                Console.WriteLine(song);
            }

        }

        public static void DisplaySongs(double longerThan) 
        {
            foreach (Song song in songs)
            {
                if(song.Length > longerThan)
                {
                    Console.WriteLine(song);
                }
            }
        }

        public static void DisplaySongs(SongGenre genre)
        {
            foreach (Song song in songs)
            {
                if (song.Genre == genre)
                {
                    Console.WriteLine(song);
                }
            }
        }
        public static void DisplaySongs(string artist)
        {
            foreach (Song song in songs)
            {
                if (song.Artist == artist)
                {
                    Console.WriteLine(song);
                }
            }
        }
    }
}
