using Chess.Enums;
using Chess.Core;

namespace Chess.Figures
{
    class King : ChessFigure 
    {
        public King(Team team) : base("King", team) { }

        public override bool CanMove(int fromX, int fromY, int toX, int toY, ChessPlane plane)
        {
            int dx = Math.Abs(toX - fromX);
            int dy = Math.Abs(toY - fromY);

            if (dx > 1 || dy > 1) return false;

            return IsEmptyOrEnemy(toX, toY, plane, Team);
        }
    }
}