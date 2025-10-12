using Chess.Enums;
using Chess.Core;

namespace Chess.Figures
{
    class Pawn : ChessFigure
    {
        public Pawn(Team team) : base("Pawn", team) { }

        public override bool CanMove(int fromX, int fromY, int toX, int toY, ChessPlane plane)
        {
            int direction = Team == Team.WHITE ? 1 : -1;
            int startRow = Team == Team.WHITE ? 1 : 6;

            if (fromX == toX && toY == fromY + direction && plane.GetFigureAt(toX, toY) == null)
                return true;

            if (fromX == toX && toY == fromY + 2 * direction && !HasMoved && 
                plane.GetFigureAt(toX, toY) == null && plane.GetFigureAt(fromX, fromY + direction) == null)
                return true;

            if (Math.Abs(toX - fromX) == 1 && toY == fromY + direction)
            {
                var target = plane.GetFigureAt(toX, toY);
                return target != null && target.Team != Team;
            }

            return false;
        }
    }
}