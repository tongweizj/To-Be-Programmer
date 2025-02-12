using System;
using System.Collections.Generic;


Stack<char> alphabet = new();
alphabet.Push('A');
alphabet.Push('B');
alphabet.Push('C');

Console.Write("First iteration: ");
foreach (char item in alphabet)
{
    Console.Write(item);
}
Console.WriteLine();

// ====> New Code
Console.WriteLine($"Contains B: {alphabet.Contains('B')}");
Console.WriteLine($"The top item is: {alphabet.Peek()}");
// ====> End of New Code

Console.Write("Second iteration: ");
while (alphabet.Count > 0)
{
    Console.Write(alphabet.Pop());
}
Console.WriteLine();


