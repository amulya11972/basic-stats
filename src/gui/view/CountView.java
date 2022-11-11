package gui.view;

import java.util.*;
import javax.swing.*;
import gui.BasicStats;
import model.BasicStatsModel;


public class CountView implements View {
        private JTextField jtfCount;
        private JLabel jlCount;

        //Initialize Count View component
        public CountView(){
            jtfCount = new JTextField(5);
            jtfCount.setEditable(false);
            jlCount = new JLabel("Numbers");
        }

        // get Label for count Textfield
        public JLabel getComponentLabel(){
            return jlCount;
        }

        //get Count Component
        public  JTextField getComponent(){
            return jtfCount;
        }

        //reset the Count component
        public void resetComponent(){
            jtfCount.setText("");
        }

        //get count textfield value
        public String getValue(){
            return jtfCount.getText();
        }

        //update the count component
        @Override
        public void update(BasicStatsModel model){
            int count = model.getArrayDouble().length;
            jtfCount.setText("" + count);
        }

}