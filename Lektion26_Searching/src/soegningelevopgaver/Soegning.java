package soegningelevopgaver;

import java.util.ArrayList;

public class Soegning {

    public static boolean findUlige(int[] tabel) {
        int i = 0;
        while (i < tabel.length) {
            if (tabel[i] % 2 != 0) {
                return true;
            } else {
                i++;
            }
        }

        return false;
    }

    public static int findFørsteInterval(int[] tabel, int intervalStart, int intervalSlut) {
        for (int v : tabel) {
            if (v > intervalStart && v < intervalSlut) {
                return v;
            }
        }

        return -1;
    }

    public static boolean ensTalSekvens(int[] tabel) {
        for (int i = 0; i < tabel.length; i++) {
            if (i + 1 > tabel.length - 1) {
                return false;
            }
            if (tabel[i] == tabel[i + 1]) {
                return true;
            }
        }

        return false;
    }

    public static int heltalsKvadratrod(int n) {
        int r = n;
        boolean found = false;
        while (!found && r > 0) {
            if (r * r <= n && n < (r + 1) * (r + 1)) {
                found = true;
            } else {
                r--;
            }
        }

        return (found) ? r : 0;
    }

    public static int heltalsKvadratrodBinaer(int n) {
        return 0;
    }

    public static int rykNed(ArrayList<Integer> list, int n) {
        int i = 0;
        int result = -1;
        while (result == -1 && i < list.size()) {
            if (list.get(i) == n) {
                if (i > 0) {
                    list.set(i, list.get(i - 1));
                    list.set(i - 1, n);

                    result = i - 1;
                } else {
                    list.set(i, list.get(list.size() - 1));
                    list.set(list.size() - 1, n);

                    result = list.size();
                }
            } else {
                i++;
            }
        }

        return result;
    }
}
