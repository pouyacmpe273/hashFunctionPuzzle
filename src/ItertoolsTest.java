//import static net.ericaro.neoitertools.Itertools.*;
//
//import java.util.Arrays;
//import java.util.List;
//
//import net.ericaro.neoitertools.Generator;
//import net.ericaro.neoitertools.Index;
//import net.ericaro.neoitertools.Lambda;
//
//public class ItertoolsTest {
//
//    public static <T> void assertList(Generator<T> generator, T... expected) {
//        for (T x : expected) {
//            T c = generator.next();
//            System.out.print(c + " , ");
//            assert x.equals(c);
//        }
//        System.out.println("...");
//    }
//
//    public static Lambda<Integer, Boolean> lt(final int bound) {
//        return new Lambda<Integer, Boolean>() {
//            public Boolean map(Integer x) {
//                return x < bound;
//            }
//        };
//    }
//
//    Lambda<? super List<Character>, String> str = new Lambda<List<Character>, String>() {
//
//        public String map(List<Character> arg) {
//            return string(iter(arg));
//        }
//    };
//
//    Lambda<Integer, Boolean> pair = new Lambda<Integer, Boolean>() {
//
//        public Boolean map(Integer arg) {
//            return (arg % 2) == 0;
//        }
//    };
//
//    public void testAll() {
//        System.out.println(">>> all(range(0, 10, 2);");
//        boolean res = all(range(0, 10, 2), pair);
//        System.out.println(res);
//        assert res;
//    }
//
//    public void testAny() {
//
//        System.out.println(">>> any(range(0, 10);");
//        boolean res = any(range(0, 10), pair);
//        System.out.println(res);
//        assert res;
//    }
//
//    public void testChainGeneratorOfGeneratorOfT() {
//        Generator<Generator<Integer>> generators = iter(Arrays.asList(range(3), range(3, 5)));
//        List<Integer> all = list(chain(generators));
//        assert Arrays.asList(0, 1, 2, 3, 4).equals(all);
//    }
//
//    public void testChainGeneratorOfTArray() {
//        System.out.println(">>> chain(range(3), range(3,5));");
//        assertList(chain(range(3), range(3, 5)), 0, 1, 2, 3, 4);
//    }
//
//    public void testCombinations() {
//        // combinations('ABCD', 2) --> AB AC AD BC BD CD
//        // combinations(range(4), 3) --> 012 013 023 123
//
//        System.out.println(">>> map(str, combinations(iter(\"ABCD\"), 2));");
//        assertList(map(str, combinations(iter("ABCD"), 2)), "AB", "AC", "AD", "BC", "BD", "CD");
//    }
//
//    public void testCount() {
//        System.out.println(">>> count();");
//        assertList(count(), 0, 1, 2, 3, 4);
//    }
//
//    public void testCountInt() {
//        System.out.println(">>> count(6);");
//        assertList(count(6), 6, 7, 8, 9);
//    }
//
//    public void testCycle() {
//        // cycle('ABCD') --> A B C D A B C D ...
//        System.out.println(">>> cycle(iter(\"ABCD\");");
//        assertList(cycle(iter("ABCD")), 'A', 'B', 'C', 'D', 'A', 'B', 'C', 'D');
//    }
//
//    public void testDropwhile() {
//        // dropwhile(lambda x: x<5, [1,4,6,4,1]) --> 6 4 1
//        System.out.println(">>> dropwhile(lt(5), iter(binomial) )");
//        int[] binomial = new int[]{1, 4, 6, 4, 1};
//
//        assertList(dropwhile(lt(5), iter(binomial)), 6, 4, 1);
//    }
//
//    public void testEnumerate() {
//        // >>> for i, season in enumerate(['Spring', 'Summer', 'Fall', 'Winter']):
//        // ... print i, season
//        // 0 Spring
//        // 1 Summer
//        // 2 Fall
//        // 3 Winter
//        System.out.println(">>> for(Index<Character>  pair: in( enumerate(iter(\"ABCD\")))){\n" + "...     System.out.println(pair.i+\" \"+pair.value);");
//        for (Index<Character> pair : in(enumerate(iter("ABCD")))) {
//            System.out.println(pair.i + " " + pair.value);
//        }
//    }
//}
