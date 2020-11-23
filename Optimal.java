import java.util.ArrayList;
/**
 * 
 * https://www.geeksforgeeks.org/optimal-page-replacement-algorithm/
 */
public class Optimal extends ReplacementAlgorithm {

    protected Optimal(ArrayList<Integer> pageReferenceString, int pageFrameCount) {
        super(pageReferenceString, pageFrameCount);
        
        frame = new ArrayList<>(pageFrameCount);
    }

    private int findIndexOfFarthestReference(int currentPageNumberIndex){
        int indexOfFathestReferenceInFrame = -1;
        int fathestDistanceFromReference = -1;

        // for every page number in the frame
        for(int pageNumberIndexInFrame = 0; pageNumberIndexInFrame < this.frame.size(); pageNumberIndexInFrame++){

            // for every page number in the reference string, from where we currently are to the end
            for(int i = currentPageNumberIndex; i < this.pageReferenceString.size(); i++){

                // if the page number in the frame is one of the values in the remaining reference string
                if( this.frame.get(pageNumberIndexInFrame).equals( this.pageReferenceString.get(i) ) ){

                    // if thet distance of that reference is greater than any other distance of page numbers in the frame
                    if(i > fathestDistanceFromReference){

                        //assign the index found and report the distance for further comparison
                        fathestDistanceFromReference = i;
                        indexOfFathestReferenceInFrame = pageNumberIndexInFrame;

                    }

                    // once we find the first instance of the page number in the frame in the remaining reference string..
                    // break out the loop so as not to consider further instances of the same page number currently considered in the frame
                    break;
                }
            }

            // if the distance is never updated than that page number is not in the remaining reference string
            // therefore it is never needed again and can be replaced
            if(fathestDistanceFromReference == -1){
                return pageNumberIndexInFrame;
            }
        }

        // if none of the page numbers in the frame are in the remaining reference string then return the first, but any could be replaced
        if(indexOfFathestReferenceInFrame == -1){
            return 0;
        }

        //return the index of the reference that is furthest out
        return indexOfFathestReferenceInFrame;
    }

    @Override
    public int computeFaults() {

        int pageNumber;

        for (int pageNumberIndex = 0; pageNumberIndex < this.pageReferenceString.size(); pageNumberIndex++) {

            pageNumber = this.pageReferenceString.get(pageNumberIndex);

            // do nothing if the frame contians the page number
            if (this.frame.contains(pageNumber)) {
                continue;
            }

            this.pageFaultCount++;

            if (this.frame.size() < this.pageFrameCount) {
                this.frame.add(pageNumber);

            } else {
                this.frame.set( findIndexOfFarthestReference(pageNumberIndex) , pageNumber);

            }

        }
        return getPageFaultCount();

    }
    
}
