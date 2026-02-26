package Authentication;

import javax.swing.*;
import java.awt.*;

public class glass extends JPanel {

    public glass() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Semi-transparent rounded panel
        g2.setColor(new Color(255, 255, 255, 150));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);

        // Subtle gradient for frosted effect
        GradientPaint gradient = new GradientPaint(
                0, 0, new Color(255, 255, 255, 180),
                0, getHeight(), new Color(255, 255, 255, 100)
        );
        g2.setPaint(gradient);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);

        g2.dispose();
        super.paintComponent(g);
    }
}