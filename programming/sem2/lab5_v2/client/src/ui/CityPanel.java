package ui;

import ui.utils.enums.CityPopupOpt;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CityPanel {
    public JPanel panel;

    public JLabel cancel;
    public JLabel delete;
    public JLabel edit;
    public JLabel save;

    private JLabel population;
    private JLabel LocX;
    private JLabel LocY;
    private JLabel GovName;

    private JTextField AreaTF;
    private JTextField MetersAboveSeaLevelTF;
    private JTextField ClimateTF;
    private JTextField GovernmentTF;
    private JTextField StandardOfLivingTF;
    private JTextField NameTF;
    private JTextField populationTF;
    private JTextField XTF;
    private JTextField YTF;
    private JTextField GovNameTF;
    private JTextField GovAgeTF;
    private JTextField GovHeightTF;
    private JTextField GovBirthdayTF;

    private JTextField[] TFArray = {
            AreaTF, MetersAboveSeaLevelTF, ClimateTF, GovernmentTF, StandardOfLivingTF, NameTF,
            populationTF, GovNameTF, GovAgeTF, GovHeightTF, GovBirthdayTF
    };

    public CityPanel() {
        setOptions(new CityPopupOpt[]{});
        isEditable(true);
    }

    public CityPanel(float x, float y) {
        XTF.setText(String.valueOf(x));
        YTF.setText(String.valueOf(y));

        setOptions(new CityPopupOpt[]{});
        isEditable(true);
    }

    public CityPanel(String area, String metersAboveSeaLevel, String climate, String government, String standardOfLiving, String name, String population, String x, String y, String govName, String age, String height, String birthday) {
        AreaTF.setText(area);
        MetersAboveSeaLevelTF.setText(metersAboveSeaLevel);
        ClimateTF.setText(climate);
        GovernmentTF.setText(government);
        StandardOfLivingTF.setText(standardOfLiving);
        NameTF.setText(name);
        populationTF.setText(population);
        GovNameTF.setText(govName);
        GovAgeTF.setText(age);
        GovHeightTF.setText(height);
        GovBirthdayTF.setText(birthday);
        XTF.setText(x);
        YTF.setText(y);

        setOptions(new CityPopupOpt[]{});
        isEditable(false);
        isCordsEditable(false);
    }

    public HashMap<String, String> getData() {
        HashMap<String, String> data = new HashMap<>();
        data.put("area", AreaTF.getText());
        data.put("metersAboveSeaLevel", MetersAboveSeaLevelTF.getText());
        data.put("climate", ClimateTF.getText());
        data.put("government", GovernmentTF.getText());
        data.put("standardOfLiving", StandardOfLivingTF.getText());
        data.put("name", NameTF.getText());
        data.put("population", populationTF.getText());
        data.put("x", XTF.getText());
        data.put("y", YTF.getText());
        data.put("govName", GovNameTF.getText());
        data.put("age", GovAgeTF.getText());
        data.put("height", GovHeightTF.getText());
        data.put("birthday", GovBirthdayTF.getText());
        return data;
    }

    public void setOptions(CityPopupOpt[] options) {
        edit.setVisible(false);
        save.setVisible(false);
        delete.setVisible(false);

        for (var option : options) {
            if (option == CityPopupOpt.EDIT) {
                edit.setVisible(true);
            } else if (option == CityPopupOpt.SAVE) {
                save.setVisible(true);
            } else if (option == CityPopupOpt.DELETE) {
                delete.setVisible(true);
            }
        }
    }

    public void isCordsEditable(boolean isEditable) {
        for (JTextField tf : new JTextField[]{XTF, YTF}) {
            tf.setEditable(isEditable);
            tf.setFocusable(isEditable);
        }
    }
    public void isEditable(boolean isEditable) {
        for (JTextField tf : TFArray) {
            tf.setEditable(isEditable);
            tf.setFocusable(isEditable);
        }
    }
}