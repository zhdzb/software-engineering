package sorftware_engineering;

public class e_5 {
    public static void main(String[] args) {
        //接收命令行消息
        String path_in = args[0];
        String path_out = args[1];
        String onlyProvince = "";
        if(args.length > 2) {
            onlyProvince = args[2];
        }
        txt_Handle handle = new txt_Handle();//实例txt处理类
        Sort sort = new Sort();//实例数据排序类
        Province[] provinces = new Province[10];//创建一个province数组，长度为10
        //从txt文件中读取数据放入province数组中
        handle.read(path_in,provinces,onlyProvince);
        //处理取出的数据
        sort.sortPrvince(provinces);//为提高速度，在为省份排序的同时进行了对城市的排序
        //数据处理完成，输出txt文件
        handle.write(path_out,provinces);
    }
}
