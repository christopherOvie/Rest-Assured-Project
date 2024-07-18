package allMyTest;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestDemo {


            @Test(enabled = false)
    public void testCaseHamcrest01(){
        String message = "programming";
        assertThat(message, equalTo("programming"));

                assertThat(message, is(equalTo("programming")));

                assertThat(message, is("programming"));
                assertThat(message, startsWithIgnoringCase("PROG"));
                assertThat(message, endsWithIgnoringCase("ING"));
                assertThat(message,hasLength(11));
                assertThat("",is(emptyString()));
                assertThat(message, containsString("mmin"));
    }
    @Test
    public void testCaseHamcrest02(){

        assertThat(30,greaterThan(20));
        assertThat(30,greaterThanOrEqualTo(30));
        assertThat(30,lessThan(50));
        assertThat(30,lessThanOrEqualTo(30));

    }
    @Test
    public void testCaseHamcrest03(){

                List<String> languages= new ArrayList<String>();

        languages.add("javascript");
        languages.add("csharp");
        languages.add("java");
        System.out.println(languages);
        assertThat(languages,hasItem("java"));
        assertThat(languages,hasItems("java","csharp"));
        assertThat(languages,hasItems(startsWithIgnoringCase("ja"),endsWithIgnoringCase("arp")));
        assertThat(languages,contains("javascript","csharp","java"));

        assertThat(languages,containsInAnyOrder("javascript","java","csharp"));

        assertThat(languages,hasSize(3));

    }

    @Test
    public void testCaseHamcrest04() {
        Map<String, String> employee=new HashMap<String,String>();
        employee.put("name","peter");
        employee.put("location","london");

        System.out.println(employee);
        assertThat(employee,hasKey("name"));

        assertThat(employee,hasValue("peter"));
        assertThat(employee,hasEntry("name","peter"));
    }

    @Test
    public void hamcrestgeneraltestcases(){
          String smonth = "december";
          String id= "08FD56fa76T";  //alphanumeric value  //a-z A-Z 0-9
          //aallof  both passed
         // assertThat(smonth,allOf(startsWithIgnoringCase("Dec"),endsWithIgnoringCase("er"),containsStringIgnoringCase("cem")));

       // assertThat(smonth,anyOf(startsWithIgnoringCase("h"),endsWithIgnoringCase("er"),containsStringIgnoringCase("cem")));

        assertThat(id,matchesRegex("[a-zA-Z0-9]+"));
    }
}
