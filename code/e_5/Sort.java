package sorftware_engineering;

public class Sort {
    void sortPrvince(Province[] provinces){
        for(int i = 0;i < provinces.length;i++){
            for(int j = 0;j < provinces.length - 1 - i;j++){
                if(provinces[i] != null && provinces[j + 1] != null){
                    if(provinces[j + 1].getSum() > provinces[j].getSum()){
                           Province temp = provinces[j];
                           provinces[j] = provinces[j + 1];
                           provinces[j + 1] = temp;
                    }
                }
            }
            if(provinces[i] != null)
                sortCity(provinces[i].getCity());
        }
    }
    void sortCity(City[] cities){
        for(int i = 0;i < cities.length;i++){
            for(int j = 0;j < cities.length - 1 - i;j++){
                if (cities[i] != null && cities[j + 1] != null) {
                    if(cities[j + 1].getNum() > cities[j].getNum()){
                        City temp = cities[j];
                        cities[j] = cities[j + 1];
                        cities[j + 1] = temp;
                    }
                }
            }
        }
    }
}
