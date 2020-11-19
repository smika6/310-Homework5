public class FIFO extends ReplacementAlgorithm{
    int[] Frame;

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
    public void insert(int pageNumber) {

    }
}
