package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import ui.RecipeUI;

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

    public ArrayList<String> readRecipes() {
        ArrayList<String> list = new ArrayList<>();
        //ファイルの読み込み
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line ;
            //ファイルを読み込む
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            //例外が発生した場合はError reading file: 例外のメッセージとコンソールに表示する
        } catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
        }
        return list;
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
    public void addRecipe(String recipe, String ingredients) {
        try  (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))){
            String writeString = "";
            writeString = recipe + "," + ingredients;
            //ファイルに書き込む処理
            writer.write(writeString);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
        }
    }
}
