package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        int sizeEven = evenElements.size();
        StringBuilder phraseGetEven = new StringBuilder();
        for (int i = 0; i < sizeEven; i++) {
            if (i % 2 == 0) {
                phraseGetEven.append(evenElements.poll());
            } else {
                evenElements.poll();
            }
        }
        return phraseGetEven.toString();
    }

    private String getDescendingElements() {
        StringBuilder phraseGetDescending = new StringBuilder();
        int sizeDescending = descendingElements.size();
        for (int i = 0; i < sizeDescending; i++) {
            phraseGetDescending.append(descendingElements.pollLast());
        }
        return phraseGetDescending.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}