import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dto.Car;
import dto.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) throws JsonProcessingException {
        System.out.println("main");

        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User();
        user.setName("홍길동");
        user.setAge(25);

        Car car1 = new Car();
        car1.setName("K5");
        car1.setCarNumber("12가 4675");
        car1.setTYPE("sedan");

        Car car2 = new Car();
        car1.setName("K7");
        car1.setCarNumber("72가 4275");
        car1.setTYPE("SUV");

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        user.setCarList(carList);

        System.out.println(user);

        //window환경에서 돌리면 인코딩 에러가 남. 기본 인코더가 UTF-8이 아닌 ms949이기 때문.
        //setting - encoding검색 - file encoding에 들어가서 UTF-8로 바꿔주면 됨

        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);

        JsonNode jsonNode = objectMapper.readTree(json);
        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();

        System.out.println("name : " + _name);
        System.out.println("age : " + _age);

        JsonNode cars = jsonNode.get("cars");
        ArrayNode arrayNode = (ArrayNode) cars;

        List<Car> _cars = objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() {});
        System.out.println(_cars);

        ObjectNode objectNode =(ObjectNode) jsonNode;

        objectNode.put("name","steve");
        objectNode.put("age","25");

        System.out.println(objectNode.toPrettyString());





    }
}
