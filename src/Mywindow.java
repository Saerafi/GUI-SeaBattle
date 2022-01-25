import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.URL;
import java.nio.Buffer;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Mywindow extends JFrame {
    BufferedImage backImage;
    public Mywindow() {
        super("MyWindow");
        CloseButton cButt = new CloseButton(this);
        add(cButt);

        try {
            backImage = ImageIO.read(new URL("https://hdfon.ru/wp-content/uploads/hdfon.ru-987911.jpg"));
        } catch (Exception e){}

        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);

        setVisible(true);
    }
    public void paint(Graphics gr) {
        super.paint(gr);
        try {
            gr.drawImage(backImage, 0, 0, getWidth(), getHeight(), null);
        } catch (Exception ex){}
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
