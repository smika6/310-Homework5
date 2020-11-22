import java.util.ArrayList;

public class Optimal extends ReplacementAlgorithm {

    protected Optimal(ArrayList<Integer> pageReferenceString, int pageFrameCount) {
        super(pageReferenceString, pageFrameCount);
        
        frame = new ArrayList<>(pageFrameCount);
    }

    @Override
    public int run() {

        return 0;
    }
    
}
