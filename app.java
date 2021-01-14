import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;


public class app{

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

			//結果の表示
			System.out.println("Result : " + list);

		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
	}

}