package cp213;

/**
 * A single linked list structure of <code>Node T</code> objects. These data
 * objects must be Comparable - i.e. they must provide the compareTo method.
 * Only the <code>T</code> object contained in the priority queue is visible
 * through the standard priority queue methods. Extends the
 * <code>SingleLink</code> class.
 *
 * @author David Brown
 * @version 2024-09-01
 * @param <T> this SingleList data type.
 */
public class SingleList<T extends Comparable<T>> extends SingleLink<T> {

    /**
     * Searches for the first occurrence of key in this SingleList. Private helper
     * methods - used only by other ADT methods.
     *
     * @param key The object to look for.
     * @return A pointer to the node previous to the node containing key.
     */
    private SingleNode<T> linearSearch(final T key) {

	// your code here
	SingleNode<T> current = this.front;
    SingleNode<T> previous = null;

    while (current != null) {
        if (current.getObject().compareTo(key) == 0) {
            return previous;
        }
        previous = current;
        current = current.getNext();
    }
    return null;
    }

    /**
     * Appends data to the end of this SingleList.
     *
     * @param data The object to append.
     */
    public void append(final T data) {

	// your code here
    SingleNode<T> node2 = new SingleNode<>(data, null);
    
    if(this.front == null) {
    	this.front = node2;
    	this.rear = node2;
    } else {
    	this.rear.setNext(node2);
    	this.rear = node2;
    }
    
    this.length ++;

	return;
    }

    /**
     * Removes duplicates from this SingleList. The list contains one and only one
     * of each object formerly present in this SingleList. The first occurrence of
     * each object is preserved.
     */
    public void clean() {

	// your code here
	if (this.front == null) {
        return;
    }
    SingleNode<T> current = this.front;
    while (current != null && current.getNext() != null) {
        SingleNode<T> pointer = current;
        while (pointer.getNext() != null) {
            if (pointer.getNext().getObject().equals(current.getObject())) {
                pointer.setNext(pointer.getNext().getNext());
                this.length--;
            } else {
                pointer = pointer.getNext();
            }
        }
        current = current.getNext();
    }
	return;
    }

    /**
     * Combines contents of two lists into a third. Values are alternated from the
     * origin lists into this SingleList. The origin lists are empty when finished.
     * NOTE: data must not be moved, only nodes.
     *
     * @param left  The first list to combine with this SingleList.
     * @param right The second list to combine with this SingleList.
     */
    public void combine(final SingleList<T> left, final SingleList<T> right) {

	// your code here
	boolean turn = true;
    while (left.length > 0 || right.length > 0) {
        if (turn && left.length > 0) {
            this.moveFrontToRear(left);
        } else if (right.length > 0) {
            this.moveFrontToRear(right);
        }
        turn = !turn;
    }

	return;
    }

    /**
     * Determines if this SingleList contains key.
     *
     * @param key The key object to look for.
     * @return true if key is in this SingleList, false otherwise.
     */
    public boolean contains(final T key) {

	// your code here

	return linearSearch(key) != null;
    }

    /**
     * Finds the number of times key appears in list.
     *
     * @param key The object to look for.
     * @return The number of times key appears in this SingleList.
     */
    public int count(final T key) {

	// your code here
    int total = 0;
    SingleNode<T> current = this.front;
    
    while(current != null) {
    	if(current.getObject().compareTo(key) == 0) {
    		total++;
    	}
    	current = current.getNext();
    }

	return total;
    }

    /**
     * Finds and returns the object in list that matches key.
     *
     * @param key The object to search for.
     * @return The object that matches key, null otherwise.
     */
    public T find(final T key) {

	// your code here
    SingleNode<T> current = this.front;
    
    while(current != null) {
    	if(current.getObject().compareTo(key) == 0) {
    		return current.getObject();
    	}
    	current = current.getNext();
    }

	return null;
    }

