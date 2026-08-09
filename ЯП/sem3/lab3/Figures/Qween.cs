using Chess.Enums;
using Chess.Core;

namespace Chess.Figures
{
    class Queen : ChessFigure
    {
        public Queen(Team team) : base("Queen", team) { }

        public override bool CanMove(int fromX, int fromY, int toX, int toY, ChessPlane plane)
        {
            var rookMove = new Rook(Team).CanMove(fromX, fromY, toX, toY, plane);
            var bishopMove = new Bishop(Team).CanMove(fromX, fromY, toX, toY, plane);

            return rookMove || bishopMove;
        }
    }
}