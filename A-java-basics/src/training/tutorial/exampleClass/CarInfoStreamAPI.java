package training.tutorial.exampleClass;

import java.util.List;
import java.util.stream.Stream;

public class CarInfoStreamAPI {

    // 使用.filter()对CarInfo组成的List进行过滤
    public Stream<CarInfo> yearFilter(List<CarInfo> carGroup){
//        Stream<CarInfo> carStream1 = carGroup.stream();
//        Predicate<CarInfo> yearFilter = car -> car.getYear() > 2013;
//        Stream<CarInfo> carStream2 = carStream1.filter(yearFilter);
//        return carStream2;
        Stream<CarInfo> carStream1 = carGroup.stream();
        return carStream1.filter(car -> car.getYear() > 2013 );
    }

    // 使用.map()对CarInfo组成的List进行修改
    public Stream<CarInfo> changeToUppercase(List<CarInfo> carGroup){
//        Stream<CarInfo> carStream1 = carGroup.stream();
//        Function<CarInfo,CarInfo> brandMap = car -> new CarInfo(car.getYear(),car.getBrand().toUpperCase());
//        Stream<CarInfo>carStream2 = carStream1.map(brandMap);
        Stream<CarInfo> carStream1 = carGroup.stream();
        return carStream1.map(car -> new CarInfo(car.getYear(),car.getBrand().toUpperCase()));
    }
}
