package leetcode.datastructure;

public interface Queue<E> {

    /**
     * 入队
     * @param e
     */
    void enQueue(E e);

    /**
     * 出队
     * @return
     */
    E deQueue();
}
