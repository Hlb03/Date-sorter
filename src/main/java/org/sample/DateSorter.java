package org.sample;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DateSorter {

    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
     * would sort to
     * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        return Stream.concat(
                        takeDatesWithRInMonth(unsortedDates)
                                .stream()
                                .sorted(Comparator.naturalOrder()),
                        takeDatesWithoutRInMonth(unsortedDates)
                                .stream()
                                .sorted(Comparator.reverseOrder())
                )
                .collect(Collectors.toList());
    }

    /**
     * @param dateList - list of dates
     * @return list of dates, where months contain the letter "R"
     */
    private List<LocalDate> takeDatesWithRInMonth(List<LocalDate> dateList) {
        return dateList.stream()
                .filter(date -> date.getMonth().name().contains("R"))
                .collect(Collectors.toList());
    }

    /**
     * @param localDates - list of dates
     * @return list of dates, where months do not contain the letter "R"
     */
    private List<LocalDate> takeDatesWithoutRInMonth(List<LocalDate> localDates) {
        return localDates.stream()
                .filter(date -> !date.getMonth().name().contains("R"))
                .collect(Collectors.toList());
    }
}