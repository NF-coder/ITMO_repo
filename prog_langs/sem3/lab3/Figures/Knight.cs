using Chess.Enums;
using Chess.Core;

namespace Chess.Figures
{
    class Knight : ChessFigure
    {
        public Knight(Team team) : base("Knight", team) { }

        public override bool CanMove(int fromX, int fromY, int toX, int toY, ChessPlane plane)
        {
            int dx = Math.Abs(toX - fromX);
            int dy = Math.Abs(toY - fromY);

            if (!((dx == 2 && dy == 1) || (dx == 1 && dy == 2))) return false;

            return IsEmptyOrEnemy(toX, toY, plane, Team);
        }
    }
}
