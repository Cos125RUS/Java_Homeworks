package org.example;

public class Check {
    public static boolean check(String value) {
        char[] hooks = {'(', '{', '[', '<', '>', ']', '}', ')'};
        int[] counter = new int[hooks.length];
        for (int i = 0; i < hooks.length; i++) {
            for (int j = 0; j < value.length(); j++) {
                if (hooks[i] == value.charAt(j))
                    counter[i]++;
            }
        }
        for (int i = 0; i < hooks.length / 2; i++) {
            if (counter[i] != counter[hooks.length - 1 - i])
                return false;
        }
        return true;
    }
}
