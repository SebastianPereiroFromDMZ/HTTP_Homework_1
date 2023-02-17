import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HTTP_Homework_1 {

    public  static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args)throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();

        HttpGet request = new HttpGet("https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats");

        CloseableHttpResponse response = httpClient.execute(request);

        List<Information> information = mapper.readValue(
                response.getEntity().getContent(),
                new TypeReference<>() {
                }
        );

        /**
         * Здравствуйте уважаемый преподаватель! Можно вопрос по фильтру в Stream API?
         * Поле upvotes из класса Information необходимо сделать Integer так как на запрашиваемом сайте оно в некоторых случаях имеен null
         * в условии задания так же указан фильтр :"filter(value -> value.getUpvotes() != null && value.getUpvotes() > 0);"
         * но при использовании данного учатка фильтра "value.getUpvotes() != null" джава не компилит!!! И пишет что null не может применет к int
         * это понятно, но я же в классе Information поле и в конструкторе указывал Integer.
         * Привести в фильтре значение у меня так же не получилось Integer.valueOf(value.getUpvotes())
         * подскажите где моя ошибка...
         * Спасибо :-)
         */

        List<Information> list = information.stream()
                .filter(value ->value.getUpvotes() > 0)
                .collect(Collectors.toList());

        response.close();
        httpClient.close();

        printList(list);
    }

    public static void printList(List<Information>list){
        for (Information info : list){
            System.out.println(info);
        }
    }
}