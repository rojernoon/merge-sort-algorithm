import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;


public class app{
    // 2つの配列をマージする処理
    static void merge(List<Integer> list, List<Integer> list_left, List<Integer> list_right){
        System.out.println("before execution list : " + list);
        System.out.println("left : " + list_left);
        System.out.println("right : " + list_right);
        int i = 0;
        int j = 0;
        while(i<list_left.size() || j<list_right.size()){
            if(j>=list_right.size() || (i<list_left.size() && list_left.get(i)<list_right.get(j))){
                list.set(i+j,list_left.get(i));
                i++;
            }
            else{
                list.set(i+j,list_right.get(j));
                j++;
            }
          }
        System.out.println("after execution : " + list);
    }

    static void mergesort(List<Integer> list){
        // 確認用
        // System.out.println("mergesort : " + list);

        if (list.size() > 1){
            // 真ん中で分ける
            int center = list.size() / 2;
            int right_len = list.size() - center;
            // 分けたリスト
            List<Integer> list_left = new ArrayList<Integer>();
            List<Integer> list_right = new ArrayList<Integer>();
            //要素の格納
            for (int i=0;i<center;i++){
                list_left.add(list.get(i));
            }
            for (int j=0;j<right_len;j++){
                list_right.add(list.get(center+j));
            }
            mergesort(list_left);
            mergesort(list_right);
            merge(list, list_left, list_right);
        }
    }

	public static void main(String[] args){
		try{
			String file_name = "./data.txt";
			BufferedReader br = new BufferedReader(new FileReader(file_name));
			String str;
			List<Integer> list = new ArrayList<Integer>();
			// 一行ずつデータを読み込む
			while((str = br.readLine()) != null){
				// String→Integer変換
				int data = Integer.parseInt(str);
				list.add(data);
			}
			br.close();

			// 読み込んだデータの表示
			System.out.println("elements:" + list);
			System.out.println("number of elements:" + list.size());
			// 確認用
			// System.out.println(list.getClass());
			// System.out.println(list.get(0).getClass());

			// マージソート実行
            System.out.println("Start Merge-Sort");
            mergesort(list);

			//結果の表示
			System.out.println("Result : " + list);

		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
	}

}