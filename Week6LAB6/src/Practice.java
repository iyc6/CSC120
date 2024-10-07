//=================================================================================================
public class Practice {
    //-------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

        printBookParts(4,6);
        printBookParts();
        printBookParts('8');
        printBookParts(2);
        printBookParts('B');
    }
    //-------------------------------------------------------------------------------------------------
    private static void printBookParts() {

        System.out.println("Preface");
    }
    //-------------------------------------------------------------------------------------------------
    private static void printBookParts(int chapterNumber) {

        System.out.println("Chapter " + chapterNumber);
    }
    //-------------------------------------------------------------------------------------------------
    private static void printBookParts(int start,int end) {

        int chapterNumber;

        for (chapterNumber = start; chapterNumber <= end; chapterNumber++) {
            printBookParts(chapterNumber);
        }
    }
    //-------------------------------------------------------------------------------------------------
    private static void printBookParts(char appendixNumber) {

        if (appendixNumber >= '1' && appendixNumber <= '9') {
            printBookParts((int)appendixNumber - (int)'0');
        } else {
            System.out.println("Appendix " + appendixNumber);
        }
    }
//-------------------------------------------------------------------------------------------------
}
//=================================================================================================