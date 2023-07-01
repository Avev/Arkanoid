
/**
 * counter class.
 */
public class Counter {
    private int counter;

    /**
     * counter constructor.
     */
    public Counter() {
        this.counter = 0;
    }

    /**
     * counter constructor.
     *
     * @param count the count
     */
    public Counter(int count) {
        this.counter = count;
    }


    /**
     * add number to current count.
     *
     * @param number added number
     */
    public void increase(int number) {
        this.counter += number;
    }


    /**
     * subtract number from current count.
     *
     * @param number the number we substract
     */
    public void decrease(int number) {
        this.counter -= number;
    }

    /**
     * get current count.
     *
     * @return counter
     */
    public int getValue() {
        return counter;
    }
}
