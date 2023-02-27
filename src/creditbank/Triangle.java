package creditbank;

public class Triangle {
    public static boolean isEquilateral; //Равносторонний ли треугольник?
    public int height = 96; //Высота треугольника

    //Функция вычисляет площадь, выбирая формулу в зависимости от того
    //равнобедренный треугольник или нет.
    public static double Square(boolean Equilateral, int a, int h)
    {
        if(Equilateral)
            return a*a*Math.sqrt(3)/4;
        else return 0.5*a*h;
    }
}