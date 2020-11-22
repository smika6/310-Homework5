public class FIFO extends ReplacementAlgorithm{
    int[] Frame;
    int faultCount;
   

    protected FIFO(int pageFrameCount) {
        super(pageFrameCount);
    }

    public boolean searchForPage(int pageNumber){
        boolean pageFound = false;

        for(int i = 0; i < Frame.length; i++ ){
            if(pageNumber == Frame[i]){
                pageFound = true;
                break;
            }
        }
    
        return pageFound;

    }

    @Override
    public void insert(int pageNumber, int[] referenceString) {  
        int referenceStringSize = referenceString.length;
        int index = 0;
        int referenceIndex = 0;
        while(index < referenceStringSize){
            if(Frame.length < pageFrameCount){
                Frame[index] = referenceString[referenceIndex];
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
}
