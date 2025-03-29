package Lab1;

public class QuadraticEquation {
    private final double a;
    private final double b;
    private final double c;
    
    public QuadraticEquation(double a, double b, double c) {
        if (a == 0) {
            throw new IllegalArgumentException("Coefficient 'a' cannot be zero");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public double getA() {
        return a;
    }
    
    public double getB() {
        return b;
    }
    
    public double getC() {
        return c;
    }
    
    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }
    
    public boolean hasRealRoots() {
        return getDiscriminant() >= 0;
    }
    
    public double[] getRoots() {
        double discriminant = getDiscriminant();
        
        if (discriminant < 0) {
            throw new IllegalStateException("Equation has no real roots");
        }
        
        if (discriminant == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        } else {
            double sqrtDiscriminant = Math.sqrt(discriminant);
            double root1 = (-b + sqrtDiscriminant) / (2 * a);
            double root2 = (-b - sqrtDiscriminant) / (2 * a);
            return new double[]{root1, root2};
        }
    }
    
    @Override
    public String toString() {
        return String.format("%.2fx² + %.2fx + %.2f = 0", a, b, c);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            QuadraticEquation equation = new QuadraticEquation(1, -3, 2);
            
            System.out.println("Equation: " + equation);
            
            if (equation.hasRealRoots()) {
                double[] roots = equation.getRoots();
                if (roots.length == 1) {
                    System.out.println("Double root: " + roots[0]);
                } else {
                    System.out.println("Roots: " + roots[0] + " and " + roots[1]);
                }
            } else {
                System.out.println("No real roots");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid equation: " + e.getMessage());
        }
    }
}
