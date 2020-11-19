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

    }

    public static void print(Object o){
        System.out.print(o);
    }
}