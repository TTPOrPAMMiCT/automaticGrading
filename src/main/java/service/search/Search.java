package service.search;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search {

    public List<Integer> getListSymbolsAndParseInt(String string) {
        List<Integer> listNumbers = new ArrayList();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(string);
        int start = 0;
        while (matcher.find(start)) {
            String value = string.substring(matcher.start(), matcher.end());
            int result = Integer.parseInt(value);
            /*System.out.println(result);*/
            listNumbers.add(result);
            start = matcher.end();
        }
        return listNumbers;
    }

    /*public static void main(String[] args) {
        SearchInString searchInString = new  SearchInString();
        List<Integer> list = searchInString.searchSymbolAndParseInt("10,9,11 12 12");
    }*/
}
