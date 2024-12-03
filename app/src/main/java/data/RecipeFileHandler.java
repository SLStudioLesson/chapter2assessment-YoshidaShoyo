package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class RecipeFileHandler {
    private String filePath;

    public RecipeFileHandler() {
        filePath = "app/src/main/resources/recipes.txt";
    }

    public RecipeFileHandler(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 設問1: 一覧表示機能
     * recipes.txtからレシピデータを読み込み、それをリスト形式で返します。 <br> 
     * IOExceptionが発生したときは<i>Error reading file: 例外のメッセージ</i>とコンソールに表示します。
     * @return レシピデータ
     */

    /*
     * 読み込んだデータを「,」で区切る
     * 「,」で区切ったデータを配列にする。
     * 配列をArrayListにして返す
     */
    public ArrayList<String> readRecipes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line ;
            while ((line = reader.readLine()) != null) {
                String[] pairs = line.split(",");

                ArrayList<String> list = new ArrayList<>();
                for (int i = 0 ; i < pairs.length; i++){
                    list.add(pairs[i]);
                }
                return list;
            }

        } catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
        }
        return null;
    }

    /**
     * 設問2: 新規登録機能
     * 新しいレシピをrecipes.txtに追加します。<br>
     * レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
     *
     * @param recipeName レシピ名
     * @param ingredients 材料名
     */
     // 
    public void addRecipe(String recipeName, String ingredients) {
        // try {

        // } catch (IOException e) {

        // }
    }
}
