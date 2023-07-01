public class TowersOfHanoiAnimated {

    private static double poleLength, smallestDiscW, x0, y0;
    private static int NoOfDicses, NoOfPoles, timePerMove;
    private static int[][] discesOnPole;

    public static void main(String[] args) {
        NoOfDicses = Integer.parseInt(args[0]);
        timePerMove = Integer.parseInt(args[1]);
        NoOfPoles = 3;

        double canvasW = 1900;
        double canvasH = 850;

        StdDraw.setCanvasSize((int) canvasW, (int) canvasH);
        StdDraw.setXscale(0, canvasW);
        StdDraw.setYscale(0, canvasH);

        poleLength = (canvasH / 10) + (NoOfDicses * 9 * canvasH / 700);
        y0 = (canvasH - poleLength) / 2;
        x0 = canvasW / (NoOfPoles + 1);
        smallestDiscW = 0.6 * x0 / NoOfDicses;

        discesOnPole = new int[NoOfPoles + 1][NoOfDicses + 1];

        for (int i = 0; i < NoOfDicses; i++) {
            discesOnPole[1][i] = i + 1;
        }
        draw(discesOnPole);
        MoveDisces(NoOfDicses, 1, 2, 3);

    }

    public static void draw(int[][] discesOnPole) {
        for (int i = 1; i <= NoOfPoles; i++) {
            StdDraw.setPenColor(StdDraw.BOOK_RED);
            StdDraw.setPenRadius(0.01);
            StdDraw.line(i * x0, y0, i * x0, y0 + poleLength);
            for (int j = 0; j < NoOfDicses; j++) {
                if (discesOnPole[i][NoOfDicses - j - 1] == 0) break;
                double discW = discesOnPole[i][NoOfDicses - j - 1] * smallestDiscW;
                double discH = 0.95 * poleLength / NoOfDicses;
                double y1 = y0 + j * discH;

                if (discesOnPole[i][NoOfDicses - 1 - j] % 3 == 0)
                    StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                else if (discesOnPole[i][NoOfDicses - 1 - j] % 3 == 1)
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                else StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
                StdDraw.setPenRadius(0.008);
                drawDisc(i * x0, y1 + discH / 2, discW / 2, discH / 2);
            }
        }
        StdDraw.show(timePerMove);
        StdDraw.clear();

    }

    public static void MoveDisces(int NoOfDisces, int pole1, int pole2, int pole3) {
        if (NoOfDisces == 0) return;

        MoveDisces(NoOfDisces - 1, pole1, pole3, pole2);

        for (int i = NoOfDicses - 1; i >= 0; i--) {
            if (discesOnPole[pole3][i] == 0) {
                discesOnPole[pole3][i] = NoOfDisces;
                break;
            }
        }
        for (int i = 0; i < NoOfDicses; i++) {
            if (discesOnPole[pole1][i] != 0) {
                discesOnPole[pole1][i] = 0;
                break;
            }
        }
        draw(discesOnPole);
        MoveDisces(NoOfDisces - 1, pole2, pole1, pole3);
    }

    public static void drawDisc(double x, double y, double halfW, double halfH) {
        StdDraw.line(x - halfW, y + halfH, x + halfW, y + halfH);
        StdDraw.line(x - halfW, y - halfH, x + halfW, y - halfH);
        StdDraw.arc(x - halfW, y, halfH, 90, -90);
        StdDraw.arc(x + halfW, y, halfH, -90, 90);/* 
        StdDraw.filledRectangle(x, y, halfW, halfH);
        StdDraw.filledCircle(x - halfW, y, halfH);
        StdDraw.filledCircle(x + halfW, y, halfH);*/
    }
}
