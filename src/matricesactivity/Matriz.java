/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricesactivity;

import java.util.Arrays;
import java.math.BigInteger;

/**
 *
 * @author Virgilio
 */
public class Matriz {

    private int value;

    private int[][] Matrix;

    public int getValue() {

        return this.value;
    }

    public void setValue(int newValue) {

        this.value = newValue;
    }

    public int[][] getMatrix() {

        return this.Matrix;
    }

    public void setMatrix(int[][] newMatrix) {

        this.Matrix = newMatrix;

    }

    public void LoadMatrix() {
        this.Matrix = new int[this.value][this.value];
        for (int i = 0; i < this.value; i++) {
            int[] StandBy = new int[this.value];
            int counter = 0;
            for (int j = 0; j < this.value; j++) {

                this.Matrix[i][j] = (int) (Math.random() * (999 - 1) + 1);

                StandBy[counter] = this.Matrix[i][j];
                counter++;
            }

            System.out.println(Arrays.toString(StandBy));
        }

    }

    public int[] OrderMatrix() {

//---------------We Load the Matrix in one Array------------------
        int[] aux = new int[this.value * this.value];
        int counter = 0;
        for (int i = 0; i < this.value; i++) {

            for (int j = 0; j < this.value; j++) {

                aux[counter] = this.Matrix[i][j];

                counter++;

            }

        }
//-----------------------------------------------------------------
//----------------Here we Order the Array--------------------------

        for (int i = 0; i < aux.length; i++) {

            for (int j = 0; j < aux.length; j++) {

                if (aux[i] > aux[j]) {

                    int aux2 = aux[i];
                    aux[i] = aux[j];
                    aux[j] = aux2;

                }

            }

        }

//------------------------------------------------------------------
        return aux;
    }

    public BigInteger MultiplyFirstColumn() {

        long aux = 1;
        int counter = 0;
        for (int i = 0; i < this.value; i++) {

            long aux2 = this.Matrix[counter][0];

            aux = aux * aux2;
            counter++;

        }

        return BigInteger.valueOf(aux);
    }

    public String InvertedColumn() {

        String StringAux = String.valueOf(MultiplyFirstColumn());

        String Inverted = "";

        for (int i = StringAux.length() - 1; i >= 0; i--) {

            Inverted += StringAux.charAt(i);

        }

        return Inverted;

    }
    
    public BigInteger SeconodaryDiagonal(){
    
        long aux = 0;
        int counter = 0;
        for (int i = this.value - 1; i >= 0 ; i--) {
            
                
            aux = aux + this.Matrix[i][counter];

            counter++;
        }
        
    
        return BigInteger.valueOf(aux/this.value);
    }
    
    public BigInteger PowByExtremes(){
    
        BigInteger base = BigInteger.valueOf(OrderMatrix()[(this.value*this.value) -1]);
        
        int Expo = OrderMatrix()[0];
        
        return base.pow(Expo);
    
    }

}
