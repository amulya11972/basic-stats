package gui.view;

import java.util.*;
import javax.swing.*;
import gui.BasicStats;
import model.BasicStatsModel;


public class CountView implements View {
        private JTextField jtfCount;
        private JLabel jlCount;

        public CountView(){
            jtfCount = new JTextField(5);
            jtfCount.setEditable(false);
            jlCount = new JLabel("Numbers");
        }

        public JLabel getComponentLabel(){
            return jlCount;
        }

        public  JTextField getComponent(){
            return jtfCount;
        }

        public void resetComponent(){
            jtfCount.setText("");
        }

        public String getValue(){
            return jtfCount.getText();
        }

        @Override
        public void update(BasicStatsModel model){
            int count = model.getArrayDouble().length;
            jtfCount.setText("" + count);
        }

}