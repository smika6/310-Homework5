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
        
        int[] pageReferenceString = PageGenerator.getPageReferenceString(referenceStringLength);

        print("\nPage Reference String: \n");
        for(int pageNumber : pageReferenceString ){
            print(pageNumber);
            print(" ");
        }

        // Run the tests

        ReplacementAlgorithm pargeReplacementAlgorithm;

        String fifoPageAlgoString = "FIFO Page Replacement w/ Frame Size %s.";
        String fifoPageFaultsString = "";

        String optimalPageAlgoString = "Optimal Page Replacement w/ Frame Size %s.";
        String optimalPageFaultsString = "";

        String faultCountString = "Fault Count: %s";

        for(int pageFrameSize : pageFrameSizesForTesting ){

            print("Running FIFO and Optimal with a frame size of " + pageFrameSize + ".");

            pargeReplacementAlgorithm = new FIFO(pageReferenceString, pageFrameSize);
            int fifoFaults = pargeReplacementAlgorithm.run();

            print(fifoPageAlgoString);
            fifoPageFaultsString = String.format(faultCountString, fifoFaults);
            print(fifoPageFaultsString);
            print("\n");

            pargeReplacementAlgorithm = new Optimal(pageReferenceString, pageFrameSize);
            int optimalFaults = pargeReplacementAlgorithm.run();

            print(optimalPageAlgoString);
            optimalPageFaultsString = String.format(faultCountString, optimalFaults);
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