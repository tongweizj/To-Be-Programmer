// See https://aka.ms/new-console-template for more information
using System.Collections.Generic;
using System.Runtime.Intrinsics.X86;
using System.Text.RegularExpressions;
using Linq;

Console.WriteLine("Hello, World!");


//// 1.Select all the persons with assets of over 50B dollars.
//IEnumerable<Person> result = from p
//                      in Person.persons
//                      where p.Asset > 50
//                      select p;
//Console.WriteLine("Q1:");

//Console.WriteLine(@"IEnumerable<Person> result = from p
//                      in Person.persons
//                      where p.Asset > 50
//                      select p;");
//Console.WriteLine(string.Join(",\n ", result));

//// 2.	Select all non-US citizens.
//IEnumerable<Person> result2 = from p
//                      in Person.persons
//                             where p.Country != "US"
//                              select p;
//Console.WriteLine("\nQ2:");
//Console.WriteLine(@"IEnumerable<Person> result2 = from p
//                      in Person.persons
//                      where p.Country != ""US""
//                      select p;");
//Console.WriteLine(string.Join(",\n ", result2));

//// 3.Select the name of all the females from India.
//// Your query should only capture the person’s name. (This is a projection query)
//IEnumerable<Person> result3 = from p
//                      in Person.persons
//                              where p.Country == "India"
//                              select p;
//Console.WriteLine("\nQ3:");
//Console.WriteLine(@"IEnumerable<Person> result3 = from p
//                      in Person.persons
//                      where p.Country == ""India""
//                      select p;");
//foreach (Person man in result3)
//{
//    Console.WriteLine($"\n{man.Name}");
//}



//// 4.Select all persons whose first name is less than five letters long.

//IEnumerable<Person> result4 = from p
//                      in Person.persons
//                              where p.Name.Split()[0].Length < 5
//                              select p;
//Console.WriteLine("\nQ4:");
//Console.WriteLine(@"IEnumerable<Person> result4 = from p
//                      in Person.persons
//                      where p.Name.Split()[0].Length < 5
//                      select p;");
//foreach (Person man in result4)
//{
//    Console.WriteLine($"\n{man.Name.Split()[0]}");
//}
//// 5.	Sort the collection by assets. 
//// Your query should only capture the person’s name and asset.

//IEnumerable<Person> result5 = from p
//                      in Person.persons
//                      orderby p.Asset                            
//                             select p;
//Console.WriteLine("Q5:");
//Console.WriteLine(@"IEnumerable<Person> result5 = from p
//                      in Person.persons
//                      orderby p.Asset                            
//                      select p;");
//foreach (Person man in result5)
//{
//    Console.WriteLine($"\nName:{man.Name} Asset:{man.Asset}");
//}

//// 6.	Group the collection by country.
//var result6 = from p
//                      in Person.persons
//                      group p by p.Country into country_groups
//                      select country_groups;
//Console.WriteLine("Q6:");
//Console.WriteLine(@"var result6 = from p
//                      in Person.persons
//                      group p by p.Country into country_groups
//                      select country_groups;");

//foreach (var grp in result6)  
//{
//    Console.WriteLine($"Name:{grp.Key} count:{grp.Count()}");
//    Console.WriteLine($"group: {(string.Join(",\n ", grp))}");
//}

//// 7.	Sort the above grouping.
//var result7 = from p
//                      in Person.persons
//              group p by p.Country into country_groups
//              select country_groups;
//var sortedGroups = result7.OrderBy(group => group.Key);
//Console.WriteLine("Q7:");
//Console.WriteLine(@"var result7 = from p
//              in Person.persons
//              group p by p.Country into country_groups
//              select country_groups;
//var sortedGroups = result7.OrderBy(group => group.Key);");

//foreach (var group in sortedGroups)
//{
//    Console.WriteLine($"Group {group.Key}: {string.Join(", ", group)}");
//}

//// 8.Make up three queries of your own.
//// You will not get a mark if you do a simple filter or order!!!

//// 1) Select all non-US citizens and Age <70 and Asset > 10

//IEnumerable<Person> result8 = from p
//                      in Person.persons
//                              where p.Country != "US" && p.Age < 70 && p.Asset > 10
//                              select p;
//Console.WriteLine("\nQ8:");
//Console.WriteLine(@"IEnumerable<Person> result8 = from p
//                      in Person.persons
//                      where p.Country != ""US"" && p.Age < 70 && p.Asset > 10
//                      select p;");
//foreach (Person man in result8)
//{
//    Console.WriteLine($"\nName:{man.Name} Asset:{man.Asset}");
//}

//// 2) Select all women, Age <70 and Asset > 10, then group then by country

//var result9 = from p
//                      in Person.persons
//              where p.IsFemale == true && p.Age < 70 && p.Asset > 10
//              group p by p.Country into country_groups2
//              select country_groups2;
//Console.WriteLine("\nQ9:");
//Console.WriteLine(@"var result9 = from p
//                      in Person.persons
//              where p.IsFemale == true && p.Age < 70 && p.Asset > 10
//              group p by p.Country into country_groups2
//              select country_groups2;");
//foreach (var grp in result9)
//{
//    Console.WriteLine($"Country:{grp.Key} count:{grp.Count()}");
//    Console.WriteLine($"group: \n{(string.Join(",\n ", grp))}");
//}

//// 3) select all age < 50, order by name's length
//var result10 = from p
//               in Person.persons
//               where p.Asset < 50
//               orderby p.Name.Length
//               select p;
//Console.WriteLine("\nQ10:");
//Console.WriteLine(@"var result10 = from p
//               in Person.persons
//               where p.Asset < 50
//               orderby p.Name.Length
//               select p;");
//foreach (Person man in result10)
//{
//    Console.WriteLine($"\nName:{man.Name} Namelength:{man.Name.Length} Asset:{man.Asset}");
//}



//1.Show all non-US citizens
// r1 = persons.Where(p => p.IsFemale);
var result = Person.persons.Where(p=>p.Country != "US");
             
Console.WriteLine("Q1:");
Console.WriteLine(@"var result = Person.persons.Where(p=>p.Country != ""US"");");
Console.WriteLine(string.Join(",\n ", result));

//2.Shows only the name of all US citizens
var result1 = Person.persons.Where(p=>p.Country == "US");

Console.WriteLine("Q1:");
Console.WriteLine(@"var result = Person.persons.Where(p=>p.Country != ""US"");");
Console.WriteLine(string.Join(",\n ", result));
//3.Show all females from India
//4.Sort the collection by last name and then first name
//5.Group the collection by gender
//6.The first longest word in the string array words (See the Aggregate example above)
//7.The first word with the most vowels. (Again see the Aggregate example above)
//8.All the elements in second and third with no duplicates. Do not use the Distinct() method. (See the Set example above)
//9.Inner, left and right join on persons and fruits. (You may use a mixed-query)
