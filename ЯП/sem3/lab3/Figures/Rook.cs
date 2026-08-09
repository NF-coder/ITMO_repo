using Chess.Enums;
using Chess.Core;

namespace Chess.Figures
{
    class Rook : ChessFigure
    {
        public Rook(Team team) : base("Rook", team) { }

        public override bool CanMove(int fromX, int fromY, int toX, int toY, ChessPlane plane)
        {
            if (fromX != toX && fromY != toY) return false;

            int xStep = toX == fromX ? 0 : (toX > fromX ? 1 : -1);
            int yStep = toY == fromY ? 0 : (toY > fromY ? 1 : -1);

            int steps = Math.Max(Math.Abs(toX - fromX), Math.Abs(toY - fromY));

            for (int i = 1; i < steps; i++)
            {
                if (plane.GetFigureAt(fromX + i * xStep, fromY + i * yStep) != null)
                    return false;
            }

            return IsEmptyOrEnemy(toX, toY, plane, Team);
        }
    }
}