    /**
     * Get the nth object in this SingleList.
     *
     * @param n The index of the object to return.
     * @return The nth object in this SingleList.
     * @throws ArrayIndexOutOfBoundsException if n is not a valid index.
     */
    public T get(final int n) throws ArrayIndexOutOfBoundsException {

	// your code here
    if( n < 0 || n >= this.length) {
    	throw new ArrayIndexOutOfBoundsException();
    }
    
    SingleNode<T> current = this.front;
    for(int i = 0; i < n; i++) {
    	current = current.getNext();
    }

	return current.getObject();
    }

    /**
     * Determines whether two lists are identical.
     *
     * @param source The list to compare against this SingleList.
     * @return true if this SingleList contains the same objects in the same order
     *         as source, false otherwise.
     */
    public boolean equals(final SingleList<T> source) {

	// your code here
	if (this.length != source.length) {
        return false;
    }
    SingleNode<T> current1 = this.front;
    SingleNode<T> current2 = source.front;
    while (current1 != null) {
        if (!current1.getObject().equals(current2.getObject())) {
            return false;
        }
        current1 = current1.getNext();
        current2 = current2.getNext();
    }
    return true;
    }

    /**
     * Finds the first location of a object by key in this SingleList.
     *
     * @param key The object to search for.
     * @return The index of key in this SingleList, -1 otherwise.
     */
    public int index(final T key) {

	// your code here
    SingleNode<T> current = this.front;
    int index = 0;
    
    while(current != null) {
    	if(current.getObject().compareTo(key) == 0) {
    		return index;
    	}
    	
    	current = current.getNext();
    	index++;
    }

	return -1;
    }

    /**
     * Inserts object into this SingleList at index i. If i greater than the length
     * of this SingleList, append data to the end of this SingleList.
     *
     * @param i    The index to insert the new data at.
     * @param data The new object to insert into this SingleList.
     */
    public void insert(int i, final T data) {

	// your code here
	if (i >= this.length) {
        this.append(data);
        return;
    }
    SingleNode<T> newNode = new SingleNode<>(data, null);
    if (i == 0) {
        newNode.setNext(this.front);
        this.front = newNode;
        if (this.length == 0) {
            this.rear = newNode;
        }
    } else {
        SingleNode<T> current = this.front;
        for (int index = 0; index < i - 1; index++) {
            current = current.getNext();
        }
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        if (newNode.getNext() == null) {
            this.rear = newNode;
        }
    }
    this.length++;

	return;
    }

    /**
     * Creates an intersection of two other SingleLists into this SingleList. Copies
     * data to this SingleList. left and right SingleLists are unchanged. Values
     * from left are copied in order first, then objects from right are copied in
     * order.
     *
     * @param left  The first SingleList to create an intersection from.
     * @param right The second SingleList to create an intersection from.
     */
    public void intersection(final SingleList<T> left, final SingleList<T> right) {

	// your code here
    SingleNode<T> current = left.front;
    
    while(current != null) {
    	if(right.contains(current.getObject())) {
    		this.append(current.getObject());
    	}
    	
    	current = current.getNext();
    }

	return;
    }

    /**
     * Finds the maximum object in this SingleList.
     *
     * @return The maximum object.
     */
    public T max() {

	// your code here
	if (this.front == null) {
        return null;
    }
    T max = this.front.getObject();
    SingleNode<T> current = this.front.getNext();
    while (current != null) {
        if (current.getObject().compareTo(max) > 0) {
            max = current.getObject();
        }
        current = current.getNext();
    }
    return max;
    }

    /**
     * Finds the minimum object in this SingleList.
     *
     * @return The minimum object.
     */
    public T min() {

	// your code here
	if (this.front == null) {
        return null;
    }
    T min = this.front.getObject();
    SingleNode<T> current = this.front.getNext();
    while (current != null) {
        if (current.getObject().compareTo(min) < 0) {
            min = current.getObject();
        }
        current = current.getNext();
    }
    return min;
    }

    /**
     * Inserts object into the front of this SingleList.
     *
     * @param data The object to insert into the front of this SingleList.
     */
    public void prepend(final T data) {

	// your code here
    SingleNode<T> node2 = new SingleNode<>(data, this.front);
    this.front = node2;
    if(this.length == 0) {
    	this.rear = node2;
    }
    
    this.length++;

	return;
    }

