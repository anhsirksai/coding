In computer science, a ternary search tree is a type of trie (sometimes called a prefix tree) where nodes are arranged in a manner similar to a binary search tree, but with up to three children rather than the binary tree's limit of two. Like other prefix trees, a ternary search tree can be used as an associative map structure with the ability for incremental string search. However, ternary search trees are more space efficient compared to standard prefix trees, at the cost of speed. Common applications for ternary search trees include spell-checking and auto-completion.

Phone contact application.

          c
        / | \
       a  u  h
       |  |  | \
       t  t  e  u
     /  / |   / |
    s  p  e  i  s

For the same phone book application, TRIE is also an option.
http://www.geeksforgeeks.org/trie-insert-and-search/

Anytime a trie could be used but a less memory-consuming structure is preferred.[1]
A quick and space-saving data structure for mapping strings to other data.[3]
To implement auto-completion.[2][self-published source?]
As a spell check.[4]
Near-neighbor searching (of which spell-checking is a special case).[1]
As a database especially when indexing by several non-key fields is desirable.[4]
In place of a hash table.[4]

###  TST VS TRIE:(Copied from Quora, lazy to find the link now)

Essentially a TST is just one way of implementing a Trie where you store edges in a binary search tree.  There are a few other ways of implementing a Trie including storing edges in a global hash table, per node hash table, array, or array with condensing.

Assume that N is the number of strings in your Trie and M is the number of nodes in the Trie.  The most obvious benefit of a BST (and hash tables) is that it has better memory efficiency, using O(M) memory compared with O(M * sigma) of the array approach and O(M + N * sigma) of the condensed array approach.

Let's assume your search trees are all balanced (either de factor or de jure) otherwise all the benefits of a BST disappear.  Then a BST allows you to compute range aggregates (e.g. how many strings appear between these two strings) in O((m1 + m2) log(sigma)) where the other Trie approaches would either take O((m1 + m2) sigma) time or would have longer insert times.

So when should you use a TST?  Pretty sparingly.  You should consider it if you are really concerned about memory and/or the lexical ordering of your strings and/or you have a large alphabet.  And only if you're Trie is changing; in the static case you almost certainly want to go with the array implementation where you could precompute range aggregates.

Storing your edges as an array is usually going to be the way to go.  If you are concerned about memory you can reduce the memory overhead from O(M * sigma) to O(M + N * sigma) by allocating the entire child array only after two or more edges are created out of a node.  Before that just store a single child pointer and child label.  It's easy to prove that only O(N) nodes in the Trie have more than one child node as there must be at least this many leaves of the Trie.  If your strings are Omega(sigma) in length on average then condensed arrays have the same memory efficiency while retaining fast lookup.

By the way, the analysis of runtimes in the Wikipedia entry on Ternary Search Trees appears to be garbage.


