using System;

using Chess.Enums;
using Chess.Figures;
using Chess.Core;


class Program
{
    static void Main()
    {
        var chess = new ChessPlane();
        
        while (chess.State == GameState.Ongoing)
        {
            Console.WriteLine();
            
            chess.PrintBoard();
            Console.WriteLine($"Current turn: {chess.CurrentTurn}");
            Console.Write("Enter move (e.g., 'a2 a4'): ");
            string input = Console.ReadLine();
            
            if (input?.Length == 5)
            {
                int fromX = input[0] - 'a';
                int fromY = input[1] - '1';
                int toX = input[3] - 'a';
                int toY = input[4] - '1';
                
                if (chess.Move(fromX, fromY, toX, toY))
                {
                    Console.WriteLine("Move successful!");
                }
                else
                {
                    Console.WriteLine("Invalid move!");
                }
            }
        }
        
        Console.WriteLine($"Game over! Result: {chess.State}");
    }
}