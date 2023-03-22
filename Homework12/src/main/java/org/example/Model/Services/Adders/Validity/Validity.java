package org.example.Model.Services.Adders.Validity;

import java.time.LocalDate;

public class Validity implements DateValidityImpl {


    public Validity() {
    }

    @Override
    public boolean dateCheck(String value) {
        if (value.length() < 10) return false;
        if (value.charAt(2) != '.' || value.charAt(5) != '.')
            return false;
        String[] breakdown = value.replace(".", ". ").split(". ");
        int[] nums = new int[3];
        try {
            for (int i = 0; i < 3; i++)
                nums[i] = Integer.parseInt(breakdown[i]);
        } catch (Exception e) {
            return false;
        }
        return checkDayMonthYear(nums[0], nums[1], nums[2]);
    }

    private boolean checkDayMonthYear(int d, int m, int y) {
        if (y < 1930 || y > LocalDate.now().getYear())
            return false;
        else if (m < 1 || m > 12) {
            return false;
        } else if (d < 0) {
            return false;
        } else {
            boolean loftiness = false;
            if (y % 4 == 0)
                loftiness = true;
            switch (m) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (d > 31)
                        return false;
                    break;

                case 4:
                case 6:
                case 9:
                case 11:
                    if (d > 30)
                        return false;
                    break;

                case 2:
                    if (loftiness) {
                        if (d > 29)
                            return false;
                    } else if (d > 28) return false;
            }
        }
        return true;
    }
}
