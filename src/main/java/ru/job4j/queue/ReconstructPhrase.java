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
        int size = evenElements.size();
        StringBuilder phraseGetEven = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                phraseGetEven.append(evenElements.poll());
            } else {
                evenElements.poll();
            }
        }
        return phraseGetEven.toString();
    }

    private String getDescendingElements() {
        Iterator<Character> iterator = descendingElements.descendingIterator();
        StringBuilder phraseGetDescending = new StringBuilder();
        while (iterator.hasNext()) {
            phraseGetDescending.append(iterator.next());
        }
        return phraseGetDescending.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}