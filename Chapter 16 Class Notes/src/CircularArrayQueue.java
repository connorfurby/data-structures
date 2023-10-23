import java.util.NoSuchElementException;

/**
    An implementation of a queue as a circular array.
*/
public class CircularArrayQueue
{
    private Object[] elements;
    private int head,tail,currentSize;

    //private data



    /**
        Constructs an empty queue.
    */
    public CircularArrayQueue(){
        final int INITIAL_SIZE = 5; // arbritrary size
        this.elements = new Object[INITIAL_SIZE];
        this.head = 0;
        this.tail = 0;
        this.currentSize = 0;
    }





    /**
        Checks whether this queue is empty.
        @return true if this queue is empty
    */
    public boolean empty(){
        return this.currentSize == 0;
    }



    /**
        Adds an element to the tail of this queue.
        @param newElement the element to add
    */
    public void add(Object element){
        this.growIfNecessary();

        this.currentSize++;
        this.elements[this.tail] = element;
        this.tail++;
        
        this.tail %= this.elements.length; //Moves it to the front if its divisible by the length of the array, if not then it remains the same.

    }




    /**
        Removes an element from the head of this queue.
        @return the removed element
    */
    public Object remove(){
        if (this.empty()){
            throw new NoSuchElementException();
            
        }
        this.currentSize--;
        Object element = this.elements[this.head];
        this.head = (this.head + 1) % this.elements.length;
        // if head is not at the end of the array, it will be the remainder, which is head+1\

        return element; 
    }




    /**
        Grows the element array if the current size equals the capacity.
    */
    private void growIfNecessary()
    {
        
        if(this.currentSize == this.elements.length)
        {
            Object[] newElements = new Object[2 * this.elements.length];
            for(int i = 0; i < this.elements.length; i++)
            {
                newElements[i] = this.elements[(head + i) % this.elements.length];
            }
            this.elements = newElements;
            this.head = 0;
            this.tail = this.currentSize;
        }
        
    }




}//CircularArrayQueue