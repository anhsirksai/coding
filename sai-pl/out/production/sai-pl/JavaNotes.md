```
// Other data types worth checking out
        // ArrayLists - Like arrays except more functionality is offered, and
        //              the size is mutable.
        // LinkedLists - Implementation of doubly-linked list. All of the
        //               operations perform as could be expected for a
        //               doubly-linked list.
        // Maps - A set of objects that map keys to values. Map is
        //        an interface and therefore cannot be instantiated.
        //        The type of keys and values contained in a Map must
        //        be specified upon instantiation of the implementing
        //        class. Each key may map to only one corresponding value,
        //        and each key may appear only once (no duplicates).
        // HashMaps - This class uses a hashtable to implement the Map
        //            interface. This allows the execution time of basic
        //            operations, such as get and insert element, to remain
        //            constant even for large sets.
        // TreeMap - This class is a sorted tree structure. It implements a red
        //           black tree and sorts the entries based on the key value or
        //           the comparator provided while creating the object
```

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

### Topics: Collections, Exceptions, Threads
+ running ready-to-run resume suspended locked
+ priority
+ context switch
+ currentThread() getName() serName() getPriority() isAlive()
+ Extending thread class run() | implementing a runnable interface (Benifit: when extending a class, we cant extend any other class)
+ Synchronization - Synchronized() or synchronized statement. - To avoid race conditions while executing threads in parallel.
+ Interthread comm : wait() notify() nitifyAll()
+ Executor framework :
	- Specify user defined threadpool
+ callable and future : in run method, nothing can be returned. So to return something.
	- callable: return object. public String call throws Execution{}
#### Exceptions
+ checked exception : compile-time. handled in compiler.: throws
+ unchecked exception : runtime. We should handle these in program. throw

```http://stackoverflow.com/questions/3940213/exception-handling-throw-throws-and-throwable```

+ throws() - The method calling this function with checked exception should handle in the method only.
+ throw() - Should be followed by a catch block, if we dont want to use throws.
+ java7 features: try with resources

#### Collections
```
Collections :

Object :
	- Methods (9). like hashcode(), equals().  http://stackoverflow.com/questions/27581/what-issues-should-be-considered-when-overriding-equals-and-hashcode-in-java
	- Hashcode is a pointer to a memory location.
	- : These methods can be overrided to verify equality of objects.
	- If equals method is overridden, we should make sure hashcode also matches.
	

Comparable and comparator :
	- comparator is a class.
	- comparable is an interface.
Set:
===	
Hashset: - No ordering. considers equals and hashcode.
Treeset: - Ordering via comparable class and comparator interface.
LinkedHashSet: retains insertion ordering. Considers equals and hashcode. 

List:
====
- Arraylist
- Linkedlist

Map:
===
Key - should be Immutable.

utility operations in collections:
===


1.5 additional features:
+ Generics:
	- generic print collection function.
+ AutoBoxing:
int b =2;
Integer a = b;

+ varargs:
+ Static import:
+ annotations:
```

#### Abstract class, extends(inheretence), interface, final class and method
+ Abstract methods are methods which do not have method statements. The subclasse provides the method statements. The methods provided by the superclass needs to be overridden by the subclass. The class that has at least one abstract method should be made abstract. The abstract class can not be instantiated because it does not define a complete implementation.

+ Using Final with methods: We can prevent a method from being overridden by using the keyword final at the start of its declaration. Final methods can not be overridden.

+ Using Final with class: We can also prevent inheritance by making a class final. When a class is declared as final, its methods also become final. An abstract class cannot be declared as final because an abstract class is incomplete and its subclasses need to provide the implementation.

+ Inheretence:
```
public class ChildClass extends BaseClass  {
   // derived class methods extend and possibly override
}
```
