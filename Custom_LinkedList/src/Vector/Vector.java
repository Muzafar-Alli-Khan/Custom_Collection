package Vector;

import java.util.Arrays;

/**
 * Create Your Own Vector Class
 * 
 * Vector is a public generic class based on an abstract list structure.
 * Behaves like a list (with add/remove etc.)
 * Can be serialized (saved/sent)
 * Can be cloned (duplicated)
 * Allows fast random access to elements
 * 
 * Vector Internally Uses Array Concept
 * Default Capacity is 10
 */
public class Vector<E> {

    private Object[] elements;        // Stores the actual elements
    private int elementCount;         // Number of elements stored
    private static final int DEFAULT_CAPACITY = 10;

    // Constructor with no parameter
    public Vector() {
        elements = new Object[DEFAULT_CAPACITY];
        elementCount = 0;
    }

    // Constructor with initial capacity
    public Vector(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Capacity can't be negative");
        } else {
            elements = new Object[initialCapacity];
            elementCount = 0;
        }
    }

    // Add element to the end
    public boolean add(E element) {
        if (elementCount == elements.length) {
            grow();
        }
        elements[elementCount++] = element;
        return true;
    }

    // Remove element at a specific index
    @SuppressWarnings("unchecked")
	public E remove(int index) {
        verifyIndex(index);
        E removedElement = (E) elements[index];
        int numMoved = elementCount - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--elementCount] = null;
        return removedElement;
    }

    // Return current size
    public int size() {
        return elementCount;
    }

    // Return current capacity
    public int capacity() {
        return elements.length;
    }

    // Check if vector is empty
    public boolean isEmpty() {
        return elementCount == 0;
    }

    // Clear all elements
    public void clear() {
        Arrays.fill(elements, 0, elementCount, null);
        elementCount = 0;
    }

    // Return a string representation of the vector
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < elementCount; i++) {
            sb.append(elements[i]);
            if (i < elementCount - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Grow the internal array size (double the capacity)
    private void grow() {
        int newCapacity = elements.length * 2;
        if (newCapacity == 0) {
            newCapacity = DEFAULT_CAPACITY;
        }
        elements = Arrays.copyOf(elements, newCapacity);
    }

    // Verify index is within valid bounds
    private void verifyIndex(int index) {
        if (index < 0 || index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    // Sample usage
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        v.add(10);
        v.add(20);
        v.add(30);
        v.add(40);
        v.add(50);

        System.out.println("Vector: " + v);          // [10, 20, 30, 40, 50]
        System.out.println("Size: " + v.size());     // 5
        System.out.println("Capacity: " + v.capacity());

        v.remove(2); // remove element at index 2 (30)
        System.out.println("After removal: " + v);   // [10, 20, 40, 50]

        v.clear();
        System.out.println("After clear: " + v);     // []
        System.out.println("Is Empty? " + v.isEmpty());
    }
}
