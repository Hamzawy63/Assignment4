package eg.edu.alexu.csd.datastructure.linkedList.cs26.cs56;

import java.awt.*;

import static java.lang.Math.pow;

public class Polynomial {

    /**
     * We will store the presentation of polynomial (Which is linkedList ) in linked list of objects
     * Each object contains the linked list and the character representing name of polynomial (A,B,C)
     */
    class Data
    {
        char X;
        singlyLinkedList polynomial = new singlyLinkedList();
        int[][] matrixRepresentation = new int[1][] ;
        Data(char X)
        {
            this.X = X;
        }
    }
    Data A = new Data('A');
    Data B = new Data('B');
    Data C = new Data('C');
    Data R = new Data('R');

    public singlyLinkedList fillDataArrayList()
    {
        singlyLinkedList dataArray = new singlyLinkedList();
        dataArray.add(A);
        dataArray.add(B);
        dataArray.add(C);
        dataArray.add(R);
        return dataArray;
    }
    singlyLinkedList dataArray = fillDataArrayList();

    public void  setPolynomial(char poly, int[][] terms) /// not tested yet
    {
        Point term = new Point();
        for(int i =(terms.length-1) ;i>=0;i-- ) // to order the linkedlist in descending order
        {
            for(int j =0 ;j<terms[0].length ;j++ )
            {
                term.x = terms[i][j] ;
                term.y =  i;

                if(poly == 'A')
                    A.polynomial.add(new Point(term));
                else if (poly == 'B')
                    B.polynomial.add(new Point(term));
                else if((poly == 'C'))
                    C.polynomial.add(new Point(term));

            }

        }

    }
    public String print(char poly)
    {
        switch (poly)
        {
            case 'A':
                return print(A.polynomial);
            case 'B':
                return print(B.polynomial);
            case 'C':
                return print(C.polynomial);
        }
        return "an Error occured this character is unavailable ";
    }
    public String print(singlyLinkedList poly)  ///tested
    {
        String representation = " ";
        singlyLinkedList.singlyLinkedListNode tmp = poly.head;
        int redundantVariable = 0;
        while(tmp!=null)
        {
            Point termPoint  =(Point) (tmp.value);
            representation = representation.concat(Integer.toString(termPoint.x));
            representation = representation.concat("X^");
            representation = representation.concat(Integer.toString(termPoint.y));


            if(redundantVariable !=poly.size()-1 )
                representation=representation.concat("+");
            redundantVariable++;
            tmp = tmp.next;
        }
        return representation;
    }
    public float evaluatePolynomial(char poly, float value) /// not tested yet
    {
        for(int i = 0;i<3;i++)
        {
            Data tmp = (Data)dataArray.get(i);
            if(tmp.X == poly)
            {
                return evaluatePolynomial(tmp.polynomial,value);
            }
        }
        System.out.print("Your character is not found");
        return 0; //redundant

    }
    public float evaluatePolynomial(singlyLinkedList poly, float value) /// method overloading
    {


        float result=0;
        singlyLinkedList.singlyLinkedListNode tmp = poly.head; // a pointer at head node
        while(tmp!=null)
        {
            Point term = (Point) tmp.value;
            int x = term.x; /// coeffecient
            int y = term.y; /// exponential
            result += pow(value,y)*x;
            tmp = tmp.next;
        }

        return result;
    }
    int[][] add(char poly1, char poly2)
    {
        int[][] x = (((Data)(dataArray.get(0))).matrixRepresentation);
        int[][] y =(((Data)(dataArray.get(0))).matrixRepresentation);
        for(int i =0 ;i<3;i++ )
        {
            Data tmp  = (Data)dataArray.get(i);
            if(tmp.X == poly1) {
                tmp.matrixRepresentation = fillOnto2D(tmp.polynomial);
                x = tmp.matrixRepresentation;
            }
            if(tmp.X == poly2){
                tmp.matrixRepresentation  = fillOnto2D(tmp.polynomial);
                y = tmp.matrixRepresentation;
            }

        }
        return  add(x,y);

    }

    int[][] add(int[][] poly1, int[][] poly2)    {
        int biggerColumn     = poly1[0].length     >  poly2[0].length ? poly1[0].length:poly2[0].length;
        int smallerColumn    = poly1[0].length     <  poly2[0].length ? poly1[0].length:poly2[0].length;
        int[][] result = new int[1][biggerColumn];
        for(int i = 0 ;i<smallerColumn ;i++)
        {
            result[0][i] = poly1[0][i]+poly2[0][i];
        }
        // Fill the rest of the bigger array into fucking result
        for(int i = smallerColumn ;i<biggerColumn ;i++)
        {
            result[0][i] =poly1.length     >  poly2.length ? poly1[0][i]:poly2[0][i];
        }
        return result;
    }
    public int[][]  fillOnto2D(singlyLinkedList src)
    {
        int[][] dest =new int[1][sizeOfArr(src)];
        singlyLinkedList.singlyLinkedListNode ptr  = src.head;
        Point term;
        while (ptr !=null)
        {
            term = (Point) ptr.value;
            dest[0][term.y] = term.x;
            ptr = ptr.next;
        }
        return dest;
    }
    public int sizeOfArr(singlyLinkedList list)
    {
        singlyLinkedList.singlyLinkedListNode tmp = list.head;
        Point term = (Point) list.get(0);
        int size =term.y;
        while(tmp != null)
        {
            term = (Point) tmp.value;
            if(term.y>size)
                size = term.y;

            tmp = tmp.next; //out of if
        }
        return size+1;
    }















}