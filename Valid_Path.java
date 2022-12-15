// https://workat.tech/problem-solving/practice/valid-path

class Solution {
    class Circle {
        public int x, y; // Co-ordinates of center
        public Circle(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
	boolean[][] points;
	int n, m;
	
	void markPoints(int x, int y, int a, int b, int r){
		int dx = Math.abs(x - a);
		int dy = Math.abs(y - b);
		
		dx *= dx;
		dy *= dy;
		
		if(Math.sqrt(dx + dy) <= r) 
			points[x][y] = true;
	}
	
	boolean hasValidPath(int n, int m, int r, Circle[] circles) {
    	points = new boolean[n + 1][m + 1];
		
		for(int i = 0; i <= n; ++i){
			for(int j = 0;j <= m; ++j){
				for(Circle c: circles)
					markPoints(i, j, c.x, c.y, r);
			}
		}
		
		this.n = n;
		this.m = m;
		return hasPath(0, 0);
	}
	
	boolean hasPath(int x, int y){
		if(x < 0 || y < 0 || x > n || y > m) return false;
		if(x == n && y == m) return true;
		
		if(points[x][y]) return false;
		
		points[x][y] = true;
		if(hasPath(x, y + 1)) return true;
		if(hasPath(x + 1, y + 1)) return true;
		if(hasPath(x + 1, y)) return true;
		if(hasPath(x + 1, y - 1)) return true;
		if(hasPath(x, y - 1)) return true;
		if(hasPath(x - 1, y - 1)) return true;
		if(hasPath(x - 1, y)) return true;
		if(hasPath(x - 1, y + 1)) return true;
		
		return false;
	}
}