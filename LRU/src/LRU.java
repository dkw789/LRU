import java.util.*;


public class LRU implements LruCache
{
	private LinkedList<Object> list;
	private Map<Object, Object> cache;
	private int currentSize;
	private int maxSize;
	
	LRU()
	
	{
		list = new LinkedList<Object>();
		cache = new HashMap<Object, Object>();
		currentSize = 0;
	}
	
	@Override
	public Object get(Object key) 
	{
		if(cache.get(key) != null && list.contains(cache.get(key)))
		{
			/** get () Method gets the map entry from the map and marks the accessing order.
			When an element is accessed from the map, it is added to the head of the list.
			If an element is accessed and is already on the first position, then nothing occurs but if it is somewhere else in the list, 
			it needs to be removed and then added to the head of the list.
			**/
			
			list.remove(cache.get(key));
			list.addFirst(cache.get(key));
			System.out.println("Moving " + cache.get(key) + " to first!");
			return cache.get(key);
		}
		else
		{
			/**
			 * The get() method should return null in cases where it does not return an Object. 
			 **/
			return null;
		}
	}

	@Override
	
	// method to set the elements in the cache.Depending on the cache size so if there is not enough space, the least recently accessed
	// element is deleted first.
	
	public void put(Object key, Object value)
	{
		if(currentSize < maxSize)
		{
			cache.put(key, value);
			list.addFirst(cache.get(key));
			currentSize++;
		}
		else
		{
			Object lastElement = list.removeLast();
			cache.remove(lastElement);
			cache.put(key, value);
			list.addFirst(cache.get(key));
		}
	}

	@Override
	public int getMaxSize()
	{
		return maxSize;
	}
	
	public void setMaxSize(int maxSize)
	{
		this.maxSize = maxSize;
	}

	
	// method to displays all the elements present in the cache after an operation.
	
	public void getAll()
	{
		System.out.println("Cache List");
		
		ListIterator<Object> listIterator = list.listIterator();
		
		while(listIterator.hasNext())
			
		{
			System.out.println(listIterator.next());
		}
		
	}
	
	public static void main(String [] args)
	{
		
	    String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.	    
	    
		System.out.println("LRU Cache Test"+ newLine  );
		
		String byte1 = new String("001");
		String byte2 = new String("010");
		String byte3 = new String("011");
		String byte4 = new String("100");
		String byte5 = new String("101");
		
		LRU x = new LRU();
		
		/** set max size here!  **/
		
		x.setMaxSize(3);
		
		
		System.out.println("Test 1: " + newLine );
		
		x.put(byte1, byte1);
		x.put(byte2, byte2);
		x.put(byte3, byte3);
		x.put(byte4, byte4);
		x.put(byte5, byte5);
		x.getAll();
		    
		System.out.println(newLine + "Test 2: " + newLine );
		
		x.get(byte3);
		x.getAll();
		
		System.out.println(newLine +"Test 3: " + newLine );
		
		x.get(byte5);
		x.getAll();
	    
		System.out.println(newLine +"Test 4: " + newLine );
	
		x.get(byte4);
		x.getAll();
		
	    System.out.println( newLine +"Test 5:" + newLine );
	    
	    x.get(byte4);      // testing for an element already in the cache in the head position
		x.getAll();
	    
		System.out.println( newLine +  "Test 6:" + newLine );
		    
		    x.get(byte1); // note: once an element has been removed from the cache list, it can't be access anymore 
		    			  //and should be retrieved from the RAM or hard drive but this wasn't implemented here yet! 
		    				// so nothings happens here in this case.
			x.getAll();
	    
	}
}

