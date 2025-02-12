using System;
using System.Threading.Tasks;

DocumentManager dm = new();

//Task processDocuments = ProcessDocuments.StartAsync(dm);

// Create documents and add them to the DocumentManager
//Random random = new();
for (int i = 0; i < 10; i++)
{
    var doc = new Document($"Doc {i}", "content");
    int queueSize = dm.AddDocument(doc);
    Console.WriteLine($"Added document {doc.Title}, queue size: {queueSize}");
    //await Task.Delay(random.Next(20));
}
Console.WriteLine($"finished adding documents");
//await processDocuments;

// ====> New code
// Peek
Console.WriteLine($"The first element is: {dm.GetFirst.Title}");

// Contains
Document doc5 = new Document($"Doc 5", "content");
Console.WriteLine(doc5.Title, dm.Exists(doc5)?  " exists" :  " does not exist");
doc5 = new Document($"Doc 5", "No content");
Console.WriteLine(doc5.Title, dm.Exists(doc5) ? " exists" : " does not exist");

// Dequeue
Console.WriteLine($"Current queue size: {dm.Size}");
for (int i = dm.Size; i > 0; i--)
{
    Console.WriteLine($"Dequeueing {dm.GetDocument().Title}");
    Console.WriteLine($"Current queue size: {dm.Size}");
}
Console.WriteLine($"finished removing documents");

Console.WriteLine("bye!");
