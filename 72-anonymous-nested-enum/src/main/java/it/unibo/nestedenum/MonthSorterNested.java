package it.unibo.nestedenum;

import java.time.Month;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    public enum Month{
        JANUARY(31),
        FEBRUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);

        private int days;
        Month(int days){
            this.days = days;
        }

        public static Month fromString(String month){
            String upperMonth = month.toUpperCase();

            Month correctMonth = null;
            int countMonth = 0;
            for(Month courrentM : Month.values()){
                if(courrentM.name().startsWith(upperMonth)){
                    correctMonth = courrentM;
                    countMonth++;
                }
            }
            if(countMonth == 1){
                return correctMonth;
            } else if(countMonth > 1){
                throw new IllegalArgumentException(
                    month + "metched with plural months"
                );
            }
            else{
                throw new IllegalArgumentException(
                    "no month found"
                );
            }
        }
    }

    @Override
    public Comparator<String> sortByDays() {
        return new Comparator<String>() {
            public int compare(String month1, String month2){
                Month monthA = Month.fromString(month1);
                Month monthB = Month.fromString(month2);

                if(monthA.days < monthB.days){
                    return -1;
                }
                else if (monthA.days == monthB.days){
                    return 0;
                } else  {
                    return 1;
                }
            }
        };
    }

    @Override
    public Comparator<String> sortByOrder() {
                return new Comparator<String>() {
            public int compare(String month1, String month2){
                Month monthA = Month.fromString(month1);
                Month monthB = Month.fromString(month2);

                if(monthA.ordinal() < monthB.ordinal()){
                    return -1;
                }
                else if (monthA.ordinal() == monthB.ordinal()){
                    return 0;
                } else  {
                    return 1;
                }
            }
        };
    }
}
