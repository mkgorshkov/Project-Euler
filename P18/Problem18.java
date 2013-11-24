/*
 * Maxim Gorshkov 2012
 * www.mgorshkov.com
 * Project Euler Problem # 18
 * 
 * Running time: 175ms (0.175s)
 */

import java.io.*;
import java.util.*;

public class Problem18{

	public static int[][] getTriangle() throws NumberFormatException, IOException {		

		int[][] triangle = new int[15][]; //change with depth of the triangle
		FileReader fr = new FileReader("triangle.txt"); //change with triangle file
		BufferedReader br = new BufferedReader(fr);

		String input;
		int i = 0;
		while ((input = br.readLine()) != null) {
			triangle[i] = new int[i + 1];
			int j = 0;
			Scanner tokenize = new Scanner(input);
			while (tokenize.hasNext()) {
				int value = tokenize.nextInt();
				triangle[i][j++] = value;
			}
			i++;
		}

		return triangle;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
        	int[][] values = getTriangle();
        	int depth = values.length - 2;

		while ( depth >= 0) {
	            for (int j = 0; j <= depth; j++) {
        	        values[depth][j] += Math.max( values[depth+1][j], values[depth+1][j+1]);
       		    }
		depth += -1;
        	}

        	System.out.println(values[0][0]);
	}
}
