# LRU 

Least Recently Used Cache

Using Java or the language of your choice, implement an LRU (Least Recently Used Cache) by creating a basic class that implements the get() and put() methods of this interface:

interface LruCache
{
Object get(Object key);
void put(Object key, Object value);
int getMaxSize();
String toString();
}

A Least Recently Used Cache is expected to keep all items that have been used the most recently, and discard the ones that haven’t been used in the longest amount of time as it becomes full.
Notes

# “Recently used” is defined as either being retrieved or inserted.
# In this exercise, assume getMaxSize() will return the maximum number of items that can be in the cache. We aren’t worrying   about memory footprint or anything like that - just the number of items.
# While you do not need to implement getMaxSize() for this exercise, you can for testing purposes if you wish. We will not     evaluate this method, so it can be anything you require.
# The get() method should return null in cases where it does not return an Object.
# The toString() method should return a string representation of the items in the cache, including keys and values, in order   of recent use.
# Please use any solution you like, but you cannot use a LinkedHashMap in your implementation.
