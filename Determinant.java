
import java.util.Scanner;

class Det {

    // Dimension of input square matrix 
  int N ;

    public Det(int N) {
        this.N = N;
    }

    // Function to get cofactor of  
    // mat[p][q] in temp[][]. n is  
    // current dimension of mat[][] 
   public void getCofactor(int mat[][],
            int temp[][], int p, int q, int n) {
        int i = 0, j = 0;

        // Looping for each element of  
        // the matrix 
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                // Copying into temporary matrix  
                // only those element which are  
                // not in given row and column 
                if (row != p && col != q) {
                    temp[i][j++] = mat[row][col];

                    // Row is filled, so increase  
                    // row index and reset col  
                    //index 
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    /* Recursive function for finding determinant 
    of matrix. n is current dimension of mat[][]. */
     public int findDeterminant(int mat[][], int n) 
    { 
        int D = 0; // Initialize result 
      
        // Base case : if matrix contains single 
        // element 
        if (n == 1) 
            return mat[0][0]; 
          
        // To store cofactors 
        int temp[][] = new int[N][N];  
          
        // To store sign multiplier 
        int sign = 1;  
      
        // Iterate for each element of first row 
        for (int f = 0; f < n; f++) 
        { 
            // Getting Cofactor of mat[0][f] 
            getCofactor(mat, temp, 0, f, n); 
            D += sign * mat[0][f]  
               * findDeterminant(temp, n - 1); 
            // terms are to be added with  
            // alternate sign 
            sign = -sign; 
        } 
      
        return D; 
    }

}

    // Driver code 
    public class Determinant {

        public static void main(String[] args) {
            Scanner sc = new Scanner (System.in);
            int N = sc.nextInt();
            Det d = new Det(N);
            
            int mat[][] = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    mat[i][j] = sc.nextInt();                
                }
            }System.out.println("Dimension of Matrix " + N);
            System.out.print("Determinant "
                    + "of the matrix is : "
                    + d.findDeterminant(mat, N));
        }
    }

