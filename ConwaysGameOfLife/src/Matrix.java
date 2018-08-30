
public class Matrix {
	
	int rows = 200;
	int columns = 200;
	int[][] matrix ;
	public Matrix() {
		
	}
	
	
	public void populateDataInMatrix() {
		matrix = new int [rows][columns];
		for(int i=0 ; i < rows ; i++) {
			
			for(int j=0 ; i < columns ; i++) {
				matrix[i][j] = 0;
			}
		}
		inputValuesInMatrix();
		displayMatrix(matrix);
	}
	
	
	//change the input here
	public void inputValuesInMatrix() {
		matrix[5][5] = 1;
		matrix[6][5] = 1;
		matrix[7][5] = 1;
		matrix[5][6] = 1;
		matrix[6][6] = 1;
		matrix[7][6] = 1;
		
		
	}
	
	public void next() {
		nextGenerationMatrix(matrix);
	}
	
	public void display() {
		displayMatrix(matrix);
	}
	public void nextGenerationMatrix(int[][]matrix) {
		
		int[][]nextGenMatrix = new int[rows][columns];
		
		// loop through cells
        for (int l = 1; l < rows - 1; l++)
        {
            for (int m = 1; m < columns - 1; m++)
            {
                // find neighbours active
                int activeCells = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                    	activeCells += matrix[l + i][m + j];
 
                //The cell is counted before hence needs to be removed
                activeCells -= matrix[l][m];
 
                // underpopulated cell dies
                if ((matrix[l][m] == 1) && (activeCells < 2))
                	nextGenMatrix[l][m] = 0;
 
                // overpopulated cell dies
                else if ((matrix[l][m] == 1) && (activeCells > 3))
                	nextGenMatrix[l][m] = 0;
 
                // new cell is created
                else if ((matrix[l][m] == 0) && (activeCells == 3))
                	nextGenMatrix[l][m] = 1;
 
                // no change
                else
                	nextGenMatrix[l][m] = matrix[l][m];
            }
        }
        
        //copy contents of newly genereated matrix 
        for(int i =0 ; i< rows; i++) {
        	for(int j=0;j<columns;j++) {
        		matrix[i][j] = nextGenMatrix[i][j]; 
        	}
        }
        
        displayMatrix(matrix);
	}
	
	public void displayMatrix(int[][]matrix) {
		System.out.println("\nMatrix:");
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				System.out.print("\t" + matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	
	
	

}
