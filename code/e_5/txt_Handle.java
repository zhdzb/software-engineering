package sorftware_engineering;

import java.io.*;

public class txt_Handle {
    void read(String path,Province[] provinces,String onlycity){
        try {
            //读文件流
            FileInputStream fin = new FileInputStream(path);
            InputStreamReader reader = new InputStreamReader(fin, "GBK");
            BufferedReader buffreader = new BufferedReader(reader);
            //处理txt
            String temp = "";
            String title = "";
            int num = 0;//省份总数
            int i = 0,j = 0;//省份城市下标
            Province province = new Province();
            City city = new City();
            City[] cities = new City[100];
            while((temp = buffreader.readLine()) != null) {
                //待明确地区不记录
                if (temp.contains("待明确地区")) continue;
                if(onlycity != ""){
                    if(!temp.contains(onlycity)) continue;
                }
                //分割字符串中省份与其他信息
                String head = temp.substring(0, 3);
                String msg = temp.substring(3).trim();
                if(title.equals(head) != true){//if(title.equals(head) != true && title != ""){
                    //一个新的省份
                    if(title != ""){
                        province.setName(title);
                        province.setCity(cities);
                        province.setSum(num);
                        provinces[i] = province;
                        num = 0;
                        province = new Province();
                        cities = new City[100];
                        i++;
                        j = 0;
                    }
                }
                city.setName(msg.substring(0,msg.indexOf('\t')));
                city.setNum(Integer.parseInt(msg.substring(msg.indexOf('\t')).trim()));
                cities[j] = city;
                num += Integer.parseInt(msg.substring(msg.indexOf('\t')).trim());
                title = head;
                city = new City();
                j++;
            }
            //最后一个城市信息
            province.setName(title);
            province.setCity(cities);
            province.setSum(num);
            provinces[i] = province;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    void write(String path,Province[] provinces){
        try {
            //写文件流
            FileOutputStream fout = new FileOutputStream(path);
            OutputStreamWriter writer = new OutputStreamWriter(fout, "GBK");
            BufferedWriter buffwriter = new BufferedWriter(writer);
            for(int i = 0;i < provinces.length;i++){
                if(provinces[i] == null) continue;
                buffwriter.write(provinces[i].getName() + '\t' + provinces[i].getSum() + "\r\n");
                for(int j = 0;j < provinces[i].getCity().length;j++){
                    if(provinces[i].getCity()[j] != null) {
                        buffwriter.write(provinces[i].getCity()[j].getName() + '\t' + provinces[i].getCity()[j].getNum() + "\r\n");
                        buffwriter.flush();
                    }
                }
                buffwriter.write("\r\n");
                buffwriter.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
