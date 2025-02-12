using System.Collections.Generic;

public class DocumentManager
{
    private readonly object _syncQueue = new object();

    private readonly Queue<Document> _documentQueue = new();

    public int AddDocument(Document doc)
    {
        lock (_syncQueue)
        {
            _documentQueue.Enqueue(doc);
            return _documentQueue.Count;
        }
    }

    public Document GetDocument()
    {
        lock (_syncQueue)
        {
            return _documentQueue.Dequeue();
        }
    }

    public bool IsDocumentAvailable => _documentQueue.Count > 0;

    // New method: returns the size of the queue.
    public int Size => _documentQueue.Count;

    // New method: returns the first element of the queue,
    public Document GetFirst => _documentQueue.Peek();

    public bool Exists(Document doc) => _documentQueue.Contains(doc);
}