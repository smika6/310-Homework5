import java.util.ArrayList;

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

    /** The reference string of page numbers */
    protected ArrayList<Integer> pageReferenceString;

    /** The frame of pages. */
    ArrayList<Integer> frame;

    /** The number of page faults. */
    protected int pageFaultCount;

    /** The number of physical page frames. */
    protected int pageFrameCount;

    /**
     * Constructor for any replacement algorithm.
     * 
     * @param pageFrameCount - the number of physical page frames
     */
    protected ReplacementAlgorithm(ArrayList<Integer> pageReferenceString, int pageFrameCount){
        if(pageFrameCount < 0){
            throw new IllegalArgumentException();
        }
        this.pageFrameCount = pageFrameCount;
        this.pageFaultCount = 0;
        this.pageReferenceString = pageReferenceString;
        this.frame = new ArrayList<>(pageFrameCount);
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
     *  This is the driver function to run the algorithm to find the page faults created.
     * 
     * @return the number of page faults
     */
    public abstract int run();


}






