import java.util.ArrayList;
/**
 * FIFO page replacement Algorithm
 * 
 * https://www.geeksforgeeks.org/program-page-replacement-algorithms-set-2-fifo/
 */
public class FIFO extends ReplacementAlgorithm {

    protected FIFO(ArrayList<Integer> pageReferenceString, int pageFrameCount) {
        super(pageReferenceString, pageFrameCount);
    }

    /**
     * page faults exist when the frame does not contian the page number if the
     * frame is full then replace the last replaced with the new page count and
     * update the index of the last replaced page number
     */
    @Override
    public int computeFaults() {

        int indexOfLastReplaced = 0;

        for (int pageNumber : this.pageReferenceString) {

            // do nothing if the frame contians the page number
            if (this.frame.contains(pageNumber)) {
                continue;
            }

            this.pageFaultCount++;

            if (this.frame.size() < this.pageFrameCount) {
                this.frame.add(pageNumber);

            } else {
                this.frame.set(indexOfLastReplaced, pageNumber);

                indexOfLastReplaced++;

                if (indexOfLastReplaced == this.pageFrameCount) {
                    indexOfLastReplaced = 0;
                }
            }

        }
        return getPageFaultCount();

    }

}
