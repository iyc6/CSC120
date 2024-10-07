public class Kindle {

    private int numberOfPages;
    private int currentPage;

    public Kindle() {

        numberOfPages = 0;
        currentPage = 1;

    } // end of Default constructor

    public Kindle (int theNumberOfPages) {

        numberOfPages = theNumberOfPages;
        currentPage = 1;

    } // end of constructor with 1 parameter

    public String toString(){

        return("Page   " + currentPage + " of  " + numberOfPages);

    } // end of toString

    public void turnPages() {

        currentPage = currentPage + 1;

    }


    public void turnPages (int pagesToTurn) {

        if ((pagesToTurn + currentPage) < numberOfPages ) {
            currentPage = pagesToTurn + currentPage;

        } else {
            System.out.println("Turning " + pagesToTurn + " pages would take you past the last page.");
            System.out.println("You are now on             : Page " + numberOfPages + " of"   + numberOfPages);
        }

    }
}
