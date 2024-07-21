import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class LightManager {
    List<List<LightLabel>> lightsList = new ArrayList<>();

    private boolean judge() {
        for (var lights : lightsList) {
            for (var light : lights) {
                if (light.isOn()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void clickHandler(int x, int y) {
        // x軸方向を toggle する
        for (int i = x - 1; i <= x + 1; i++) {
            if (i < 0 || i >= lightsList.size())
                continue;

            lightsList.get(y).get(i).toggle();
        }

        // y軸方向+1を toggle する
        if (y + 1 < lightsList.size()) {
            lightsList.get(y + 1).get(x).toggle();
        }
        // y軸方向-1を toggle する
        if (y - 1 >= 0) {
            lightsList.get(y - 1).get(x).toggle();
        }
    }

    /**
     * ライトの配列初期化
     */
    private void initLightsList(JLabel[][] ls) {
        for (JLabel[] jLabels : ls) {
            List<LightLabel> rowList = new ArrayList<>();
            for (JLabel jLabel : jLabels) {
                LightLabel l = new LightLabel(jLabel, false);
                rowList.add(l);
            }
            lightsList.add(rowList);
        }
    }

    /**
     * マウスイベントを設定する
     */
    private void setMouseEvent(JLabel[][] lightList, Runnable clearedHandler) {
        for (int i = 0; i < lightList.length; i++) {
            var labels = lightList[i];
            for (int j = 0; j < labels.length; j++) {
                var light = labels[j];
                int finalI = i;
                int finalJ = j;
                light.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        SwingUtilities.invokeLater(() -> {
                            clickHandler(finalJ, finalI);
                            if (judge()) {
                                clearedHandler.run();
                            }
                        });
                    }
                });
            }
        }
    }

    /**
     * ライトをランダムに設定する
     */
    public void randomise() {
        for (var lights : lightsList) {
            for (var light : lights) {
                light.setOn(Math.random() < 0.5);
            }
        }
    }

    public LightManager(
            JLabel label00, JLabel label01, JLabel label02,
            JLabel label10, JLabel label11, JLabel label12,
            JLabel label20, JLabel label21, JLabel label22,
            Runnable clearedHandler) {
        JLabel[][] lightsList = {
                { label00, label01, label02 },
                { label10, label11, label12 },
                { label20, label21, label22 }
        };

        initLightsList(lightsList);
        setMouseEvent(lightsList, clearedHandler);
        randomise();
    }
}
