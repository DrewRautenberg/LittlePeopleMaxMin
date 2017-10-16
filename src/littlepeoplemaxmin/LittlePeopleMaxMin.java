/* PROJECT: LittlePeopleMaxMin 
 * AUTHOR:  Drew Rautenberg
 * DESCRIPTION:  This program gives the user 6 options for getting further
 *      data about the group of little people - e.g., richest, youngest, etc.
 * INPUT:  user chooses from menu:
 *              R - richest,  P - poorest,  O - oldest,  Y - youngest,
 *              F - alphabetically First by name, L - alpha. Last by name
 * OUTPUT:  selected person's NAME & PICTURE displayed in output window
 * TO DO:  You need to write:
 *      - the actual parameters for the 6 CALLS
 *      - the formal parameters for the 6 METHODS
 *      - the 6 methods' bodies
 *****************************************************************************/
package littlepeoplemaxmin;

import javax.swing.JOptionPane;

public class LittlePeopleMaxMin {

    public static void main(String[] args) {

        //"INPUT" DATA
        // Hardcoded (vs. read from a file) to simplify this for testing
        String[] name = {"Happy", "Grumpy", "Doc", "Sneezy", "Sleepy",
                "Bashful", "Dopey"};
        String[] pic = {":-)", ":-(", "|:-)", ":<)", "-)", ":-|", "<:-]"};
        int[] age = {55, 65, 80, 40, 45, 40, 50};
        double[] salary = {50000.00, 35000.00, 100000.00, 54321.99, 9123.45,
                64000.88, 10000.01};
        //PROCESSING
        showRawData(name, pic, age, salary);

        char choice = getUserOption();

        handleUserRequest(choice, name, pic, age, salary);

        System.exit(0);
    }

    private static char getUserOption() {
        String menu = "CHOOSE OPTION:\n"
                + "P:  poorest\n"
                + "R:  richest\n"
                + "O:  oldest\n"
                + "Y:  youngest\n"
                + "F:  first (by name)\n"
                + "L:  last (by name)\n";
        String userResponse = JOptionPane.showInputDialog(menu);
        char choice = userResponse.charAt(0);
        return choice;
    }

    private static void showRawData(String[] name, String[] pic, int[] age,
                                    double[] salary) {
        System.out.println("FYI:  THE DATA");
        for (int i = 0; i < name.length; i++)
            System.out.printf("[%d]  %-8s %5s  %d  %,10.2f\n",
                    i, name[i], pic[i], age[i], salary[i]);
        System.out.println("\n");
    }

    private static void handleUserRequest(char choice, String[] name, String[] pic, int[] age, double[] salary) {
        // IMPORTANT NOTE:  output includes selected person's name and pic

        switch (choice) {
            case 'P':
            case 'p':
                showPoorest(name,pic,salary);
                break;
            case 'R':
            case 'r':
                showRichest(name,pic,salary);
                break;
            case 'O':
            case 'o':
            case '0':                                     // zero, just in case
                showOldest(name,pic,age);
                break;
            case 'Y':
            case 'y':
                showYoungest(name,pic,age);
                break;
            case 'F':
            case 'f':
                showFirst();
                break;
            case 'L':
            case 'l':
            case '1':                                      // one, just in case
                showLast();
                break;
            default:
                System.out.println("\nERROR:  option was invalid");
        }
    }

    private static void showPoorest(String name[],String pic[],double salary[]) {
        double minSal=Integer.MAX_VALUE;
        int spot=0;
        for (int i=0; i<salary.length;i++){
            if (salary[i]<minSal){
                minSal=salary[i];
                spot=i;
            }
        }
        System.out.println("Name: "+name[spot]+ " "+pic[spot]);
    }
    private static void showRichest(String name[],String pic[],double salary[]) {
        double maxSal=Integer.MIN_VALUE;
        int spot=0;
        for (int i=0; i<salary.length;i++){
            if (salary[i]>maxSal){
                maxSal=salary[i];
                spot=i;
            }
        }
        System.out.println("Name: "+name[spot]+ " "+pic[spot]);
    }
    private static void showOldest(String name[],String pic[],int age[]) {
        double maxAge=Integer.MIN_VALUE;
        int spot=0;
        for (int i=0; i<age.length;i++){
            if (age[i]>maxAge){
                maxAge=age[i];
                spot=i;
            }
        }
        System.out.println("Name: "+name[spot]+ " "+pic[spot]);
    }
    private static void showYoungest(String name[],String pic[],int age[]) {
        double minAge=Integer.MAX_VALUE;
        int spot=0;
        for (int i=0; i<age.length;i++){
            if (age[i]<minAge){
                minAge=age[i];
                spot=i;
            }
        }
        System.out.println("Name: "+name[spot]+ " "+pic[spot]);
    }
    // First alphabetically, by name (not the first name in the array)
    private static void showFirst() {

    }
    // Last alphabetically, by name (not the last name in the array)
    private static void showLast() {

    }
}