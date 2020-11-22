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

    int referenceStringSize = this.pageReferenceString.length;
    int index = 0;
    int referenceIndex = 0;
    while(index < referenceStringSize){
        if(Frame.length < pageFrameCount){
            Frame[index] = this.pageReferenceString[referenceIndex];
            faultCount++;
            referenceIndex++;
            break;
        }
        boolean insertFlag = searchForPage(pageNumber); 
        if(!insertFlag){
            int indexToReplaceAt = index % pageFrameCount + 1; 
            Frame[indexToReplaceAt] = referenceString[referenceIndex];
            faultCount++;
            referenceIndex++;
            break;    
        }
        else{
            index--;
            referenceIndex++;
            break;
        }   
        index++;
    }

*/
