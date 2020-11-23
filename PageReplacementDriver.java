import java.util.ArrayList;

public class PageReplacementDriver {

    public static void main(String[] args) {

        int[] pageFrameSizesForTesting = {1,2,3,4,5,6,7,8};

        print("\nPage Frame Sizes to be Tested: \n");
        for(int pageFrameSize : pageFrameSizesForTesting ){
            print(pageFrameSize);
            print(" ");
        }
        print("\n\n");
        

        int referenceStringLength = 10000;
        
        if(args.length > 0){
            try{
                referenceStringLength = Integer.parseInt(args[0]);
                if(referenceStringLength < 10000){
                    System.out.println("Imputed reference-string length requested below 10,000.");
                    throw new IllegalArgumentException();
                }
            }catch(Exception e){
                referenceStringLength = 10000;
            }
        }
        
        ArrayList<Integer> pageReferenceString = PageGenerator.getPageReferenceString(referenceStringLength);

        // Run the tests

        ReplacementAlgorithm pageReplacementAlgorithm;

        String fifoPageAlgoString = "Fault Count w/ FIFO Page Replacement: ";
        String optimalPageAlgoString = "Fault Count w/ Optimal Page Replacement: ";

        int faultCount = -1;

        for(int pageFrameSize : pageFrameSizesForTesting ){

            print("Running FIFO and Optimal with a frame size of " + pageFrameSize + ".");

            pageReplacementAlgorithm = new FIFO(pageReferenceString, pageFrameSize);
            faultCount = pageReplacementAlgorithm.computeFaults();

            print("\n");
            print(fifoPageAlgoString);
            print(faultCount);
            print("\n");

            pageReplacementAlgorithm = new Optimal(pageReferenceString, pageFrameSize);
            faultCount = pageReplacementAlgorithm.computeFaults();

            print(optimalPageAlgoString);
            print(faultCount);
            print("\n\n");

        }
        print("\n\n");



    }

    public static void print(Object o){
        System.out.print(o);
    }

}

/*
public void insert(int pageNumber) {
        int referenceStringSize = referenceString.length;
        int pageReferenceindex = 0;
        int positionInReferenceString = 0;
        int referenceStringIndex = 0;
        int index = 0;
        while(positionInReferenceString < referenceStringSize){
            boolean insertFlag = searchForPage(pageNumber); 
            if(!insertFlag || Frame.length < pageFrameCount ){
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

        //Practice

        print("Test Case for FIFO, should be 5...");
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(0);
        arr.add(3);
        arr.add(5);
        arr.add(6);
        FIFO f = new FIFO(arr,3);
        print("\n");
        print("Faults: " + f.computeFaults());
        print("\n\n");
*/