
public class SmithJohnA3Q3 {

    public static final double a0 = 1.27731344;
    public static final double a1 = 0.85418707;
    public static final double a2 = 0.032282353;
    public static final double a3 = 0.127018447;
    public static final double a4 = (-5.1957538) * Math.pow(10, -2);
    public static final double a5 = 6.718114 * Math.pow(10, -3);
    public static final double a6 = (-3.61828) * Math.pow(10, -4);
    public static final double a7 = 7.025 * Math.pow(10, -6);

    public void init(){
        StdDraw.setXscale(0.0, 15.0);
        StdDraw.setYscale(-7.5, 7.5);
    }

    private double silhouette(double x) {

        return Math.sqrt(a0
                + a1 * Math.pow(x,1)
                + a2 * Math.pow(x,2)
                + a3 * Math.pow(x,3)
                + a4 * Math.pow(x,4)
                + a5 * Math.pow(x,5)
                + a6 * Math.pow(x,6)
                + a7 * Math.pow(x,7));
    }

    private void filledEllipses(){
        for(int x = 0; x <= 15; x += 3) {

            filledEllipse(x);
        }

    }

    private void filledEllipse(int x){
            StdDraw.filledEllipse(x, 0, 0.2 * silhouette(x), silhouette(x));

    }

    private void line(){
        StdDraw.setPenColor(StdDraw.GRAY);

        for (int x = 0; x < 15; x += 3 ){

            double x2 =  x + 3 - 0.2 * silhouette(x+3);
            StdDraw.line(x, 0, x2, 0);
        }

        StdDraw.setPenColor(StdDraw.BLACK);
    }

    public void run(){

        init();
        filledEllipses();
        line();

        for (int i = 0; i <= 150; i++) {
            for(double x = 0.0; x <= 15.0; x += 15.0/150){

                double endX = x + 15.0/150;
                double y = silhouette(x);

                StdDraw.line(x,y,endX,y);

                StdDraw.line(x,-y,endX,-y);

            }
        }

        StdDraw.save("SmithJohnA3Q3-output.jpg");

    }
    public static void main(String[] args) {

        new SmithJohnA3Q3().run();

    }
}
