public class MedianSortedMatrix {
    int calculateMedianOfMatrix(int[][] matrix){
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
          int r = matrix.length, c = matrix[0].length - 1;
  
          for(int i = 0; i < r; ++i){
              if(matrix[i][0] < min) min = matrix[i][0];
              if(matrix[i][c] > max) max = matrix[i][c];
          }
  
          ++c;
          int med = (r*c + 1)/2;
  
          while(min < max){
              int mid = (min + max) >>> 1;
              int count = 0 ,ind = 0;
  
              for(int i = 0; i < r; ++i){
                  ind = Arrays.binarySearch(matrix[i], mid);
              
                  // 2's compliment of x = x*(-1);
                  // x = ~x + 1 
                  if(ind < 0) ind = Math.abs(ind) - 1;
                  else
                      while(ind < c && matrix[i][ind] == mid) ind++;
  
                  count += ind;
              }
  
              
              if(count < med) min = mid + 1;
              else max = mid;
          }
  
          return min;   
      }  
}
