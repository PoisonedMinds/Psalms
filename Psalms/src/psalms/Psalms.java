package psalms;

import javax.swing.*;
import file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @title Psalms
 * @author Steven Biro
 * @teacher Mr. J. Carron
 * @date 9-Apr-2015 2:06:58 PM
 * @purpose The purpose of this program is to find a psalm in a file for the
 * user
 */
public class Psalms {

    public static void main(String[] args) {

        List<String> psalms = new ArrayList(), file;//make lists
        List<Integer> psalmsnum = new ArrayList();
        int key, index;
        file = fileRead.read("Psalms.txt");//read the file and add to a list
        for (int i = 0; i < file.size(); i++) {//split up original list into numbers and names
            if (i % 2 == 0) {
                psalmsnum.add(Integer.parseInt(file.get(i)));
            } else {
                psalms.add((String) file.get(i));
            }
        }
        //get the number the user wants to see
        key = Integer.parseInt(JOptionPane.showInputDialog("Input a pslams number to search for."));
        index = binarySearch(psalmsnum, 0, psalmsnum.size() - 1, key);//search
        if (index == -1) {//if it isnt found; exit
            JOptionPane.showMessageDialog(null, "Sorry that one isnt in the databse.");
            System.exit(1);
        }//show the nmber and name
        JOptionPane.showMessageDialog(null, "Psalm " + key + "\n" + psalms.get(index));
    }

    private static int binarySearch(List list, int lower, int upper, int key) {
        if (upper - lower > 1) {//if there is more than one then left in the list, search it
            if (key > (Integer) (list.get((upper + lower) / 2))) {//key is larger than the number at this index
                lower = (upper + lower) / 2;//reassign lower index
                return binarySearch(list, lower, upper, key);
            } else if (key < (int) list.get((upper + lower) / 2)) {//key is smaller than the number at this index
                upper = (upper + lower) / 2;//reassing upper index
                return binarySearch(list, lower, upper, key);
            } else {
                return (upper + lower) / 2;//return index
            }
        } else {
            return -1;//return -1 if nothing is found
        }
    }
}