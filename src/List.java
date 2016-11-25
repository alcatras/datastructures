import java.util.Arrays;

/**
 * Simple array backed list.
 * @param <T> Type of stored elements.
 */
public class List<T> {

    private int currentSize;
    private T[] array;

    /**
     * Constructs new empty list with default initial capacity.
     */
    public List() {
        this(8);
    }

    /**
     * Constructs new empty list.
     * @param initialCapacity Initial capacity of the list.
     */
    public List(int initialCapacity) {
        resize(initialCapacity);
        currentSize = 0;
    }

    /**
     * Adds new element to the end of the list.
     * @param newElement Element to be added.
     */
    public void add(T newElement) {
        if(currentSize == array.length)
            resize();

        array[currentSize++] = newElement;
    }

    /**
     * Gets element with specified index.
     * @param index Index of element to be returned.
     * @return Element with given index.
     * @throws IndexOutOfBoundsException Throws exception when specified index is out of bounds.
     */
    public T get(int index) throws IndexOutOfBoundsException {
        validateIndexOrThrow(index);
        return array[index];
    }

    /**
     * Removes and returns element with specified index.
     * @param index Index of element to be removed.
     * @return Removed element.
     * @throws IndexOutOfBoundsException Throws exception when specified index is out of bounds.
     */
    public T remove(int index) throws IndexOutOfBoundsException {
        validateIndexOrThrow(index);
        T removedItem = array[index];
        System.arraycopy(array, index + 1, array, index, array.length - index + 1);
        return removedItem;
    }

    /**
     * Finds index of a given element.
     * @param element Element to be found.
     * @return Index of given element, -1 otherwise.
     */
    public int find(T element) {
        for (int i = 0; i < array.length; i++) {
            if(element.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Number of elements in the list.
     * @return Number of elements in the list.
     */
    public int size() {
        return currentSize;
    }

    /**
     * Current capacity of the list.
     * @return Current capacity of the list.
     */
    public int capacity() {
        return array.length;
    }

    /**
     * Validates given index.
     * @param index Index to be checked.
     * @throws IndexOutOfBoundsException Throws exception if given index is out of bounds.
     */
    private void validateIndexOrThrow(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds, current size: " + currentSize);
        }
    }

    /**
     * Doubles capacity of the array.
     */
    private void resize() {
        resize(array.length * 2);
    }

    /**
     * Grows capacity.
     * @param targetCapacity Target capacity of the array.
     * @throws NegativeArraySizeException Throws exception if negative index is supplied.
     */
    private void resize(int targetCapacity) throws NegativeArraySizeException {
        array = Arrays.copyOf(array, targetCapacity);
    }
}
