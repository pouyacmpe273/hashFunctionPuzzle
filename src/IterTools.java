/**
 * Created by Pouya on 10/22/2014.
 */


import net.ericaro.neoitertools.Generator;
import net.ericaro.neoitertools.Lambda;

import static net.ericaro.neoitertools.Itertools.*;

import java.util.Arrays;
import java.util.List;

public class IterTools {


    static Lambda<? super List<Character>, String> str = new Lambda<List<Character>, String>() {

        public String map(List<Character> arg) {
            return string(iter(arg));
        }
    };

    public static void testCombinations() {
        // combinations('ABCD', 2) --> AB AC AD BC BD CD
        // combinations(range(4), 3) --> 012 013 023 123

        System.out.println(">>> map(str, combinations(iter(\"ABCD\"), 2));");
        Generator<String> out = map(str, combinations(iter("ABCD"), 2));

    }

    public static void main(String[] args){
        testCombinations();
    }






}
