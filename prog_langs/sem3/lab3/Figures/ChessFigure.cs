using Chess.Enums;
using Chess.Core;

namespace Chess.Figures
{
    abstract class ChessFigure
    {
        public string Name;
        public Team Team;
        public bool HasMoved;

        public ChessFigure(string name, Team team)
        {
            this.Name = name;
            this.Team = team;
            this.HasMoved = false;
        }

        public abstract bool CanMove(int fromX, int fromY, int toX, int toY, ChessPlane plane);

        protected bool IsInBounds(int x, int y)
        {
            return x >= 0 && x < 8 && y >= 0 && y < 8;
        }

        protected bool IsEmptyOrEnemy(int x, int y, ChessPlane plane, Team team)
        {
            if (!IsInBounds(x, y)) return false;

            var figure = plane.GetFigureAt(x, y);
            return figure == null || figure.Team != team;
        }
    }
}