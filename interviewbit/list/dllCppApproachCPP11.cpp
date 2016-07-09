    #include <iostream>
    #include <unordered_map> 
    #include <utility> 
     
    using namespace std; 
     
    // List nodeclass 
    class Node 
    { 
        public: 
        int data; 
        Node* next; 
        Node* prev; 
    }; 
     
    //Doubly Linked list 
    class DLList 
    { 
        public: 
     
        DLList() 
        { 
            head = NULL; 
            tail = NULL; 
            count = 0;
        } 
     
        ~DLList() {} 
     
        Node* addNode(int val); 
        void print();
        void removeTail();
        void moveToHead(Node* node);
     
        int size() 
        { 
            return count; 
        } 
     
        private: 
        Node* head; 
        Node* tail; 
        int count; 
    };
     
    // Function to add a node to the list 
     
    Node* DLList::addNode(int val) 
    {
        Node* temp = new Node(); 
     
        temp->data = val; 
        temp->next = NULL; 
        temp->prev = NULL; 
     
        if ( tail == NULL ) 
        { 
            tail = temp; 
            head = temp; 
        } 
        else 
        { 
            head->prev = temp; 
            temp->next = head; 
            head = temp; 
        }
     
        count++; 
     
        return temp; 
    } 
     
    void DLList::moveToHead(Node* node) 
    { 
        if (head == node) 
        return; 
     
        node->prev->next = node->next; 
     
        if (node->next != NULL)
        {
            node->next->prev = node->prev; 
        } 
        else 
        { 
            tail = node->prev; 
        } 
            node->next = head; 
            node->prev = NULL; 
            head->prev = node; 
            head = node; 
        } 
     
    void DLList::removeTail() 
    { 
        count--; 
     
        if (head == tail) 
        { 
            delete head; 
            head = NULL; 
            tail = NULL; 
        } 
        else
        {
            Node* del = tail;
            tail = del->prev; 
            tail->next = NULL; 
            delete del; 
        }
    } 
     
    void DLList::print() 
    {
        Node* temp = head;
     
        int ctr = 0;
     
        while ( (temp != NULL) && (ctr++ != 25) ) 
        { 
            cout << temp->data << " "; 
            temp = temp->next; 
        } 
        cout << endl; 
    }
     
    class LRUCache 
    { 
        public: 
            LRUCache(int aCacheSize); 
            void fetchPage(int pageNumber); 
     
        private: 
            int cacheSize; 
            DLList dlist; 
            unordered_map< int, Node* > directAccess; 
    }; 
     
        LRUCache::LRUCache(int aCacheSize):cacheSize(aCacheSize) { } 
     
        void LRUCache::fetchPage(int pageNumber) 
        { 
            /* find the page in the map */
            unordered_map< int, Node* >::const_iterator it = directAccess.find(pageNumber); 
     
            /* if the page is found in the map */
            if (it != directAccess.end()) 
            {   
                /* move the page on to the head of the doubly list */
                dlist.moveToHead( (Node*)it->second); 
            } 
            else 
            { 
                /* if size of list is full */
                if (dlist.size() == cacheSize-1) 
                   dlist.removeTail(); 
     
                /* add the node to the head of doubly list */
                Node* node = dlist.addNode(pageNumber); 
                /* add the node in the map */
                directAccess.insert(pair< int, Node* >(pageNumber,node)); 
            }
     
            dlist.print(); 
        }
     
        int main() 
        { 
            LRUCache lruCache(10); 
     
            lruCache.fetchPage(5); 
            lruCache.fetchPage(7); 
            lruCache.fetchPage(15); 
            lruCache.fetchPage(34); 
            lruCache.fetchPage(23); 
            lruCache.fetchPage(21); 
            lruCache.fetchPage(7); 
            lruCache.fetchPage(32); 
            lruCache.fetchPage(34); 
            lruCache.fetchPage(35); 
            lruCache.fetchPage(15); 
            lruCache.fetchPage(37); 
            lruCache.fetchPage(17); 
            lruCache.fetchPage(28); 
            lruCache.fetchPage(16); 
     
            return 0; 
    }

#if 0
     

Implement LRU Cache

How to implement LRU caching scheme? What data structures should be used?

We are given total possible page numbers that can be referred. We are also given cache (or memory) size (Number of page frames that cache can hold at a time). The LRU caching scheme is to remove the least recently used frame when the cache is full and a new page is referenced which is not there in cache. Please see the Galvin book for more details (see the LRU page replacement slide here).

We use two data structures to implement an LRU Cache.

1. A Queue which is implemented using a doubly linked list. The maximum size of the queue will be equal to the total number of frames available (cache size).
The most recently used pages will be near front end and least recently pages will be near rear end.

2. A Hash with page number as key and address of the corresponding queue node as value.

When a page is referenced, the required page may be in the memory. If it is in the memory, we need to detach the node of the list and bring it to the front of the queue.
If the required page is not in the memory, we bring that in memory. In simple words, we add a new node to the front of the queue and update the corresponding node address in the hash. If the queue is full, i.e. all the frames are full, we remove a node from the rear of queue, and add the new node to the front of queue.

Note: Initially no page is in the memory.

#endif
