import javax.swing.JLabel;

public class LightLabel {
    private JLabel label;
    private boolean isOn;

    public LightLabel(JLabel label, boolean isOn) {
        this.label = label;
        this.isOn = isOn;
    }

    public JLabel getLabel() {
        return label;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
        label.setText(on ? "1" : "0");
    }

    public void toggle() {
        isOn = !isOn;
        label.setText(isOn ? "1" : "0");
    }
}
