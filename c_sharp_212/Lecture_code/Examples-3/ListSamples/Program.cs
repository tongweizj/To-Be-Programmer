using System;
using System.Collections.Generic;

Racer graham = new(7, "Graham", "Hill", "UK", 14);
Racer emerson = new(13, "Emerson", "Fittipaldi", "Brazil", 14);
Racer mario = new(16, "Mario", "Andretti", "USA", 12);



List<Racer> racers = new(20) { graham, emerson, mario };

racers.Add(new(24, "Michael", "Schumacher", "Germany", 91));
racers.Add(new(27, "Mika", "Hakkinen", "Finland", 20));

racers.AddRange(new Racer[] {
               new(14, "Niki", "Lauda", "Austria", 25),
               new(21, "Alain", "Prost", "France", 51)});

// insert elements at a specified position
racers.Insert(3, new(6, "Phil", "Hill", "USA", 3));

// accessing elements
for (int i = 0; i < racers.Count; i++)
{
    Console.WriteLine(racers[i]);
}

foreach (var r in racers)
{
    Console.WriteLine(r);
}

// searching
Console.WriteLine("====> Searching");
int index1 = racers.IndexOf(mario);
int index2 = racers.FindIndex(r => r.Country == "Finland");
Racer? racer = racers.Find(r => r.FirstName == "Niki");
Console.WriteLine($"found: {racer?.LastName}");
List<Racer> bigWinners = racers.FindAll(r => r.Wins > 20);
foreach (Racer r in bigWinners)
{
    Console.WriteLine($"{r:A}");
}

// Comparing
Console.WriteLine("====> Comparing");

Racer graham2 = new(30, "Graham", "Hill", "CA", 41);
Console.WriteLine(racers[0].CompareTo(graham2) == 0 ? "Are equal" : "Nope");

RacerComparer racerComparer = new RacerComparer(CompareType.Country);
Console.WriteLine(racerComparer.Compare(racers[3], mario) == 0? "Are equal": "Nope");

foreach (Racer r in racers)
{
    Console.WriteLine(racerComparer.Compare(r, mario) == 0 ? "Are equal " + r.Country : "Nope " + r.Country);
    //Console.WriteLine(r == mario ? "Are equal "+r.Country : "Nope "+ r.Country);
}


// Sorting
Console.WriteLine("====> Sorting");
//racers.Sort(new RacerComparer(CompareType.FirstName));
racers.Sort((r1, r2) => r2.FirstName.CompareTo(r1.FirstName));
foreach (Racer r in racers)
{
    Console.WriteLine($"{r:A}");
}


Console.WriteLine();

// remove elements
if (!racers.Remove(graham))
{
    Console.WriteLine("object not found in collection");
}

List<Racer> racers2 = new(new Racer[] {
               new(12, "Jochen", "Rindt", "Austria", 6),
               new(22, "Ayrton", "Senna", "Brazil", 41) });

// Removes at position
//racers2.RemoveAt(3);

// Removes a range from index to count.
//int index = 3;
//int count = 5;
//racers.RemoveRange(index, count);