    /**
     * Finds, removes, and returns the object in this SingleList that matches key.
     *
     * @param key The object to search for.
     * @return The object matching key, null otherwise.
     */
    public T remove(final T key) {

	// your code here
	SingleNode<T> previous = linearSearch(key);
    if (previous == null && this.front != null && this.front.getObject().compareTo(key) == 0) {
        return this.removeFront();
    } else if (previous != null) {
        SingleNode<T> toRemove = previous.getNext();
        previous.setNext(toRemove.getNext());
        if (toRemove == this.rear) {
            this.rear = previous;
        }
        this.length--;
        return toRemove.getObject();
    }
    return null;
    }

    /**
     * Removes the object at the front of this SingleList.
     *
     * @return The object at the front of this SingleList.
     */
    public T removeFront() {

	// your code here
    assert this.front != null;
    
    T data = this.front.getObject();
    this.front = this.front.getNext();
    if (this.front == null) {
        this.rear = null;
    }
    this.length--;
    return data;
    }

    /**
     * Finds and removes all objects in this SingleList that match key.
     *
     * @param key The object to search for.
     */
    public void removeMany(final T key) {

	// your code here
	while (this.contains(key)) {
        this.remove(key);
    }
	
	return;
    }

    /**
     * Reverses the order of the objects in this SingleList.
     */
    public void reverse() {

	// your code here
	SingleNode<T> previous = null;
    SingleNode<T> current = this.front;
    SingleNode<T> next = null;
    this.rear = this.front;
    while (current != null) {
        next = current.getNext();
        current.setNext(previous);
        previous = current;
        current = next;
    }
    this.front = previous;

	return;
    }

    /**
     * Splits the contents of this SingleList into the left and right SingleLists.
     * Moves nodes only - does not move object or call the high-level methods insert
     * or remove. this SingleList is empty when done. The first half of this
     * SingleList is moved to left, and the last half of this SingleList is moved to
     * right. If the resulting lengths are not the same, left should have one more
     * object than right. Order is preserved.
     *
     * @param left  The first SingleList to move nodes to.
     * @param right The second SingleList to move nodes to.
     */
    public void split(final SingleList<T> left, final SingleList<T> right) {

	// your code here
    int middle = (this.length + 1)/2;
    
    SingleNode<T> current = this.front;
    for(int i = 0; i < middle; i++) {
    	left.moveFrontToRear(this);
    }
    
    while(this.front != null) {
    	right.moveFrontToRear(this);
    }
	return;
    }

    /**
     * Splits the contents of this SingleList into the left and right SingleLists.
     * Moves nodes only - does not move object or call the high-level methods insert
     * or remove. this SingleList is empty when done. Nodes are moved alternately
     * from this SingleList to left and right. Order is preserved.
     *
     * @param left  The first SingleList to move nodes to.
     * @param right The second SingleList to move nodes to.
     */
    public void splitAlternate(final SingleList<T> left, final SingleList<T> right) {

	// your code here
	boolean turn = true;
    while (this.front != null) {
        if (turn) {
            left.moveFrontToRear(this);
        } else {
            right.moveFrontToRear(this);
        }
        turn = !turn;
    }
	return;
    }

    /**
     * Creates a union of two other SingleLists into this SingleList. Copies object
     * to this list. left and right SingleLists are unchanged. Values from left are
     * copied in order first, then objects from right are copied in order.
     *
     * @param left  The first SingleList to create a union from.
     * @param right The second SingleList to create a union from.
     */
    public void union(final SingleList<T> left, final SingleList<T> right) {

	// your code here
	SingleNode<T> currentLeft = left.front;
    while (currentLeft != null) {
        if (!this.contains(currentLeft.getObject())) {
            this.append(currentLeft.getObject());
        }
        currentLeft = currentLeft.getNext();
    }
    SingleNode<T> currentRight = right.front;
    while (currentRight != null) {
        if (!this.contains(currentRight.getObject())) {
            this.append(currentRight.getObject());
        }
        currentRight = currentRight.getNext();
    }

	return;
    }
}
