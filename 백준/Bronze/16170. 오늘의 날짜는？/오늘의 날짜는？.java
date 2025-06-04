import java.time.LocalDate;
import java.time.ZoneOffset;

public class Main {
    public static void main(String[] args) {
        LocalDate utcDate = LocalDate.now(ZoneOffset.UTC);
        int year = utcDate.getYear();
        int month = utcDate.getMonthValue();
        int day = utcDate.getDayOfMonth();

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%04d", year)).append('\n');
        if (month < 10) sb.append('0').append(month).append('\n');
        else sb.append(month).append('\n');
        if (day < 10) sb.append('0').append(day).append('\n');
        else sb.append(day).append('\n');

        System.out.print(sb.toString());
    }
}
