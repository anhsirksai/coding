Pizza delivery system :
``` https://github.com/shravin/PizzaDelivery```
ood
```https://github.com/interviewcoder/ood```

## Links :
0. https://www.quora.com/How-do-I-prepare-to-answer-design-questions-in-a-technical-interview
1. https://github.com/checkcheckzz/system-design-interview
2. http://www.palantir.com/2011/10/how-to-rock-a-systems-design-interview/
3. http://www.hiredintech.com/system-design
4. http://programmers.stackexchange.com/questions/75269/how-do-i-design-an-arbitrary-system-in-an-interview
5. gainlo blogs.
6. highscalability
7. cheap resource : http://javarevisited.blogspot.in/2012/06/20-design-pattern-and-software-design.html

## TODO : It is always a good idea to note down all the data structures you know and write the pros and cons of using each one of them in the problem domain at hand.

Approach:
---------
1. KISS
    - Example :  suppose you are asked to design a minimalist text editor using appropriate data structures.
    - Approach : tries are optimized for fast insertion and search, but you need to ask yourself, "Is that really required for a minimalist editor". 
    
2. Know the data, before deciding on ds :
    - Example : to design a technique to compress log records (lossless compression),
    - approach would be to first decide on what kind of fields a log record might contain and then think about efficient ways of compressing each one of them. Date and time can be stored as seconds elapsed since the beginning of the year.
        - (assuming we are interested in logs that are not more than a year old, this should fit in a 32 bit integer), verbose error descriptions can be replaced by short error codes which are mapped to their respective descriptions on a separate hash map, and so on!
        
        - Decide on fields to store.
        - (Scale) setup NFS and divide into layers(read/write/..)
        - (Optimize) Caching
        - A stack of servers for www, dns, images, Object Store -- Index(Metadata) + Data, Storage(Blade server)
         
     - This approach reduces the I/Os.  
Note : Handling scale is not only improving resources, but also reducing I/Os.

3. Think out loud : 

4. Know the appropriate ML/NLP concepts.(not mandatory though)
    - Example : "Did you mean" feature in Google search, in addition to everything else, it wouldn't hurt you to know about how spelling correctors work (N.L.P.)!
    
5. Common questions to think of :
    - Is it possible to make your design asynchronous and/or parallelize it?
    - Can your system handle millions of requests and are there any bottlenecks?
    - Can you cache?