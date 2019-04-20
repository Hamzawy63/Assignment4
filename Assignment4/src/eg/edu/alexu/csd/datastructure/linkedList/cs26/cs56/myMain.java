package eg.edu.alexu.csd.datastructure.linkedList.cs26.cs56;

import java.awt.*;
import java.util.Scanner;

public class myMain {


    public static void main(String[] args) {
        Polynomial newPolynomial = new Polynomial();
        simpleUserInterface(newPolynomial);

    }

    public static void simpleUserInterface(Polynomial newPolynomial) {

        System.out.println("============================================================");
        System.out.println("Please choose an action\n" +
                "-----------------------\n" +
                "1- Set a polynomial variable\\n\n" +
                "2- Print the value of a polynomial variable\\n\n" +
                "3- Add two polynomials\\n\n" +
                "4- Subtract two polynomials5- Multiply two polynomials\\n\n" +
                "6- Evaluate a polynomial at some point\\n\n" +
                "7- Clear a polynomial variable\\n\n" +
                "=====================================================================");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        switch (input) {
            case 1:
                setPolynomialvariable(newPolynomial);
                break;
            case 2:
                PrintPolynomial(newPolynomial);
                break;
            case 3:
                Addpolynomials(newPolynomial);
            default:
                return;

        }
        simpleUserInterface(newPolynomial);
        // Polynomial.Data tmp =(Polynomial.Data) newPolynomial.dataArray.get(0);
        //tmp.polynomial.print();
        //System.out.print(tmp.matrixRepresentation[0][1]);

    }

    public static void setPolynomialvariable(Polynomial poly) {
        char tmpChar = getCharacter();


        System.out.println("Insert the polynomial terms in the form:\n" +
                "(coeff1, exponent1), (coeff2, exponent2), ..");
        Scanner sce = new Scanner(System.in);
        // String redundant = sc.nextLine();
        String polynomial = sce.nextLine();

        if (checkPolyInput(polynomial) == false) {
            System.out.println("Invalid input");
            setPolynomialvariable(poly);
        } else {
            singlyLinkedList tmpPolynomial = new singlyLinkedList();
            /// FILL THE INPUT INTO THE LINKED LIST
            int start = polynomial.indexOf("(");
            while (start != -1) {
                //Integer.parseInt(number);
                int x = Character.getNumericValue(polynomial.charAt(start + 1));
                int y = Character.getNumericValue(polynomial.charAt(start + 4));
                Point termPoint = new Point(x, y);
                tmpPolynomial.add(termPoint);
                start = polynomial.indexOf("(", start + 1);
            }
            for (int i = 0; i < 3; i++) {
                Polynomial.Data tmp = (Polynomial.Data) poly.dataArray.get(i);
                if (tmpChar == tmp.X) {
                    /// fill the points into the linkedList
                    for (int j = 0; j < tmpPolynomial.size(); j++) {
                        Point p = (Point) tmpPolynomial.get(j);
                        tmp.polynomial.add(new Point(p.x, p.y));
                    }
                }

            }

        }

        System.out.println(tmpChar + " is set successfully");
    }

    public static boolean checkPolyInput(String polynomial) ///checked
    {
        int termEnd = 0;
        int termStart = polynomial.indexOf("(");
        while (termStart != -1) {
            termEnd = polynomial.indexOf(")", termStart);
            if (polynomial.substring(termStart, termEnd).length() != 5) // (x, y)
                return false;

            else {
                termStart = polynomial.indexOf("(", termEnd);
            }
        }
        if (termEnd + 1 == polynomial.length())
            return true;
        else
            return false;
    }
    public static void PrintPolynomial(Polynomial poly) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert the variable name: A, B or C");
        char tmpChar = sc.next().charAt(0);
        if (!(tmpChar == 'A' || tmpChar == 'B' || tmpChar == 'C') || tmpChar == 'R') {
            System.out.println("Invalid variable");
            PrintPolynomial(poly);
            return;
        } else {
            for (int i = 0; i < 3; i++) {
                Polynomial.Data tmp = (Polynomial.Data) poly.dataArray.get(i);
                if (tmpChar == tmp.X) {
                    /// Print the representatiom
                    String rep = poly.print(tmpChar);
                    System.out.println(rep);


                }

            }

        }
    }

    public static void Addpolynomials(Polynomial poly) {
        char tmpchar1 = getCharacter();
        char tmpchar2 = getCharacter();
        Polynomial.Data tmpData1,tmpData2 ;

        for(int i = 0 ;i<3 ;i++)
        {
            tmpData1 = (Polynomial.Data) poly.dataArray.get(i);
            for(int j = 0 ;j<4 ;j++ )
            {
                tmpData2 = (Polynomial.Data) poly.dataArray.get(j);
                if(tmpData1.X ==tmpchar1 && tmpData2.X ==tmpchar2)
                {
                    int [][]result = poly.add(tmpchar1,tmpchar2);
                    Polynomial.Data r  = (Polynomial.Data) poly.dataArray.get(3);
                    r.matrixRepresentation = new int[1][result.length];
                    for(int k = 0;k<result[0].length;k++ )
                    {
                        r.matrixRepresentation[0][k] = result[0][k];
                    }
                    return;
                }
            }
        }


    }

    public static void Subtractpolynomials(Polynomial poly)
    {

    }


    public static char getCharacter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert the variable name: A, B or C");
        char tmpChar = sc.next().charAt(0);
        if (!(tmpChar == 'A' || tmpChar == 'B' || tmpChar == 'C')) {
            System.out.println("Invalid variable");
            return getCharacter();
        }

        return tmpChar;
    }
}













