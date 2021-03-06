package GUItxtCodLib;


        import java.io.File;
        import java.nio.CharBuffer;
        import java.sql.Struct;
        import java.util.*;
        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;

        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.image.BufferedImage;
        import java.io.*;

        import javax.imageio.ImageIO;
        import javax.swing.ImageIcon;
        import java.awt.event.MouseAdapter;
        import java.awt.event.MouseEvent;
        import java.io.IOException;
        import java.awt.Dimension;
        import java.awt.Graphics;
        import java.awt.Graphics2D;
        import java.util.List;

public class GUItxtCodLib extends  Frame implements
        WindowListener {

    public int x, y, w, h;
    public int x1, y1, x2, y2, x3, y3;
    public int cr, cq, cb;
    public int d;
    public int cx, cy, dx, dy;

    public void windowOpened(WindowEvent e) {    }    ;

    public void windowClosing(WindowEvent e) {
        dispose();
        System.exit(0);
    };

    public void windowClosed(WindowEvent e) { };
    public void windowIconified(WindowEvent e) { };
    public void windowDeiconified(WindowEvent e) { };
    public void windowActivated(WindowEvent e) { };
    public void windowDeactivated(WindowEvent e) { };



    public void paint(Graphics g) {

        Dimension rc = getSize();
        Insets in = getInsets();

        int RH = rc.width;
        int RW = rc.height;

        int minX = in.left;
        int maxX = RH - in.right;
        int minY = in.top;
        int maxY = RW - in.bottom;

        float wdk = 3.0f;

        cx = Math.abs(maxX - minX) / 2;
        cy = Math.abs(maxY - minY) / 2;
        dx = maxX / 10;
        dy = maxY / 10;

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(wdk));

        // TO DO init

        x=100; y=100; dy=dx=20;
        String text = "";
        String ms = "Таблиця кодів:";
        g.setFont(new Font("Trebuchet Ms", Font.BOLD, 16));
        g.setColor(new Color(0, 0, 0));
        g.drawString(ms, x, y);

        File file = new File("data.txt");
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            text = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // TO DRAW

        int k,i,j,p,n,m;
        int [] B=new int[100];
        String z,t;
        char[] A=new char[100];
        char[] buf=new char[256];
        t="";
        A[0]=' '; B[0]=0;
        A[65]='.'; B[65]=65;
        t+="\""+A[0]+"\"=0"+B[0]+" ";
        for ( k = 1; k <65 ; k++) {
            B[k]=k;
            A[k]= (char) ((int)k+1039);
            if(k<10)
            t+="\""+A[k]+"\"=0"+B[k]+" ";
            else
            t+="\""+A[k]+"\"="+B[k]+" ";
        }
        t+="\""+A[65]+"\"="+B[65];

        y+=2*dy;

        for (i = 0; i <6 ; i++) {
            z=t.substring(0+70*i,69+70*i);
            g.drawString(z, x, y);
            y+=dy;
        }
        z=t.substring(t.length()-35,t.length());
        g.drawString(z, x, y);
        y+=dy;




        y+=2*dy;
        g.drawString(text, x, y);




    }

/*
    private static int rnd(int min, int max) {
        return (new Random()).ints(min,max).iterator().nextInt();
    }
*/

    public GUItxtCodLib() {

        super("Програма кодування тексиів (RUS).");
        addWindowListener(this);
        setLayout(null);
        setLocation(20,50);
        setSize(750,600);
        this.setResizable(false);

        show();
    }
}
