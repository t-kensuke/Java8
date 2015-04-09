package ch08;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Ex09 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner("a b c\nd e f\n 1 2 3\n1.0 1.2");

		Object[] result = convertWordStream(scanner).toArray(String[]::new);
		System.out.println("Result: " + Arrays.asList(result));

		Scanner scanner2 = new Scanner("a b c\nd e f\n 1 2 3\n1.0 1.2");
		result = convertLineStream(scanner2).toArray(String[]::new);
		System.out.println("Result: " + Arrays.asList(result));

		Scanner scanner3 = new Scanner("1 2 3\n1.0 1.2");
		result = convertIntStream(scanner3).toArray(Integer[]::new);
		System.out.println("Result: " + Arrays.asList(result));

		Scanner scanner4 = new Scanner("1 2 3\n1.0 1.2");
		result = convertDoubleStream(scanner4).toArray(Double[]::new);
		System.out.println("Result: " + Arrays.asList(result));
	}

	public static Stream<String> convertWordStream(Scanner scanner) {
		Iterator<String> iter = new Iterator<String>() {
			@Override
			public boolean hasNext() {
				return scanner.hasNext();
			}

			@Override
			public String next() {
				return scanner.next();

			}
		};
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
				iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
	}

	public static Stream<String> convertLineStream(Scanner scanner) {
		Iterator<String> iter = new Iterator<String>() {
			@Override
			public boolean hasNext() {
				return scanner.hasNextLine();
			}

			@Override
			public String next() {
				return scanner.nextLine();

			}
		};
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
				iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
	}

	public static Stream<Integer> convertIntStream(Scanner scanner) {
		Iterator<Integer> iter = new Iterator<Integer>() {
			@Override
			public boolean hasNext() {
				return scanner.hasNextInt();
			}

			@Override
			public Integer next() {
				return scanner.nextInt();

			}
		};
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
				iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
	}

	public static Stream<Double> convertDoubleStream(Scanner scanner) {
		Iterator<Double> iter = new Iterator<Double>() {
			@Override
			public boolean hasNext() {
				return scanner.hasNextDouble();
			}

			@Override
			public Double next() {
				return scanner.nextDouble();

			}
		};
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
				iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
	}

	//    /**
	//     * Returns a {@code Stream}, the elements of which are lines read from
	//     * this {@code BufferedReader}.  The {@link Stream} is lazily populated,
	//     * i.e., read only occurs during the
	//     * <a href="../util/stream/package-summary.html#StreamOps">terminal
	//     * stream operation</a>.
	//     *
	//     * <p> The reader must not be operated on during the execution of the
	//     * terminal stream operation. Otherwise, the result of the terminal stream
	//     * operation is undefined.
	//     *
	//     * <p> After execution of the terminal stream operation there are no
	//     * guarantees that the reader will be at a specific position from which to
	//     * read the next character or line.
	//     *
	//     * <p> If an {@link IOException} is thrown when accessing the underlying
	//     * {@code BufferedReader}, it is wrapped in an {@link
	//     * UncheckedIOException} which will be thrown from the {@code Stream}
	//     * method that caused the read to take place. This method will return a
	//     * Stream if invoked on a BufferedReader that is closed. Any operation on
	//     * that stream that requires reading from the BufferedReader after it is
	//     * closed, will cause an UncheckedIOException to be thrown.
	//     *
	//     * @return a {@code Stream<String>} providing the lines of text
	//     *         described by this {@code BufferedReader}
	//     *
	//     * @since 1.8
	//     */
	//    public Stream<String> lines() {
	//        Iterator<String> iter = new Iterator<String>() {
	//            String nextLine = null;
	//
	//            @Override
	//            public boolean hasNext() {
	//                if (nextLine != null) {
	//                    return true;
	//                } else {
	//                    try {
	//                        nextLine = readLine();
	//                        return (nextLine != null);
	//                    } catch (IOException e) {
	//                        throw new UncheckedIOException(e);
	//                    }
	//                }
	//            }
	//
	//            @Override
	//            public String next() {
	//                if (nextLine != null || hasNext()) {
	//                    String line = nextLine;
	//                    nextLine = null;
	//                    return line;
	//                } else {
	//                    throw new NoSuchElementException();
	//                }
	//            }
	//        };
	//        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
	//                iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
	//    }
}
