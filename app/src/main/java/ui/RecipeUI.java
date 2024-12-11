package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

import data.RecipeFileHandler;

public class RecipeUI {
    private BufferedReader reader;
    private RecipeFileHandler fileHandler;

    public RecipeUI() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        fileHandler = new RecipeFileHandler();
    }

    public RecipeUI(BufferedReader reader, RecipeFileHandler fileHandler) {
        this.reader = reader;
        this.fileHandler = fileHandler;
    }

    public void displayMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        // 設問1: 一覧表示機能
                        displayRecipes();
                        break;
                    case "2":
                        // 設問2: 新規登録機能
                        addNewRecipe();
                        break;
                    case "3":
                        // 設問3: 検索機能
                        searchRecipe();
                        break;
                    case "4":
                        System.out.println("Exit the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    /**
     * 設問1: 一覧表示機能
     * RecipeFileHandlerから読み込んだレシピデータを整形してコンソールに表示します。
     */

     /*
      * 表示形式を出力する。
      */
    private void displayRecipes() {

        System.out.println();
        
        ArrayList<String> recipes = fileHandler.readRecipes();
        if (recipes.size() == 0){
            System.out.println("No recipes available.");
        }else{
            System.out.println("Recipes:");
            for (String recipe : recipes){
                String menu = recipe.substring(0,recipe.indexOf(","));
                String ingredients = recipe.substring(recipe.indexOf(",")+1);
                System.out.println("-----------------------------------");
                System.out.println("Recipe Name:"+ menu);
                System.out.println("Main Ingredients: " + ingredients);
            }
            System.out.println("-----------------------------------");
        }
    }

    /**
     * 設問2: 新規登録機能
     * ユーザーからレシピ名と主な材料を入力させ、RecipeFileHandlerを使用してrecipes.txtに新しいレシピを追加します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void addNewRecipe() throws IOException {
        try {
            
            System.out.println("メニューを入力してください");
            String inputRecipe = reader.readLine();
            System.out.println("主な食材を「,」区切りで入力してください");
            String inputIngredients = reader.readLine();
            
            fileHandler.addRecipe(inputRecipe, inputIngredients);
            
            System.out.println("Recipe added successfully.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //2が呼ばれる
        //入力を求める
        //
    }

    /**
     * 設問3: 検索機能
     * ユーザーから検索クエリを入力させ、そのクエリに基づいてレシピを検索し、一致するレシピをコンソールに表示します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void searchRecipe() throws IOException {
        System.out.println("Enter search query");
        String inputQuery = reader.readLine();
        


    }

}

