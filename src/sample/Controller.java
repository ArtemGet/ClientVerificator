package sample;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;

public class Controller {
    private static ArrayList<Integer> Id;
    private static RW rW;
    private static ArrayList<String> data;
    private static ArrayList<Integer> verifId = new ArrayList<Integer>(0);


    @FXML
    private ColumnConstraints idColumn;

    @FXML
    private ColumnConstraints dataColumn;

    @FXML
    private ColumnConstraints checkColum;
    @FXML
    private  Label id0;

    @FXML
    private Label id1;

    @FXML
    private Label id2;

    @FXML
    private Label id3;

    @FXML
    private Label id4;

    @FXML
    private Label id5;

    @FXML
    private Label id6;

    @FXML
    private Label id7;

    @FXML
    private Label data0;

    @FXML
    private Label data1;

    @FXML
    private Label data2;

    @FXML
    private Label data3;

    @FXML
    private Label data4;

    @FXML
    private Label data5;

    @FXML
    private Label data6;

    @FXML
    private Label data7;

    @FXML
    private CheckBox ch0;

    @FXML
    private CheckBox ch2;

    @FXML
    private CheckBox ch5;

    @FXML
    private CheckBox ch1;

    @FXML
    private CheckBox ch3;

    @FXML
    private CheckBox ch4;

    @FXML
    private CheckBox ch6;

    @FXML
    private CheckBox ch7;

    @FXML
    private Button refreshData;

    @FXML
    private Button sendData;


    @FXML
    void initialize() throws IOException {
        connect();
        getUnverifiedData();
        drawData(data);
        drawId(Id);




        sendData.setOnAction(actionEvent -> {
            System.out.println("пересылка зареганных id");
            sendVerifiedId();

        });
        refreshData.setOnAction(actionEvent -> {
            System.out.println("рефреш");
            refresh();
            getUnverifiedData();
            drawData(data);
            drawId(Id);
            clearCh();
        });



        ch0.setOnAction(actionEvent -> {
            if (ch0.isSelected() == true) {
                setVerifId(0);
                //System.out.println(verifId.get(0));
            }
            else {
                removeVerifId(0);
            }

        });
        ch1.setOnAction(actionEvent -> {
            if (ch1.isSelected() == true) {
                setVerifId(1);
                //System.out.println(verifId.get(0));
            }
            else {
                removeVerifId(1);
            }

        });
        ch2.setOnAction(actionEvent -> {
            if (ch2.isSelected() == true) {
                setVerifId(2);
                //System.out.println(verifId.get(0));
            }
            else {
                removeVerifId(2);
            }

        });
        ch3.setOnAction(actionEvent -> {
            if (ch3.isSelected() == true) {
                setVerifId(3);
                //System.out.println(verifId.get(0));
            }
            else {
                removeVerifId(3);
            }

        });
        ch4.setOnAction(actionEvent -> {
            if (ch4.isSelected() == true) {
                setVerifId(4);
                //System.out.println(verifId.get(0));
            }
            else {
                removeVerifId(4);
            }

        });
        ch5.setOnAction(actionEvent -> {
            if (ch5.isSelected() == true) {
                setVerifId(5);
                //System.out.println(verifId.get(0));
            }
            else {
                removeVerifId(5);
            }

        });
        ch6.setOnAction(actionEvent -> {
            if (ch6.isSelected() == true) {
                setVerifId(6);
                //System.out.println(verifId.get(0));
            }
            else {
                removeVerifId(6);
            }

        });
        ch7.setOnAction(actionEvent -> {
            if (ch7.isSelected() == true) {
                setVerifId(7);
                //System.out.println(verifId.get(0));
            }
            else {
                removeVerifId(7);
            }

        });
    }

    public static void setVerifId(int c) {
        if (Id.size() > c) {
            verifId.add(Id.get(c));
        }

    }
    public static void removeVerifId(int c) {
        if (Id.size() > c) {
            verifId.remove(Id.get(c));
        }
    }
    public  void clearCh() {
        ch0.setSelected(false);
        ch1.setSelected(false);
        ch2.setSelected(false);
        ch3.setSelected(false);
        ch4.setSelected(false);
        ch5.setSelected(false);
        ch6.setSelected(false);
        ch7.setSelected(false);
    }
    public static void connect() {
        rW = new RW("192.168.0.110", 9000);
        rW.writeLine("adminId");
    }

    public static void disconnect() {
        rW.writeLine("disconnect");
    }

    public static void getUnverifiedData() {
        try {
            Id = rW.readUnverifiedId();
            data = rW.readUnverifiedData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void refresh() {
        rW.writeLine("refresh");
        verifId.clear();
    }

    public static void sendVerifiedId() {
        try {
            rW.writeLine("takeId");
            rW.writeVerifiedId(verifId);
            System.out.println("отослал");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void drawData(ArrayList<String> d) {
   if (d.size() != 0 ) {
       data0.setText(" ");
       data1.setText(" ");
       data2.setText(" ");
       data3.setText(" ");
       data4.setText(" ");
       data5.setText(" ");
       data6.setText(" ");
       data7.setText(" ");
       for (int a = 0; a < d.size(); a++) {
           switch (a) {
               case 0:
                   data0.setText(d.get(a));
                   break;
               case 1:
                   data1.setText(d.get(a));
                   break;
               case 2:
                   data2.setText(d.get(a));
                   break;
               case 3:
                   data3.setText(d.get(a));
                   break;
               case 4:
                   data4.setText(d.get(a));
                   break;
               case 5:
                   data5.setText(d.get(a));
                   break;
               case 6:
                   data6.setText(d.get(a));
                   break;
               case 7:
                   data7.setText(d.get(a));
                   break;
           }
       }
   }
   else if (d.size() == 0) {
       data0.setText(" ");
       data1.setText(" ");
       data2.setText(" ");
       data3.setText(" ");
       data4.setText(" ");
       data5.setText(" ");
       data6.setText(" ");
       data7.setText(" ");
   }
    }

    public  void drawId(ArrayList<Integer> i) {
        if (i.size() != 0 ) {
            id0.setText(" ");
            id1.setText(" ");
            id2.setText(" ");
            id3.setText(" ");
            id4.setText(" ");
            id5.setText(" ");
            id6.setText(" ");
            id7.setText(" ");
            for (int a = 0; a < i.size(); a++) {
                switch (a) {
                    case 0:
                        id0.setText(String.valueOf(i.get(a)));
                        break;
                    case 1:
                        id1.setText(String.valueOf(i.get(a)));
                        break;
                    case 2:
                        id2.setText(String.valueOf(i.get(a)));
                        break;
                    case 3:
                        id3.setText(String.valueOf(i.get(a)));
                        break;
                    case 4:
                        id4.setText(String.valueOf(i.get(a)));
                        break;
                    case 5:
                        id5.setText(String.valueOf(i.get(a)));
                        break;
                    case 6:
                        id6.setText(String.valueOf(i.get(a)));
                        break;
                    case 7:
                        id7.setText(String.valueOf(i.get(a)));
                        break;
                }
            }

        }
        else if (i.size() == 0) {
            id0.setText(" ");
            id1.setText(" ");
            id2.setText(" ");
            id3.setText(" ");
            id4.setText(" ");
            id5.setText(" ");
            id6.setText(" ");
            id7.setText(" ");

        }
    }

}
