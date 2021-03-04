package App;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.DelayQueue;

class MyWindowAdapter extends WindowAdapter {
    Frame fFrame;

    public MyWindowAdapter(Frame f) {
        fFrame = f;
    }

    public void windowClosing(WindowEvent we) {
        System.out.println("Closing window...");
        fFrame.setVisible(false);
        System.out.println("Exiting system...");
        System.exit(0);
    }
}

class ButtonW implements ActionListener {
    MyFrame fFrame;

    public ButtonW(MyFrame f) {
        fFrame = f;
    }

    public void actionPerformed(ActionEvent e) {
        fFrame.fCanvas.setX(fFrame.fCanvas.getX() - 25);
        fFrame.fCanvas.repaint();
    }
}

class ButtonE implements ActionListener {
    MyFrame fFrame;

    public ButtonE(MyFrame f) {
        fFrame = f;
    }

    public void actionPerformed(ActionEvent arg0) {
        fFrame.fCanvas.setX(fFrame.fCanvas.getX() + 25);
        fFrame.fCanvas.repaint();
    }
}

class ButtonN implements ActionListener {
    MyFrame fFrame;

    public ButtonN(MyFrame f) {
        fFrame = f;
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        fFrame.fCanvas.setY(fFrame.fCanvas.getY() - 25);
        fFrame.fCanvas.repaint();        
    }
}

class ButtonS implements ActionListener {
    MyFrame fFrame;

    public ButtonS(MyFrame f) {
        fFrame = f;
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        fFrame.fCanvas.setY(fFrame.fCanvas.getY() + 25);
        fFrame.fCanvas.repaint();
    }
}

class MyCanvas extends Canvas {
    int delta;
    int x, y;

    public MyCanvas() {
        delta = 0;
    }

    public void setDelta(int d) {
        delta = d;
    }

    public void setX (int X) {
        x = X;
    }

    public void setY(int Y) {
        y = Y;
    }
    public int getDelta() {
        return delta;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void paint(Graphics g) {
        System.out.println("Painting...");
        g.drawRect(x, y, 20 + delta, 20 + delta);
    }
}

class MyFrame extends Frame {
    private Panel fPanel;

    private Button fButtonW;
    private Button fButtonE;
    private Button fButtonN;
    private Button fButtonS;

    public MyCanvas fCanvas;

    public MyFrame() {
        fPanel = new Panel();
        add(fPanel);

        fPanel.setLayout(new BorderLayout());

        fButtonW = new Button("W");
        fButtonW.addActionListener(new ButtonW(this));
        fPanel.add(fButtonW, BorderLayout.WEST);

        fButtonE = new Button("E");
        fButtonE.addActionListener(new ButtonE(this));
        fPanel.add(fButtonE, BorderLayout.EAST);

        fButtonN = new Button("N");
        fButtonN.addActionListener(new ButtonN(this));
        fPanel.add(fButtonN, BorderLayout.NORTH);

        fButtonS = new Button("S");
        fButtonS.addActionListener(new ButtonS(this));
        fPanel.add(fButtonS, BorderLayout.SOUTH);

        fCanvas = new MyCanvas();
        fPanel.add(fCanvas, BorderLayout.CENTER);

        addWindowListener(new MyWindowAdapter(this));
    }
}

class GUI {
    public static void main(String args[]) {
        MyFrame f = new MyFrame();
        f.setTitle("My first window application");
        f.setSize(500, 500);
        f.setVisible(true);

        String enIn = "Cp1251";
        String enOut = "Cp1251";

        String s = "End. Выход.";

        try {
            System.out.println(s);
            System.out.println(new String(s.getBytes(enIn), enOut));
        } catch (Exception e) {
        }

        System.out.println("Ending main...");
    }
}
