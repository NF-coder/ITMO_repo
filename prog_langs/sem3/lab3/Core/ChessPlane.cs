using Chess.Figures;
using Chess.Enums;

namespace Chess.Core
{
    class ChessPlane
    {
        private ChessFigure[,] figuresState;
        public Team CurrentTurn;
        public GameState State;

        public ChessPlane()
        {
            this.figuresState = new ChessFigure[8, 8];
            this.CurrentTurn = Team.WHITE;
            this.State = GameState.Ongoing;
            InitializeBoard();
        }

        private void InitializeBoard()
        {
            for (int i = 0; i < 8; i++)
            {
                figuresState[i, 1] = new Pawn(Team.WHITE);
                figuresState[i, 6] = new Pawn(Team.BLACK);
            }

            figuresState[0, 0] = new Rook(Team.WHITE);
            figuresState[7, 0] = new Rook(Team.WHITE);
            figuresState[1, 0] = new Knight(Team.WHITE);
            figuresState[6, 0] = new Knight(Team.WHITE);
            figuresState[2, 0] = new Bishop(Team.WHITE);
            figuresState[5, 0] = new Bishop(Team.WHITE);
            figuresState[3, 0] = new Queen(Team.WHITE);
            figuresState[4, 0] = new King(Team.WHITE);

            figuresState[0, 7] = new Rook(Team.BLACK);
            figuresState[7, 7] = new Rook(Team.BLACK);
            figuresState[1, 7] = new Knight(Team.BLACK);
            figuresState[6, 7] = new Knight(Team.BLACK);
            figuresState[2, 7] = new Bishop(Team.BLACK);
            figuresState[5, 7] = new Bishop(Team.BLACK);
            figuresState[3, 7] = new Queen(Team.BLACK);
            figuresState[4, 7] = new King(Team.BLACK);
        }

        
        public ChessFigure GetFigureAt(int x, int y)
        {
            if (x < 0 || x >= 8 || y < 0 || y >= 8) return null;
            return figuresState[x, y];
        }


        public bool Move(int fromX, int fromY, int toX, int toY)
        {
            if (State != GameState.Ongoing) return false;

            ChessFigure figure = GetFigureAt(fromX, fromY);
            
            if (figure == null || figure.Team != CurrentTurn) return false;

            if (!figure.CanMove(fromX, fromY, toX, toY, this)) return false;

            ChessFigure target = GetFigureAt(toX, toY);
            if (target is King)
            {
                State = figure.Team == Team.WHITE ? GameState.WhiteWon : GameState.BlackWon;
            }

            figuresState[toX, toY] = figure;
            figuresState[fromX, fromY] = null;
            figure.HasMoved = true;

            CurrentTurn = CurrentTurn == Team.WHITE ? Team.BLACK : Team.WHITE;

            return true;
        }

        public void PrintBoard()
        {
            Console.WriteLine("  a b c d e f g h");
            for (int y = 7; y >= 0; y--)
            {
                Console.Write($"{y + 1} ");
                for (int x = 0; x < 8; x++)
                {
                    ChessFigure figure = GetFigureAt(x, y);

                    if (figure == null)
                    {
                        Console.Write(". ");
                    }
                    else
                    {
                        char symbol = figure.Name[0];
                        if (figure.Team == Team.WHITE)
                            symbol = char.ToUpper(symbol);
                        else
                            symbol = char.ToLower(symbol);
                        Console.Write($"{symbol} ");
                    }
                }
                Console.WriteLine();
            }
        }
    }
}