using Chess.Enums;
using Chess.Core;

namespace Chess.Figures
{
    class Bishop : ChessFigure
    {
        public Bishop(Team team) : base("Bishop", team) { }

        public override bool CanMove(int fromX, int fromY, int toX, int toY, ChessPlane plane)
        {
            if (Math.Abs(toX - fromX) != Math.Abs(toY - fromY)) return false;

            int xStep = toX > fromX ? 1 : -1;
            int yStep = toY > fromY ? 1 : -1;

            int steps = Math.Abs(toX - fromX);
            for (int i = 1; i < steps; i++)
            {
                if (plane.GetFigureAt(fromX + i * xStep, fromY + i * yStep) != null)
                    return false;
            }

            return IsEmptyOrEnemy(toX, toY, plane, Team);
        }
    }
}
