// HashSet<T> class implements the ICollection<T> interface.
HashSet<string> companyTeams = new() { "Ferrari", "McLaren", "Mercedes" };
HashSet<string> traditionalTeams = new() { "Ferrari", "McLaren" };
HashSet<string> privateTeams = new() { "Red Bull", "Lotus", "Toro Rosso", "Force India", "Sauber" };

// Add returns bool
if (privateTeams.Add("Williams"))
    Console.WriteLine("Williams added");
if (!companyTeams.Add("McLaren"))
    Console.WriteLine("McLaren was already in this set");

// The methods IsSubsetOf and IsSupersetOf compare a set with a
// collection that implements the IEnumerable<T> interface
// and returns a Boolean result.
if (traditionalTeams.IsSubsetOf(companyTeams))
{
    Console.WriteLine("traditionalTeams is subset of companyTeams");
}

if (companyTeams.IsSupersetOf(traditionalTeams))
{
    Console.WriteLine("companyTeams is a superset of traditionalTeams");
}

traditionalTeams.Add("Williams");
// Overlaps returns true if the System.Collections.Generic.HashSet`1 object
// and other share at least one common element; otherwise, false.
if (privateTeams.Overlaps(traditionalTeams))
{
    Console.WriteLine("At least one team is the same with traditional and private teams");
}

// The variable allTeams that references a new SortedSet<string> is filled
// with a union of companyTeams, privateTeams, and traditionalTeams
// by calling the UnionWith method:
SortedSet<string> allTeams = new(companyTeams);
allTeams.UnionWith(privateTeams);
allTeams.UnionWith(traditionalTeams);

Console.WriteLine();
Console.WriteLine("all teams");
foreach (var team in allTeams)
{
    Console.WriteLine(team);
}

allTeams.ExceptWith(privateTeams);
Console.WriteLine();
Console.WriteLine("no private team left");
foreach (var team in allTeams)
{
    Console.WriteLine(team);
}
