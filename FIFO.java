import java.util.ArrayList;

public class FIFO extends ReplacementAlgorithm {
   
    protected FIFO(ArrayList<Integer> pageReferenceString, int pageFrameCount) {
        super(pageReferenceString, pageFrameCount);
    }

    /**
     * page faults exist when the frame does not contian the page number
     * if the frame is full
     * then replace the last replaced with the new page count
     * and update the index of the last replaced page number
     */
    @Override
    public int run() {  
        // 0 - 9 inputs, and so 10 total differnt page numbers, and the fault count is reporting 10 no matter what

        int indexOfLastReplaced = 0;

        for(int pageNumber : this.pageReferenceString){

            if(this.frame.contains(pageNumber)){
                continue;
            }

            this.pageFaultCount++;

            if(this.frame.size() == this.pageFrameCount){ 

                this.frame.add(indexOfLastReplaced, pageNumber);
                indexOfLastReplaced++;

                if(indexOfLastReplaced == this.pageFrameCount){
                    indexOfLastReplaced = 0;
                }

            }else{ 
                this.frame.add(pageNumber);
            }

        }
        return getPageFaultCount();
    }

}

/*
TO BE WORKED ON. KWINTON
    public void run() {
        int referenceStringSize = referenceString.length;
        int pageReferenceindex = 0;
        int positionInReferenceString = 0;
        int referenceStringIndex = 0;
        while(positionInReferenceString < referenceStringSize){
            if(Frame.length < pageFrameCount){
                Frame[index] = referenceString[referenceStringIndex];
                faultCount++;
                referenceStrtingIndex++;
                break;
            }
            boolean insertFlag = searchForPage(pageNumber); 
            if(!insertFlag){
                int indexToReplaceAt = index % pageFrameCount + 1; 
                Frame[indexToReplaceAt] = referenceString[referenceStringIndex];
                faultCount++;
                referenceStringIndex++;
                break;
            }
            else{
                index--;
                referenceStringIndex++;
                break;
            }
            index++;
            positionInReferenceString++;
        }
    }

*/
