package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public String beautify(String text, PoemDecorator poemDecorator){
        String result = poemDecorator.decorate(text);
        System.out.println(result);
        return result;
    }
}
