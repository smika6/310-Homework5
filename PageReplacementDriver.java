import java.util.ArrayList;

public class PageReplacementDriver {

    public static void main(String[] args) {

        int[] pageFrameSizesForTesting = {1,2,3,4,5,6,7,8,9};

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

        print("\nPage Reference String: \n");
        for(int pageNumber : pageReferenceString ){
            print(pageNumber);
            print(" ");
        }

        // Run the tests

        ReplacementAlgorithm pageReplacementAlgorithm;

        String fifoPageAlgoString = "FIFO Page Replacement w/ Frame Size: ";
        String fifoPageFaultsString = "";

        String optimalPageAlgoString = "Optimal Page Replacement w/ Frame Size: ";
        String optimalPageFaultsString = "";

        String faultCountString = "Fault Count: %s";

        int faultCount = -1;

        for(int pageFrameSize : pageFrameSizesForTesting ){

            print("Running FIFO and Optimal with a frame size of " + pageFrameSize + ".");

            pageReplacementAlgorithm = new FIFO(pageReferenceString, pageFrameSize);
            faultCount = pageReplacementAlgorithm.run();

            print(fifoPageAlgoString + pageFrameSize);
            fifoPageFaultsString = String.format(faultCountString, faultCount);
            print(fifoPageFaultsString);
            print("\n");

            pageReplacementAlgorithm = new Optimal(pageReferenceString, pageFrameSize);
            faultCount = pageReplacementAlgorithm.run();

            print(optimalPageAlgoString + pageFrameSize);
            optimalPageFaultsString = String.format(faultCountString, faultCount);
            print(optimalPageFaultsString);
            print("\n");

            print("\n\n");
        }
        print("\n\n");



    }

    public static void print(Object o){
        System.out.print(o);
    }

}