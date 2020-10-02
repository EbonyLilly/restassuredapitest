package commons;

import org.testng.annotations.Test;

public class FluentTest {
    @Test
    public void practice_fluent(){
        Printer printer = new Printer();
        printer.printGreeting()
        .printColor()
        .printFavoriteNum();

    }
}
