import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.URL;
import java.nio.Buffer;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Mywindow extends JFrame {
    BufferedImage backImage;
    CloseButton cButt;
    RegistrationButton rButton;
    RegistrationTextFieldName rTextFieldName;
    RegistrationTextFieldHost rTextFieldHost;
    String name;
    String host;
    MyPanel mp;
    VSPanel vp;
    public Mywindow() {
        super("MyWindow");

        try {
            backImage = ImageIO.read(new URL("https://hdfon.ru/wp-content/uploads/hdfon.ru-987911.jpg"));
        } catch (Exception e){}

        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);

        add(cButt = new CloseButton(this));
        add(rButton = new RegistrationButton(this));
        add(rTextFieldName = new RegistrationTextFieldName());
        add(rTextFieldHost = new RegistrationTextFieldHost());
        setVisible(true);
    }
    public void paint(Graphics gr) {
        super.paint(gr);
        try {
            gr.drawImage(backImage, 0, 0, getWidth(), getHeight(), null);
            cButt.repaint();
            rButton.repaint();
            rTextFieldName.repaint();
            rTextFieldHost.repaint();
            mp.repaint();
            vp.repaint();
        } catch (Exception ex){}
    }
    public void registerNplay() {
        rButton.setVisible(false);
        rTextFieldName.setVisible(false);
        rTextFieldHost.setVisible(false);
        add(mp = new MyPanel());
        add(vp = new VSPanel());
        this.repaint();

    }
}

class CloseButton extends JButton implements ActionListener {
    Mywindow parentWin;
    public CloseButton(Mywindow win) {
        super("CLOSE");
        parentWin = win;
        setSize(100, 50);
        setLocation(200, 600);
        setBackground(new Color(127, 20, 20));

        addActionListener(this);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        parentWin.dispose();
    }
}

class RegistrationButton extends JButton implements ActionListener {
    Mywindow win;
    public RegistrationButton(Mywindow win) {
        super("Log in");
        this.win = win;

        setSize(100, 50);
        setLocation(200, 200);
        setBackground(new Color(78, 120, 13));
        addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        win.name = win.rTextFieldName.getText();
        win.host = win.rTextFieldHost.getText();
        win.registerNplay();
    }
}

class RegistrationTextFieldName extends JTextArea {
    public RegistrationTextFieldName() {
        super("Name");
        setSize(100, 20);
        setLocation(200, 100);

    }
}

class RegistrationTextFieldHost extends JTextArea {
    public RegistrationTextFieldHost() {
        super("Host");
        setSize(100, 20);
        setLocation(200, 150);

    }
}

class MyButton extends JButton {
    public MyButton (int x, int y){
        super();
        setSize(40,40);
        setLocation(x,y);
        setBackground(new Color (127,127,127));
        setVisible(true);
    }
}

class VSButton extends JButton  implements ActionListener {
    int x, y;
    Boolean wasntPressed = true;
    public VSButton (int x, int y){
        super();
        this.x = x;
        this.y = y;
        //addActionListener(this);
        setSize(40,40);
        setLocation(x,y);
        setBackground(new Color (127,127,127));
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        /*wasntPressed = false;
        removeActionListener(this);
        System.out.println("shot:" + x / 40 + ":" + y / 40);
        try {
            dos.writeUTF("shot:" + x / 40 + ":" + y / 40);
        } catch (Exception ex) {}*/
    }
}

class MyPanel extends JPanel {

    MyButton b[][] = new MyButton[10][10];
    public MyPanel() {
        super();
        setLocation(40, 100);
        setSize(400, 400);
        setLayout(null);

        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                add(b[i][j] = new MyButton(j * 40 , i * 40 ));
            }
        }
    }
}

class VSPanel extends JPanel {
    //DataOutputStream dos;
    VSButton v[][] = new VSButton[10] [10];

    public VSPanel() {
        super();

        setLocation(590, 100);
        setSize(400, 400);
        setLayout(null);
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                add(v[i][j] = new VSButton(j * 40 , i * 40));
            }
        }
    }
}