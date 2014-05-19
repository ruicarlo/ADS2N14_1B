package estruturas;

import Exceptions.StackException;

public class Stack<T> extends Object{
    private int top;
    private T[] stack;
    private boolean autoExpand;

    public Stack(int size, boolean allowAutoExpand) {
        this.top = 0;
        this.stack = (T[]) new Object[size];
        this.autoExpand = allowAutoExpand;
    }

    public T peek() {
        return this.stack[this.top-1];
    }

    public void push(T item) throws StackException {
        if(this.top == this.stack.length) {
            if(this.autoExpand) {
                this.expandStack();
            } else {
                throw new StackException("Stack Index Out Of Bounds");
            }
        }
        this.stack[this.top] = item;
        this.top++;
    }

    public T pop() throws StackException {
        if(this.isEmpty()) {
            throw new StackException("Stack Is Empty");
        }
        this.top--;
        return this.stack[this.top];
    }

    public boolean isEmpty() {
        return this.top == 0;
    }

    public int size() {
        return this.isEmpty() ? 0 : this.top;
    }

    private void expandStack() {
        T[] newStack = (T[]) new Object[this.getSizeToExpand()];
        System.arraycopy(this.stack, 0, newStack, 0, this.stack.length);
        this.stack = newStack;
    }

    private int getSizeToExpand() {
        int size = this.stack.length;
        return (int) size <= 200 ? (size*2) : (size+size/2);
    }
}
