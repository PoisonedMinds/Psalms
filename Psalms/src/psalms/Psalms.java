package psalms;

import javax.swing.*;
import file.*;
import java.util.ArrayList;
import java.util.Arrays;
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

        List<String> psalms = new ArrayList(), file;
        List<Integer> psalmsnum = new ArrayList();
        int key, index;
        file = fileRead.read("Psalms.txt");
        for (int i = 0; i < file.size(); i++) {
            if (i % 2 == 0) {
                psalmsnum.add(Integer.parseInt(file.get(i)));
            } else {
                psalms.add((String) file.get(i));
            }
        }
        key = Integer.parseInt(JOptionPane.showInputDialog("Input a pslams number to search for."));
        index = binarySearch(psalmsnum, 0, psalmsnum.size() - 1, key);
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Sorry that one isnt in the databse.");
            System.exit(1);
        }
        JOptionPane.showMessageDialog(null, "Psalm " + key + "\n" + psalms.get(index));
    }

    private static int binarySearch(List list, int lower, int upper, int key) {
        if (upper - lower > 1) {
            if (key > (Integer) (list.get((upper + lower) / 2))) {
                lower = (upper + lower) / 2;
                return binarySearch(list, lower, upper, key);
            } else if (key < (int) list.get((upper + lower) / 2)) {
                upper = (upper + lower) / 2;
                return binarySearch(list, lower, upper, key);
            } else {
                return (upper + lower) / 2;
            }
        } else {
            return -1;
        }
    }
}
