// Time limit exceed 

public class Solution130 {
    private class Coord {
        public int x;
        public int y;
        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private ArrayList<Coord> list;
    
    public void solve(char[][] board) {
        list = new ArrayList<Coord>();        

        if(board.length < 3) return;
        if(board[0].length < 3) return;
        
        for(int i = 0; i < board[0].length; i++) {
            if(board[0][i] == 'O') {
                runBFS(board, new Coord(0, i));
            }
            
            if(board[board.length - 1][i] == 'O') {
                runBFS(board, new Coord(board.length - 1, i));
            }
        }
        
        for(int i = 0; i < board.length; i++) {
            if(board[i][0] == 'O') {
                runBFS(board, new Coord(i, 0));
            }
            
            if(board[i][board[i].length - 1] == 'O') {
                runBFS(board, new Coord(i, board[i].length - 1));
            }
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'K') {
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        
        return;
    }
    
    private void runBFS(char[][] board, Coord coord) {
        list.add(coord);
        
        while(list.size() != 0) {
            Coord c = list.remove(0);
            board[c.x][c.y] = 'K';
            
            if(c.x != 0 && board[c.x - 1][c.y] == 'O') {
                list.add(new Coord(c.x - 1, c.y));
            }
            
            if(c.x != board.length - 1 && board[c.x + 1][c.y] == 'O') {
                list.add(new Coord(c.x + 1, c.y));
            }
            
            if(c.y != 0 && board[c.x][c.y - 1] == 'O') {
                list.add(new Coord(c.x, c.y - 1));
            }
            
            if(c.y != board[c.x].length - 1 && board[c.x][c.y + 1] == 'O') {
                list.add(new Coord(c.x, c.y + 1));
            }
        }
    }
}