/**
 * Abstract
 * 
 * @author Kwinton Dropps
 * @author Jacob Hopkins
 * 
 * @version 1.0
 * @since 1.0
 */
public abstract class ReplacementAlgorithm{

    /** The number of page faults. */
    protected int pageFaultCount;

    /** The number of physical page frames. */
    protected int pageFrameCount;

    /**
     * Constructor for any replacement algorithm.
     * 
     * @param pageFrameCount - the number of physical page frames
     */
    protected ReplacementAlgorithm(int pageFrameCount){
        if(pageFrameCount < 0){
            throw new IllegalArgumentException();
        }
        this.pageFrameCount = pageFrameCount;
        pageFaultCount = 0;
    }    

    /**
     * Accessor method for the page fault count.
     * 
     * @return the number of page faults
     */
    public int getPageFaultCount(){
        return pageFaultCount;
    }

    /**
     * Abstract method definition for inserting a page number into the frame
     * 
     * @param pageNumber - the page number to be inserted.
     */
    public abstract void insert(int pageNumber);


}






