package bin;

public class Grid 
{
	public static GridPoint[][] grid = new GridPoint[U.gridWidth][U.gridHeight];

	Grid()
	{
		init();
	}
	
	void init()
	{
		for(int i=0;i<U.gridWidth;i++)
		{
			for(int j=0;j<U.gridHeight;j++)
			{
				grid[i][j] = new GridPoint(i,j);
			}
		}
	}
		
	static GridPoint getPoint(int x,int y)
	{
		if(x>U.gridWidth||y>U.gridHeight||x<0||y<0)
		{
			return null;
		}
		else
		{
			return grid[x][y];
		}	
	}
	
}
