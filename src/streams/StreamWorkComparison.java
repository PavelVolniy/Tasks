package streams;

import java.io.*;

import java.util.*;

public class StreamWorkComparison {

    public static long checkFileReaderWork(String path) {
        if (path != null) path = path.trim();
        long result = System.currentTimeMillis();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
            while (fileReader.ready()) {
                fileReader.read();
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            result = -1;
        } catch (Exception e) {
            result = -1;
        }
        if (result == -1) return result;
        else return System.currentTimeMillis() - result;
    }

    public static long checkBufferedReaderWork(String path) {
        if (path != null) path = path.trim();
        BufferedReader bufferedReader = null;
        long result = System.currentTimeMillis();
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            while (bufferedReader.ready()) {
                bufferedReader.read();
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            result = -1;
        } catch (Exception e) {
            result = -1;
        }
        if (result == -1) return result;
        else return System.currentTimeMillis() - result;
    }

    public static long checkScannerWork(String path) {
        if (path != null) path = path.trim();
        Scanner scanner = null;
        long result = System.currentTimeMillis();
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(path)));
            while (scanner.hasNext()) {
                scanner.next();
            }
        } catch (Exception e) {
            result = -1;
        } finally {
            if (scanner != null) scanner.close();
        }
        if (result == -1) return result;
        else return System.currentTimeMillis() - result;
    }

    public static List<Pair> compareReading(String path) {
        List<Pair> list = new ArrayList() {
        };
        Long fileReader = checkFileReaderWork(path);
        Long bufferReader = checkBufferedReaderWork(path);
        Long scanner = checkScannerWork(path);
        list.add(new Pair("checkFileReaderWork ", fileReader));
        list.add(new Pair("checkBufferedReaderWork ", bufferReader));
        list.add(new Pair("checkScannerWork ", scanner));

        return list.stream().sorted(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return (int) (o1.second - o2.second);
            }
        }).toList();
    }


    static class Pair<U extends String, V extends Long> {
        public final U first;       // первое поле пары
        public final V second;      // второе поле пары

        // Создает новую пару с указанными значениями
        private Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Pair<?, ?> pair = (Pair<?, ?>) o;
            if (!first.equals(pair.first)) {
                return false;
            }
            return second.equals(pair.second);
        }

        @Override
        public int hashCode() {
            return 31 * first.hashCode() + second.hashCode();
        }

        @Override
        public String toString() {
            return "(" + first + " = " + second + ")";
        }
    }

}
