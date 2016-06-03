## ArrayList vs. LinkedList vs. Vector

From the hierarchy diagram, they all implement List interface. They are very similar to use. Their main difference is their implementation which causes different performance for different operations.  ArrayList is implemented as a resizable array. As more elements are added to ArrayList, its size is increased dynamically. It's elements can be accessed directly by using the get and set methods, since ArrayList is essentially an array. LinkedList is implemented as a double linked list. Its performance on add and remove is better than Arraylist, but worse on get and set methods. Vector is similar with ArrayList, but it is synchronized. ArrayList is a better choice if your program is thread-safe. Vector and ArrayList require space as more elements are added. Vector each time doubles its array size, while ArrayList grow 50% of its size each time. LinkedList, however, also implements Queue interface which adds more methods than ArrayList and Vector, such as offer(), peek(), poll(), etc.    Note: The default initial capacity of an ArrayList is pretty small. It is a good habit to construct the ArrayList with a higher initial capacity. This can avoid the resizing cost.

### Vector

Vector is almost identical to ArrayList, and the difference is that Vector is synchronized. Because of this, it has an overhead than ArrayList. Normally, most Java programmers use ArrayList instead of Vector because they can synchronize explicitly by themselves.

### Iterator/ListIterator

Both Iterator and ListIterator are used to iterate through elements of a collection class. Using Iterator we can traverse in one direction (forward) while using ListIterator we can traverse the collection class on both the directions(backward and forward). To know more differences between these two refer this article: Difference between Iterator and ListIterator.

        - Iterator
        - ListIterator

### Sort
java.util.Arrays uses quicksort (actually dual pivot quicksort in the most recent version) for primitive types such as int and mergesort for objects that implement Comparable or use a Comparator

Why the difference? Why not pick one and use it for all cases? Robert Sedgewick suggests that “the designer’s assessment of the idea that if a programmer’s using objects maybe space is not a critically important consideration and so the extra space used by mergesort maybe’s not a problem and if the programmer’s using primitive types maybe performance is the most important thing so we use the quicksort”, but I think there’s a much more obvious reason.

Quicksort is faster in both cases. Mergesort is stable in both cases. But for primitive types quicksort is stable too! 

### Priority Queue and comparator:
Use the constructor overload which takes a Comparator<? super E> comparator and pass in a comparator which compares in the appropriate way for your sort order. If you give an example of how you want to sort, we can provide some sample code to implement the comparator if you're not sure. (It's pretty straightforward though.)

As has been said elsewhere: offer and add are just different interface method implementations. In the JDK source I've got, add calls offer. Although add and offer have potentially different behaviour in general due to the ability for offer to indicate that the value can't be added due to size limitations, this difference is irrelevant in PriorityQueue which is unbounded.

Here's an example of a priority queue sorting by string length:

```java
// Test.java
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test
{
    public static void main(String[] args)
    {
        Comparator<String> comparator = new StringLengthComparator();
        PriorityQueue<String> queue = 
            new PriorityQueue<String>(10, comparator);
        queue.add("short");
        queue.add("very long indeed");
        queue.add("medium");
        while (queue.size() != 0)
        {
            System.out.println(queue.remove());
        }
    }
}

// StringLengthComparator.java
import java.util.Comparator;

public class StringLengthComparator implements Comparator<String>
{
    @Override
    public int compare(String x, String y)
    {
        // Assume neither string is null. Real code should
        // probably be more robust
        // You could also just return x.length() - y.length(),
        // which would be more efficient.
        if (x.length() < y.length())
        {
            return -1;
        }
        if (x.length() > y.length())
        {
            return 1;
        }
        return 0;
    }
}
```

### util.map
This is as close to iterating over the map as we can because you have to say whether you want just the keys, just the values or the whole key/value entry. For Sets and Lists, there is only one option so, no need to have a separate method to do this.

Map<K,V> m=new LinkedHashMap<K,V>();
for(Map.Entry<K,V> entry: m.entrySet())
    System.out.println(entry.getKey() + ": " + entry.getValue());
    
In Java 8 you can write

m.forEach((k, v) -> System.out.println(k + ": " + v));